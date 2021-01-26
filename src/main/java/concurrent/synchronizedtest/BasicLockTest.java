package concurrent.synchronizedtest;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
public class BasicLockTest {
    public static void main(String[] args){
        Object o=new Object();
        log.info(ClassLayout.parseInstance(o).toPrintable());

        new Thread(()->{
            synchronized(o){
                log.info(ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();

        try{
            log.info(ClassLayout.parseInstance(o).toPrintable());
            Thread.sleep(2000);

        }catch(InterruptedException e){
            e.printStackTrace();
        }

        new Thread(()->{
            synchronized(o){
                log.info(ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();

//        try{
//            Thread.sleep(2000);
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }
//
//        new Thread(()->{
//            synchronized(o){
//                log.info(ClassLayout.parseInstance(o).toPrintable());
//            }
//        }).start();

    }
}
