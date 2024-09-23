package interviewReady.bitoperations;

public class IntegerToBinary{
    public static String IntegerToBinaryTranformation(int n) {
        String ans = "";
        while (n > 0){
            int remainder = n % 2;
            n = n / 2;
            String s = Integer.toBinaryString(remainder);
            ans += s;
        }
        String reversed = new StringBuilder(ans).reverse().toString();
        return reversed;
    }
    public static void main(String[] args){
        System.out.println("Whats up!");
        System.out.println(IntegerToBinary.IntegerToBinaryTranformation(255566636));
    }
}
