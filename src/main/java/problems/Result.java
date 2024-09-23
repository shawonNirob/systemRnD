package problems;

import java.util.*;

class Result {

    public static String gridChallenge(List<String> grid) {
        int n = grid.size();

        // Step 1: Sort each row alphabetically
        for (int i = 0; i < n; i++) {
            char[] row = grid.get(i).toCharArray();
            Arrays.sort(row);
            grid.set(i, new String(row));
        }

        // Step 2: Check if columns are sorted
        for (int col = 0; col < n; col++) {
            for (int row = 1; row < n; row++) {
                if (grid.get(row - 1).charAt(col) > grid.get(row).charAt(col)) {
                    return "NO";
                }
            }
        }

        return "YES";  // If all columns are sorted, return "YES"
    }

    public static void main(String[] args) {
        List<String> grid = new ArrayList<>();
        grid.add("mpxz");
        grid.add("abcd");
        grid.add("wlmf");

        String result = gridChallenge(grid);
        System.out.println("Answer: " + result);
    }
}