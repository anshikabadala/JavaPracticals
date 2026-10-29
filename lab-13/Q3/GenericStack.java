import java.util.Arrays;
import java.util.EmptyStackException;

class Stack<T>{
    private Object[] data;
    private int top;

    Stack(int capacity){
        if(capacity<=0){
            throw new IllegalArgumentException("Capacity must be positive");
        }
        data=new Object[capacity];
        top=-1;
    }

    public void push(T value){
        if(top==data.length-1){
            data=Arrays.copyOf(data,data.length*2);
        }
        data[++top]=value;
    }

    @SuppressWarnings("unchecked")
    public T pop(){
        if(top==-1){
            throw new EmptyStackException();
        }
        T value=(T)data[top];
        data[top--]=null;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        if(top==-1){
            throw new EmptyStackException();
        }
        return (T)data[top];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public int size(){
        return top+1;
    }
}

public class GenericStack{
    public static void main(String[] args){
        Stack<Integer> s1=new Stack<>(2);
        s1.push(10);
        s1.push(20);
        s1.push(30);

        System.out.println("Integer Stack Top: "+s1.peek());
        System.out.println("Popped: "+s1.pop());
        System.out.println("Stack Size: "+s1.size());

        Stack<String> s2=new Stack<>(2);
        s2.push("Java");
        s2.push("Python");

        System.out.println("String Stack Top: "+s2.peek());
        System.out.println("Popped: "+s2.pop());
        System.out.println("Is Empty: "+s2.isEmpty());

        try{
            while(!s2.isEmpty()){
                s2.pop();
            }
            s2.pop();
        }catch(EmptyStackException e){
            System.out.println("Stack is empty");
        }
    }
}