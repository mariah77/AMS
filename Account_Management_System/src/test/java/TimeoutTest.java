import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(AccuracyTests.class)
public class TimeoutTest {
	private static Admin user;
    private static double[] p;
    
    @BeforeClass
    public static void init() {
    	user = new Admin("Maria","F7","4893903");
    	user.openAccount(2, "11-06-2021");
    	user.openAccount(1, "11-06-2021");
        p = new double[100];
    	for(int i = 0; i<100; i++)
			p[i] = 0;
    	
    	
    }
	@Test(timeout = 1000)
	public void test1() throws InterruptedException {
		user.setName("Alice");
		assertThat("Alice", is(user.getName()));
	}
	@Test(timeout = 1000)
	public void test2() throws InterruptedException {
		user.setAddress("France");
		assertThat("France", is(user.getAddress()));
	}
	@Test(timeout = 1000)
	public void test() throws InterruptedException {
		user.setPhone("0514444899");
		assertThat("0514444899", is(user.getPhone()));
	}
}
