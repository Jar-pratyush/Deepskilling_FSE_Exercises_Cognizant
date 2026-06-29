import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

// Testing the Dependency Injection configuration.
public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("--- Loading Spring Context for DI Test ---");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // We only need to fetch the service; Spring already injected the repository inside it!
        BookService service = (BookService) context.getBean("bookService");

        System.out.println("\n--- Executing Service Logic ---");
        service.processBookCheckout();
    }
}