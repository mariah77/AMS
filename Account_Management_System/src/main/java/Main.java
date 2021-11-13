import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		SavingsAccount str = new SavingsAccount(null,null,null,null);
		CheckingAccount ctr = new CheckingAccount(null,null,null,null);
		
		/*********** menu *******************/
        int choice = 0;
        Scanner cin = new Scanner(System.in);
        System.out.println("Hello User welcome to Account Mangement system ");
        System.out.println("Enter name : ");
        String name = cin.nextLine();
        System.out.println("Enter address : ");
        String add = cin.nextLine();
        System.out.println("Enter phone number : ");
        String phone = cin.nextLine();
        
        Admin user = new Admin(name,add,phone);
        		
        
		do {
		   System.out.println("1) Open a new Account ");
		   System.out.println("2) Close an Account ");
		   System.out.println("3) Login into an Account ");
		   System.out.println("4) Perform Account Operations (login first)");
		   System.out.println("5) Specify Interest Rate (Savings Account Only) (login first) ");
		   System.out.println("6) Display Account Details (login first)");
		   System.out.println("7) Display Account Deductions along with account details (login first)");
		   System.out.println("8) Exit ");
		   System.out.println("Select one of the above ");
		   choice = cin.nextInt();
			
		   if(choice == 1) {
			   
		       
		       System.out.println("Do you want to open SavingsAccount(1) or CheckingAccount(2) : ");
		       int c = cin.nextInt();
		       cin.nextLine(); 
		       System.out.println("Enter date as mm-dd-yyyy : ");
		       String date = cin.nextLine();
		       
		       user.openAccount(c, date);
		       System.out.println("\n");
		   }
		   
		   else if(choice == 2) {
			   System.out.println("Do you want to close SavingsAccount(1) or CheckingAccount(2) : ");
			   int c = cin.nextInt();
		       cin.nextLine(); 
		       System.out.println("Enter account number(4 digit number) : ");
		       int an = cin.nextInt();
		       user.closeAccount(c, an);
		       System.out.println("\n");
		       
		   }
		   else if(choice == 3) {
			   System.out.println("Do you want to Login into SavingsAccount(1) or CheckingAccount(2) : ");
			   int c = cin.nextInt();
			   cin.nextLine(); 
			   System.out.println("Enter account number(4 digit number) : ");
		       int an = cin.nextInt();
		       if(c==1) {
		    	   user.getsa().login(an);
		       }
		       else if(c ==2) {
		    	   user.getca().login(an);
		       }
		       
		       System.out.println("\n");
		   }
		   
		   else if(choice == 4 ) {
			   
			   System.out.println("Do you want to Login into SavingsAccount(1) or CheckingAccount(2) : ");
			   int c = cin.nextInt();
			   cin.nextLine(); 
			   System.out.println("Enter account number(4 digit number) : ");
		       int an = cin.nextInt();
		       if(c==1) {
		    	   user.getsa().login(an);
		    	   if(user.getsa().getlogin()) {
		    	   int select = 0;
		    	   do {
		    	      System.out.println("1) Deposit amount");
		    	      System.out.println("2) Withdraw amount");
		    	      System.out.println("3) Transfer amount");
		    	      System.out.println("4) Check current Balance");
		    	      System.out.println("5) Find Interest");
		    	      System.out.println("6) Find Zakat");
		    	      System.out.println("7) Exit");
		    	      System.out.println("Select one of the above ");
				      select = cin.nextInt();
				      if(select == 1) {
					     System.out.println("Enter amount to deposit ");
					     int amount = cin.nextInt();
					      user.getsa().makeDeposit(amount);
					      System.out.println("\n");
				         }
				      else if(select == 2) {
				    	  System.out.println("Enter amount to withdraw ");
						  int amount = cin.nextInt();
						  user.getsa().makeWithdrawal(amount);
						  System.out.println("\n");
				      }
				      else if(select == 3) {
				    	  System.out.println("Do you want to transfer into another SavingsAccount(1) or CheckingAccount(2) : ");
						  int c1 = cin.nextInt();
						  cin.nextLine(); 
						  System.out.println("Enter account number of that account(4 digit number) : ");
					      int an1 = cin.nextInt();
					      if(c1 == 1) {
					    	  user.getsa().transferAmount(str, an1);
					    	  
					      }
					      else if(c1 == 2) {
					    	  user.getsa().transferAmount(ctr, an1);
					      }
					      System.out.println("\n");
				    	  
				      }
				      else if(select ==4) {
				    	  user.getsa().checkBalance();
				      }
				      else if(select == 5) {
				    	  System.out.println("Enter date as mm-dd-yyyy : ");
					      String date1 = cin.nextLine();
					      cin.nextLine();
					      user.getsa().calculateInterest(date1);
				      }
				      else if(select == 6) {
				    	  user.getsa().calculateZakat();
				      }
		    	     
		    	   }while(select>=1 && select<=6);
		         } 
		       }
		       else if(c ==2) {
		    	   user.getca().login(an);
		    	   if(user.getca().getlogin()) {
		    	   int select = 0;
		    	   do {
		    	      System.out.println("1) Deposit amount");
		    	      System.out.println("2) Withdraw amount");
		    	      System.out.println("3) Transfer amount");
		    	      System.out.println("4) Check current Balance");      
		    	      System.out.println("6) Exit");
		    	      System.out.println("Select one of the above ");
				      select = cin.nextInt();
				      if(select == 1) {
					     System.out.println("Enter amount to deposit ");
					     int amount = cin.nextInt();
					      user.getca().makeDeposit(amount);
					      System.out.println("\n");
				         }
				      else if(select == 2) {
				    	  System.out.println("Enter amount to withdraw ");
						  int amount = cin.nextInt();
						  user.getca().makeWithdrawal(amount);
						  System.out.println("\n");
				      }
				      else if(select == 3) {
				    	  System.out.println("Do you want to transfer into another SavingsAccount(1) or CheckingAccount(2) : ");
						  int c1 = cin.nextInt();
						  cin.nextLine(); 
						  System.out.println("Enter account number of that account(4 digit number) : ");
					      int an1 = cin.nextInt();
					      if(c1 == 1) {
					    	  user.getca().transferAmount(str, an1);
					    	  
					      }
					      else if(c1 == 2) {
					    	  user.getca().transferAmount(ctr, an1);
					      }
					      System.out.println("\n");
				    	  
				      }
				      else if(select ==4) {
				    	  user.getca().checkBalance();
				      }
				      
		    	     
		    	   }while(select>=1 && select<=4);
		    	  }
		       }
		       
		       System.out.println("\n");
		       
		       
			   
		   }
		   else if(choice == 5) {
			   
			   System.out.println("Enter account number(4 digit number) for Savings Account : ");
		       int acc = cin.nextInt();
		       user.getsa().login(acc);
		       if(user.getsa().getlogin()) {
		    	   System.out.println("Interset Rate : "+user.getsa().getInterestRate());
		       }
		       else {
		    	   System.out.println("Wrong account number");
		       }
		       
		   }
		   else if(choice == 6) {
			   System.out.println("Do you want to Login into SavingsAccount(1) or CheckingAccount(2) : ");
			   int c3 = cin.nextInt();
			   cin.nextLine(); 
			   System.out.println("Enter account number(4 digit number) : ");
		       int ann = cin.nextInt();
		       if(c3 == 1) {
		    	   user.getsa().login(ann);
		    	   if(user.getsa().getlogin()) {
		    		   user.getsa().printStatement();
		    	   }
		    	   else {
		    		   System.out.println("Wrong account number");
		    	   }
		    	   
		       }
		       else if(c3 == 2) {
		    	   user.getca().login(ann);
		    	   if(user.getca().getlogin()) {
		    		   user.getca().printStatement();
		    	   }
		    	   else {
		    		   System.out.println("Wrong account number");
		    	   }
		    	   
		       }
		       
			   
		   }
		   
		   else if(choice == 7) {
			   
			   System.out.println("Do you want to Login into SavingsAccount(1) or CheckingAccount(2) : ");
			   int c3 = cin.nextInt();
			   cin.nextLine(); 
			   System.out.println("Enter account number(4 digit number) : ");
		       int ann = cin.nextInt();
		       if(c3 == 1) {
		    	   user.getsa().login(ann);
		    	   if(user.getsa().getlogin()) {
		    		   user.getsa().displayAllDeductions();
		    	   }
		    	   else {
		    		   System.out.println("Wrong account number");
		    	   }
		    	   
		       }
		       else if(c3 == 2) {
		    	   user.getca().login(ann);
		    	   if(user.getca().getlogin()) {
		    		   user.getca().displayAllDeductions();
		    	   }
		    	   else {
		    		   System.out.println("Wrong account number");
		    	   }
		    	   
		       }
		       
			   
		   }
			
			
			
		}while(choice>=1 && choice<=7);

				
		//cin.close();//closing scanner object
		
		
		
		
		
		MYSQLHandler mysql = new MYSQLHandler();
		OracleDBHandler sql = new OracleDBHandler();
		FileHandler f = new FileHandler();
		
		int choice1 = 0;
		do {
			System.out.println("1) Store data in file");
			System.out.println("2) Store data in Oracle");
			System.out.println("3) Store data in Mysql");
			System.out.println("0) Exit");
			System.out.println("Enter choice : ");
			choice1 = cin.nextInt();
			
		  if(choice1 == 1) {
			  try {
				f.addcustomer(user.getName(), user.getAddress(), user.getPhone());
				if(user.getsa()!=null) {
					f.addsavingsaccount(user.getsa().getaccountnumber(), user.getName(), user.getsa().getInterestRate(), user.getsa().calculateZakat());
				}
				else {
					System.out.println("Cannot insert data, savings account doesnot exist");
				}
				if(user.getca()!=null) {
					f.addcheckingaccount(user.getca().getaccountnumber(), user.getName(), user.getca().gettransaction(), user.getca().gettot());
				}
				else {
					System.out.println("Cannot insert data, checking account doesnot exist");
				}
			    } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			   }
		  }
				
			  else if(choice1 == 2) {
				  try {
					sql.addcustomer(user.getName(), user.getAddress(), user.getPhone());
					if(user.getsa()!=null) {
						sql.addsavingsaccount(user.getsa().getaccountnumber(), user.getName(), user.getsa().getInterestRate(), user.getsa().calculateZakat());
					}
					else {
						System.out.println("Cannot insert data, savings account doesnot exist");
					}
					if(user.getca()!=null) {
						sql.addcheckingaccount(user.getca().getaccountnumber(), user.getName(), user.getca().gettransaction(), user.getca().gettot());
					}
					else {
						System.out.println("Cannot insert data, checking account doesnot exist");
					}
				    } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
				  
		      }
		  
			  else if(choice1 == 3) {
				  try {
					mysql.addcustomer(user.getName(), user.getAddress(), user.getPhone());
					if(user.getsa()!=null) {
						mysql.addsavingsaccount(user.getsa().getaccountnumber(), user.getName(), user.getsa().getInterestRate(), user.getsa().calculateZakat());
					}
					else {
						System.out.println("Cannot insert data, savings account doesnot exist");
					}
					if(user.getca()!=null) {
						mysql.addcheckingaccount(user.getca().getaccountnumber(), user.getName(), user.getca().gettransaction(), user.getca().gettot());
					}
					else {
						System.out.println("Cannot insert data, checking account doesnot exist");
					}
				    } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
				  
		      }
				
				
			
			
		}while(choice1!=0);
			
		
	}

}
 