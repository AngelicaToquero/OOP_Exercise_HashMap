import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class BookDA {
    private HashMap<String, Book> bookMap;

    public BookDA() {

        try {
            Scanner bookFile = new Scanner(new FileReader("Book.csv"));
            bookFile.nextLine();

            while (bookFile.hasNext()) {

                bookMap = new HashMap<>();
                String bookLineData = new String();
                bookLineData = bookFile.nextLine();

                String[] bookLineDataSpecific = new String[3];
                bookLineDataSpecific = bookLineData.split(",");

                Book book = new Book();
                book.setIsbn(bookLineDataSpecific[0].trim());
                book.setTitle(bookLineData);(bookLineDataSpecific[1].trim());
                book.setAuthor((bookLineDataSpecific[2]));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void printReport(Book book) {
        for (Map.Entry<String, Book> entryMap : book.getBookMap().entrySet()) {
            System.out.print(entryMap.getValue().getIsbn());
            System.out.print(entryMap.getValue().getTitle());
            System.out.print(entryMap.getValue().getAuthor());
            System.out.println(entryMap.getValue().getBio());
        }
        System.out.println();
    }
    }
   
