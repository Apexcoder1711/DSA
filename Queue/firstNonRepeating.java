import java.util.*;

public class firstNonRepeating {

    public static void printNonRepeating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);

            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1 ){
                q.remove();
            }

            //upr wale loop ke baad 2 hi case ho skta hai ya toh usko non repeating letter mil gya jiska freq 1 hai nhi toh queue pura khali hai
            
            //case 1
            if(q.isEmpty()){
                System.out.println(-1 + " ");
            }

            //case 2
            else{
                System.out.println(q.peek()+ " ");
            }
        }

        System.out.println();
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
}
