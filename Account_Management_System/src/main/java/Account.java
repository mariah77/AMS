
public abstract class Account {
	
	protected static int i = 1000;
	protected int account_number;
	protected String name;
	protected String address;
	protected String phone_number;
	protected int balance;
	protected String date; 
	protected boolean login_status;
	
	
	public Account(String n, String a, String p,String d) {
		account_number = i;
		i++;
		name = n;
		address = a;
		phone_number = p;
		balance = 0;
		date = d; 
		login_status = false;
		System.out.println("Your account number is "+account_number);
		
	   
		
	   }
	public void setBalance(int b) {
		if(login_status == true) {
		  if(b>0) {
		    balance +=b;
		   }
		
		}
	}
	
	public void checkBalance() {
		if(login_status == true) {
		  System.out.println("Name : "+ name);
		  System.out.println("Current account balance : "+ balance);
		}
	}
	public void makeDeposit(int a) {
	  if(login_status == true) {
		if(a>0) {
			
			balance +=a;
		}
		else {
			System.out.println("Deposit can't be made");
		}
		
	  }
		
	}
	public abstract void makeWithdrawal(int a);
	
	public void transferAmount(Account b, int amount) {
	  if(login_status == true) {
		if(b.account_number != account_number) {
			if(amount>0) {
				b.setBalance(amount);
				System.out.println("Amount succesfully transferred");
			}
			else {
				System.out.println("Transfer can't be made");
			}
			
		}
		else {
			System.out.println("Transfer can't be made");
		}
		
	  }
	}
	
	public void printStatement() {
		
	  if(login_status == true) {
		System.out.println("Account Holder's Name : "+name);
		System.out.println("Address : "+address);
		System.out.println("Phone number : "+phone_number);
		System.out.println("Date of Account Creation : "+date); 
		System.out.println("Account Number : "+account_number);
		System.out.println("Current Balance : "+ balance);
		
	  }
		
	}
	
	public void login(int a) {
		if(a == account_number ) {
			login_status = true;
			System.out.println("Successfully logged in");
		}
		else {
			System.out.println("Wrong account number, can't login");
		}
		
	}
	public boolean getlogin() {
		return login_status;
	}
	

}
