import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Example of using streams to filter and collect elements
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(num -> num % 2 == 0)  // Filter even numbers
                                           .collect(Collectors.toList()); // Collect results into a new list

        // Print the filtered even numbers
        System.out.println("Even numbers: " + evenNumbers);

        // Example of using streams to calculate sum
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);  // Perform reduction to calculate sum starting with 0

        // Print the sum of all numbers
        System.out.println("Sum of all numbers: " + sum);
    }
}
