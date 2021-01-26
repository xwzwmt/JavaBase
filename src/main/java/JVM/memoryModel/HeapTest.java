package JVM.memoryModel;

import java.util.ArrayList;
import java.util.HashMap;

public class HeapTest {
    byte[] a=new byte[1024*100];//100kb
    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heaptests=new ArrayList<>();
        while(true){
            heaptests.add(new HeapTest());
            Thread.sleep(10);
        }
    }
}

