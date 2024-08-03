package com.employee;
import java.util.*;
public class main {
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Select by process by entering no");
		System.out.println("1.create employees database");
		System.out.println("2.insert employees data");
		System.out.println("3.select or retrieve employees specific details");
		System.out.println("4.select all employee deatails");
		System.out.println("5.update employees data");
		System.out.println("6.delete employees data");
		int n=sc.nextInt();
		
		Employee_DAO edao=new Employee_DAO();
		switch(n)
		{
		case 1:
			{
		
				edao.create();
				break;
			}
		case 2:
		{
			
			System.out.println("Number of employee details");
			int k=sc.nextInt();
			
			System.out.println("id ename city dept designation doj dob salary");
			for(int i=0;i<k;i++)
			{
				
			
			
			edao.insert(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next()
					);
			}
			break;
		}
		case 3:{
			System.out.print("Enter your id: ");
			edao.select(sc.nextInt());
			break;
		}
			
		case 4:
		{
			edao.selectAll();
			break;
		}
		case 5:
		{
			System.out.println("Enter id and salary");
			
			edao.update(sc.nextInt(),sc.next());
			break;
		}
		case 6:
		{
			
			System.out.println("Enter id which you want to delete");
			edao.delete(sc.nextInt());
			break;
		}
		}
		
		
	}
	

}