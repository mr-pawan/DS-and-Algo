import java.util.*;

public class  Main{

    public static class CustomQueue{
        int[]data;
        int size;
        int front;

        //constructors
        CustomQueue(){
            this.data = new int[10];
            this.size = 0;
            this.front = 0;
        }

        CustomQueue(int val){
            this.data = new int[val];
            this.size = 0;
            this.front = 0;
        }

        // size
        int size(){
            return this.size;
        }

        // add
        void add(int val){
            int rear = (front + size) % this.data.length;
            if(this.size != 0 && this.front == rear){
                System.out.println("Queue overflow");
                return;
            }else{
                this.data[rear] = val;
                size++;
                return;
            }
        }

        //remove
        int remove(){
            if(this.size == 0){
                System.out.println("Queue underflow");
                return -1;
            }else{
                int rval = this.data[front];
                this.front = (this.front + 1) % this.data.length;
                size--;
                return rval;
            }
        }

        //peek
        int peek(){
            if(this.size == 0){
                System.out.println("Queue underflow");
                return -1;
            }else{
                return this.data[front];
            }
        }
        // display
        void display(){
                for(int i = this.front; i < this.front + this.size; i++){
                int idx = i % this.data.length;
                System.out.print(this.data[idx] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args){
        CustomQueue que = new CustomQueue(5);
        que.add(10);
        que.add(20);
        que.add(30);
        System.out.println(que.size());
        System.out.println(que.peek());
        que.display();        
        que.remove();
        System.out.println(que.peek());

        que.display();
        System.out.println(que.size());
        que.remove();
        que.remove();
        que.remove();
        
    }
}