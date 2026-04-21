import java.util.ArrayList;

public class monotonic {

    public static boolean monotonicOrNot(ArrayList<Integer> list){

        boolean isIncreasing = true;
        boolean isDecreasing = true;
        

        for(int i=0; i<list.size()-1 ; i++){
            if(list.get(i) <= list.get(i+1)){
                isIncreasing = true;
            }else{
                isIncreasing = false;
                break;
            }
            
        }

        for(int i=0 ; i < list.size()-1 ; i++){
            if(list.get(i) >= list.get(i+1)){
                isDecreasing = true;
            }else{
                isDecreasing = false;
                break;
            }
        }

        return isDecreasing || isIncreasing;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        System.out.println(monotonicOrNot(list));

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(5);
        list2.add(4);
        list2.add(4);
        System.out.println(monotonicOrNot(list2));


        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(3);
        list3.add(2);
        list3.add(4);
        System.out.println(monotonicOrNot(list3));
    }   
}
