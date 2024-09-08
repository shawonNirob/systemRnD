package problems;

import java.util.HashMap;
import java.util.Map;

public class FileRename {

    // Memoization cache to store already computed states
    private static final Map<String, Integer> memo = new HashMap<>();

    // Function to count all possible subsequences
    public static int countSubsequences(String oldName, String newName) {
        return backtrack(oldName, newName, 0, 0);
    }

    // Backtracking function with memoization
    private static int backtrack(String oldName, String newName, int i, int j) {
        // Base case: If we have formed the entire newName, return 1 (found a valid subsequence)
        if (j == newName.length()) {
            return 1;
        }

        // Base case: If we have exhausted oldName but newName is not completely formed
        if (i == oldName.length()) {
            return 0;
        }

        // Create a unique key for the current state
        String key = i + "," + j;

        // If this state has already been computed, return the cached result
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result = 0;

        // If the current characters of oldName and newName match
        if (oldName.charAt(i) == newName.charAt(j)) {
            // Move both pointers forward (include the character in subsequence)
            result += backtrack(oldName, newName, i + 1, j + 1);
        }

        // Skip the current character in oldName and move to the next character
        result += backtrack(oldName, newName, i + 1, j);

        // Store the result in the memoization cache and return it
        memo.put(key, result);
        return result;
    }

    // Driver function
    public static void main(String[] args) {
        String oldName = "abcababcd";
        String newName = "abc";

        // Call the function to count all subsequences
        int count = countSubsequences(oldName, newName);

        // Print the total count
        System.out.println("Total count of subsequences: " + count);
    }
}