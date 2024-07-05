package com.example.Assignment;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "/books.json";  // Adjust path as needed
        List<Books> books = BookJsons.parseBooksJson(filePath);  // Corrected to BookJsons

        if (books != null) {
            BookProcessors bookProcessor = new BookProcessors(books);
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("Choose an option:");
                System.out.println("1. Display all books");
                System.out.println("2. Find books by author");
                System.out.println("3. Calculate average price of all books");
                System.out.println("4. Display the book with the highest price");
                System.out.println("5. List books by category");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Displaying all the books present in BookProcessors:");
                        bookProcessor.displayAllBooksdetail();
                        System.out.println();
                        break;
                    case 2:
                        System.out.print("Enter the author's name: ");
                        String author = scanner.nextLine();
                        System.out.println("Finding books by author present in the BookProcessors '" + author + "':");
                        bookProcessor.findBooksBySpecificAuthor(author);
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Calculating average price of all books present in the BookProcessors:");
                        bookProcessor.calculateAveragePriceofbooks();
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("Displaying the book with the highest price present in the BookProcessors:");
                        bookProcessor.display_the_books_with_Highestprice();
                        System.out.println();
                        break;
                    case 5:
                        System.out.print("Enter the category: ");
                        String category = scanner.nextLine();
                        System.out.println("Finding books in category '" + category + "' present in the BookProcessors:");
                        bookProcessor.List_the_Books_ByCategory(category);
                        System.out.println();
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            scanner.close();
        } else {
            System.out.println("Failed to parse the books.json file.");
        }
    }
}
