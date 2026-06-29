import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.repository.BookRepository;

// The main application that loads the Spring context and tests the bean creation.
public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("--- Starting Spring Application Context ---");

        // Load the Spring context from the XML configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("--- Context Loaded. Fetching Beans ---");

        // Retrieve beans to verify they were configured correctly
        BookService service = (BookService) context.getBean("bookService");
        service.displayServiceStatus();

        BookRepository repo = (BookRepository) context.getBean("bookRepository");
        repo.fetchBooks();
    }
}