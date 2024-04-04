import java.util.HashMap;

public class BookReport {
    public BookReport() {
        BookDA bookDA = new BookDA();
        AuthorDA authorDA = new AuthorDA(); // Initialize AuthorDA
    }

    public static void main(String[] args) {
        BookDA bookDA = new BookDA();
        AuthorDA authorDA = new AuthorDA(); // Initialize AuthorDA
        bookDA.displayReport(authorDA.getAuthorMap());
    }
}