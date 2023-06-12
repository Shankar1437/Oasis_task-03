package oasisTask;

import java.util.ArrayList;
import java.util.Scanner;

public class AtmInterface 
{
	private static String userId = "Shankar";
	private static int pin = 1234;
	private static double balance = 10000;
	
    static ArrayList<String> Amt = new ArrayList<>();


	public static void main(String[] args) 
	{	
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter a User ID : ");
		String enteredUserId = sc.nextLine();
		
		System.out.println("Enter a Pin : ");
		int enteredPin = sc.nextInt();
		
		
		if(userId.equals(enteredUserId) && pin==(enteredPin))
		{
			System.out.println("Login Sucessfully. Welcome, Shankar ! ");
			
			while(true)
			{
				
				System.out.println("\nATM options :- ");
				System.out.println("1. Transition History ");
				System.out.println("2. Withdraw");
				System.out.println("3. Deposit");
				System.out.println("4. Transfer");
				System.out.println("5. Quit");
				
				System.out.println("\nEnter your Choice :");
				int choice = sc.nextInt();
				
				switch(choice)
				{
				case 1 : transitionHist(sc);
							break;
							
				case 2 : withdraw(sc);
							break;
							
				case 3 : deposit(sc);
							break;
							
				case 4 : transfer(sc);
							break;
							
				case 5 : System.out.println("Thank You !");
							System.exit(0);
				
				}
			}
			
		}
		else
		{
			System.out.println("Invalid user ID or PIN. Login failed.");
		}
	}
	private static void transitionHist(Scanner sc)
	{
		for(String d : Amt)
		{
			System.out.println(d);
		}
	}
	
	private static void withdraw(Scanner sc)
	{
		System.out.println("Enter withdraw amount : ");
		double withdrawAmt = sc.nextDouble();
		
		if(withdrawAmt<balance)
		{
			Amt.add("Withdrawal : "+withdrawAmt);
			balance=balance-withdrawAmt;
			System.out.println("Your Balance is : "+balance);
		}
		else
		{
			System.out.println("Insufficient Balance.");
		}
		
	}
	
	private static void deposit(Scanner sc)
	{
		System.out.println("Enter Deposit amount : ");
		double depositAmt = sc.nextDouble();
		Amt.add("Deposit : "+depositAmt);
			
			balance=balance+depositAmt;
			System.out.println("Your Balance is : "+balance);	
		
	}
	
	private static void transfer(Scanner sc)
	{
		
		System.out.println("Enter a receiver's Account Number : ");
		int transferAccNum = sc.nextInt();
		
		System.out.println("Renter Account Number : ");
		int transferAccNumRe = sc.nextInt();
		
		if(transferAccNum == transferAccNumRe)
		{
			
			System.out.println("Enter Transfer amount : ");
			double transferAmt = sc.nextDouble();
			Amt.add("Transfer : "+transferAmt);
			if(transferAmt<balance)
			{
				balance=balance-transferAmt;
				System.out.println("Your Balance is : "+balance);
			}
			else
			{
				System.out.println("Insufficient Balance.");
			}
		}
		else
		{
			System.out.println("Please Enter correct Account Number .");
		}		
	}
}
