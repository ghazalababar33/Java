# Book Processor Application

## Description
The Book Processor Application is a Java program designed to process a list of books stored in a JSON file. It provides various functionalities such as displaying all books, finding books by author, calculating the average price of all books, displaying the book with the highest price, and listing books by category.

## Features
- Display all books
- Find books by author
- Calculate the average price of all books
- Display the book with the highest price
- List books by category

## Project Structure
com.example.Assignment
├── BookJsons.java
├── BookProcessors.java
├── Bookss.java
├── BookListss.java
├── Metadataa
└── Main.java

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Gson library for JSON parsing

### Setup
1. **Clone the repository:**
    ```sh
    git clone https://github.com/your-username/book-processor.git
    cd book-processor
    ```

2. **Add Gson Library:**
    Add the Gson library to your project. You can download it from [here](https://github.com/google/gson) or add it as a dependency if you're using a build tool like Maven or Gradle.

3. **Place your JSON file:**
    Ensure that the `books.json` file is placed in the resources folder or the root directory of your project. Adjust the `filePath` in `Main.java` if necessary.

### Running the Application
1. **Compile the Java files:**
    ```sh
    javac -cp .;gson-2.8.6.jar com/example/Assignment/*.java
    ```

2. **Run the Main class:**
    ```sh
    java -cp .;gson-2.8.6.jar com.example.Assignment.Main
    ```

3. **Follow the on-screen instructions:**
    The program will prompt you to choose various options to interact with the book list.

### Example `books.json` File
Here's a sample structure of `books.json`:

```json
{
  "books": [
    {
      "title": "To Kill a Mockingbird",
      "author": "Harper Lee",
      "metadata": {
        "price": 10.99,
        "categories": ["Fiction", "Classic"]
      }
    },
    {
      "title": "1984",
      "author": "George Orwell",
      "metadata": {
        "price": 14.99,
        "categories": ["Dystopian", "Science Fiction"]
      }
    }
  ]
}
