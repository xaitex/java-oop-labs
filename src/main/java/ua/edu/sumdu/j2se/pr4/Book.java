package ua.edu.sumdu.j2se.pr4;

import java.util.Objects;

/**
 * Клас, що описує сутність "Книга" (Варіант 2).
 * Містить інформацію про назву, автора, рік видання, ціну та кількість сторінок.
 */
public class Book {
    private String title;
    private String author;
    private int year;
    private double price;
    private int pages;

    /**
     * Конструктор з параметрами для створення об'єкта книги.
     *
     * @param title  назва книги
     * @param author автор книги
     * @param year   рік видання
     * @param price  ціна книги
     * @param pages  кількість сторінок
     */
    public Book(String title, String author, int year, double price, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.pages = pages;
    }

    /**
     * Конструктор за замовчуванням для зворотної сумісності (4 параметри).
     *
     * @param title  назва книги
     * @param author автор книги
     * @param year   рік видання
     * @param price  ціна книги
     */
    public Book(String title, String author, int year, double price) {
        this(title, author, year, price, 100);
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', year=%d, price=%.2f грн, pages=%d}",
                title, author, year, price, pages);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                pages == book.pages &&
                Double.compare(book.price, price) == 0 &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, price, pages);
    }
}