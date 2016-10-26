package library.view;

import library.model.Book;
import library.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Mi on 25.10.2016.
 */
@Component
public class ConsoleView {

    @Autowired
    private AuthorService authorService;
    private Scanner scanner = new Scanner(System.in);

    public void start() {

        while (true) {
            showMenu();

            int choice = readChoice();

            if (choice == 1) {
                loginMenu();
            } else if (choice == 2) {
                showAuthors();
            } else if (choice == 3) {
                showAllBooks();
            } else if (choice == 4) {
                addBook();
            } else if (choice == 5) {
                booksByAuthor();
            } else {
                System.out.println("wrong choice");
            }

        }
    }

    private void booksByAuthor() {

    }

    private void addBook() {

    }

    private void showAllBooks() {
        System.out.println("Input author id");
        int authorId = readChoice();
        List<Book> bookList = authorService.getBooks(authorId);

        bookList.stream().forEach(System.out::println);
    }

    private void showAuthors() {

    }

    private int readChoice() {
        return scanner.nextInt();
    }

    private void loginMenu() {
        System.out.println("Input login");
        String login = scanner.next();
        System.out.println("Input pass");
        String pass = scanner.next();

        String key = authorService.login(login,pass);
    }

    private void showMenu() {
        System.out.println("1.Login");
        System.out.println("2.Authors");
        System.out.println("3.Books");
        System.out.println("4.Add Books");
        System.out.println("5.Author Books");
    }


}

