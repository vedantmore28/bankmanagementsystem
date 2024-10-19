package com.cjc.bankmanagement.serviceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
	import com.cjc.bankmanagement.service.*;
	import com.cjc.bankmanagement.model.*;


	public class Sbi implements Rbi{
		
		Account a=new Account();
		Scanner sc=new Scanner(System.in);
		@Override
		public void createAccount() throws Exception
		{
			//setting name
			{
				System.out.println("Enter your full name");
				a.setName(sc.nextLine().toUpperCase().trim().replaceAll("+", " "));
	         }
			
			while(true) {
			System.out.println("Enter account number");
			//a.setAccno(sc.nextLong());
			int count=0;
			long l1=sc.nextLong();
			for(long i;l1>0;l1=l1/10)
			{
				count++;
			}
			if(count==12)
			{
				a.setAccno(l1);
				break;
			}
			
			}
			
		
			
			
		
	//setting mobile number		
			
			while(true) {
			System.out.println("Enter your mobile number");
			String mobno=sc.next();
		try
		{
		    int count=0; 
		    Long mob=Long.parseLong(mobno);
			while(mob!=0)
			{
				mob/=10;
				count++;
			}
			if(count==10)
			{
				a.setMobno(mob);
				break;
			}
			else 
			{
				System.out.println("Enter valid mobile number");
			}
			
		}
		catch(NumberFormatException e)
		{
			System.out.println("Mobile number cannot contain letters");
		}
			
			while(true)
			{
			System.out.println("Enter your adharno");
			
			String no=sc.next();
		    int count=0; 
		    long n=Long.parseLong(no);
			for(long i=n;i>0;i=i/10)
			{
				count++;
			}
			if(count==12)
			{
				a.setAdharno(no);
				break;
			}
			else 
			{
				System.out.println("Enter valid 12 digit adhar number");
			
			}
			
			}
			
			while(true)
			{
			System.out.println("Enter your choice: 1.Male "
					+ "2.Female\n");
			
			System.out.println("Enter your gender");
			
			int choice=sc.nextInt();
			if(choice==1)
			{
				a.setGender("Male");
				break;
			}
			else if(choice==2)
			{
				a.setGender("Female");
				break;
			}
			else
			{
				System.out.println("Select valid input");
			}
		}

				
			
			
			
			while(true)
			{
			System.out.println("Enter your age");
			a.setAge(sc.nextInt());
			int age=sc.nextInt();
			if(age<18)
			{
				System.out.println("Your age is between 18-80");
			}
			else
			{
				a.setAge(age);
				break;
			}
			}
			
			System.out.println("Enter your balance");
			a.setBalance(sc.nextDouble());
			
			
			}	

		
		}
		
		
		public void displayAllDetails() throws Exception
		{
			
			System.out.println("Account number:"+a.getAccno());
			System.out.println("Account holder name:"+a.getName());
			System.out.println("Account holder mobno:"+a.getMobno());
			System.out.println("Account holder adharno:"+a.getAdharno());
			System.out.println("Account holder gender:"+a.getGender());
			System.out.println("Account holder age:"+a.getAge());
			System.out.println("Account holder start balance:"+a.getBalance());
			
			
            Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
			
			String sql="insert into AccountHolder values(?,?,?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1,a.getAccno());
			ps.setString(2,a.getName());
			ps.setLong(3, a.getMobno());
			ps.setString(4, a.getAdharno());
			ps.setString(5,a.getGender());
			ps.setInt(6, a.getAge());
			ps.setDouble(7, a.getBalance());
			
			ps.execute(sql);
			
			ps.close();
			con.close();
			
			System.out.println("Data inserted into table");  
			
		}
		
		public void  depositeMoney()
		{
			
			System.out.println("Enter your deopsit money");
			double d=sc.nextDouble();
			a.setBalance(a.getBalance()+d);
			
			System.out.println(a.getBalance());
			
		}
		
		public void withdrawal()
		{
			
			
			System.out.println("Enter your withdraw");
			double withdraw=sc.nextDouble();
			 a.setBalance(a.getBalance()-withdraw);
			System.out.println(a.getBalance());
			
		}
		
		public void balanceCheck()
		{
			
			double r=(a.getBalance());
			
			System.out.println("Check your balance after all operations"+r);
			
			
		}
	

}
