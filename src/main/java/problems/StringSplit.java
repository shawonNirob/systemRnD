package problems;

public class StringSplit {
    public static void main(String[] args) {
        String s1 = "Md Shawon Sarowar. How are you, , I am fine. What is your address? My Adress is #Badda, Dahaka";

        String[] arr = s1.split("[\\s\\.\\,\\?\\#]+");

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
