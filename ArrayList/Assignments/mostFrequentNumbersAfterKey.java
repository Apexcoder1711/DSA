import java.util.ArrayList;
import java.util.HashMap;

public class mostFrequentNumbersAfterKey {
    public static int mostNumber(int nums[], int key) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int count = 0;
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == key) {
                if (mp.containsKey(nums[i + 1]) == false) {
                    mp.put(nums[i+1],1);
                }
                else{
                    mp.put(nums[i+1],mp.get(nums[i+1])+1);
                }

                if(mp.get(nums[i+1]) > count){
                    count = mp.get(nums[i+1]);
                    ans = nums[i+1];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 100, 1, 200, 1, 100, 1, 100 };
        int nums2[] = { 1, 100, 1, 200, 1, 200, 1, 200 };
        

        System.out.println(mostNumber(nums2, 1));
        System.out.println(mostNumber(nums, 1));
    }
}
