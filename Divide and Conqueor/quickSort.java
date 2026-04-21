public class quickSort {
    public static void Sort(int nums[] , int left , int right){
        if(left >= right){
            return;
        }
        int pivotidx = partition(nums , left , right , nums[right]);
        
        Sort(nums , left , pivotidx-1);
        Sort(nums, pivotidx+1, right);
    }

    public static int partition(int nums[] , int left , int right , int key){
        int i=left;
        for(int j=left ; j<=right ; j++){
            if(nums[j] <= key){
                //Swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        return i-1;
    }

    public static void printArr(int nums[]){
        for(int i=0; i<nums.length ; i++){
            System.out.print(nums[i] + " ");
        }
    }
    public static void main(String[] args){
        int nums[] = {1,5,6,2,4,7,90,64,3,54,21};
        Sort(nums, 0, nums.length-1);
        printArr(nums);
    }
}
