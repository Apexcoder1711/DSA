

public class circularQueueByArray {
    static class circularQueue {
        static int arr[];
        static int size;
        static int rear;
        static int front;


        circularQueue(int n){
            arr= new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear==-1 && front==-1;
        }

        public static boolean isFull(){
            return (rear+1)%size == front;
        }

        //operations 
        //add --> O(1)
        public static void add(int data){
            if(isFull()){
                return;
            }
            //for 1st element :- 

            if(front == -1){
                front = 0;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }

        //remove--> O(1)
        public static int remove(){
            if(isEmpty()){
                return -1;
            }

            int removed = arr[front];
            //if last element is being deleted
            if(rear == front){
                rear = front = -1;
            }
            else{
                front = (front + 1) % size;
            }
            

            

            return removed;
        }

        //peek() --> O(1)

        public static int peek(){
            if(isEmpty()) return -1;

            return arr[front];

        }

    }
    public static void main(String[] args) {
       circularQueue q = new circularQueue(5);
       q.add(1);
       q.add(2);
       q.add(3);
       
       while(!q.isEmpty()){
            System.out.println(q.peek() + " ");
            q.remove();
       };

    }
}
