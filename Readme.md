**Media Library Enhancement**
**Problem Statement**
You are tasked with enhancing the existing Library class to accommodate a broader range of media types beyond books. The new and improved Library should now handle various media types such as movies, audiobooks, magazines, and more. Additionally, a notification system needs to be implemented using the Observer pattern to notify users when new media is added or when prices are updated.

**Requirements**
**Media Interface**: Create a generic interface called Media that includes common methods for all types of media, such as updatePrice() and getPrice().

**Media Types**: Implement classes for various media types (e.g., Book, Movie, AudioBook, Magazine) that implement the Media interface.

**Library Class**: Modify the existing Library class to be generic but bound to the Media interface.

**Observer Pattern**: Implement the Observer pattern for the notification system. Allow users or external components to subscribe to library events and be notified when new media is added or when prices are updated.

**Notification System**: Enhance the Library class to include methods for adding observers, notifying observers when new media is added or prices are updated, and handling subscriptions.

**Additional Considerations**: Ensure that the Library class is flexible enough to handle different types of media and can be easily extended in the future. Implement at least two media types (e.g., Book and Movie) to demonstrate the generic and observer functionalities.

**File Structure
Java Classes**
**AudioBook.java:** Represents the Audiobook media type.
**AudioBookList.java:** Manages a list of audiobooks.
**AudioJson.java:** Handles JSON operations for audiobooks.
**BookJson.java:** Handles JSON operations for books.
**BookList.java:** Manages a list of books.
**BookProcessor.java:** Processes book-related operations.
**Books.java:** Represents the Book media type.
**Categorized.java**: Handles categorization of media.
**Library.java:** Central library class managing all types of media.
**LibraryEvent.java:** Represents events within the library.
**LibraryObserver.java:** Observer interface for library events.
**Magazine.java:** Represents the Magazine media type.
**MagazineJson.java:** Handles JSON operations for magazines.
**MagazineList.java:** Manages a list of magazines.
**MainApp.java:** Main application class.
**Media.java:** Media interface for all media types.
**MediaType.java:** Enum representing different media types.
**Metadata.java:** Stores metadata for media.
**Movie.java:** Represents the Movie media type.
**MovieJson.java:** Handles JSON operations for movies.
**MovieList.java:** Manages a list of movies.
**JSON Files**
**audiobooks.json:** Contains data for audiobooks.
**books.json:** Contains data for books.
**magazines.json:** Contains data for magazines.
**movies.json:** Contains data for movies.
