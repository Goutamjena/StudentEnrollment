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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        int rollno=Integer.parseInt(request.getParameter("rollnumber")); 
        String addrs=request.getParameter("address");  
        
        Student s=new Student ();
        studentdao sd=new studentdao();
        s.setName(name);
        s.setRollno(rollno);
        s.setAddress(addrs);
        
        int status=sd.reister(s);
        if (status > 0) {
        	out.print("<p>Data saved sucessfully</p?");
        	request.getRequestDispatcher("Register.html").include(request, response); 
        }
        else
        {
        	out.print("<p>Sorry Data processin failed</p?");
        	request.getRequestDispatcher("Register.html").include(request, response);
        }
        

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
