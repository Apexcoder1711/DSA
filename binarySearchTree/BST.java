import java.util.ArrayList;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val); // root.left pointer ki trh work krega
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }

    }

    public static Node delete(Node root, int val) {
        if (root == null) {
            return null;
        } else {
            if (root.data > val) {
                // in left subtree
                root.left = delete(root.left, val);
            } else if (root.data < val) {
                // in right subtree
                root.right = delete(root.right, val);
            } else {// voila case when root.data == val
                    // CASE 1 :- delete 0 child
                if (root.left == null && root.right == null) {
                    return null;
                }

                // case 2 :- delete 1 child
                if (root.left == null) {
                    return root.right;
                }

                if (root.right == null) {
                    return root.left;
                }

                // CAse 3 :- deleting 2 child
                Node IS = findInorderSuccessor(root.right);// left most node in right subtree
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {// left most node in right subtree
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        // Base Case
        if (root == null) {
            return;
        }

        // Case 1: Agar root ka data k1 aur k2 ke beech (range mein) hai
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2); // Left check karo
            System.out.print(root.data + " "); // Root print karo
            printInRange(root.right, k1, k2); // Right check karo
        }
        // Case 2: Agar data k1 se chhota hai, toh sirf bade elements (Right) check karo
        else if (root.data < k1) {
            printInRange(root.right, k1, k2); // <--- Yahan right aayega
        }
        // Case 3: Agar data k2 se bada hai, toh sirf chhote elements (Left) check karo
        else {
            printInRange(root.left, k1, k2); // <--- Yahan left aayega
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0 ; i<path.size() ; i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    public static void printRoot2Leaf(Node root , ArrayList<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }

        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }


    //Valid BST
    public static boolean isValidate(Node root , Node min , Node max){
        if(root == null) return true;

        if(min != null && root.data <= min.data){
            return false;
        }

        if(max != null && root.data >= max.data){
            return false;
        }

        return isValidate(root.left, min, root) && isValidate(root.right, root, max); 
        
    }


    //mirror a BST
    public static Node mirrorBST(Node root){
        if(root == null) return null;

        Node leftMirror = mirrorBST(root.left);
        Node rightMirror = mirrorBST(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }
    public static void main(String[] args) {
        int values[] = { 8, 8, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inOrder(root);
        System.out.println();

        System.out.println(search(root, 9));
        System.out.println(search(root, 1));

        System.out.println();

        inOrder(root);
        root = delete(root, 14);
        System.out.println();
        inOrder(root);
        root = delete(root, 8);
        System.out.println();
        inOrder(root);


        System.out.println();

        printInRange(root, 5, 14);

        System.out.println();


        printRoot2Leaf(root,new ArrayList<>());

        System.out.println();

        System.out.println(isValidate(root, null, null));

        System.out.println();

        mirrorBST(root);
        inOrder(root);
    }
}
