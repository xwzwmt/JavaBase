package concurrent.aqstest.cyclebarriertest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierRunner implements Runnable {
private CyclicBarrier cyclicBarrier;
private int index;

public CyclicBarrierRunner(CyclicBarrier cyclicBarrier,int index){
    this.cyclicBarrier = cyclicBarrier;
    this.index = index;
}
    @Override
    public void run() {
    try{
        System.out.println("index: "+index);
        index--;
        cyclicBarrier.await();
    }catch(Exception e){
        e.printStackTrace();
    }
    }
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
    CyclicBarrier cyclicBarrier=new CyclicBarrier(11,new Runnable(){
        @Override
        public void run(){
            System.out.println("所有特工到达屏障，准备开始执行任务");
        }
    });
    for(int i=0;i<10;i++){
        new Thread(new CyclicBarrierRunner(cyclicBarrier,i)).start();
    }
    cyclicBarrier.await();
        System.out.println("全部到达屏障");
    }
}
