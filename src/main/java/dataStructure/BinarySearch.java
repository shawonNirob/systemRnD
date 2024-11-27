package dataStructure;

public class BinarySearch {

    // Binary search template
    public static int binarySearch(int[] searchSpace, Condition condition) {
        int left = 0;
        int right = searchSpace.length - 1; // Can vary depending on the problem

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (condition.check(mid)) {
                right = mid; // Narrow down the range to the left
            } else {
                left = mid + 1; // Narrow down the range to the right
            }
        }

        return left; // The point where the condition is first satisfied
    }

    // Interface to define the condition logic
    interface Condition {
        boolean check(int value);
    }

    // Example usage
    public static void main(String[] args) {
        int[] searchSpace = {1, 2, 3, 4, 5, 6, 7};

        // Define the condition as a lambda or an anonymous class
        Condition condition = value -> searchSpace[value] >= 5;

        int result = binarySearch(searchSpace, condition);
        System.out.println("Result index: " + result); // Example: Finds the first index where value >= 5
    }
}
