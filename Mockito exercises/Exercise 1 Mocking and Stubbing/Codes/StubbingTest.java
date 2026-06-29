import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Using Mockito to fake an external API dependency and force it to return specific data.
public class StubbingTest {

    @Test
    public void testExternalApi() {
        // 1. Create a mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Stub the method to return predefined values
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Write a test case using the mock
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }
}