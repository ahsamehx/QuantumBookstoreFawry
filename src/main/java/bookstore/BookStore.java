package bookstore;

import java.util.*;

public class BookStore {
    private Map<String, Book> inventory = new HashMap<>();

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Added book " + book);
    }

    public Book removeBook(String isbn) {
        return inventory.remove(isbn);
    }

    public List<Book> removeOutdatedBooks(int maxAge) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Book> removed = new ArrayList<>();

        Iterator<Map.Entry<String, Book>> it = inventory.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Book> entry = it.next();
            Book book = entry.getValue();
            if (currentYear - book.getYear() > maxAge) {
                removed.add(book);
                it.remove();
                System.out.println("Removed outdated book " + book);
            }
        }
        return removed;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);
        if (book == null) {
            System.out.println("Book not found: " + isbn);
            return 0.0;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is not available for purchase: " + isbn);
            return 0.0;
        }

        book.handlePurchase(quantity, email, address);
        double totalPrice = book.getPrice() * quantity;
        System.out.println("Purchase completed. Total: $" + totalPrice);
        return totalPrice;
    }
}
