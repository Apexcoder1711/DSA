import java.util.*;
public class billWithGST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("hi");

        float pencil = sc.nextFloat();
        float pen = sc.nextFloat();
        float eraser = sc.nextFloat();

        float total = pencil + pen + eraser ;
         
        System.out.println("total is " + total);

        float totalGST = total + (total*0.18f);

        System.out.println("Total Bill with 18% GST is " + totalGST);
    }
}
