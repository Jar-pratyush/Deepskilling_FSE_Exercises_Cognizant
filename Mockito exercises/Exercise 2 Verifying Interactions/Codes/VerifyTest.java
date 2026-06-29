import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

//Using Mockito to verify that my service actually communicated with the dependency exactly as expected.
public class VerifyTest {

    @Test
    public void testVerifyInteraction() {
        // 1. Create a mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // 2. Call the method
        service.fetchData();

        // 3. Verify the interaction occurred
        verify(mockApi).getData();
    }
}