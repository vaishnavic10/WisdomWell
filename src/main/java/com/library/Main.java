package com.library;

import com.library.model.Book;
import com.library.model.User;
import com.library.service.LibraryService;
import com.library.service.ValidationService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LibraryService libraryService = new LibraryService();
        ValidationService validationService = new ValidationService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. View All Books");
            System.out.println("4. View All Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine();

            switch (choice) {

                case "1":
                    System.out.print("Enter Book ID: ");
                    String bId = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    validationService.validateString(bId);
                    validationService.validateString(title);
                    validationService.validateString(author);
                    libraryService.addBook(new Book(bId, title, author));
                    System.out.println("Book added.");
                    break;

                case "2":
                    System.out.print("Enter User ID: ");
                    String uId = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    validationService.validateString(uId);
                    validationService.validateString(name);
                    validationService.validateEmail(email);
                    libraryService.addUser(new User(uId, name, email));
                    System.out.println("User added.");
                    break;

                case "3":
                    System.out.println("\nBooks:");
                    libraryService.getAllBooks().forEach(b ->
                        System.out.println(b.getBookId() + " | " + b.getTitle() + " | " + b.getAuthor() + " | Issued: " + b.isIssued())
                    );
                    break;

                case "4":
                    System.out.println("\nUsers:");
                    libraryService.getAllUsers().forEach(u ->
                        System.out.println(u.getUserId() + " | " + u.getName() + " | " + u.getEmail())
                    );
                    break;

                case "5":
                    System.out.print("Enter Book ID: ");
                    String ib = sc.nextLine();
                    System.out.print("Enter User ID: ");
                    String iu = sc.nextLine();
                    libraryService.issueBook(ib, iu);
                    System.out.println("Book issued.");
                    break;

                case "6":
                    System.out.print("Enter Book ID: ");
                    String rb = sc.nextLine();
                    libraryService.returnBook(rb);
                    System.out.println("Book returned.");
                    break;

                case "7":
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
