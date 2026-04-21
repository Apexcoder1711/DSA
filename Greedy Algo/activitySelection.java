import java.util.*;

public class activitySelection{
    public static void main(String args[]){
        System.out.println("j");
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        //What if it is not sorted
        int activites[][] = new int[start.length][3]; 
        for(int i=0 ; i<start.length ; i++){
            activites[i][0] = i;
            activites[i][1] = start[i];
            activites[i][2] = end[i];
        }
        //lamda function short form
        //2nd matrix sorting 
        Arrays.sort(activites , Comparator.comparingDouble(o -> o[2])); // sorted on the basis of end 

        //end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();


        //already sorted
        //1st activity

        // maxAct = 1;
        // ans.add(0);
        // int lastEnd = end[0];
        // for(int i=1 ; i<end.length ; i++){
        //     if(start[i] >= lastEnd){
        //         ans.add(i);
        //         lastEnd = end[i];
        //         maxAct++;
        //     }
        // }

        //-------------------->>>>>>>>


        //after Sorting 
        //1st activity
        maxAct = 1;
        ans.add(activites[0][0]);
        int lastEnd = activites[0][2];
        for(int i=1 ; i<end.length ; i++){
            if(activites[i][1] >= lastEnd){
                ans.add(activites[i][0]);
                lastEnd = activites[i][2];
                maxAct++;
            }
        }

        System.out.println("max activities = " + maxAct);
        for(int i=0 ; i<ans.size() ; i++){
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}