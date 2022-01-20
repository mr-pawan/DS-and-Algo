import java.util.*;

public class CustomStack{

    public static class myStack{
        int[]data;
        int tos = -1;

        //constructor
        myStack(int size){
            this.data = new int[size];
        }

        //push
        void push(int val){
            if(this.tos == this.data.length-1){
                System.out.println("Stack overflow");
                return;
            }else{
                this.tos++;
                this.data[tos] = val;
                return;
            }
        }

        //pop
        int pop(){
            if(tos == -1){
                System.out.println("Stack underflow");
                return -1;
            }else{
                int val = this.data[tos--];
                return val;
            }
        }

        //size
        int size(){
            return this.data.length;
        }

        //peek
        int peek(){
            if(tos == -1){
                System.out.println("Stack underflow");
                return -1;
            }else{
                return this.data[tos];
            }
        }

        void display(){
            for(int i = this.tos; i >= 0; i--){
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }


    }

    public static void main(String[] args){
        myStack st = new myStack(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.display();
       


    }
}