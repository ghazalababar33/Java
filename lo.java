public class Main {
    public static void main(String[] args) {
        // Example of a for loop
        System.out.println("Example of a for loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count is: " + i);
        }
        System.out.println();

      
        System.out.println("Example of an enhanced for loop (for-each loop):");
        int[] numbers = {1, 2, 3, 4, 5};
        for (int number : numbers) {
            System.out.println("Number is: " + number);
        }
        System.out.println();

        // Example of a while loop
        System.out.println("Example of a while loop:");
        int count = 1;
        while (count <= 5) {
            System.out.println("Count is: " + count);
            count++;
        }
        System.out.println();

        // Example of a do-while loop
        System.out.println("Example of a do-while loop:");
        count = 1; // Reset count for do-while loop
        do {
            System.out.println("Count is: " + count);
            count++;
        } while (count <= 5);
    }
}
