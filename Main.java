public class Main {

    // Instance variables
    private String name;
    private int age;

    // Constructor
    public Main(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Instance method to display information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Main method
    public static void main(String[] args) {
        // Create object 1
        Main obj1 = new Main("Alice", 25);
        obj1.displayInfo();

        // Create object 2
        Main obj2 = new Main("Bob", 30);
        obj2.displayInfo();
    }
}
