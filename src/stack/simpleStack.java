package stack;

import java.util.Random;

public class simpleStack {
    private int top;
    private int size;
    private Object[] array;
    private Object[] arrays;
    simpleStack(int size){
        this.size = size;
        array = new Object[size];
        top = -1;
    }
    public void initSimpleStack(int max){
        arrays = array;
        array = new Object[max];
        for (int i = 0; i <arrays.length ; i++) {
            array[i] = arrays[i];
        }
        size++;
    }
    public void push(Object data){
        if(top+1==size){
            initSimpleStack(size+1);
        }
        if(top < size-1){
            array[++top] = data;
        }
    }
    public Object pop(){
        return array[top--];
    }
    public Object peck(){
        return array[top];
    }
    public boolean isEmpty(){
        return (top == -1);
    }

    public static void main(String[] args) {
        simpleStack simpleStack = new simpleStack(10);
        Random random = new Random();
        for (int i = 0; i <15 ; i++) {
            simpleStack.push(random.nextInt(1000));
        }
        System.out.println(simpleStack.peck());
        while(!simpleStack.isEmpty()){
            System.out.println(simpleStack.pop());
        }
    }
}
