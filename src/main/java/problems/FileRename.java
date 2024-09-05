package problems;

import java.util.ArrayList;
import java.util.List;

public class FileRename {

    private static int count = 0;
    // Function to find all possible subsequences
    public static List<String> findAllSubsequences(String oldName, String newName) {
        List<String> results = new ArrayList<>();
        backtrack(results, new StringBuilder(), oldName, newName, 0, 0);
        return results;
    }

    // Backtracking function
    private static void backtrack(List<String> results, StringBuilder current, String oldName, String newName, int i, int j) {
        // Base case: If we have formed the entire newName, add the current subsequence to the result list
        if (j == newName.length()) {
            results.add(current.toString());
            count++;
            return;
        }

        // Base case: If we have exhausted oldName but newName is not completely formed
        if (i == oldName.length()) {
            return;
        }

        // If the current characters of oldName and newName match
        if (oldName.charAt(i) == newName.charAt(j)) {
            // Include the current character and move both pointers forward
            current.append(oldName.charAt(i));
            backtrack(results, current, oldName, newName, i + 1, j + 1);
            // Backtrack by removing the last character
            current.deleteCharAt(current.length() - 1);
        }

        // Skip the current character in oldName and move to the next character
        backtrack(results, current, oldName, newName, i + 1, j);
    }

    // Driver function
    public static void main(String[] args) {
        String oldName = "abcababcd";
        String newName = "abc";

        // Call the function to find all subsequences
        List<String> subsequences = findAllSubsequences(oldName, newName);

        // Print the results
        System.out.println("All possible subsequences are: ");
        for (String subsequence : subsequences) {
            System.out.println(subsequence);
        }
        System.out.println("Total count: " + count);
    }
}
