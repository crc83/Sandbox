package org.sbelei.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;

@Entity
public class GoodsGroup implements Serializable
{

   @Id
   private @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   Long id = null;
   @Version
   private @Column(name = "version")
   int version = 0;

   @Column
   private String groupName;

   @Column
   private Integer parentGroup;

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object that)
   {
      if (this == that)
      {
         return true;
      }
      if (that == null)
      {
         return false;
      }
      if (getClass() != that.getClass())
      {
         return false;
      }
      if (id != null)
      {
         return id.equals(((GoodsGroup) that).id);
      }
      return super.equals(that);
   }

   @Override
   public int hashCode()
   {
      if (id != null)
      {
         return id.hashCode();
      }
      return super.hashCode();
   }

   public String getGroupName()
   {
      return this.groupName;
   }

   public void setGroupName(final String groupName)
   {
      this.groupName = groupName;
   }

   public Integer getParentGroup()
   {
      return this.parentGroup;
   }

   public void setParentGroup(final Integer parentGroup)
   {
      this.parentGroup = parentGroup;
   }

   public String toString()
   {
      String result = "";
      if (groupName != null && !groupName.trim().isEmpty())
         result += groupName;
      if (parentGroup != null)
         result += " " + parentGroup;
      return result;
   }
}