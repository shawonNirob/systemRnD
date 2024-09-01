package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        // Initialize the frequency map for characters in p
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            // If the current character is in p, decrement its count in the map
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                // Only decrease count if the character is still needed (i.e., count > 0)
                if (map.get(s.charAt(right)) >= 0) {
                    count--;
                }
            }
            right++;

            // When the window size equals p's length
            if (right - left == p.length()) {
                if (count == 0) {
                    result.add(left); // Found an anagram
                }

                // Now slide the window: remove the character at 'left' from the window
                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if (map.get(s.charAt(left)) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Anagrams sol = new Anagrams();
        String s = "aaaaaabcd";
        String p = "aaabcd";
        List<Integer> result = sol.findAnagrams(s, p);
        System.out.println(result);  // Output: [0, 6]
    }
}
