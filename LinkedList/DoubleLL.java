public class DoubleLL {
    public class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    //operations


    //---------->add first

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }


    //---------> addLAst

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            tail = head = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }


    //------> remove first
    public int removeFirst(){
        if(head == null){
            System.out.println("Dll is empty");
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }


    //removeLast
    public int removeLast(){
        if(head == null){
            System.out.println("Dll is empty");
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;

        
    }




    //---- > REverse
    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }

        head = prev;
    }


    //print
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }

        System.out.println("null");
    }



    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print(); //1<->2<->3<->null
        System.out.println(dll.size);
        

        dll.addLast(4);
        System.out.println(dll.size);
        dll.print();


        System.out.println(dll.removeFirst());
        dll.print();
        System.out.println(dll.size);


        System.out.println(dll.removeLast());
        dll.print();
        System.out.println(dll.size);



        dll.addFirst(1);
        dll.addLast(4);
        dll.print();
        dll.reverse();
        dll.print();
        
    }

}
