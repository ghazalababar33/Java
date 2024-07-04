package com.example.Assignment;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) {
        Library<Media> library = new Library<>();

        // Create observers
        LibraryObserver observer1 = event -> System.out.println("Observer 1: " + event.getMessage() + " - " + event.getMedia().getClass().getSimpleName());
        LibraryObserver observer2 = event -> System.out.println("Observer 2: " + event.getMessage() + " - " + event.getMedia().getClass().getSimpleName());

        // Add observers to library
        library.addObserver(observer1);
        library.addObserver(observer2);

        // Add media to library from JSON files
        addMediaToLibrary(library, "books.json", MediaType.BOOK);
        addMediaToLibrary(library, "movies.json", MediaType.MOVIE);
        addMediaToLibrary(library, "audiobooks.json", MediaType.AUDIO_BOOK);
        addMediaToLibrary(library, "magazines.json", MediaType.MAGAZINE);

        // Example: Update prices for all media in the library
        updateMediaPrices(library, 5);  // Example price increment

        // Display all media in the library
        System.out.println("\nAll media in the library:");
        displayMedia(library.getAllMedia());

        // Prompt user for media type and display results
        handleUserInteraction(library);
    }

    private static void addMediaToLibrary(Library<Media> library, String filePath, MediaType type) {
        List<? extends Media> mediaList = parseJson(filePath, type);
        if (mediaList != null) {
            mediaList.forEach(library::addMedia);
        } else {
            System.err.println("Failed to parse media from file: " + filePath);
        }
    }

    private static List<? extends Media> parseJson(String filePath, MediaType type) {
        try {
            switch (type) {
                case BOOK:
                    return BookJson.parseBooksJson(filePath);
                case MOVIE:
                    return MovieJson.parseMoviesJson(filePath);
                case AUDIO_BOOK:
                    return AudioJson.parseAudioBooksJson(filePath);
                case MAGAZINE:
                    return MagazineJson.parseMagazinesJson(filePath);
                default:
                    return null;
            }
        } catch (Exception e) {
            System.err.println("Error parsing JSON for type " + type + ": " + e.getMessage());
            return null;
        }
    }

    private static void updateMediaPrices(Library<Media> library, double increment) {
        if (!library.getAllMedia().isEmpty()) {
            library.getAllMedia().forEach(media -> library.updateMediaPrice(media, media.getPrice() + increment));
        }
    }

    private static void handleUserInteraction(Library<Media> library) {
        Scanner scanner = new Scanner(System.in);
        boolean continueInteraction = true;

        while (continueInteraction) {
            // Prompt user for action
            System.out.println("\nChoose an action: (1) Search media, (2) Add media, (3) Exit");
            String userInput = scanner.nextLine().trim();

            switch (userInput) {
                case "1":
                    handleUserSearch(library, scanner);
                    break;
                case "2":
                    handleUserAddMedia(library, scanner);
                    break;
                case "3":
                    continueInteraction = false;
                    break;
                default:
                    System.out.println("Invalid input. Please choose a valid action.");
            }
        }
    }

    private static void handleUserSearch(Library<Media> library, Scanner scanner) {
        boolean continueSearch = true;

        while (continueSearch) {
            // Prompt user for media type
            System.out.println("\nEnter the media type to search (BOOK, MOVIE, AUDIO_BOOK, MAGAZINE):");
            String mediaTypeInput = scanner.nextLine().trim();
            MediaType searchMediaType;
            try {
                searchMediaType = MediaType.valueOf(mediaTypeInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid media type entered.");
                continue; // Ask the user to enter a valid media type again
            }

            // Search and display media by type
            System.out.println("\nSearching media for type " + searchMediaType + ":");
            List<Media> mediaByType = searchMediaByType(library, searchMediaType);
            displayMedia(mediaByType);

            // Ask the user if they want to search again
            System.out.println("\nDo you want to search for another media type? (yes/no):");
            String userResponse = scanner.nextLine().trim();
            if (userResponse.equalsIgnoreCase("no")) {
                continueSearch = false;
            }
        }
    }

    private static void handleUserAddMedia(Library<Media> library, Scanner scanner) {
        // Prompt user for media type to add
        System.out.println("\nEnter the media type to add (BOOK, MOVIE, AUDIO_BOOK, MAGAZINE):");
        String mediaTypeInput = scanner.nextLine().trim();
        MediaType addMediaType;
        try {
            addMediaType = MediaType.valueOf(mediaTypeInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid media type entered.");
            return; // Exit the method if the media type is invalid
        }

        // Prompt user for media details and add to library
        switch (addMediaType) {
            case BOOK:
                addBook(library, scanner);
                break;
            case MOVIE:
                addMovie(library, scanner);
                break;
            case AUDIO_BOOK:
                addAudioBook(library, scanner);
                break;
            case MAGAZINE:
                addMagazine(library, scanner);
                break;
            default:
                System.out.println("Unknown media type.");
        }
    }

    private static void addBook(Library<Media> library, Scanner scanner) {
        System.out.println("\nEnter book title:");
        String title = scanner.nextLine().trim();
        System.out.println("Enter book author:");
        String author = scanner.nextLine().trim();
        System.out.println("Enter book price:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Assuming Metadata creation logic
        Metadata metadata = new Metadata(price, null, null, 0); // Adjust based on your Metadata constructor
        Books book = new Books(title, author, metadata); // Adjust based on your Books class constructor
        library.addMedia(book);
        System.out.println("Book added successfully.");
    }

    private static void addMovie(Library<Media> library, Scanner scanner) {
        System.out.println("\nEnter movie title:");
        String title = scanner.nextLine().trim();
        System.out.println("Enter movie director:");
        String director = scanner.nextLine().trim();
        System.out.println("Enter movie price:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Movie movie = new Movie(price, title, director, List.of()); // Adjust based on your Movie constructor
        library.addMedia(movie);
        System.out.println("Movie added successfully.");
    }

    private static void addAudioBook(Library<Media> library, Scanner scanner) {
        System.out.println("\nEnter audiobook title:");
        String title = scanner.nextLine().trim();
        System.out.println("Enter audiobook narrator:");
        String narrator = scanner.nextLine().trim();
        System.out.println("Enter audiobook price:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Prompt user for categories
        System.out.println("Enter audiobook categories (comma-separated):");
        String categoriesInput = scanner.nextLine().trim();
        List<String> categories = List.of(categoriesInput.split(",\\s*"));

        AudioBook audioBook = new AudioBook(price, title, narrator, categories); // Ensure categories is a List<String>
        library.addMedia(audioBook);
        System.out.println("Audiobook added successfully.");
    }



    private static void addMagazine(Library<Media> library, Scanner scanner) {
        System.out.println("\nEnter magazine title:");
        String title = scanner.nextLine().trim();
        System.out.println("Enter magazine publisher:");
        String publisher = scanner.nextLine().trim();
        System.out.println("Enter magazine price:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Magazine magazine = new Magazine(price, title, publisher, List.of()); // Adjust based on your Magazine constructor
        library.addMedia(magazine);
        System.out.println("Magazine added successfully.");
    }

    private static List<Media> searchMediaByType(Library<Media> library, MediaType type) {
        return library.getAllMedia().stream()
                .filter(media -> media.getType() == type)
                .collect(Collectors.toList());
    }

    private static void displayMedia(List<Media> mediaList) {
        if (mediaList.isEmpty()) {
            System.out.println("No media found.");
        } else {
            mediaList.forEach(media -> {
                System.out.println("Title: " + media.getTitle());
                System.out.println("Type: " + media.getClass().getSimpleName());
                System.out.println("Price: " + media.getPrice());
                if (media instanceof Books) {
                    System.out.println("Author: " + ((Books) media).getAuthor());
                } else if (media instanceof Movie) {
                    System.out.println("Director: " + ((Movie) media).getDirector());
                } else if (media instanceof AudioBook) {
                    System.out.println("Narrator: " + ((AudioBook) media).getNarrator());
                } else if (media instanceof Magazine) {
                    System.out.println("Publisher: " + ((Magazine) media).getPublisher());
                }
                if (media instanceof Categorized) {
                    System.out.println("Categories: " + ((Categorized) media).getCategories());
                }
                System.out.println();
            });
        }
    }
}
