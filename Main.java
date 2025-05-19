import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static File f;
    private static Scanner s;
    public static void main(String[] args) throws FileNotFoundException {
        f = new File("booklist.txt");
        s = new Scanner(f);

        ArrayList<Book> catalog = new ArrayList<Book>() ;
        while (s.hasNext()) {
            String word = s.nextLine();
            Book b = new Book(word.substring(0,word.indexOf("-")-1), 
                            word.substring(word.indexOf("-")+1, word.lastIndexOf("-")-1),
                            word.substring(word.lastIndexOf("-")+1));
            catalog.add(b);
        }

        Library BTHS = new Library(catalog, "Mr.Holmer");

        if (args.length > 0 && args[0].equals("author")) {
            System.out.println("Most Read Author: " + BTHS.commonAuthor() );
        } else {
            System.out.println("Most Popular Genre: " + BTHS.commonGenre() );
        }
    }
}


//remember to do [ javac Main.java ] when you change the content of Main.java 