package ua.edu.sumdu.j2se.pr4;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Драйвер-клас із консольним меню для управління списком об'єктів класу Book.
 * Забезпечує безпечне зчитування з клавіатури та обробку винятків.
 */
public class BookDriver {

    /**
     * Головний метод програми, що реалізує інтерактивне консольне меню.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        scanner.useLocale(Locale.US);

        List<Book> books = new ArrayList<>();
        books.add(new Book("Кобзар", "Тарас Шевченко", 2020, 350.00, 720));
        books.add(new Book("Тигролови", "Іван Багряний", 2021, 280.50, 304));
        books.add(new Book("Clean Code", "Robert Martin", 2019, 850.00, 464));

        boolean running = true;
        while (running) {
            System.out.println("\n=== КОНСОЛЬНЕ МЕНЮ ===");
            System.out.println("1. Створити новий об'єкт");
            System.out.println("2. Вивести інформацію про всі об'єкти");
            System.out.println("3. Завершити роботу");
            System.out.print("Ваш вибір: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    createBookInteractive(scanner, books);
                    break;
                case "2":
                    printAllBooks(books);
                    break;
                case "3":
                    System.out.println("Завершення роботи програми...");
                    running = false;
                    break;
                default:
                    System.out.println("Помилка: невідомий пункт меню! Введіть 1, 2 або 3.");
            }
        }
        scanner.close();
    }

    /**
     * Інтерактивний метод для створення нової книги з обробкою помилок введення та винятків валідації.
     *
     * @param scanner об'єкт Scanner для зчитування даних
     * @param books   список книг, куди буде додано новий об'єкт
     */
    private static void createBookInteractive(Scanner scanner, List<Book> books) {
        System.out.println("\n--- Додавання нової книги ---");
        try {
            String title = readNonEmptyString(scanner, "Введіть назву книги: ");
            String author = readNonEmptyString(scanner, "Введіть автора книги: ");
            int year = readInt(scanner, "Введіть рік видання (1450-2026): ");
            double price = readDouble(scanner, "Введіть ціну книги (через крапку): ");
            int pages = readInt(scanner, "Введіть кількість сторінок: ");

            Book newBook = new Book(title, author, year, price, pages);
            books.add(newBook);
            System.out.println("Успішно додано: " + newBook);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка валідації даних: " + e.getMessage());
            System.out.println("Об'єкт не створено. Спробуйте ще раз через меню.");
        }
    }

    /**
     * Виводить список усіх збережених книг у консоль.
     *
     * @param books список книг
     */
    private static void printAllBooks(List<Book> books) {
        System.out.println("\n=== Список усіх книг (" + books.size() + ") ===");
        if (books.isEmpty()) {
            System.out.println("Список порожній.");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    /**
     * Зчитує непорожній рядок з консолі.
     *
     * @param scanner об'єкт Scanner
     * @param prompt  текст підказки
     * @return введений непорожній рядок
     */
    private static String readNonEmptyString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Помилка: поле не може бути порожнім!");
        }
    }

    /**
     * Безпечно зчитує ціле число з консолі, обробляючи нечислове введення.
     *
     * @param scanner об'єкт Scanner
     * @param prompt  текст підказки
     * @return зчитане ціле число
     */
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Помилка: введіть коректне ціле число!");
            }
        }
    }

    /**
     * Безпечно зчитує дробове число з консолі, обробляючи нечислове введення.
     *
     * @param scanner об'єкт Scanner
     * @param prompt  текст підказки
     * @return зчитане число типу double
     */
    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Помилка: введіть коректне числове значення (наприклад 350.5)!");
            }
        }
    }
}