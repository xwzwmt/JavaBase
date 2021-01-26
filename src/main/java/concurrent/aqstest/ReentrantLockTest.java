package concurrent.aqstest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockTest {
    private static ReentrantLock lock=new ReentrantLock(true);
    public static void reentrantLock(){
        String threadName=Thread.currentThread().getName();
        lock.lock();
        log.info("Thread {} ，第一次枷锁",threadName);
        lock.lock();
        log.info("Thread {} ，第二次枷锁",threadName);
        lock.unlock();
        log.info("Thread {} ，第一次解锁",threadName);
//        lock.unlock();
//        log.info("Thread {} ，第二次解锁",threadName);
    }

    public static void main(String[] args){
        Thread t0=new Thread(new Runnable(){
            @Override
            public void run(){
                reentrantLock();
            }
        },"t0");
        t0.start();
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run(){
                reentrantLock();
            }
        },"t1");
        t1.start();
    }
}
