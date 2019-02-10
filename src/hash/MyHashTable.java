package hash;

import java.util.Map;

public class MyHashTable {
    private StuInfo[] data = new StuInfo[100];

    public void put(StuInfo stuInfo){
        int index = stuInfo.hashCode();
        data[index] = stuInfo;

    }
    public StuInfo get(StuInfo stuInfo){
        int index = stuInfo.hashCode();
        return data[index];
    }

}
