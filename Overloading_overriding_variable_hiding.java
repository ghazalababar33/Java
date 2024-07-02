class Parent {
    int x = 10;

    void display() {
        System.out.println("Parent's display method");
    }

    static void staticMethod() {
        System.out.println("Static method in Parent");
    }
}

class Child extends Parent {
    int x = 20;

    void display() {
        System.out.println("Child's display method");
    }

    void display(String message) {
        System.out.println("Child's overloaded display method with message: " + message);
    }

    static void staticMethod() {
        System.out.println("Static method in Child");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent obj1 = new Parent();
        System.out.println("Parent variable x: " + obj1.x);
        obj1.display();
        Parent.staticMethod();

        System.out.println();

        Child obj2 = new Child();
        System.out.println("Child variable x: " + obj2.x);
        obj2.display();
        obj2.display("Hello");
        Child.staticMethod();

        System.out.println();

        // Polymorphism example
        Parent obj3 = new Child();
        System.out.println("Polymorphism - Parent variable x: " + obj3.x);
        obj3.display();
        Parent.staticMethod();

        // Accessing overridden method using type casting
        ((Child) obj3).display(); // Cast to Child to access Child's display method
        Child.staticMethod(); // Access Child's static method
    }
}
