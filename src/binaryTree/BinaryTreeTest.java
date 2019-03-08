package binaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1);
        binaryTree.setRoot(root);
        Node leftRoot = new Node(2);
        Node rightRoot = new Node(3);
        root.setLeftChild(leftRoot);
        root.setRightChild(rightRoot);
        leftRoot.setLeftChild(new Node(4));
        leftRoot.setRightChild(new Node(5));
        rightRoot.setLeftChild(new Node(6));
        rightRoot.setRightChild(new Node(7));


        //三种遍历
        binaryTree.frontShow();
        System.out.println("================");
        binaryTree.middleShow();
        System.out.println("================");
        binaryTree.afterShow();
        System.out.println("================");
        //查找
        Node result = binaryTree.searchShow(2);
        System.out.println(result);
        System.out.println("================");
        binaryTree.frontDelete(2);
        binaryTree.frontShow();


    }
}
