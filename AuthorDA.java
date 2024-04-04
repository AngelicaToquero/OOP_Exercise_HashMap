import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class AuthorDA {
    private HashMap<String, String> authorMap;

    public AuthorDA() {
        this.authorMap = new HashMap<>();
        // Initialize authorMap from file or database
        populateAuthorMap();
    }

    private void populateAuthorMap() {
        // Read Author.csv and populate authorMap
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Author.csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] authorData = line.split(",");
                if (authorData.length >= 2) {
                    String authorName = authorData[0].trim();
                    String bio = authorData[1].trim();
                    addAuthor(authorName, bio);
                } else {
                    System.out.println("Incomplete data in line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAuthor(String authorName, String bio) {
        authorMap.put(authorName, bio);
    }

    public String getBioByAuthorName(String authorName) {
        return authorMap.get(authorName);
    }

    // Method to get the author map
    public HashMap<String, String> getAuthorMap() {
        return authorMap;
    }
}
