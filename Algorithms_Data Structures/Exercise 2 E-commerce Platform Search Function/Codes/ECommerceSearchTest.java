import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearchTest {
    public static void main(String[] args) {
        // Setup array of products (Notice they are unsorted initially)
        Product[] inventory = {
                new Product(105, "Wireless Mouse", "Electronics"),
                new Product(101, "Mechanical Keyboard", "Electronics"),
                new Product(109, "Desk Lamp", "Furniture"),
                new Product(103, "Coffee Mug", "Kitchen"),
                new Product(107, "Ergonomic Chair", "Furniture")
        };

        System.out.println("--- LINEAR SEARCH O(n) ---");
        Product foundLinear = SearchAlgorithms.linearSearch(inventory, 109);
        System.out.println("Searching for ID 109: " + (foundLinear != null ? foundLinear : "Not Found"));

        System.out.println("\n--- PREPARING FOR BINARY SEARCH ---");
        // Binary search REQUIRES a sorted array
        Arrays.sort(inventory, Comparator.comparingInt(Product::getProductId));
        System.out.println("Inventory sorted by ID.");

        System.out.println("\n--- BINARY SEARCH O(log n) ---");
        Product foundBinary = SearchAlgorithms.binarySearch(inventory, 107);
        System.out.println("Searching for ID 107: " + (foundBinary != null ? foundBinary : "Not Found"));

        System.out.println("\n--- ALGORITHM ANALYSIS ---");
        System.out.println("Binary Search is vastly superior for our e-commerce platform because it runs in O(log n) time.");
        System.out.println("As our product catalog grows to millions of items, Linear Search O(n) would cause the site to lag, while Binary Search will remain almost instant.");
    }
}