public class Method {

    public static void showStaticMessage() {
        System.out.println("This is a static method.");
    }

    public void showInstanceMessage() {
        System.out.println("This is an instance method.");
    }

    public void showMessageWithParams(String msg, int value) {
        System.out.println("Message: " + msg + ", Value: " + value);
    }

    public int calculateSum(int num1, int num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {
        showStaticMessage();

        MethodDemo demo = new MethodDemo();
        demo.showInstanceMessage();
        demo.showMessageWithParams("Hello, World!", 42);
        
        int sum = demo.calculateSum(5, 7);
        System.out.println("Sum: " + sum);
    }
}
