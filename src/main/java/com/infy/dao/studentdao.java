package com.infy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.infy.BO.Student;
import com.infy.svc.StudentAction;

public class studentdao extends StudentAction{
	
	
	public static Connection getConnection() {
		Connection con=null;
		/*String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="admin";
		String password="password";
		
		//This section for oracle database
                  Comment the below url based upon the local or container deployement
		*/
		//String url="jdbc:mysql://localhost:3306/mydatabase";
		String url = "jdbc:mysql://mysql-service:3306/mydatabase";
		String username="root";
		String password="Password@2023";
		
		try
		{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");  
			 con=DriverManager.getConnection(url,username,password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}

	public int reister(Student s) {
		
		int status=0;
		Connection con=studentdao.getConnection();
		System.out.println(con);
		try
		{ 
		   PreparedStatement ps=con.prepareStatement("insert into std values(?,?,?)");
		    ps.setString(1, s.getName());
			ps.setInt(2,s.getRollno());
			ps.setString(3,s.getAddress() );
			status=ps.executeUpdate();
			System.out.println("inside try Name:"+s.getName() +" Roll:"+s.getRollno()+"Addrs:"+s.getAddress());
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		//System.out.println("Status:"+status);
		//System.out.println("outside Name:"+s.getName() +" Roll:"+s.getRollno()+"Addrs:"+s.getAddress());
		return status;
	}
	
	
	@Override
	public Student viewDetails(int s2) {
		
		int rollno=s2;
		Student s=new Student();
		Connection con=studentdao.getConnection();
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from std where rollno=?");
			ps.setInt(1, rollno);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				s.setName(rs.getString(1));
				s.setRollno(rs.getInt(2));
				s.setAddress(rs.getString(3));
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

}
