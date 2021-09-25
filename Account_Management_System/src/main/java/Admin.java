import java.util.concurrent.TimeUnit;
public class Admin {

	private String name;
	private String address;
	private String phone_number;
	private int s;
	private int c;
    public SavingsAccount sa;
	public CheckingAccount ca;
	
	public Admin(String n, String a, String p ) {
		name =n;
		address = a;
		phone_number = p;
		sa = null;
		ca = null;
		s = 0;
		c = 0;
	}
	
	public int openAccount(int c1, String d) {
		int b = 0;
		if(s > 0 && c1 == 1) {
			System.out.println("Savings Account Already exists");
			return 0;
		}
		if(c > 0 && c1 == 2) {
			System.out.println("Checking Account already exists");
			return 0;
		}
		
		if(c1 == 1 && s == 0) {
			System.out.println("Savings Account succesfully created");
			sa = new SavingsAccount(name,address,phone_number,d);
			s++;
			b = sa.account_number;
			
		}
		else if(c1 == 2 && c == 0) {
			
			System.out.println("Checking Account succesfully created");
			ca = new CheckingAccount(name,address,phone_number,d);
			c +=1;
			b = ca.account_number;
		}
		
		return b;
		
		
	}
	
	public String getName() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(500);
		return name;
		
	}
	public void setName(String s) {
		name =s;
	}
	
	public String getAddress()  throws InterruptedException{
		TimeUnit.MILLISECONDS.sleep(500);
		return address;
	}
	public void setAddress(String s) {
		address = s;
	}
	
	public String getPhone()  throws InterruptedException{
		TimeUnit.MILLISECONDS.sleep(500);
		return phone_number;
	}
	public void setPhone(String s) {
		phone_number = s;
	}
	
	public SavingsAccount getsa() {
		if(sa!=null) {
		  return sa;
		}
		else {
			System.out.println("Savings Account not created");
			return null;
		}
	}
	
	public CheckingAccount getca() {
		if(ca!=null) {
		  return ca;
		}
		else {
			System.out.println("Checking Account not created");
			return null;
		}
	}
	public boolean closeAccount(int c,int an) {
		boolean flag = false;
        if(c == 1) {
        	if(sa!=null && sa.account_number == an) {
        		
        		sa = null;
        		System.out.println("Savings Account Successfully closed");
        		flag = true;
        	}
        	else {
        		System.out.println("Savings Account doesnot exist");
        	}
        }
        else if(c == 2) {
        	if(ca!=null && ca.account_number == an) {
        		ca = null;
        		System.out.println("Checking Account Successfully closed");
        		flag = true;
        	}
        	else {
        		System.out.println("Checking Account doesnot exist");
        	}
        }
        return flag;
	}
	
}
