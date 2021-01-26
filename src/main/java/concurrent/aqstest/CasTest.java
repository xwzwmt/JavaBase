package concurrent.aqstest;

import concurrent.uitils.UnsafeInstance;
import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
@Slf4j
public class CasTest {
    private volatile int state=0;
    private static CyclicBarrier cyclicBarrier=new CyclicBarrier(5);
    private static CasTest cas=new CasTest();

    public static void main(String[] args){
        new Thread(new Worker(),"t-0").start();
        new Thread(new Worker(),"t-1").start();
        new Thread(new Worker(),"t-2").start();
        new Thread(new Worker(),"t-3").start();
    }

    static class Worker implements Runnable{

        @Override
        public void run() {
            log.info("请求：{}到达预定点，准备开始抢state",Thread.currentThread().getName());
            try{
//                cyclicBarrier.await();
                if(cas.compareAndSwapState(0,1)){
                    log.info("当前请求{}，抢到锁",Thread.currentThread().getName());
                }else{
                    log.info("当前请求：{}，抢锁失败！",Thread.currentThread().getName());
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param oldValue 线程工作内存中的值
     * @param newValue 要替换的新值
     * @return
     */
    public final boolean compareAndSwapState(int oldValue, int newValue){
        return unsafe.compareAndSwapInt(this,stateOffset, oldValue, newValue);
    }
    private static final Unsafe unsafe= UnsafeInstance.reflectGetUnsage();
    private static final long stateOffset;
    static{
        try{
//            成员变量在内存中的地址一般可根据实例对象的地址加上该成员变量的偏移量获得。
            stateOffset=unsafe.objectFieldOffset(CasTest.class.getDeclaredField("state"));
        }catch(Exception e){
            throw new Error();
        }
    }
}
