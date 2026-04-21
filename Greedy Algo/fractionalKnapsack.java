import java.util.*;
;

public class fractionalKnapsack{
    public static void main(String[] args) {
        int val[] = {60 , 100 , 120};
        int weight[] = {10 , 20 , 30};
        int W = 50;

        double ratio[][] = new double[val.length][2];
        //1st col --> index
        //2nd col --> ratio

        for(int i=0 ; i<val.length ; i++){
            ratio[i][0] = i; //index
            ratio[i][1] = val[i]/(double)weight[i]; //ek ko double krenge toh calculation v double me aayega 
        }


        //sorting ascending order
        Arrays.sort(ratio , Comparator.comparingDouble(o -> o[1])); //perform sorting on the basis of 1st column

        int value = 0;
        int capacity = W;

        for(int i=ratio.length-1 ; i >= 0 ; i--){ //sorting is in ascending order thats why 
            int idx = (int)ratio[i][0];
            if(capacity > weight[idx]){
                //total include
                value += val[idx];
                capacity -= weight[idx];
            }
            else{
                //fraction include
                value += capacity * ratio[i][1];
                capacity = 0;
                break;
            }
        }

        System.out.println("final value : " + value);
    }
}