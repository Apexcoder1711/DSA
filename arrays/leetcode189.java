public class leetcode189 {
     public static void  rotate(int[] nums, int k) {
              int n= nums.length;
        int shift = k;


        if(shift==0){
            return;
        }
        int output[] = new int[n];

        for(int i=0; i<n ; i++){
            int x=(i+shift)%n;
            output[x] = nums[i]; 
        }

        for(int i=0; i<n;i++){
            nums[i] = output[i];
        }

    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7};
        int k=2;

        rotate(nums, 3);
    }
}
