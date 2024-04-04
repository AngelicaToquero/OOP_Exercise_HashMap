import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class BookDA {
    private HashMap<String, Book> bookMap;

    public BookDA() {
        this.bookMap = new HashMap<>();
        // Initialize bookMap from file or database
        populateBookMap();
    }

    private void populateBookMap() {
        // Read Book.csv and populate bookMap
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Book.csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] bookData = line.split(",");
                if (bookData.length >= 3) {
                    String isbn = bookData[0].trim();
                    String title = bookData[1].trim();
                    String authorName = bookData[2].trim();
                    Book book = new Book();
                    book.setIsbn(isbn);
                    book.setTitle(title);
                    addBook(book);
                    setAuthorName(isbn, authorName); // Set author here
                } else {
                    System.out.println("Incomplete data in line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book) {
        bookMap.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        return bookMap.get(isbn);
    }

    // Added setAuthorName() method in BookDA
    public void setAuthorName(String isbn, String authorName) {
        Book book = bookMap.get(isbn);
        if (book != null) {
            book.setAuthorName(authorName);
        }
    }

    // Added getAuthorName() method in BookDA
    public String getAuthorName(String isbn) {
        Book book = bookMap.get(isbn);
        if (book != null) {
            return book.getAuthorName();
        }
        return null;
    }

    // Display report
    public void displayReport(HashMap<String, String> authorMap) {
        for (String isbn : bookMap.keySet()) {
            Book book = bookMap.get(isbn);
            String title = book.getTitle();
            String authorName = book.getAuthorName();
            String bio = authorMap.get(authorName);
            System.out.println(isbn + " " + title);
            System.out.println("\t" + authorName + " - " + bio);
        }
    }
}