import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main();

    }

    private Scanner scanner;
    private List<Book> bookList = new ArrayList<>();

    public Main() {
        scanner = new Scanner(System.in);
        bookList = Utils.parseBookFromFile(Paths.get("books.txt"));
        start();
    }

    private void start(){
        System.out.println("Witaj w mojej bibliotece");
        String command;
        do {
            System.out.println("1 - dodawanie książki");
            System.out.println("2 - wypożyczenie książki");
            System.out.println("3 - oddawanie książki");
            System.out.println("4 - wyświtl wolne pozycje");
            System.out.println("Wpisz polecenie");
            command = scanner.nextLine();
            parseChoice(command);
        } while (!command.equals("exit"));
    }

    private void parseChoice(String command) {
        switch (command){
            case "4": {
                for (Book book : bookList) {
                    if (book.getRentStatus() == 0){
                        System.out.println("Wolna pozycja: " + book.getName());
                    }
                }
                break;
            }
        }
    }

}
