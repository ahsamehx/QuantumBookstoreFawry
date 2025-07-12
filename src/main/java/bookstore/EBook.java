package bookstore;

public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, int year, double price, String author, String fileType) {
        super(isbn, title, year, price, author);
        this.fileType = fileType;
    }

    @Override
    public void handlePurchase(int quantity, String email, String address) {
        System.out.println("Sending eBook to " + email);
        MailService.send(this, email);
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public void reduceStock(int quantity) {
        // No implementation needed as there is no stock here
    }
}
