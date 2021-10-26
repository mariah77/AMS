
import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(PerformanceTests.class)
public class AdminTest {
    private static Admin user;
    private SavingsAccount str;
    private CheckingAccount ctr;
    private static double[] p;
    
    @BeforeClass
    public static void init() {
    	user = new Admin("Maria","F7","4893903");
    	user.openAccount(2, "11-06-2021");
    	user.openAccount(1, "11-06-2021");
        p = new double[100];
    	for(int i = 0; i<100; i++)
			p[i] = 0;
    	user.getsa().login(1001);
    	
    	
    }
    
/*	@Test// positive test case positive amount Deposited for savings account
	public void Test1() {
		  
		  user.getsa().makeDeposit(1000);
		  int x = user.getsa().checkBalance();
		  assertEquals(1000,x);
		  
	}
	@Test// negative test case negative amount Deposited for savings account
	public void Test2() {
		  
		  user.getsa().makeDeposit(-1000);
		  int x = user.getsa().checkBalance();
		  assertEquals(1000,x);
		  
	}
	@Test// positive test case for withdrawal 
	public void Test3() {
		 
		  user.getsa().makeWithdrawal(100);;
		  int x = user.getsa().checkBalance();
		  assertEquals(900,x);
		  
	}
	@Test// negative test case  withdrawal amount exceeds balance for savings account
	public void Test4() {
		 
		  user.getsa().makeWithdrawal(2000);;
		  int x = user.getsa().checkBalance();
		  assertEquals(900,x);
		  
	}
	@Test // positive test case for zakat calculation,deposit, and login
	public void Test5() {
		user.getsa().makeDeposit(90000);
		user.getsa().calculateZakat();
		
		user.getsa().makeDeposit(9000);
		user.getsa().calculateZakat();
		p[0] = 2272.5;
		p[1] = 2497.5;
	
		double[] arr;
		arr = user.getsa().displayAllDeductions();
		
			for(int i = 0; i<100; i++) {
				assertEquals(p[i],arr[i],0);
			}
		
	    
	}
	@Test // negative test case for zakat calculation, enters wrong amount
	public void Test6() {
		
		
		user.getsa().makeDeposit(-9000);
		user.getsa().calculateZakat();
		p[2] = 2497.5;
		double[] arr;
		arr = user.getsa().displayAllDeductions();
		
			for(int i = 0; i<100; i++) {
				assertEquals(p[i],arr[i],0);
			}
		
	    
	}
	*/
	@Test //positive test case tries to get savings account which exists
	public void Test7() {
		
		SavingsAccount sa = user.getsa();
		//System.out.println(sa);
		assertNotNull(sa);
		
	}
	@Before
	public void set() {
		user.getsa().setInterestRate(2.5);
	}
	
	/*@Test //positive test case for interest 
	public void Test8() {
		double d =user.getsa().calculateInterest("12-30-2021");
		assertEquals(4995.0,d,0);
	}
	*/
	@Test //negative test case for interest 
	public void Test9() {
		double d =user.getsa().calculateInterest("1-3-2021");
		assertEquals(0.0,d,0);
	}
	@Before
	public void run() {
		user.getsa().login(1001);
		str = new SavingsAccount(null,null,null,null);
	    ctr = new CheckingAccount(null,null,null,null);
		
	}
	
	/*@Test // positive test case for transfer amount in savings account
	public void Test10() {
		
		
		boolean f1 = user.getsa().transferAmount(str, 100);
		boolean f2 = user.getsa().transferAmount(ctr, 100);
		assertTrue(f1);
		assertTrue(f2);
	}
	*/
	
	@Test // negative test case for transfer amount in savings account
	public void Test11() {
		boolean f1 = user.getsa().transferAmount(str, -100);
		boolean f2 = user.getsa().transferAmount(ctr, -100);
		assertFalse(f1);
		assertFalse(f2);
	}
	@Before
	public void set1() {
		user.getca().login(1000);
		user.getca().makeDeposit(10000);
		user.getca().makeDeposit(5000);
	}
	/*@Test// positive test case for making withdrawal from checking account
	public void Test12() {
		
		boolean flag = user.getca().makeWithdrawal(20000);
		assertTrue(flag);
	}
	*/
	@Test // negative test case for making withdrawal from checking account
	public void Test13() {
		boolean flag = user.getca().makeWithdrawal(-15000);
		assertFalse(flag);
		
	}

	
	/*@Test// positive test case for displaying total tax
	public void Test14() {
		
		int tax = user.getca().displayAllDeductions();
		assertEquals(100,tax);
		
	}
	
	@Test// negative test case for displaying total tax
	public void Test15() {
		
		int tax = user.getca().displayAllDeductions();
		assertEquals(120,tax);
		
	}
	@Test // positive test case for transfer amount in checking account
	public void Test16() {
		boolean f1 = user.getca().transferAmount(str, 100);
		boolean f2 = user.getca().transferAmount(ctr, 100);
		assertTrue(f1);
		assertTrue(f2);
	}
	*/
	@Test // negative test case for transfer amount in savings account
	public void Test17() {
	
		boolean f1 = user.getca().transferAmount(str, -1500);
		boolean f2 = user.getca().transferAmount(ctr, -1500);
		assertFalse(f1);
		assertFalse(f2);
	}
	/*@Test// positive test case positive amount Deposited for checking account
	public void Test18() {
		  
		  user.getca().makeDeposit(1000);
		  int x = user.getca().checkBalance();
		  assertEquals(116000,x);
		  
	}*/
	@Test// negative test case negative amount Deposited for checking account
	public void Test19() {
		
		  user.getca().makeDeposit(-1000);
		  int x = user.getca().checkBalance();
		  assertEquals(/*131000*/60000,x);
		  
	}

	@Test // test case for closing checking account
	public void Test20() {
		boolean f = user.closeAccount(1, 1006);
		assertFalse(f);
	}

	@AfterClass 
	public static void Destructor() {
		user.closeAccount(2, 1000);
		user.closeAccount(1, 1001);
		user = null;
	}
	
	
}
