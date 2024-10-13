package problems;

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder str = new StringBuilder(s);
        int n = s.length();

        int leftOpen = 0;
        int rightClose = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='(') leftOpen++;
            if(s.charAt(i)==')') leftOpen--;

            if(leftOpen < 0 && s.charAt(i)==')'){
                str.deleteCharAt(i);
                leftOpen = 0;
            }
        }


        n = str.length();
        for(int j=n-1; j>=0; j--){
            if(str.charAt(j)==')') rightClose++;
            if(str.charAt(j)=='(') rightClose--;


            if(rightClose < 0 && str.charAt(j)=='('){
                str.deleteCharAt(j);
                rightClose = 0;
            }
        }

        return str.toString();
    }
}
public class RemoveParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minRemoveToMakeValid("))(("));
    }
}
