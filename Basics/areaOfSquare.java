import java.util.*;
public class areaOfSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of side of Square :");
        float s= sc.nextFloat();
        float area = s*s;
        System.out.print("The area of Square is " + area);
    }
}
