package com.cjc.bankmanagement.client;

import java.util.Scanner;

import com.cjc.bankmanagement.service.Rbi;
import com.cjc.bankmanagement.serviceImpl.Sbi;

public class Test {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		Rbi bank = new Sbi();
		
		boolean flag=true;
		while(flag)
		{
			System.out.println("\nSelect your choice");
		    System.out.println("1.Create account\n2.Display all details\n3.Deposit money\n4.Withdraw money\n5.Check Balance\n6.Exit\n");
		int choice1=sc.nextInt();
		switch(choice1)
		{
		case 1:
			bank.createAccount();
			break;
	
		case 2:	
			bank.displayAllDetails();
			break;
			
		case 3:
			bank.depositeMoney();
			break;
		
		case 4:
			bank.withdrawal();
			break;
		
		case 5:
			bank.balanceCheck();
			break;
		
		case 6:
			flag=false;
		}
	}

	}
}

