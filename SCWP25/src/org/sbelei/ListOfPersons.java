package org.sbelei;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.javafaker.Faker;

/**
 * Servlet implementation class ListOfPersons
 */
public class ListOfPersons extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOfPersons() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Faker faker = new Faker();
		List<Person> persons = new ArrayList<Person>();
		for (int i=1; i <=20; i++){
			Person aPerson = new Employee();
			aPerson.setName(faker.name());
			aPerson.setEmail(faker.firstName()+"@email.com");
			aPerson.setPhone(faker.phoneNumber());
			persons.add(aPerson);
		}
		request.setAttribute("people", persons);
		
		RequestDispatcher rd = request.getRequestDispatcher("pages/list_persons.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
