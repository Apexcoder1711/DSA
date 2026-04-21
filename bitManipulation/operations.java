import java.net.Socket;
import java.util.Scanner;

public class operations {
    public static int getith(int n , int i){

        int bitMask = 1<<i; //isme 1 ke bit ka position set kiya gya hai i ke according sirf 1 bit ko chod kr sb zero hoga

        if((n & bitMask) == 0){
            return 0;
        }


        
        //ex --> n = 10 (1010)     i = 2
        // 1 << 2 (0001)--> (0100)
        // n & (1<<2)
        //1010
        //0100
       //&------
        //0000 
        // so ans is 0;

        return 1; //usme 1 hoga toh 1 dega

    }




    public static int setithBit(int n , int i){
        int bitMask = 1 << i;
        return n | bitMask; //set kr dega us positon ko
    }

    public static int clearithBit(int n, int i){ //set ith position to zero
        int bitMask = ~(1<<i);
        return n & bitMask;
    }

    public static int updateithBit(int n , int i , int newBit){
        if(newBit == 0){
            return clearithBit(n, i);
        }
        else{
            return setithBit(n, i);
        }
    }


    public static int cleariBits(int n , int i){ //clear all bits from left side to ith position
        int bitMask = (~0)<<i; //~0 == 11111111 
        return n & bitMask;
    }


    public static int clearRangeofBits(int n , int i , int j){
        int a= (~0)<< (j+1); 
        int b = (1<<i)-1 ; // 1 << i == 2 to the power i
        int bitMask = a | b;

        return n & bitMask;
    }
    public static void main(String[] args) {

        System.out.println("Get ith position bit");
        System.out.println(getith(10, 3));
        System.out.println(getith(15, 5));

        System.out.println("Set ith position to 1");
        System.out.println(setithBit(10, 2));
        System.out.println(setithBit(19, 4));

        System.out.println("Clear ith position to 0");
        System.out.println(clearithBit(17, 3));
        System.out.println(clearithBit(89 , 4));


        System.out.println("Update ith positon to newbit");
        System.out.println(updateithBit(15, 0, 0));
        System.out.println(updateithBit(78 , 1 , 0));
        System.out.println(updateithBit(78 , 0 , 1));


        System.out.println("Clear i bits");
        System.out.println(cleariBits(7, 2));
        System.out.println(cleariBits(17, 3));


        System.out.println("Clear Range of bits");
        System.out.println(clearRangeofBits(31, 2, 4));
        System.out.println(clearRangeofBits(63, 1, 5));

    }
}
