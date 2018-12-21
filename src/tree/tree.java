package tree;

public interface tree {
    public Node find(int key);
    public Boolean insert(int data);
    public void infixOrder(Node current);
    public void preOrder(Node current);
    public void postOrder(Node current);
    public Node findMax();
    public Node findMin();
    public  Boolean delete(int key);
}
