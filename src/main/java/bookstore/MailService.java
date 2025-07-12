package bookstore;

public class MailService {
    public static void send(Book book, String email) {
        System.out.println("MailService sent eBook to " + email);
    }
}
