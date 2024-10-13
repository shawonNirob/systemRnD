package problems;

public class StringSplit {
    public static void main(String[] args) {
        String str1 = "hello. how are you? i am fine! let's code.";

        // Split by sentence-ending punctuation (period, question mark, or exclamation mark)
        String[] sentences = str1.split("(?<=[\\.\\?\\!\\s])+");

        StringBuilder result = new StringBuilder();

        for (String sentence : sentences) {
            System.out.println(sentence);
        }

    }
}