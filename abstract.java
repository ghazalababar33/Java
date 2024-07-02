abstract class Shape {
    abstract void draw();
    void display() {
        System.out.println("Displaying shape.");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing circle.");
    }
}
