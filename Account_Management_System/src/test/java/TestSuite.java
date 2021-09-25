
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.experimental.categories.Categories;

@RunWith(Categories.class)
@Categories.IncludeCategory({PerformanceTests.class , AccuracyTests.class})

@SuiteClasses({ AdminTest.class, TimeoutTest.class })
public class TestSuite {
	// This class remains empty, it is used only as a holder for the above annotations	
}
