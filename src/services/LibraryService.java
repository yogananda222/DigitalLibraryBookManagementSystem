package services;

import models.Book;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * LibraryService class manages a collection of books.
 * It provides functionalities to add, view, search, update, and delete books.
 */
public class LibraryService {
    
    private final Map<String, Book> books = new HashMap<>(); // Stores book records
    private final Scanner scanner = new Scanner(System.in); // Scanner for user input

    /**
     * Adds a new book to the library.
     * Ensures that Book ID is unique, and other required fields are not empty.
     */
    public void addBook() {
        try {
            System.out.println("\nEnter Book Details:");

            System.out.print("Book ID: ");
            String bookId = scanner.nextLine().trim();

            // Validate if the Book ID already exists
            if (books.containsKey(bookId)) {
                System.out.println("Error: Book ID already exists.");
                return;
            }

            System.out.print("Title: ");
            String title = scanner.nextLine().trim();
            if (title.isEmpty()) {
                System.out.println("Error: Title cannot be empty.");
                return;
            }

            System.out.print("Author: ");
            String author = scanner.nextLine().trim();
            if (author.isEmpty()) {
                System.out.println("Error: Author cannot be empty.");
                return;
            }

            System.out.print("Genre: ");
            String genre = scanner.nextLine().trim();

            System.out.print("Availability Status (Available/Checked Out): ");
            String status = scanner.nextLine().trim();

            // Validate the availability status
            if (!status.equalsIgnoreCase("Available") && !status.equalsIgnoreCase("Checked Out")) {
                System.out.println("Error: Status must be 'Available' or 'Checked Out'.");
                return;
            }

            // Create a new book and store it in the collection
            Book newBook = new Book(bookId, title, author, genre, status);
            books.put(bookId, newBook);

            System.out.println("Book added successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred while adding the book: " + e.getMessage());
        }
    }

    /**
     * Displays all books in the library.
     * If no books are available, it informs the user.
     */
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        
        System.out.println("\n Library Catalog:");
        books.values().forEach(System.out::println);
    }

    /**
     * Searches for a book by its ID or title.
     * Displays the details of the found book(s).
     */
    public void searchBook() {
        System.out.print("Enter Book ID or Title to search: ");
        String query = scanner.nextLine().trim().toLowerCase();

        boolean found = books.values().stream()
                .filter(book -> book.getBookId().equalsIgnoreCase(query) || book.getTitle().toLowerCase().contains(query))
                .peek(System.out::println)
                .findAny()
                .isPresent();

        if (!found) {
            System.out.println("No matching book found.");
        }
    }

    /**
     * Updates book details.
     * Allows modification of the title, author, and availability status.
     */
    public void updateBook() {
        System.out.print("Enter Book ID to update: ");
        String bookId = scanner.nextLine().trim();

        if (!books.containsKey(bookId)) {
            System.out.println("Error: Book ID not found.");
            return;
        }

        Book book = books.get(bookId);

        System.out.print("New Title (Leave empty to skip): ");
        String title = scanner.nextLine().trim();
        if (!title.isEmpty()) {
            book.setTitle(title);
        }

        System.out.print("New Author (Leave empty to skip): ");
        String author = scanner.nextLine().trim();
        if (!author.isEmpty()) {
            book.setAuthor(author);
        }

        System.out.print("New Availability Status (Available/Checked Out): ");
        String status = scanner.nextLine().trim();
        if (!status.isEmpty() && (status.equalsIgnoreCase("Available") || status.equalsIgnoreCase("Checked Out"))) {
            book.setAvailabilityStatus(status);
        } else if (!status.isEmpty()) {
            System.out.println("Error: Invalid status. Keeping the previous status.");
        }

        System.out.println("Book details updated successfully.");
    }

    /**
     * Deletes a book from the library using its ID.
     * Confirms whether the deletion was successful.
     */
    public void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String bookId = scanner.nextLine().trim();

        if (books.remove(bookId) != null) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Error: Book ID not found.");
        }
    }

    /**
     * Getter method for books collection (Used in unit testing).
     * @return books map
     */
    public Map<String, Book> getBooks() {
        return books;
    }
}
