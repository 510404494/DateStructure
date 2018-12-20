package queue;

public class queue {
    private int front;
    private int rear;
    private int num;
    Object [] queArray;
    private int maxSize;
    public queue(int size){
        maxSize = size;
        queArray = new Object[size];
        front = 0;
        rear = -1;
        num = 0;
    }

    public void insert(Object data){
        if(rear == queArray.length){
            rear = -1;
        }
        queArray[++rear] = data;
        num++;
    }
    public void remove(){
        queArray[front] = null;
        front++;
        num--;
    }
    public void display(){
        for (int i = front; i <num+1 ; i++) {
            System.out.println(queArray[i]);
        }
    }
    public static void main(String[] args) {
        queue queue = new queue(10);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        queue.remove();
        queue.display();
    }
}
