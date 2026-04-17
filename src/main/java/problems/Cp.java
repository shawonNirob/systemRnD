package problems;

import java.util.*;

public class Cp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        sc.nextLine();

        for (int t = 0; t < testCases; t++) {
            List<String> lines = new ArrayList<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) break;
                lines.add(line);
            }
        }

    }
}

