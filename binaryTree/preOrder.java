import java.util.*;
import java.util.LinkedList;

public class preOrder {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);


            return newNode;
        }


        public static void printPreorder(Node root){
            if(root == null){
                return;
            }

            System.out.print(root.data + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }


        public static void printInorder(Node root){
            if(root == null){
                return;
         }

            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }



        public static void printPostorder(Node root){
            if(root == null){
                return;
            }

            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.data + " ");
        }


        //level order traversal
        public static void printLevelorder(Node root){
            if(root == null) return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node top = q.remove();
                if(top == null){
                    System.out.println();
                    if(q.isEmpty()) {
                        return;
                    }else{
                        q.add(null);
                    }
                    
                }else{
                    System.out.print(top.data + " ");
                    if(top.left != null){
                        q.add(top.left);
                    }
                    if(top.right != null){
                        q.add(top.right);
                    }
                }

            }
        }
        
    }
    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};


        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.println(root.data);

        System.out.print("pre order : -----> ");

        tree.printPreorder(root);

        System.out.println();
        System.out.print("In order : -------> ");

        tree.printInorder(root);


        System.out.println();


        System.out.print("Post Order : --------> ");
        tree.printPostorder(root);
        System.out.println();


        System.out.println("Level order : ---------->");
        tree.printLevelorder(root);


        
    }
}
