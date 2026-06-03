public class heapSort { 
    //maxHeap --> ascending order
    //minHeap --> descending order

    private static void heapify(int i , int arr[] , int n){ //max heap logic
        int left = 2*i +1;
        int right = 2 * i+ 2;
        int maxIdx = i;

        if(left < n && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }

        if(right < n && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != i){
            //swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(maxIdx , arr , n);
        }
    }
    public static void heapSortt(int arr[]){
        int n = arr.length;
        //Step 1:- arr into maxHeap
        for(int i= n/2; i>= 0 ; i--){
            heapify(i , arr , n);
        }

        //step 2:- push element at last idx
        for(int i=n-1 ; i>=1; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(0 , arr , i);
        }

    }
    public static void main(String[] args) {
        int arr[] = {1,2 ,4,5,3};
        heapSortt(arr);
        for(int i=0 ; i < arr.length ; i++){
            System.out.print(arr[i] +  " ");
        }
    }
}
