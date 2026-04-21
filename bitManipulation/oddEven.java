import java.util.Scanner;

public class oddEven {

    public static boolean oddOrEven(int n){
        int bitMask = 1;
        if( (n & bitMask) == 0){
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter value");

        int n = sc.nextInt();
        System.out.println(oddOrEven(n));

        
    }
}
