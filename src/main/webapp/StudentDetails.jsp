<%@page import="com.infy.BO.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<% Student s=(Student)request.getAttribute("Std");

%>

<!-- Include Menu -->
    <nav>
        <a href="Home.html">Home</a>
        <a href="Register.html">Register</a>
        <a href="StudentDetails.html">Student Details</a>
    </nav>

    <section id="student-details">
        <h2 style="color: #333; text-align: center;">Student Details</h2>
        
        <table border="1" align="center">
  			<thead>
    			<tr>
      				<th style="color: #333;">Roll No</th>
      				<th style="color: #333;">Name</th>
      				<th style="color: #333;">Address</th>
    			</tr>
  			</thead>
  			<tbody>
    			<tr>
     			 <td style="color: #333;"><%=s.getRollno() %></td>
      			 <td style="color: #333;"><%=s.getName() %></td>
      			 <td style="color: #333;"><%=s.getAddress()%></td>
    			</tr>
         </tbody>
     </table>
            <div class="button-container" text-align: center;>
                <a href="Home.html" class="back-btn" >Back</a>
            </div>
       
    </section>

</body>
</html>