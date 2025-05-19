import java.util.ArrayList;

public class Library{
    private int bookNum; 
    private ArrayList<Book> bookList;
    private String librarian;

    private String commonG , commonA;

    public Library(ArrayList<Book> bookList, String name){
        this.bookList = bookList;
        librarian = name;
        bookNum = bookList.size();
    }

    private void findGenre(){
        String mostCommon = null;
        int maxCount = 0;
        for (int i = 0; i < bookNum; i++) {
            String current = bookList.get(i).getGenre();
            int count = 0;
            for (int j = 0; j < bookNum; j++) {
                if (current.equals(bookList.get(j).getGenre())) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostCommon = current;
            }
        }
        commonG = mostCommon;
    }

    private void findAuthor(){
        String mostCommon = null;
        int maxCount = 0;
        for (int i = 0; i < bookNum; i++) {
            String current = bookList.get(i).getAuthor();
            int count = 0;
            for (int j = 0; j < bookNum; j++) {
                if (current.equals(bookList.get(j).getAuthor())) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostCommon = current;
            }
        }
        commonA = mostCommon;
    }

    public String commonGenre(){
        findGenre();
        return commonG;
    }
    public String commonAuthor(){
        findAuthor();
        return commonA;
    }
    public String getLibrarian(){
        return librarian;
    }
}