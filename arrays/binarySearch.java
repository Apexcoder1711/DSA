

public class binarySearch {

    public static int search(int arr[] , int target){
        int index = -1;
        int start = 0;
        int end = arr.length-1;
        // int mid = -1;

        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]== target){
                index=mid;
                break;
            } 
            else if(arr[mid]<target){
                start= mid+1;
            }
            else if(arr[mid]> target){
                end = mid-1;
            }
        }

        return index;
    }
    public static void main(String args[]){
        int arr[] = {1, 2, 3 , 5 , 10 , 15, 16, 20 , 25, 30};
        int target = 5;

        System.out.println(search(arr, target));

    
    }
}
