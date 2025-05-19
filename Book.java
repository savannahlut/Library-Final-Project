public class Book{
    private String genre, title, author;
    
    public Book(String t, String a, String g){
        title = t;
        author = a; 
        genre = g;
    }

    public String getGenre(){
        return genre;
    }
    public String getAuthor(){
        return author;
    }
    public String getTitle(){
        return title;
    }
}