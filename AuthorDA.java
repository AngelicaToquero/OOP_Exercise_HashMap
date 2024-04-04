import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class AuthorDA {
    private HashMap<String, Author> authorMap;

    public AuthorDA() {
        this.authorMap = new HashMap<>();

        try (Scanner authorFile = new Scanner(new File("Author.csv"))) {
            while (authorFile.hasNextLine()) {
                String authorLineData = authorFile.nextLine();
                String[] authorData = authorLineData.split(",");
                if (authorData.length >= 2) {
                    String authorName = authorData[0].trim();
                    String bio = authorData[1].trim();
                   
                    Author author = new Author();
                    author.setName(authorName);
                    author.setBio(bio);
                    addAuthor(authorName, author);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addAuthor(String authorName, Author author) {
        authorMap.put(authorName, author);
    }

    public Author getAuthorByAuthorName(String authorName) {
        return authorMap.get(authorName);
    }

    public HashMap<String, Author> getAuthorMap() {
        return authorMap;
    }
}
