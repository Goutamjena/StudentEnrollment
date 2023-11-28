package com.infy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infy.BO.Student;
import com.infy.dao.studentdao;

/**
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html"); 
		int rollno=Integer.parseInt(request.getParameter("rollnumber"));
        PrintWriter out=response.getWriter();
        
        Student s=new Student();
        studentdao sd=new studentdao();
        s.setRollno(rollno);
        //System.out.println("Collected Rollno from view Page:"+rollno);
        //Need to pass it to JSP for better view
        s=sd.viewDetails(rollno);
        out.print("<p>Name</p>"+s.getName());
        out.print("<p>Roll No</p>"+s.getRollno());
        out.print("<p>Address</p>"+s.getAddress());
        //System.out.println("view servlet Name:"+s.getName() +"RollNo:"+s.getRollno() );
    	request.getRequestDispatcher("StudentDetails.html").include(request, response); 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
