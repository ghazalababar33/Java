package com.example.Assignment;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class BookProcessor {

    private List<Books> books;
    private List<Movie> movies;
    private List<AudioBook> audioBooks;
    private List<Magazine> magazines;

    public BookProcessor(List<Books> books, List<Movie> movies, List<AudioBook> audioBooks, List<Magazine> magazines) {
        this.books = books;
        this.movies = movies;
        this.audioBooks = audioBooks;
        this.magazines = magazines;
    }

    public void displayAllBooksdetail() {
        System.out.println("Books:");
        books.forEach(Books::displayBookInfo);
        System.out.println("\nMovies:");
        movies.forEach(movie -> System.out.println(movie.getTitle() + " - Directed by " + movie.getDirector()));
        System.out.println("\nAudioBooks:");
        audioBooks.forEach(audioBook -> System.out.println(audioBook.getTitle() + " - Narrated by " + audioBook.getNarrator()));
        System.out.println("\nMagazines:");
        magazines.forEach(magazine -> System.out.println(magazine.getTitle() + " - Published by " + magazine.getPublisher()));
    }

    public void findBooksBySpecificAuthor(String author) {
        List<Books> booksByAuthor = books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());

        if (booksByAuthor.isEmpty()) {
            System.out.println("No books found by this author's Name: " + author);
        } else {
            System.out.println("Books by author " + author + ":");
            booksByAuthor.forEach(Books::displayBookInfo);
        }
    }

    public void calculateAveragePriceofbooks() {
        OptionalDouble averageBookPrice = books.stream()
                .mapToDouble(book -> book.getMetadata().getPrice())
                .average();

        OptionalDouble averageMoviePrice = movies.stream()
                .mapToDouble(Movie::getPrice)
                .average();

        OptionalDouble averageAudioBookPrice = audioBooks.stream()
                .mapToDouble(AudioBook::getPrice)
                .average();

        OptionalDouble averageMagazinePrice = magazines.stream()
                .mapToDouble(Magazine::getPrice)
                .average();

        System.out.println("Average price of all the books: " + (averageBookPrice.isPresent() ? averageBookPrice.getAsDouble() : "N/A"));
        System.out.println("Average price of all the movies: " + (averageMoviePrice.isPresent() ? averageMoviePrice.getAsDouble() : "N/A"));
        System.out.println("Average price of all the audio books: " + (averageAudioBookPrice.isPresent() ? averageAudioBookPrice.getAsDouble() : "N/A"));
        System.out.println("Average price of all the magazines: " + (averageMagazinePrice.isPresent() ? averageMagazinePrice.getAsDouble() : "N/A"));
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

        movies.stream()
                .max((movie1, movie2) -> Double.compare(movie1.getPrice(), movie2.getPrice()))
                .ifPresentOrElse(
                        movie -> System.out.println("This is the Movie with the highest price: " + movie.getTitle()),
                        () -> System.out.println("No movies is available in the BookProcessor.")
                );

        audioBooks.stream()
                .max((audioBook1, audioBook2) -> Double.compare(audioBook1.getPrice(), audioBook2.getPrice()))
                .ifPresentOrElse(
                        audioBook -> System.out.println("This is the AudioBook with the highest price: " + audioBook.getTitle()),
                        () -> System.out.println("No audio books is available in the BookProcessor.")
                );

        magazines.stream()
                .max((magazine1, magazine2) -> Double.compare(magazine1.getPrice(), magazine2.getPrice()))
                .ifPresentOrElse(
                        magazine -> System.out.println("This is the Magazine with the highest price: " + magazine.getTitle()),
                        () -> System.out.println("No magazines is available in the BookProcessor.")
                );
    }

    public void List_the_Books_ByCategory(String category) {
        List<Books> booksByCategory = books.stream()
                .filter(book -> book.getMetadata().getCategories().contains(category))
                .collect(Collectors.toList());

        if (booksByCategory.isEmpty()) {
            System.out.println("No books found in category: " + category);
        } else {
            System.out.println("Books in category " + category + ":");
            booksByCategory.forEach(Books::displayBookInfo);
        }

        List<Movie> moviesByCategory = movies.stream()
                .filter(movie -> movie.getCategories().contains(category))
                .collect(Collectors.toList());

        if (moviesByCategory.isEmpty()) {
            System.out.println("No movies found in category: " + category);
        } else {
            System.out.println("Movies in category " + category + ":");
            moviesByCategory.forEach(movie -> System.out.println(movie.getTitle() + " - Directed by " + movie.getDirector()));
        }

        List<AudioBook> audioBooksByCategory = audioBooks.stream()
                .filter(audioBook -> audioBook.getCategories().contains(category))
                .collect(Collectors.toList());

        if (audioBooksByCategory.isEmpty()) {
            System.out.println("No audio books found in category: " + category);
        } else {
            System.out.println("AudioBooks in category " + category + ":");
            audioBooksByCategory.forEach(audioBook -> System.out.println(audioBook.getTitle() + " - Narrated by " + audioBook.getNarrator()));
        }

        List<Magazine> magazinesByCategory = magazines.stream()
                .filter(magazine -> magazine.getCategories().contains(category))
                .collect(Collectors.toList());

        if (magazinesByCategory.isEmpty()) {
            System.out.println("No magazines found in category: " + category);
        } else {
            System.out.println("Magazines in category " + category + ":");
            magazinesByCategory.forEach(magazine -> System.out.println(magazine.getTitle() + " - Published by " + magazine.getPublisher()));
        }
    }
}
