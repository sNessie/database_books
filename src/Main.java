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

    private void start() {
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
        switch (command) {
            case "1": {
                addBook();
                break;
            }

            case "2": {
                rentBook();
                break;
            }
            case "3": {
                break;
            }
            case "4": {
                showFreeBooks();
                break;
            }
        }
    }

    private void rentBook() {
        System.out.println("Podaj nazwę książki");
        String name = scanner.nextLine();
        for (Book book : bookList) {
            if (book.getName().equalsIgnoreCase(name) && book.getRentStatus() == 0) {
                book.setRentStatus(1);
                System.out.println("Wypożyczono książkę " + book.getName());
                System.out.println("Oddaj jak tylko przeczytasz");
                return;
            }
        }
        System.out.println("Brak takiej książki albo jest wypożyczona");
    }

    private void addBook() {
        System.out.println("Dodaj nową książkę");
        String title, author;
        int pages, produceYear;

        System.out.println("Podaj tytuł");
        title = scanner.nextLine();

        System.out.println("Podaj autora");
        author = scanner.nextLine();

        System.out.println("Podaj ilość stron");
        pages = Integer.parseInt(scanner.nextLine());

        System.out.println("Podaj rok wydania");
        produceYear = Integer.parseInt(scanner.nextLine());

        bookList.add(new Book(title, author, pages, produceYear, 0));
        System.out.println("Dodano książkę: " + title);

    }

    private void showFreeBooks() {
        for (Book book : bookList) {
            if (book.getRentStatus() == 0) {
                System.out.println("Wolna pozycja: " + book.getName());
            }
        }
    }

}
