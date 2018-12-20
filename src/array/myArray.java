package array;
public class myArray {
    private int phyLength;
    Object [] myArray;

    myArray(){
        //实际最大长度
        phyLength = 0;
        myArray = new Object[1];
    }
    private void initLenght(int max){
        Object[] initArray = new Object[max];
        for (int i = 0; i <phyLength ; i++) {
            initArray[i] = myArray[i];
        }
        myArray = initArray;
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
        if(phyLength == myArray.length){
            initLenght(2*phyLength);
        }
        myArray[phyLength++]= data;
    }
    public Boolean remove(int index){
        if(index == phyLength-1){
            phyLength--;
        }else{
            for (int i = index; i <phyLength-1 ; i++) {
                myArray[i] = myArray[i+1];
            }
            phyLength--;
        }
        myArray[phyLength] = null;
        if(phyLength>0&&phyLength == myArray.length/2){
            initLenght(myArray.length/2);
        }
        return true;
    }
    public void set(int index,Object data){
        myArray[index] = data;
    }
    public void get(int index){
        System.out.println(myArray[index]);
    }

    public static void main(String[] args) {
        myArray myArray = new myArray();
        myArray.add(10);
        myArray.add(20);
        myArray.add(30);
        myArray.add(40);
        myArray.add(50);
        myArray.add(60);
        myArray.add(70);
        myArray.add(80);
        myArray.remove(3);
        myArray.remove(3);
        myArray.remove(3);
        myArray.remove(3);
//        myArray.set(0,60);
        myArray.disPlay();
        int size = myArray.getLength();
        System.out.println(size);
        myArray.get(1);
    }
}
