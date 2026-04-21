package Functions;
import java.util.Scanner;

public class factorial {
    public static int factor(int n){
       
        int facto = 1;
        for(int i=1;i<=n; i++){
            facto*=i;
            
        }
        // System.out.println("factorial of number "+ n + "=" + facto);

        return facto;
    }

    public static int binaryCoff(int n, int r){
        int fact_n = factor(n);
        int fact_r = factor(r);
        int fact_n_r = factor(n-r);

        int binaryCoff = fact_n/(fact_r*fact_n_r);

        System.out.println(" binary coefficint is " + binaryCoff);
        return binaryCoff;
    }

    public static void main(String[] args) {
        //System.out.print("enter the number for factorial ");
        // Scanner sc = new Scanner(System.in);
        // int n;
        // = sc.nextInt();
        // factor(4);

        binaryCoff(5, 02);


    }
}
