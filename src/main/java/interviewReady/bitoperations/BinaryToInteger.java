package interviewReady.bitoperations;

public class BinaryToInteger {
    public static int BinaryToIntTranformation(String s) {
        int result =0;
        int length = s.length()-1;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='1') {
                result += Math.pow(2, length);
                length--;
            }else{
                length--;
            }
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println("Whats up!");
        System.out.println(BinaryToInteger.BinaryToIntTranformation("1101"));
    }
}
