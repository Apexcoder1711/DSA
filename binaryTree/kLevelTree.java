public class kLevelTree {
    static class Node{
        Node left,right;
        int data;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public static void kLevel(Node root ,int level ,int K){
        if(root == null){
            return;
        }

        if(level == K){
            System.out.print(root.data + " ");
            return;
        }

        kLevel(root.left, level+1, K);
        kLevel(root.right, level+1, K);
    }
    public static void main(String args[]){
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


        kLevel(root, 1, 2);
    }
}
