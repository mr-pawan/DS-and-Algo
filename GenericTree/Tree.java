import java.util.*;

public class Tree{

    public static class Node{
        int data;
        ArrayList<Node> children;

        Node(int val){
            this.data = val;
            children = new ArrayList<>();
        }
    }

    public static Node generateTree(int[] arr){
        Node root = null;

        Stack<Node>st = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                Node node = new Node(arr[i]);
                
                if(st.size() !=0){
                    st.peek().children.add(node);
                }else{
                    root = node;
                }
                st.push(node);
            } 
        }
        return root;

    }

    public static void display(Node node){

        System.out.print(node.data + " -> ") ;
        for(int i = 0; i < node.children.size(); i++){
            System.out.print(node.children.get(i).data + " ");
        }
            System.out.println();

        for(int i = 0; i < node.children.size(); i++){
            display(node.children.get(i));
        }
    }

    public static void main(String[] args){
        int[] arr = {10, 20, -1, 30, 50, -1, 60, -1, 70, -1, -1, 40, 60 };
        Node root = generateTree(arr);
        display(root);
    }
}