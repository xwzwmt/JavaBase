package concurrent.aqstest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class LockSupportTest {
    public static void main(String[] args){
        Thread t0=new Thread(new Runnable() {
            @Override
            public void run() {
                Thread current=Thread.currentThread();
                log.info("{},开始执行！",current.getName());
                for(;;){
                    log.info("准备park住当前线程{}。。。",current.getName());
                    LockSupport.park();
                    Thread.interrupted();
                    log.info("当前线程{}已经被唤醒。。。",current.getName());
                }
            }
        },"t0");
        t0.start();
        try{
            Thread.sleep(500);
            log.info("准备唤醒{}线程",t0.getName());
            LockSupport.unpark(t0);

            //被中断过的线程不能再被park住
            t0.interrupt();

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }


}
