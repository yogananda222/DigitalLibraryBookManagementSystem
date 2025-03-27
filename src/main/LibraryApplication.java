package main;

import services.LibraryService;
import java.util.Scanner;

/**
 * The entry point for the Digital Library Management System.
 * This class provides a menu-driven console interface for managing books in the library.
 */
public class LibraryApplication {

    /**
     * The main method that runs the library management system.
     */
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService(); // Library service instance to handle operations
        Scanner scanner = new Scanner(System.in); // Scanner to take user input

        while (true) {
            // Display menu options
            System.out.println("\n--- Digital Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book Details");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine(); // Read user choice

            // Perform action based on user input
            switch (choice) {
                case "1":
                    libraryService.addBook(); 
                    break;
                case "2":
                    libraryService.viewAllBooks();
                    break;
                case "3":
                    libraryService.searchBook();
                    break;
                case "4":
                    libraryService.updateBook();
                    break;
                case "5":
                    libraryService.deleteBook();
                    break;
                case "6":
                    System.out.println("Exited from the application.");
                    scanner.close(); // Close scanner before exiting
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
