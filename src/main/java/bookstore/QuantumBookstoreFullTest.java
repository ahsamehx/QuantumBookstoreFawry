package bookstore;

public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        BookStore store = new BookStore();
        store.addBook(new PaperBook("1", "Clean Code", 2015, 50.0, "Robert C. Martin", 5));
        store.buyBook("1", 2, "ahmed@example.com", "123 Java Street");

    }
}
