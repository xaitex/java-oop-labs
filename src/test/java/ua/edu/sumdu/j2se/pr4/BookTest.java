package ua.edu.sumdu.j2se.pr4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Автотести JUnit 5 для перевірки валідації та винятків у класі Book.
 */
class BookTest {

    /**
     * Перевіряє кидання IllegalArgumentException при передачі некоректних значень у сетери.
     */
    @Test
    void shouldThrowExceptionWhenInvalidValueInSetter() {
        Book book = new Book("Кобзар", "Тарас Шевченко", 2020, 350.0, 720);

        assertThrows(IllegalArgumentException.class, () -> book.setPrice(-10.0));
        assertThrows(IllegalArgumentException.class, () -> book.setPages(0));
        assertThrows(IllegalArgumentException.class, () -> book.setYear(1200));
        assertThrows(IllegalArgumentException.class, () -> book.setTitle("   "));
    }

    /**
     * Перевіряє кидання IllegalArgumentException при створенні об'єкта з некоректними параметрами в конструкторі.
     */
    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book("", "George Orwell", 1949, -50.0, -5);
        });
    }

    /**
     * Перевіряє успішне створення об'єкта з валідними даними та коректну роботу гетерів.
     */
    @Test
    void shouldCreateBookWhenDataIsValid() {
        Book book = new Book("1984", "George Orwell", 1949, 320.0, 328);

        assertEquals("1984", book.getTitle());
        assertEquals("George Orwell", book.getAuthor());
        assertEquals(1949, book.getYear());
        assertEquals(320.0, book.getPrice());
        assertEquals(328, book.getPages());
    }
}