public class Book {
    String isbn;
    String title;
    String authorName;
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthorName() {
        return authorName;
    }
}
