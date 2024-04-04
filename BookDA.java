import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class BookDA {
    private HashMap<String, Book> bookMap;
    private HashMap<String, String> authorNameMap; 
    private AuthorDA authorDA;

    public BookDA() {
        this.bookMap = new HashMap<>();
        this.authorNameMap = new HashMap<>();
        this.authorDA = new AuthorDA(); 

        try (Scanner bookFile = new Scanner(new File("Book.csv"))) {
            while (bookFile.hasNextLine()) {
                String line = bookFile.nextLine();
                String[] bookData = line.split(",");
                if (bookData.length >= 3) {
                    String isbn = bookData[0].trim();
                    String title = bookData[1].trim();
                    String authorName = bookData[2].trim();
                    
                    Book book = new Book();
                    book.setIsbn(isbn);
                    book.setTitle(title);
                    addBook(book);
                    setAuthorName(isbn, authorName); 
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBook(Book book) {
        bookMap.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        return bookMap.get(isbn);
    }

    public void setAuthorName(String isbn, String authorName) {
        authorNameMap.put(isbn, authorName); 
    }

    public String getAuthorName(String isbn) {
        return authorNameMap.get(isbn); 
    }

    public void displayReport() {
        HashMap<String, Author> authorMap = authorDA.getAuthorMap();
        for (String isbn : bookMap.keySet()) {
            Book book = bookMap.get(isbn);
            String title = book.getTitle();
            String authorName = getAuthorName(isbn); 
            Author author = authorMap.get(authorName);
            String bio = author != null ? author.getBio() : ""; 
            System.out.println(isbn + " " + title);
            System.out.println("\t" + authorName + " - " + bio);
        }
    }
}
