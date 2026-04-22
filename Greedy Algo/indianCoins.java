import java.util.*;
public class indianCoins {
    public static void main(String[] args) {
        int coins[] = {1,2,5,10,20,50,100,200,500,2000}; //kisi v order me ho skti hai
        int amount = 590;

        Arrays.sort(coins);

        ArrayList<Integer> list = new ArrayList<>();

        int count = 0;
        for(int i=coins.length-1 ; i>= 0 ; i--){
            while(amount >= coins[i]){
                count++;
                list.add(coins[i]);
                amount -= coins[i];
            }
        }

        System.out.println("no of coins/notes used : " + count);

        for(int i=0 ; i<list.size() ; i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
