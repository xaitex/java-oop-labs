package ua.edu.sumdu.j2se.pr4;

import java.util.Objects;

/**
 * Клас, що описує сутність "Книга" (Варіант 2) з валідацією вхідних даних.
 */
public class Book {
    private String title;
    private String author;
    private int year;
    private double price;
    private int pages;

    /**
     * Конструктор з параметрами для створення об'єкта книги.
     * Виконує валідацію всіх вхідних параметрів через сетери.
     *
     * @param title  назва книги (не може бути порожньою)
     * @param author автор книги (не може бути порожнім)
     * @param year   рік видання (від 1450 до 2026)
     * @param price  ціна книги (не може бути від'ємною)
     * @param pages  кількість сторінок (більше 0)
     * @throws IllegalArgumentException якщо будь-який параметр некоректний
     */
    public Book(String title, String author, int year, double price, int pages) {
        setTitle(title);
        setAuthor(author);
        setYear(year);
        setPrice(price);
        setPages(pages);
    }

    /**
     * Перевантажений конструктор із 4 параметрами (встановлює 100 сторінок за замовчуванням).
     *
     * @param title  назва книги
     * @param author автор книги
     * @param year   рік видання
     * @param price  ціна книги
     */
    public Book(String title, String author, int year, double price) {
        this(title, author, year, price, 100);
    }

    /**
     * Повертає назву книги.
     * @return назва книги
     */
    public String getTitle() { return title; }

    /**
     * Встановлює назву книги з перевіркою на порожній рядок.
     * @param title нова назва книги
     * @throws IllegalArgumentException якщо назва порожня або null
     */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва книги не може бути порожньою!");
        }
        this.title = title.trim();
    }

    /**
     * Повертає автора книги.
     * @return автор книги
     */
    public String getAuthor() { return author; }

    /**
     * Встановлює автора книги з перевіркою на порожній рядок.
     * @param author новий автор книги
     * @throws IllegalArgumentException якщо ім'я автора порожнє або null
     */
    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Автор книги не може бути порожнім!");
        }
        this.author = author.trim();
    }

    /**
     * Повертає рік видання книги.
     * @return рік видання
     */
    public int getYear() { return year; }

    /**
     * Встановлює рік видання книги.
     * @param year рік видання (допустимий діапазон: 1450 - 2026)
     * @throws IllegalArgumentException якщо рік виходить за межі допустимого діапазону
     */
    public void setYear(int year) {
        if (year < 1450 || year > 2026) {
            throw new IllegalArgumentException("Рік видання повинен бути в межах від 1450 до 2026!");
        }
        this.year = year;
    }

    /**
     * Повертає ціну книги.
     * @return ціна книги
     */
    public double getPrice() { return price; }

    /**
     * Встановлює ціну книги.
     * @param price ціна книги (невід'ємне число)
     * @throws IllegalArgumentException якщо ціна менша за 0 або не є числом
     */
    public void setPrice(double price) {
        if (price < 0 || Double.isNaN(price) || Double.isInfinite(price)) {
            throw new IllegalArgumentException("Ціна книги не може бути від'ємною!");
        }
        this.price = price;
    }

    /**
     * Повертає кількість сторінок.
     * @return кількість сторінок
     */
    public int getPages() { return pages; }

    /**
     * Встановлює кількість сторінок у книзі.
     * @param pages кількість сторінок (додатне ціле число)
     * @throws IllegalArgumentException якщо кількість сторінок менша або дорівнює 0
     */
    public void setPages(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Кількість сторінок має бути більшою за нуль!");
        }
        this.pages = pages;
    }

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