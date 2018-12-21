package tree;

public class Node {
    int data;
    Node leftChild;
    Node rightChild;
    Boolean isDelete;

    public Node(int data){
        this.data = data;
    }

    public void display(){
        System.out.println(data);
    }

}
