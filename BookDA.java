import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class BookDA {
    private HashMap<String, Book> bookMap;

    public BookDA() {
         this.bookMap = new HashMap<>();
    }
    
    public void addBook(Book book) {
        bookMap.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        return bookMap.get(isbn);
    }

        HashMap<String, String[]> bookMap = new HashMap<>();

        // Read Book.csv and populate HashMap
        try {
            FileReader fileReader = new FileReader("Book.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] bookData = line.split(",");
    
                if (bookData.length >= 3) {
                    String isbn = bookData[0].trim();
                    String title = bookData[1].trim();
                    String author = bookData[2].trim();
                    bookMap.put(isbn, new String[]{title, author});
                } else {
                    
                    System.out.println("Incomplete data in line: " + line);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        HashMap<String, String> authorMap = new HashMap<>();
        try {
            FileReader fileReader = new FileReader("Author.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] authorData = line.split(",");
                String authorName = authorData[0].trim();
                String bio = authorData[1].trim();
                authorMap.put(authorName, bio);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display report
        for (String isbn : bookMap.keySet()) {
            String[] bookData = bookMap.get(isbn);
            String title = bookData[0];
            String authorName = bookData[1];
            String bio = authorMap.get(authorName);
            System.out.println(isbn + " " + title);
            System.out.println("\t" + authorName + " - " + bio);
        }
    }
