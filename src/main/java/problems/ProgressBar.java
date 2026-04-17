package problems;

import java.util.Scanner;

public class ProgressBar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();

        int totalSat = n*k*t/100;
        int fullBlocks = totalSat/k;
        int leftover = totalSat%k;

        for(int i=0; i<n; i++){
            if(i<fullBlocks){
                System.out.println(k + " ");
            } else if (i == fullBlocks && leftover==0) {
                System.out.println(leftover + " ");
            }else{
                System.out.println(0 + " ");
            }
        }
    }
}
