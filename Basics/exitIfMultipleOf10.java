import java.util.*;
public class exitIfMultipleOf10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //BREAK STATEMENT
       
        /* do {
             System.out.print("Enter the number ");
             int number = sc.nextInt();
             if ((number%10)==0) {
                 break;      
             }
             System.out.println(number);
         }
         while (true);*/


         // CONTINUE STATEMENT


        do {
            System.out.print("Enter the number :");
            int number = sc.nextInt();
            if ((number%10)==0) {
                continue;      
            }
            System.out.println(number);
        }
        while (true);
        
    }
}
