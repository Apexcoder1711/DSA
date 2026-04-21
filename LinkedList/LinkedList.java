import java.time.temporal.Temporal;

public class LinkedList{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        //Step-1 :- create new node
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }
        

        //Step-2 :- assign the newNode of next to the head (actual linking)
        newNode.next = head;

        //Step-3:- Assign new head
        head = newNode;
    }

    public void print(){  //O(n)
        if(head == null){
            System.out.println("Linked list is empty");
            return ;
        } 

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println("null");
    }


    //addLast in linked list
    public void addLast(int data){
        //step-1 : Create a new node
        Node newNode = new Node(data);
        size++;

        //if no any node exists
        if(head == null){
            head = tail = newNode;
            return;
        }

        //step-2:- assign tail.next = newNode
        tail.next = newNode;

        //step-3 :- tail = newNode
        tail = newNode;
    }

    public  void add(int index , int data){

        //for index = 0 toh phir hmlog ko head ko manage krna hoga
        if(index == 0) {
            addFirst(data);
            return; //compulsory
        }

        //creating new node
        Node newNode = new Node(data);
        size++;

        //make temp node for operations 
        Node temp = head;
        int i = 0;

        while (i<index-1) { //jis position me daalna se usse ek km position tk chlega taki udhr phir se link kr ske
            temp = temp.next;
            i++;
        }

        // first 
        newNode.next = temp.next; 
        //second
        temp.next = newNode;


    }
    

    public int removeFirst(){
        if(size==0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;

    }

    public int itrSearch(int key){
        Node temp = head;
        int idx=0;
        while(temp != null){
            if(temp.data == key){
                return idx;
            }

            idx++;
            temp = temp.next;

        }

        return -1;
    }


    public int helper(Node head , int key){
        if(head == null){
            return -1;
        }

        if(head.data == key){
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }

        return idx+1;
    }
    public int recSearch(int key){
        return helper(head , key );
    }




    public void reverse(){
        Node prev = null;
        Node curr = tail = head ;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }



    public int removeNthFromEnd(int n){
        int sz= 0 ;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            sz++;
        }

        if(size == n){
            int val = head.data;
            head = head.next; //removeFirst
            return val;
        }

        int i = 1;
        int idxToFind = sz-n;
        Node prev = head;
        while (i < idxToFind) {
            prev = prev.next;
            i++;
        }

        int val = prev.next.data;
        prev.next = prev.next.next;

        return val;

    }


    //check ll is palindrome or not 
    //1) find mid node 
    //2) reverse from mid node
    //3) make left pointer from head and right pointer 
    //4) compare left.data and right.data



    //finding mid
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; // increment by +1 
            fast = fast.next.next; //increment by +2
        }

        return slow; //slow becomes mid node 
    }

    public boolean checkPalindrome(){
        //base case if ll is empty or single value
        if(head == null || head.next == null){
            return true;
        }

        //find mid node
        Node midNode = findMid(head);

        //reverse step
        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        //comparing left and right 
        while (right != null){
            if(left.data != right.data){
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;

    }

    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true; //cycle exists
            }
        }

        return false; //cycle doesnt exists
    }



    //removing cycle 

    public static void removeCycle(){
        // detect cycle
        Node slow = head;
        Node fast = head ;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                cycle = true;
                break;
            }
        }

        if(cycle == false){
            return;
        }

        //finding joint point

        slow = head;
        Node previous = null; //for detecting last node
        while (slow != fast) {
            slow = slow.next; // +1
            previous = fast ; // store fast previous value for detecting last node and change to null
            fast = fast.next; // it also increase by 1

            //but technically esa hoga ki iss baar slow and fast jidhr milenge woh joining point hoga
        }

        previous.next = null;
    }


    //merge sort 
    //finding mid node
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next; //for even no. of linked list to get the mid 

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; //mid node of ll 
    }

    //merge 
    private Node merge(Node leftHead , Node rightHead){
        //create new node with dummy initialization
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(leftHead != null && rightHead != null){
            if(leftHead.data <= rightHead.data){
                temp.next = leftHead;
                temp = temp.next;
                leftHead = leftHead.next;
            }
            else{
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }

        while(leftHead != null){
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }

        while (rightHead != null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }
    public Node mergeSort(Node head){

        //base case
        if(head == null || head.next == null){
            return head;
        }

        //find mid node
        Node midNode = getMid(head);

        Node rightHead = midNode.next;
        midNode.next = null ;  //divided from mid part

        //applying mergeSort for head and right Head
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft , newRight);
    }



    //-------zigzag

    //1) finding middle node of (mid = 1st half last node)
    //2) 2nd half reverse
    //3) alternate merging like checking data in palindrome

    public void zigZag(){
        //find mid
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;


        //reverse the second half

        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; //2nd half head
        Node left = head; //1st half head

        Node nextLeft;
        Node nextRight;
        while (left != null && right != null) {
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;


            left = nextLeft;
            right = nextRight;
        }
    }
    public static void main(String args[]){
        //LinkedList ll = new LinkedList();
        // ll.addFirst(2); //ll non static func ko v call kr skta hai
        // ll.print();
        // ll.addFirst(1);
        // ll.print();
        // ll.addLast(3);
        // ll.print();
        // ll.addLast(4);
        // ll.addLast(4);
        // ll.print();

        // ll.add(2, 10);
        // ll.print();

        // System.out.println(ll.size);

        // System.out.println(ll.removeFirst());

        // ll.print();

        // System.out.println(ll.itrSearch(6));
        // System.out.println(ll.itrSearch(10));


        // System.out.println(ll.recSearch(4));
        // System.out.println(ll.recSearch(15));


        // ll.reverse();
        // ll.print();


        // System.out.println(ll.removeNthFromEnd(2));
        // ll.print();


        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.print();


        // ll.addLast(2);
        // ll.addLast(1);
        // ll.addLast(3);

        // System.out.println(ll.checkPalindrome());

        
        // head = new Node(1);
        
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = head;
        // //head.next.next.next = null;
        // //1-->2-->3-->1..... 

        // System.out.println(isCycle());



        // head = new Node(1);
        // Node temp = new Node(5);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp; 
        // // 1-->5-->3-->5...

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        // LinkedList ll = new LinkedList();
        // ll.addLast(5);
        // ll.addLast(4);
        // ll.addLast(3);
        // ll.addLast(2);
        // ll.addLast(1);

        // ll.print();

        // ll.head = ll.mergeSort(ll.head);
        // ll.print();



        LinkedList ll2 = new LinkedList();
        ll2.addFirst(6);
        ll2.addFirst(5);
        ll2.addFirst(4);
        ll2.addFirst(3);
        ll2.addFirst(2);
        ll2.addFirst(1);
        ll2.print();
        ll2.zigZag();
        ll2.print();
        
    }
}


