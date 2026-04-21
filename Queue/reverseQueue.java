import java.util.*;

public class reverseQueue {
    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        int size = q.size();

        for(int i= 0 ; i<size ; i++){
            s.push(q.remove());
        }

        for(int i=0 ; i<size ; i++){
            q.add(s.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        reverse(q);

        // print
        // while (!q.isEmpty()) {
        //     System.out.print(q.remove() + " ");
        // }

        System.out.println(q);
    }
}
