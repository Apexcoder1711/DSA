public class countingSort {

    public static void countingSort(int arr[]){
        int n= arr.length;

        //counting sort works on frequncy of the elements in the array
        

        //finding the largest from the array because it is used for making count array which is size of largest + 1
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            largest = Math.max(largest, arr[i]);
        }

        //here we found frequncies and store at at that place , which means if 2 comes in arr 5 times then count[2] becomes 5 

        int count[] = new int[largest+1];
        for(int i=0 ; i< n; i++){
            count[arr[i]]++;
        }

        //here we insert values in arr according to frequencies stored in count 

        int j=0;
        for(int i=0; i< count.length ; i++){
            while(count[i]>0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

        for(int i=0; i< n; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args){
        int nums[] = {12,1,2,3,0,5,6,7,0,9,4};
        countingSort(nums);
    }
}
