public class Library{
    private int bookNum; 
    private Book[] bookList;
    private String librarian;

    public Library(Book[] bookList, String name){
        this.bookList = bookList;
        librarian = name;
        bookNum = bookList.length;
    }


}