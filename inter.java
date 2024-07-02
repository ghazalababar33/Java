interface Animal {
    void makeSound();
    default void eat() {
        System.out.println("Animal is eating.");
    }
    static void sleep() {
        System.out.println("Animal is sleeping.");
    }
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Dog barks");
    }
}
