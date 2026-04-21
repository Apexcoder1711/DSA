
import java.util.*;

public class anagram {
    public static void main(String[] args) {
        
        String s1 = "tea";
        String s2 = "eat";

        //approach 
        //isme sbse phle char array bnayenge jiske chlte sb words ka char ka alg alg ho kr arraay bn jayega
        //ab iske baad us array ko arrange krenge --> sort
        //ab .equals() use krenge agr ho gya toh shi hai nhi toh false 

        char[] s1Array = s1.toCharArray();  //['t' , 'e' , 'a']
        char[] s2Array = s2.toCharArray();  //['e' , 'a' , 't']

        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        //System.out.println(s1Array.equals(s2Array));  --> it gives false always because s1Array and s2Array is not pointing same array but both are different array

        System.out.println(Arrays.equals(s1Array, s2Array));
    }
}
