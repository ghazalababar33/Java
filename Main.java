package com.example.Assignment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "/books.json";  // Adjust path as needed
        List<Books> books = BookJson.parseBooksJson(filePath);

        if (books != null) {
            BookProcessor bookProcessor = new BookProcessor(books);

            System.out.println("Here i am Displaying all the books present in BookProcessor:");
            bookProcessor.displayAllBooksdetail();
            System.out.println();

            System.out.println("Finding books by author present in the BookProcessor 'Harper Lee':");
            bookProcessor.findBooksBySpecificAuthor("Harper Lee");
            System.out.println();

            System.out.println("Calculating average price of all books present in the BookProcessor:");
            bookProcessor.calculateAveragePriceofbooks();
            System.out.println();

            System.out.println("Displaying the book with the highest price present in the BookProcessor:");
            bookProcessor.display_the_books_with_Highestprice();
            System.out.println();

            System.out.println("Finding books in category 'Fiction'present in the BookProcessor:");
            bookProcessor.List_the_Books_ByCategory("Fiction");
        } else {
            System.out.println("Failed to parse the books.json file.");
        }
    }
}
