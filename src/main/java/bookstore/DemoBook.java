package bookstore;

public class DemoBook extends Book {
    public DemoBook(String isbn, String title, int year, double price, String author) {
        super(isbn, title, year, price, author);
    }

    @Override
    public void handlePurchase(int quantity, String email, String address) {
        System.out.println("Demo books are not for sale.");
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void reduceStock(int quantity) {
        // No implementation needed as there is no stock here
    }
}
