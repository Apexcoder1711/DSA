import java.util.*;

public class reverseString {
    public static String reverse(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            char curr = str.charAt(idx);
            s.push(curr);
            idx++;
        }

        StringBuilder result = new StringBuilder("");

        while(!s.isEmpty()){
            result.append(s.pop());
        }

        return result.toString();
    }
public static void main(String[] args) {
    String str = reverse("abc");
    System.out.println(str);
}
}
