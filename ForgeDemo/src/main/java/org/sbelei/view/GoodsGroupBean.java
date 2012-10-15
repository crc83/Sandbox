package org.sbelei.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.sbelei.model.GoodsGroup;

/**
 * Backing bean for GoodsGroup entities.
 * <p>
 * This class provides CRUD functionality for all GoodsGroup entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class GoodsGroupBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving GoodsGroup entities
    */

   private Long id;

   public Long getId()
   {
      return this.id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   private GoodsGroup goodsGroup;

   public GoodsGroup getGoodsGroup()
   {
      return this.goodsGroup;
   }

   @Inject
   private Conversation conversation;

   @PersistenceContext(type = PersistenceContextType.EXTENDED)
   private EntityManager entityManager;

   public String create()
   {

      this.conversation.begin();
      return "create?faces-redirect=true";
   }

   public void retrieve()
   {

      if (FacesContext.getCurrentInstance().isPostback())
      {
         return;
      }

      if (this.conversation.isTransient())
      {
         this.conversation.begin();
      }

      if (this.id == null)
      {
         this.goodsGroup = this.example;
      }
      else
      {
         this.goodsGroup = findById(getId());
      }
   }

   public GoodsGroup findById(Long id)
   {

      return this.entityManager.find(GoodsGroup.class, id);
   }

   /*
    * Support updating and deleting GoodsGroup entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.goodsGroup);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.goodsGroup);
            return "view?faces-redirect=true&id=" + this.goodsGroup.getId();
         }
      }
      catch (Exception e)
      {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
         return null;
      }
   }

   public String delete()
   {
      this.conversation.end();

      try
      {
         this.entityManager.remove(findById(getId()));
         this.entityManager.flush();
         return "search?faces-redirect=true";
      }
      catch (Exception e)
      {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
         return null;
      }
   }

   /*
    * Support searching GoodsGroup entities with pagination
    */

   private int page;
   private long count;
   private List<GoodsGroup> pageItems;

   private GoodsGroup example = new GoodsGroup();

   public int getPage()
   {
      return this.page;
   }

   public void setPage(int page)
   {
      this.page = page;
   }

   public int getPageSize()
   {
      return 10;
   }

   public GoodsGroup getExample()
   {
      return this.example;
   }

   public void setExample(GoodsGroup example)
   {
      this.example = example;
   }

   public void search()
   {
      this.page = 0;
   }

   public void paginate()
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

      // Populate this.count

      CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
      Root<GoodsGroup> root = countCriteria.from(GoodsGroup.class);
      countCriteria = countCriteria.select(builder.count(root)).where(getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<GoodsGroup> criteria = builder.createQuery(GoodsGroup.class);
      root = criteria.from(GoodsGroup.class);
      TypedQuery<GoodsGroup> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<GoodsGroup> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String groupName = this.example.getGroupName();
      if (groupName != null && !"".equals(groupName))
      {
         predicatesList.add(builder.like(root.<String> get("groupName"), '%' + groupName + '%'));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<GoodsGroup> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back GoodsGroup entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<GoodsGroup> getAll()
   {

      CriteriaQuery<GoodsGroup> criteria = this.entityManager.getCriteriaBuilder().createQuery(GoodsGroup.class);
      return this.entityManager.createQuery(criteria.select(criteria.from(GoodsGroup.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final GoodsGroupBean ejbProxy = this.sessionContext.getBusinessObject(GoodsGroupBean.class);

      return new Converter()
      {

         @Override
         public Object getAsObject(FacesContext context, UIComponent component, String value)
         {

            return ejbProxy.findById(Long.valueOf(value));
         }

         @Override
         public String getAsString(FacesContext context, UIComponent component, Object value)
         {

            if (value == null)
            {
               return "";
            }

            return String.valueOf(((GoodsGroup) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private GoodsGroup add = new GoodsGroup();

   public GoodsGroup getAdd()
   {
      return this.add;
   }

   public GoodsGroup getAdded()
   {
      GoodsGroup added = this.add;
      this.add = new GoodsGroup();
      return added;
   }
}