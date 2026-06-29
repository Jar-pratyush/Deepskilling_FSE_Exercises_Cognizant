import org.junit.Test;
import static org.junit.Assert.assertTrue;

//This is a basic test class to verify that JUnit 4 is correctly configured in the pom.xml.
public class JUnitSetupTest {

    @Test
    public void testJUnitConfiguration() {
        // If this test runs and passes, it means JUnit is successfully installed and working!
        assertTrue("JUnit is working correctly", true);
    }
}