package hash;

public class TestHashTable {
    public static void main(String[] args) {
        StuInfo s1 = new StuInfo(16,11);
        StuInfo s2 = new StuInfo(17,23);
        StuInfo s3 = new StuInfo(18,24);
        StuInfo s4 = new StuInfo(19,3);
        StuInfo s5 = new StuInfo(20,9);

        MyHashTable ht = new MyHashTable();
        ht.put(s1);
        ht.put(s2);
        ht.put(s3);
        ht.put(s4);
        ht.put(s5);
        StuInfo target = new StuInfo(18);
        StuInfo info = ht.get(target);
        System.out.println(info);

    }
}
