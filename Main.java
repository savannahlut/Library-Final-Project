public class Main {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("author")) {
            System.out.println("Most Read Author: ");
        } else {
            System.out.println("Most Popular Genre: ");
        }
    }
}


//remember to do [ javac Main.java ] when you change the content of Main.java 