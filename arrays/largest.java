import java.util.*;

public class largest {
    public static int largest(int arr[]){
        int largest = Integer.MIN_VALUE;
        int temp = largest;
        for(int i=0; i<arr.length ; i++){
            temp = largest;
            if(arr[i]>largest){
                
                largest = arr[i];
            }
        }
        System.out.println("Second largest :" + temp);
        
        return largest;
    }



    public static void main(String[] args) {
        int arr[] = {1,2,5,7, 11, 3,5,33, 55};

        int largest = largest(arr);
        System.out.println("largest :" + largest);

    }
}
