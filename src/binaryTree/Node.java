package binaryTree;

public class Node {
    int data;
    Node leftChild;
    Node rightChild;
    public Node(int data){
        this.data = data;
    }
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void frontShow() {
        System.out.println(this.data);
        if(this.leftChild!=null){
            leftChild.frontShow();
        }
        if(this.rightChild!=null){
            rightChild.frontShow();
        }
    }
    public void middleShow() {
        if(this.leftChild!=null){
            leftChild.middleShow();
        }
        System.out.println(this.data);
        if(this.rightChild!=null){
            rightChild.middleShow();
        }
    }
    public void afterShow(){
        if(this.leftChild!=null){
            leftChild.afterShow();
        }
        if(this.rightChild!=null){
            rightChild.afterShow();
        }
        System.out.println(this.data);
    }
    public Node searchShow(int i) {
        Node target=null;
        if(this.data==i){
            return this;
        }else{
            if(this.leftChild!=null){
                target = leftChild.searchShow(i);
            }
            if(target!=null){
                return target;
            }
            if(this.rightChild!=null){
                target = rightChild.searchShow(i);
            }
        }
        return target;
    }
    public Node middleSearch(int i){
        Node target = null;
        if(this.leftChild!=null){
            target = leftChild.middleSearch(i);
        }
        if(target!=null){
            return target;
        }
        if(this.data==i){
            return this;
        }
        if(this.rightChild!=null){
            target = rightChild.middleSearch(i);
        }
        return target;
    }
    public Node afterSearch(int i) {
        Node target = null;
        if(this.leftChild!=null){
            target = leftChild.afterSearch(i);
        }
        if(target!=null){
            return target;
        }
        if(this.rightChild!=null){
            target = rightChild.afterSearch(i);
        }
        if(this.data==i){
            return this;
        }
        return target;
    }

    public void frontDelete(int i) {
        Node  parent = this;
        if(parent.leftChild!=null&&parent.leftChild.data==i){
            parent.leftChild = null;
            return;
        }

        if(parent.rightChild!=null&&parent.rightChild!=null){
            rightChild.frontDelete(i);
        }
        parent = leftChild;
        if(parent!=null){
            parent.frontDelete(i);
        }
        parent =rightChild;
        if(parent!=null){
            parent.frontDelete(i);
        }

    }
}
