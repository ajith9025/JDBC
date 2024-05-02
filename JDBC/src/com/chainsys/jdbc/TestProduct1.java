package com.chainsys.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TestProduct1 {
	
	

	private static String signup;
	private static String login;
	

	@SuppressWarnings({ "static-access", "unused" })
	
		
	public  static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Jdbc.insert(4, "mani", 276335, 14, "snacks", 40, 400,4000);
		//Jdbc.delete(4);
		
	      
		

		Scanner sc = new Scanner(System.in);
		GroceryApp groceryapp = new GroceryApp();
		
		ABCGrocery grocery=new ABCGrocery();
		grocery.addToWelcome();
		
		System.out.println();
        System.out.println("   select the option(1 to 2)"   );
		System.out.println();
        System.out.println("1)----------Login page----------\n2)----------Signup page----------");
		int n = sc.nextInt();
		if (n == 1) {
			System.out.println("Enter the user name:");
			String userName = sc.next();
			while (true) {
				if (userName.equals("ajith@123")) {
					System.out.println("valid");
					System.out.println("Enter the password:");
					String password = sc.next();
					GroceryApp.login(login);

					double items = 3;
//				while (items > 2) {
//					System.out.println("we only have 2 items ");
//					items = sc.nextDouble();
//				}
				    ArrayList<String> al=new ArrayList<String>();
				   // System.out.println("select the product");
					//System.out.println("1.snacks");
				   // System.out.println("2.vegetable");
					//System.out.println("3.fruits");
				   //int choice = sc.nextInt();
				    al.add("select the product");
				    al.add("1.snacks");
				    al.add("2.vegatable");
				    al.add("3.fruits");
				    for(String product :al)
				    	System.out.println(product);
				    
				    int choice = sc.nextInt();
				    

				switch (choice) {
					case 1:
						System.out.println("snacks");
						GroceryApp.snacks();
						break;
					case 2:
						System.out.println("vegetable");
						GroceryApp.vegetable();
						break;
					case 3:
						System.out.println("fruits");
						GroceryApp.fruits();
						break;

					}
					
				//	System.out.println("add to card:" + choice);
				    
					System.out.println("Enter the total qty:");
					int qty = sc.nextInt();
//					System.out.println("Enter the price Rs:");
//					int price = sc.nextInt();
//					System.out.println("Enter the productId:");
	//				int productId = sc.nextInt();
					List<String> a=new ArrayList<String>();
					/*System.out.println("Select the payment mode");
					System.out.println("1.online cash");
					System.out.println("2.cash on delivery");
					System.out.println();*/
			        a.add("Select the payment mode");
			        a.add("1.online cash");
			        a.add("2.cash on delivery");
			        for(String payment:a)
			        	System.out.println(payment);
			        
					int paymentmode = sc.nextInt();

					switch (paymentmode) {
					case 1:
						System.out.println("online cash");
						break;

					case 2:
						System.out.println("cash on delivery");

						break;

					}
					System.out.println();
					ABCGrocery grocery1=new ABCGrocery();
				    grocery1.addToAddress();
					grocery1.location();
					grocery1.customerName();
		            grocery1.review();

					groceryapp.purchase(userName);
					groceryapp.purchase(items, qty, 10);
					groceryapp.purchase(125);
					int totalPrice = 0;
					groceryapp.purchase(10, qty, totalPrice);
				
					break;
					 
			
				    }	 else {
					System.out.println("Invalid(add the special character and numbers)");

					userName = sc.next();

				}
			}
			
		if (n == 2) {
			System.out.println("Enter the first name:");
			String a = sc.next();
			System.out.println("Enter the second name:");
			String b = sc.next();
			System.out.println("Enter the email:");
			String c = sc.next();
			System.out.println("Enter the password:");
			int d = sc.nextInt();
			System.out.println("Enter the conform password:");
			int e = sc.nextInt();
			GroceryApp.signup(signup);

		}
		
		System.out.println();
		ABCGrocery grocery1=new ABCGrocery();
		grocery1.thanksInformation();
		sc.close();
	}

	}
}
