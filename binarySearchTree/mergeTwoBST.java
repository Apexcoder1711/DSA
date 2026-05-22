
import java.util.*;


public class mergeTwoBST {
    static class Node{
        Node left;
        Node right;
        int data;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void getInOrder(Node root , ArrayList<Integer> arr){
        if(root == null) return ;

        getInOrder(root.left, arr);
        arr.add(root.data);
        getInOrder(root.right, arr);
    }


    public static Node generateBST(ArrayList<Integer> arr , int st , int end){
        if(st > end) return null;

        int mid = (st+end)/2;
        Node root = new Node(arr.get(mid));
        root.left = generateBST(arr , st , mid-1);
        root.right = generateBST(arr, mid+1 , end);

        return root;
    }

    public static Node mergeBST(Node root1, Node root2){
        //get inOrder of BST1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInOrder(root1 ,arr1);

        //get inOrder of BST2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInOrder(root2 , arr2);

        //merge two BST array
        ArrayList<Integer> finalList = new ArrayList<>();
        int i= 0 ;
        int j=0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalList.add(arr1.get(i));
                i++;
            }else{
                finalList.add(arr2.get(j));
                j++;
            }
        }

        while(i<arr1.size()){
            finalList.add(arr1.get(i));
            i++;
        }

        while(j<arr2.size()){
            finalList.add(arr2.get(j));
            j++;
        }

    


        //now two arrayList are sorted
        //sorted array to BST
        return generateBST(finalList , 0 , finalList.size()-1);
    }


    public static void inOrder(Node root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
    /*
     * Tree 1:
     *      2
     *    /   \
     *   1     4
     */
    Node root1 = new Node(2);
    root1.left = new Node(1);
    root1.right = new Node(4);

    /*
     * Tree 2:
     *      9
     *    /   \
     *   3     12
     */
    Node root2 = new Node(9);
    root2.left = new Node(3);
    root2.right = new Node(12);

    // Merging logic
    Node root = mergeBST(root1 , root2);
    
    // Print the sorted elements
    inOrder(root);
}
}
