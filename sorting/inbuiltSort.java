
import java.util.*;

public class inbuiltSort {

    public static void printArr(Integer arr[]){
        for(int i=0; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArr(int arr[]){
        for(int i=0; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int     arr[]={5,4,1,3,2};
        Integer arr2[] = {5 , 4, 1 , 3, 2}; 

        //increasing order
        //Arrays.sort(arr);
        Arrays.sort(arr,0,3);
        

        //decreasing order
        //Arrays.sort(arr2,Collections.reverseOrder());
        Arrays.sort(arr2,2,5,Collections.reverseOrder());

        printArr(arr);
        printArr(arr2);
    }
}
