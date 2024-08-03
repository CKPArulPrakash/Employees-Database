package com.employee;

import com.mysql.cj.jdbc.Driver;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee_DAO {
	 Connection con; 
	   PreparedStatement pst;
	public Employee_DAO() {
		try {
			DriverManager.registerDriver(new Driver());
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	public  void create()
	{
		String str="create table Employee(id int,ename varchar(20),city varchar(20),dept varchar(20),designation varchar(20),doj varchar(20),dob varchar(20),photo BLOB,salary varchar(15))";
		try {
			Statement st=con.createStatement();
			st.execute(str);
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void insert(int id, String ename, String city, String dept, String designation, String doj, String dob,
			 String salary)//saveEmp
	{
		 String str="insert into employee(id,ename,city,dept,designation,doj,dob,salary) values(?,?,?,?,?,?,?,?)";
		 
			try {
				pst = con.prepareStatement(str);
				pst.setInt(1,id);
				pst.setString(2, ename);
				pst.setString(3, city);
				pst.setString(4, dept);
				pst.setString(5, designation);
				pst.setString(6, doj);
				pst.setString(7, dob);
				pst.setString(8, salary);
				 pst.executeBatch();//return type in array
				   int r= pst.executeUpdate();
				
				    System.out.println("no of statement executed: "+r);
				   		    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   
		   
	}
	public void select(int i)//getEMP(id)
	{
		String str="select * from employee where id="+i;
		 try {
			pst = con.prepareStatement(str);
			ResultSet rs=pst.executeQuery(str);
			System.out.println("id   ename  city   dept   designation    doj   dob   salary");
            rs.next();
			System.out.println(rs.getInt("id")+" "+rs.getString("ename")+" "+rs.getString("city")+" "+rs.getString("dept")+" "+rs.getString("designation")+" "+rs.getString("doj")+" "+rs.getString("dob")+" "+rs.getString("salary"));
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void selectAll()//getEMP(id)
	{
		String str="select * from employee";
		 try {
			pst = con.prepareStatement(str);
			ResultSet rs=pst.executeQuery(str);
			System.out.println("id   ename  city   dept    designation     doj    dob    salary");
            while(rs.next())
            {
			System.out.println(rs.getInt("id")+" "+rs.getString("ename")+" "+rs.getString("city")+" "+rs.getString("dept")+" "+rs.getString("designation")+" "+rs.getString("doj")+" "+rs.getString("dob")+" "+rs.getString("salary"));
            }
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void delete(int i) 
		{
			String str="delete from employee where id="+i;
			try {
				pst=con.prepareStatement(str);
				pst.executeUpdate();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		public void update(int i,String salary)
		{
			String str="update employee set salary ="+salary+" where id="+i;
			try {
				pst=con.prepareStatement(str);
				pst.executeUpdate();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
}