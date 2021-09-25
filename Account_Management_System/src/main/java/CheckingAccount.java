
public class CheckingAccount extends Account{
   private int track;
   private static int transaction_fee = 10;
   private int[] total_tax;
   private int size;
   public CheckingAccount(String n, String a, String p,String d) {
	   super(n,a,p,d);
	   track = 0;
	   size = 0;
	   total_tax = null;
	   
   }
   public boolean makeWithdrawal(int a) {
	   boolean flag = false;
	 if(login_status == true) {
	   if(a>0) {
	      if(a>balance) {
		     int deduction = a-balance ;
		     if(deduction<=5000) {
			    balance -=a;
		      }
		     else {
			   balance -=5000;
		     }
	       }
	      else {
	    	  balance -=a;
	        }
	      track++;
	      flag = true;
	     }
	   else {
		   System.out.println("Withdrawal can't be made, withdrawal amount is negative");
	   }
		if(track > 2) {
			calculateTax();
		}
		
	 }
	 return flag;
	  
   }
   public void makeDeposit(int a) {
	   if(login_status == true) {
		if(a>0) {
			
			balance +=a;
			
			track++;	
			
			
		}
		else {
			System.out.println("Deposit can't be made");
		}
		
		if(track > 2) {
			calculateTax();
		}
		
	  }
	
	}
   public int getTrack() {
	 if(login_status == true) {
	   return track;
	 }
	 else {
		 return 0;
	 }
   }
   
   private void calculateTax() {
	   
	 if(login_status == true) {
	 
	   if(size == 0) {
		   size++;
		   total_tax = new int[size];
		   for(int i =0; i<size; i++) {
			   total_tax[i] = transaction_fee;
		   }
	   }
	   else {

		   size++;
		   total_tax = new int[size];
		   for(int i=0; i<size; i++) {
			   total_tax[i] = transaction_fee;
		   }
	   }
	   
	 }
	   
   }
   
   public int displayAllDeductions() {
	   int total = 0;
	 if(login_status == true) {
	 
	   for(int i = 0; i<size; i++) {
		   int j=i+3;
		   System.out.println("Tax Deduction for transaction "+ j +" : "+total_tax[i]);
		   total+=total_tax[i];
		   System.out.println("Total tax : "+total);
	   }
	   
	 }
	 return total;
   }
   
   public boolean transferAmount(CheckingAccount b, int amount) {
	   boolean flag = false;
	 if(login_status == true) {
	   if(b.account_number != account_number) {
			if(amount>0) {
				b.setBalance(amount);
				System.out.println("Amount succesfully transferred");
				flag = true;
			}
			else {
				System.out.println("Transfer can't be made");
			}
			
		}
		else {
			System.out.println("Transfer can't be made");
		}
	   
	 }
	 return flag;
	   
   }
   public boolean transferAmount(SavingsAccount b, int amount) {
	  boolean flag = false;
	 if(login_status == true) {
	   if(b.account_number != account_number) {
			if(amount>0) {
				b.setBalance(amount);
				System.out.println("Amount succesfully transferred");
				flag = true;
			}
			else {
				System.out.println("Transfer can't be made");
			}
			
		}
		else {
			System.out.println("Transfer can't be made");
		}
	   
	 }
	   return flag;
   }
}
