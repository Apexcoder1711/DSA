import java.util.*;

public class minimumSumAbsoluteDifferencePairs {
    public static void absoluteDiff(int A[] , int B[]){
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;
        for(int i= 0 ; i < A.length ; i++){
            minDiff = Math.abs(A[i] - B[i]);
        }
        
        System.out.println("Min abs diff of pairs : " + minDiff);
    }

    public static void main(String[] args) {
        int A[] = {4,1,8,7};
        int B[] = {2,3,6,5};


        absoluteDiff(A , B);
        absoluteDiff(new int[]{1, 3, 2}, new int[]{2, 3, 1});
    }
}
