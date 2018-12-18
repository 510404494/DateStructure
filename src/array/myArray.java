package array;
public class myArray {
    private int length;
    private int phyLength;
    Object [] myArray;

    myArray(){
        length = 0;
        //实际最大长度
        phyLength = 30;
        myArray = new Object[length];
    }
    myArray(int length){
        phyLength = 0;
        this.length = length;
        myArray = new Object[length];
    }
    public int getLength(){
        return this.phyLength;
    }
    public void disPlay(){
        for (int i = 0; i <phyLength ; i++) {
            System.out.println(myArray[i]);
        }
    }
    public void add(Object data){
        myArray[phyLength]= data;
        phyLength++;
    }
    public Boolean remove(int index){
        if(index == phyLength-1){
            phyLength--;
        }else{
            for (int i = index; i <phyLength-1 ; i++) {
                myArray[i] = myArray[i+1];
                break;
            }
            phyLength--;
        }
        myArray[phyLength] = null;
        return true;
    }
    public void set(int index,Object data){
        myArray[index] = data;
    }
    public void get(int index){
        System.out.println(myArray[index]);
    }

    public static void main(String[] args) {
        myArray myArray = new myArray(6);
        myArray.add(10);
        myArray.add(20);
        myArray.add(30);
        myArray.add(40);
        myArray.add(50);
        myArray.remove(3);
        myArray.set(0,60);
        myArray.disPlay();
        int size = myArray.getLength();
        System.out.println(size);
        myArray.get(1);
    }
}
