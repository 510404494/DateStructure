package tree;

public class BinaryTree {
    private Node root;

    public Node find(int key){
        Node current = root;
        while (current!=null){
            if(current.data>key){
                current = current.leftChild;
            }else if(current.data<key){
                current = current.rightChild;
            }else {
                return current;
            }
        }
        return null;
    }

    public Boolean insert(int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
        }else{
            Node current = root;
            Node parentNode = null;
            while (current !=null){
                parentNode = current;
                if(current.data >data){
                    current = current.leftChild;
                    if(current==null){
                        parentNode.leftChild = newNode;
                        return true;
                    }
                }else{
                    current = current.rightChild;
                    if (current == null){
                        parentNode.rightChild = newNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Node findMin(){
        Node current = root;
        Node minNode = current;
        while (current!=null){
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }

    public Node findMax(){
        Node current = root;
        Node maxNode = current;
        while (current!=null){
            maxNode = current;
            current = current.rightChild;
        }
        return  maxNode;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(6);
        bt.insert(14);
        bt.insert(19);
        bt.insert(1);
        bt.insert(7);
        bt.insert(5);
        Node min = bt.findMin();
        Node max = bt.findMax();
        System.out.println(min.data);
        System.out.println(max.data);
    }
}
