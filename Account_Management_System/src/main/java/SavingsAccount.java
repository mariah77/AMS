
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class SavingsAccount extends Account {
	
	private static double interest_rate = 2.0;
	private double[] z;
	private int index = 0;
	public SavingsAccount(String n, String a, String p,String d) {
		super(n,a,p,d);
		z = new double[100];
		for(int i=0; i<100; i++) {
			
			z[i] = 0;
		}
	}
	
	public boolean makeWithdrawal(int a) {
		boolean flag = false; 
		if(login_status == true) {
		if(a>0 ) {
			if(a<=balance) {
				balance -=a;
				flag= true;
			}
			else {
				System.out.println("Withdrawal can't be made becasue withdrawal amount exceeds account balance");
			}
		  	
		}
		else {
			System.out.println("Withdrawal can't be made because withdrawal amount can't be negative");
		}
		
	   }
		return flag;
			
	}
	public void setInterestRate(double i) {
	  if(login_status == true) {
		if(i>0) {
			interest_rate = i;
		}
		
	  }
	}
	public double getInterestRate() {
		
	   if(login_status == true) {
		return interest_rate;
		
	   }
	   else {
		   return 0;
	   }
	}
	private long dateInput(String start,String end) {

        long days = 0;		
		try {
		
		SimpleDateFormat s1 = new SimpleDateFormat("dd-MM-yyyy");
		
		Date d1 = s1.parse(start);
        Date d2 = s1.parse(end);

        long t = d2.getTime() - d1.getTime();
        
        long diffy = (t/ (1000l * 60 * 60 * 24 * 365));

        
        long diffd= (t/ (1000 * 60 * 60 * 24))% 365;

        System.out.println(diffd);

        System.out.println(diffy);
         days = diffy*365+diffd;
        
        
	}
        
        catch (ParseException e) {
            e.printStackTrace();
        }
                
		return days;
	}
	public double calculateInterest(String d2) {
		double amount = 0;
	  if(login_status == true) {
		long days = dateInput(date,d2);
		double d = days /=365;
		
		amount = (d*interest_rate*balance)/100;
		System.out.println("Total Interest : Rs "+ amount );
		
	  }
	  return amount;
	}
	
	public double calculateZakat() {
	  double zakat = 0;
	  if(login_status == true) {
		if(balance>= 20000) {
			
			zakat = (balance*2.5)/100;
			System.out.println("Zakat : Rs "+zakat);	
			z[index] = zakat;
			index++;
			
		}
		else {
			System.out.println("Balance less than Rs 20,000, not eligible for zakat");
			
		}
		
	  }
	  return zakat;
	  
	}
	
	public double[] displayAllDeductions() {
	  if(login_status == true) {
		printStatement();
		for(int i = 0; i<index; i++) {
			int j = i+1;
			System.out.println("Zakat Deduction "+ j +" : "+z[i]);
		}
		
		
	  }
	  return z;
		
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
	   public boolean  transferAmount(SavingsAccount b, int amount) {
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
