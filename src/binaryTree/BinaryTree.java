package binaryTree;

public class BinaryTree {
    public Node root;
    public void setRoot(Node root) {
        this.root = root;
    }

    public void frontShow() {
        if(root!=null){
            root.frontShow();
        }
    }

    public void middleShow() {
        if(root!=null){
            root.middleShow();
        }
    }

    public void afterShow() {
        if(root!=null){
            root.afterShow();
        }
    }

    public Node searchShow(int i) {
        //return root.searchShow(i);
        //return root.middleSearch(i);
        return  root.afterSearch(i);

    }

    public void frontDelete(int i) {
        if (root.data==i){
            root = null;
        }else{
            root.frontDelete(i);
        }
    }
}
