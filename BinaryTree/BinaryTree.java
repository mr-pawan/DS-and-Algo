import java.util.*;

public class BinaryTree{

    public static class Node{
        int data;
        Node left = null;
        Node right = null;

        Node(){
        }

        Node(int val){
            this.data = val;
        }
    }

    static int idx = 0;
    public static Node constructTree(Integer[] arr){
        if(arr[idx] == null){
            idx++;
            return null;
        }

        Node node = new Node(arr[idx++]);
        node.left = constructTree(arr);
        node.right = constructTree(arr);
        return node;

    }

    public static void display(Node node){
        if(node == null){
            return;
        }
        String str  = "";
        str += node.left != null ? node.left.data : " .";
        str += " <- " + node.data + " -> ";
        str += node.right != null ? node.right.data : " .";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public static void main(String[] args){
        Integer[] arr = {10, 20, 40, null, null, 50, 80, null, null,null, 30, 60, null, 90, null, null, null};
       Node root =  constructTree(arr);
       display(root);
    }

}