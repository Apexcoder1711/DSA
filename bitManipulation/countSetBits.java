import java.util.Scanner;

public class countSetBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number");
        int n = sc.nextInt();
        int a = n;

        int count = 0;
        while ( n > 0) {
            if((n&1) == 1){ //check LSB
                count++;
            }

            n>>=1; //single right shift and store the value
        }

        System.out.println(count);
        System.out.println(count + " is the countSetBits of " + a);

    }
}
