import java.util.*;

public class LinkedList{

    public static class Node{
        int data;
        Node next;

        //constructor
        Node(){
            this.data = data;
            this.next = null;
        }

        Node(int val){
            this.data = val;
            this.next = null;
        }
    }
    
    public static class CustomLinkedList{
        Node head;
        int size;

        //constructor
        CustomLinkedList(){
            this.head = null;
            this.size = 0;
        }

        //size
        int size(){
            return this.size;
        }

        //getFirst
        int getFirst(){
            if(this.size == 0){
                System.out.println("NullPointerException LL is emplty");
                return -1;
            }else{
                return this.head.data;
            }
        }
        //getLast
        int getLast(){
            if(this.size == 0){
                System.out.println("NUllPointerException LL is empty");
                return -1;
            }else{
                Node temp = this.head;
                while(temp.next != null){
                temp = temp.next;
            }
            return temp.data;
            }
        }
        //getAt
        int getAt(int idx){
            if(idx < 0 || idx >= this.size){
                System.out.println("NullPointerExcetion indexOutOfBound");
                return -1;
            }else if(idx == 0){
                return this.getFirst();
            }else if(idx == this.size -1){
                return this.getLast();
            }else{
                Node temp = this.head;
                for(int i = 0; i < idx;i++){
                    temp = temp.next;   
                }
                return temp.data;
            }
        }

        //addFirst
        void addFirst(int val){
            Node n = new Node(val);

            if(this.size() == 0){
                this.head = n;
            }else{
                n.next = head;
                head = n;
            }
            this.size++;
        }

        //addLast
        void addLast(int val){
            Node n = new Node(val);
            if(this.size == 0){
                this.head = n;
            }else{
                Node temp = this.head;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = n;
            }
            this.size++;
        }

        //addAt
        void addAt(int idx, int val){
            Node n = new Node(val);

            if(idx < 0 || idx >= this.size){
                System.out.println("NullPointerException index outofBound");
                return;
            }else if(idx == 0){
                addFirst(val);
            }else if(idx == this.size ){
                addLast(val);
            }else{
                Node temp = this.head;
                for(int i = 0; i < idx-1; i++){
                    temp = temp.next;
                }
                n.next = temp.next;
                temp.next = n;
                this.size++;
            }
           
        }

        //removeFirst
        int removeFirst(){
            if(this.size == 0){
                System.out.println("NullPointerException");
                return -1;
            }else{
                Node temp = this.head;
                this.head = this.head.next;
                temp.next = null;
                this.size--;
                return temp.data;

            }
        }

        //removeLast
        int removeLast(){
            if(this.size == 0){
                System.out.println("NullPointerException");
                return -1;
            }else{
                Node temp = this.head;
                while(temp.next.next != null){
                    temp = temp.next;
                }
                int rval = temp.next.data;
                temp.next = null;
                this.size--;
                return rval;
                
            }

        }

        //removeAt  
        int removeAt(int idx){
            if(idx < 0 || idx >= this.size){
                System.out.println("NullPointerException");
                return -1;
            }else if(idx == 0){
                return removeFirst();
            }else if(idx == this.size-1){
                return removeLast();
            }else{
                Node temp1 = this.head;
                for(int i = 0; i < idx-1; i++){
                    temp1 = temp1.next;
                }
                Node temp2 = temp1.next;
                temp1.next = temp1.next.next;
                temp2.next = null;
                this.size--;
                return temp2.data;
            }
        }

        void display(){
            Node temp = this.head;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }


    }


    public static void main(String[] args){
        CustomLinkedList ll = new CustomLinkedList();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        System.out.println(ll.size());
        ll.addFirst(60);
        System.out.println(ll.size());
        ll.display();
        System.out.println(ll.removeLast());
        ll.display();
        System.out.println(ll.removeAt(2));
        ll.display();
        ll.addAt(3, 90);
        ll.display();
        


    }
}