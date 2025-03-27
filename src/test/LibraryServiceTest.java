package test;

import models.Book;
import services.LibraryService;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Map;

public class LibraryServiceTest {
	
    private LibraryService libraryService;

    @Before
    public void setUp() {
        libraryService = new LibraryService();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("B001", "The Alchemist", "Paulo Coelho", "Fiction", "Available");
        libraryService.getBooks().put(book.getBookId(), book);
        assertEquals(1, libraryService.getBooks().size());
        assertTrue(libraryService.getBooks().containsKey("B001"));
    }

    @Test
    public void testViewAllBooks_WhenEmpty() {
        assertTrue(libraryService.getBooks().isEmpty());
    }

    @Test
    public void testSearchBookById_Found() {
        Book book = new Book("B002", "Harry Potter", "J.K. Rowling", "Fantasy", "Available");
        libraryService.getBooks().put(book.getBookId(), book);
        assertTrue(libraryService.getBooks().containsKey("B002"));
    }

    @Test
    public void testSearchBookById_NotFound() {
        assertNull(libraryService.getBooks().get("B999"));
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book("B003", "The Hobbit", "J.R.R. Tolkien", "Fantasy", "Available");
        libraryService.getBooks().put(book.getBookId(), book);
        book.setTitle("The Hobbit: An Unexpected Journey");
        book.setAuthor("J.R.R. Tolkien");
        book.setAvailabilityStatus("Checked Out");
        assertEquals("The Hobbit: An Unexpected Journey", libraryService.getBooks().get("B003").getTitle());
        assertEquals("Checked Out", libraryService.getBooks().get("B003").getAvailabilityStatus());
    }

    @Test
    public void testDeleteBook_Success() {
        Book book = new Book("B004", "1984", "George Orwell", "Dystopian", "Available");
        libraryService.getBooks().put(book.getBookId(), book);
        libraryService.getBooks().remove("B004");
        assertFalse(libraryService.getBooks().containsKey("B004"));
    }

    @Test
    public void testDeleteBook_Failure() {
        assertFalse(libraryService.getBooks().containsKey("B999"));
    }
}
