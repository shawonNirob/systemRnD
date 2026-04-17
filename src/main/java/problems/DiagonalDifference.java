package problems;

import java.util.Scanner;

public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(diagonalDifference(matrix));
    }

    public static int diagonalDifference(int[][] matrix) {
        int n = matrix.length;
        int left_to_right = 0;
        int right_to_left = 0;

        for(int i = 0; i < n; i++) {
            left_to_right = left_to_right + matrix[i][i];
            right_to_left = right_to_left + matrix[i][n-1-i];
        }

        return Math.abs(left_to_right - right_to_left);
    }
}
