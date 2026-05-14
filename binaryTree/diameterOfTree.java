public class diameterOfTree {
    public static class Node{
        int data;
        Node left , right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root){
        if(root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int height = Math.max(leftHeight, rightHeight) + 1;
        
        return height;
    }


    //this is approach 1 : O(n^2)
    public static int diameter1(Node root){
        if(root == null) return 0;

        int ldiam = diameter1(root.left);
        int lh = height(root.left);

        int rdiam = diameter1(root.right);
        int rh = height(root.right);

        int selfDiam = lh + rh +1; //if diameter passes through root

        return Math.max(Math.max(rdiam, ldiam), selfDiam);
    }



    //Approach 2 : O(n)
    static class Info{
        int diam ;
        int ht;

        public Info(int diam , int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }


    //return object
    public static Info diameter2(Node root){
        if(root == null) return new Info(0, 0);

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam) , leftInfo.ht + rightInfo.ht + 1);

        int ht = Math.max(leftInfo.ht , rightInfo.ht) + 1;

        return new Info(diam, ht);
    }
    public static void main(String[] args) {


        //         1 (Root)
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7


        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //height
        System.out.println(height(root));

        //diameter
        System.out.println(diameter1(root));


        //approach 2:-
        System.out.println(diameter2(root).diam);
        System.out.println(diameter2(root).ht);
    }
}

