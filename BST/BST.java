import java.util.*;

public class BST{

    public static class Node{
        int data;
        Node left;
        Node right;

        Node()gi{
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        Node(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }

        Node(int val, Node left,  Node right){
            this.data = val;
            this.left = left;
            this.right = right;
        }


    }

    public static void display(Node node){
        if(node == null){
            return;
        }

        String str = "";
        str += node.left != null ? node.left.data: ". ";
        str += "<- " +  node.data + " -> ";
        str += node.right != null ? node.right.data: ".";
        System.out.println(str);

        display(node.left);
        display(node.right); 
        
    }

    public static Node constructTree(int[]arr,int lo, int hi){
        //base case
        if(lo > hi){
            return null;
        }

        if(lo == hi){
            Node base = new Node(arr[lo]);
            return base;
        }

        //recurssive case
        int mid = (lo + hi) / 2;
        Node node = new Node(arr[mid]);
        node.left = constructTree(arr, lo, mid-1);
        node.right = constructTree(arr, mid+1, hi);

        return node;
    }
    public static void main(String[] args){
        int[]arr = {10, 12, 32, 44, 51, 63, 70, 77};

        Node root = constructTree(arr, 0, arr.length -1);
        display(root);
    }
}