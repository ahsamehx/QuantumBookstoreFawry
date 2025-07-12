package bookstore;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected int year;
    protected double price;
    protected String author;

    public Book(String isbn, String title, int year, double price, String author) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.price = price;
        this.author = author;
    }

    public String getIsbn() { return isbn; }
    public int getYear() { return year; }
    public double getPrice() { return price; }

    public abstract void handlePurchase(int quantity, String email, String address);
    public abstract boolean isAvailable();
    public abstract void reduceStock(int quantity);

    @Override
    public String toString() {
        return String.format("%s - %s by %s (%d) [$%.2f]", isbn, title, author, year, price);
    }
}
