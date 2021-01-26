package concurrent.synchronizedtest;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class ObjectSizeTest {
    public static void main(String[] args) throws Exception {
//        TimeUnit.SECONDS.sleep(5);
        Object o=new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized(o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
