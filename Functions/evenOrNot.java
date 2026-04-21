package Functions;
import java.util.*;
public class evenOrNot {
    public static boolean isEven(int n){
        if (n%2==0) {
            return true;
        }else{
            return false;
        }
        
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number to check the no. ");
        int n = sc.nextInt();

        System.out.println(isEven(n));

        if(isEven(n)){
            System.out.println("even");
        }
        else{
            System.out.println("odd");
        }
    }
}
