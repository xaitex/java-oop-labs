package ua.edu.sumdu.j2se.pr4;

import java.util.Locale;
import java.util.Scanner;

public class BookDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        scanner.useLocale(Locale.US);

        Book[] books = new Book[5];
        books[0] = new Book("Кобзар", "Тарас Шевченко", 2020, 350.00);
        books[1] = new Book("Тигролови", "Іван Багряний", 2021, 280.50);
        books[2] = new Book("Clean Code", "Robert Martin", 2019, 850.00);

        System.out.println("=== Ініціалізація масиву з 5 книг ===");
        System.out.println("Перші 3 книги вже в базі. Введіть дані ще для 2 книг:\n");

        for (int i = 3; i < books.length; i++) {
            System.out.println("--- Книга №" + (i + 1) + " ---");
            System.out.print("Введіть назву книги: ");
            String title = scanner.nextLine().trim();
            while (title.isEmpty()) {
                System.out.print("Назва не може бути порожньою! Введіть ще раз: ");
                title = scanner.nextLine().trim();
            }

            System.out.print("Введіть автора книги: ");
            String author = scanner.nextLine().trim();
            while (author.isEmpty()) {
                System.out.print("Автор не може бути порожнім! Введіть ще раз: ");
                author = scanner.nextLine().trim();
            }

            int year = readPositiveInt(scanner, "Введіть рік видання: ");
            double price = readPositiveDouble(scanner, "Введіть ціну книги (через крапку): ");

            books[i] = new Book(title, author, year, price);
            System.out.println();
        }

        books[0].setPrice(375.00);
        System.out.println("Оновлено ціну 1-ї книги через сетер: " + books[0].getPrice() + " грн\n");

        System.out.println("=== Виведення всіх 5 об'єктів масиву через toString() ===");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i].toString());
        }

        System.out.println("\n=== Перевірка методу equals() ===");
        System.out.println("Книга 1 дорівнює Книзі 2? -> " + books[0].equals(books[1]));
        System.out.println("Книга 4 дорівнює Книзі 5? -> " + books[3].equals(books[4]));

        scanner.close();
    }

    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                scanner.nextLine();
                if (val > 0) return val;
            } else {
                scanner.nextLine();
            }
            System.out.println("Помилка: введіть додатне ціле число!");
        }
    }

    private static double readPositiveDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double val = scanner.nextDouble();
                scanner.nextLine();
                if (val >= 0) return val;
            } else {
                scanner.nextLine();
            }
            System.out.println("Помилка: введіть коректне число (наприклад 250.5)!");
        }
    }
}
