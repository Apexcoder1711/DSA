import java.util.*;
public class leapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the year :");
        int year = sc.nextInt();
        if((year%4)==0){
            System.out.println(" this is leap year ");
        }
        else{System.out.println("this is not leap year");}
    }
}