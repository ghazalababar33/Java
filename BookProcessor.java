package com.example.Assignment;

import java.util.*;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class BookProcessor {

    private List<Books> books;

    public BookProcessor(List<Books> books) {
        this.books = books;
    }

    public void displayAllBooksdetail() {
        books.forEach(Books::displayBookInfo);
    }

    public void findBooksBySpecificAuthor(String author) {
        List<Books> booksByAuthor = books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());

        if (booksByAuthor.isEmpty()) {
            System.out.println("No books found by this author's Name: " + author);
        } else {
            booksByAuthor.forEach(Books::displayBookInfo);
        }
    }

    public void calculateAveragePriceofbooks() {
        OptionalDouble averagePrice = books.stream()
                .mapToDouble(book -> book.getMetadata().getPrice())
                .average();

        if (averagePrice.isPresent()) {
            System.out.println("Average price of all the books: " + averagePrice.getAsDouble());
        } else {
            System.out.println("No books is present in the bookprocessor to calculate the average price.");
        }
    }

    public void display_the_books_with_Highestprice() {
        books.stream()
                .max((book1, book2) -> Double.compare(book1.getMetadata().getPrice(), book2.getMetadata().getPrice()))
                .ifPresentOrElse(
                        book -> {
                            System.out.println("This is the Book with the highest price:");
                            book.displayBookInfo();
                        },
                        () -> System.out.println("No books is available in the BookProcessor.")
                );
    }

    public void List_the_Books_ByCategory(String category) {
        List<Books> booksByCategory = books.stream()
                .filter(book -> book.getMetadata().getCategories().contains(category))
                .collect(Collectors.toList());

        if (booksByCategory.isEmpty()) {
            System.out.println("No books found in this category: " + category);
        } else {
            booksByCategory.forEach(Books::displayBookInfo);
        }
    }
}
