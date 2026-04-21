package Functions;
import java.util.*;
public class averageOf3no {
    public static double average(double a , double b , double c){
        double average = (a + b+ c)/3;
        return average;
    }

    public static void main(String[] args) {
        // System.out.println(average(29, 034, 045));

         Scanner sc = new Scanner(System.in);
         System.out.print("Enter the first no.  ");
         double a= sc.nextDouble();
         System.out.print("Enter the second no.  ");
         double b= sc.nextDouble();
         System.out.print("Enter the third no.  ");
         double c= sc.nextDouble();
         System.out.println("the average of given no. is " + average(a,b,c));
    }
}
