package linked;

public class newSingleLinked {
    class Node{
        Node next;
        Object input;
        Node(Object data){
            this.input = data;
        }
        Node(Object data,Node nextVal){
            this.input = data;
            this.next = nextVal;
        }
        public Object getData(){
            return this.input;
        }
    }
    Node head;
    Node currentNode;
    int index;
    public newSingleLinked(){
        this.head = currentNode = new Node(null);
        this.index = -1;
    }
    Boolean isEmpty(){
        return this.currentNode == null;
    }
    public void appand(Object data){
        Node currentNode =  new Node(data);
        if(head.next==null){
            head.next = currentNode;
            index++;
        }else{
            Node tmp=head;
            while(tmp.next!=null){
                tmp=tmp.next;
            }
            tmp.next=currentNode;
            index++;
        }
    }
    public void remove(){
        Node tmp = head;
        int size = -1;
        int in = index-1;
        while (tmp.next!=null){
            tmp=tmp.next;
            Object input = tmp.input;
            size++;
            if(size==(in)){
                tmp.next=null;
                index--;
            }
        }
    }
    public void show(){
        Node tmp = head;
        while (tmp.next!=null){
            tmp=tmp.next;
            Integer input = (Integer) tmp.input;
            System.out.println(input);
        }
    }
    public void setNode(int num,Object data){
        Node tmp = head;
        int j=0;
        while (tmp.next!=null){
            tmp = tmp.next;
            if(j==num){
                tmp.input = data;
                break;
            }
            j++;
        }
    }
    public int size(){
        System.out.println(this.index+1);
        return this.index+1;
    }

    /**
     * 插入
     * @param num
     * @param data
     */
    public void insert(int num,Object data) {
        Node currentNode =  new Node(data);
        if (num < 0 || index<0) {
            System.out.println("error");
        }
        Node tmp = head;
        int nPre = num -1;
        int j = 0;
        if(num == 0){
            Node numNode = tmp.next;
            currentNode.next = numNode;
            tmp.next = currentNode;
            index++;
        }else{
            while (tmp.next != null) {
                tmp = tmp.next;
                Node inTmp = tmp.next;
                if(j==nPre){
                    tmp.next= currentNode;
                    currentNode.next =inTmp;
                    index++;
                    break;
                }
            }
        }
    }
    public void delete(int num){
        Node tmp = head;
        int j=0;
        while (tmp.next !=null){
           // tmp = tmp.next;
            Node nextTmp = tmp.next.next;
            if(j == num){
                if(num==0){
                    tmp.next = nextTmp;
                }else{
                    tmp= tmp.next;
                    tmp.next = nextTmp.next;
                }

                index--;
                break;
            }
            j++;
        }
    }
    public static void main(String[] args) {
        newSingleLinked newSingleLinked = new newSingleLinked();
        newSingleLinked.appand(2);
        newSingleLinked.appand(3);
        newSingleLinked.appand(5);
        newSingleLinked.appand(33);
        newSingleLinked.appand(44);
        newSingleLinked.remove();
        newSingleLinked.insert(1,10);
        newSingleLinked.insert(0,11);
        newSingleLinked.insert(1,22);
        newSingleLinked.delete(0);
        newSingleLinked.delete(1);
        newSingleLinked.setNode(3,44);
        newSingleLinked.show();
        newSingleLinked.size();
    }
}
