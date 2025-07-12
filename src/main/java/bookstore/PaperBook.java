package bookstore;

public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, int year, double price, String author, int stock) {
        super(isbn, title, year, price, author);
        this.stock = stock;
    }

    @Override
    public void handlePurchase(int quantity, String email, String address) {
        if (stock < quantity) {
            System.out.println("Not enough stock for ISBN: " + isbn);
            return;
        }
        reduceStock(quantity);
        System.out.println("Shipping " + quantity + " copies to " + address);
        ShippingService.send(this, quantity, address);
    }

    @Override
    public boolean isAvailable() {
        return stock > 0;
    }

    @Override
    public void reduceStock(int quantity) {
        this.stock -= quantity;
    }
}
