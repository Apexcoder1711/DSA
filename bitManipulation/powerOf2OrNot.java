import java.util.Scanner;

public class powerOf2OrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Value for check");
        int n = sc.nextInt();
        int a = n;

        int count = 0;
        while(n>0){
            if((n & 1) == 1){
                count++;
            }

            n>>=1; //right shift and store value
        }

        if(count == 1 ){
            System.out.println(a + " is power of 2");
        }
        else{
            System.out.println(a + " is not power of 2");
        }


        // 2nd approach 

        if((a & (a-1)) == 0){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}
