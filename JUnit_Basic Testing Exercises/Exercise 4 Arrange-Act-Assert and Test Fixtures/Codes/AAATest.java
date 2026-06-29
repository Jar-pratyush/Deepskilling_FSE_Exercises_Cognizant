import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

//Demonstrating the Arrange-Act-Assert pattern and setup/teardown hooks.
public class AAATest {

    private String testString;

    @Before
    public void setUp() {
        // Setup method runs before every test
        testString = "Hello";
        System.out.println("Setting up test fixture...");
    }

    @Test
    public void testStringLength_usingAAAPattern() {
        // 1. Arrange: Prepare the data
        String expectedResult = "Hello World";

        // 2. Act: Execute the behavior
        String actualResult = testString + " World";

        // 3. Assert: Verify the outcome
        assertEquals(expectedResult, actualResult);
    }

    @After
    public void tearDown() {
        // Teardown method runs after every test
        testString = null;
        System.out.println("Tearing down test fixture...");
    }
}