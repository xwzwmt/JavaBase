package concurrent.ThreadPoolExecutorTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

    public static void main(String args[]){
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(5,Integer.MAX_VALUE,5000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        for(int i=0;i<5;i++){
            threadPoolExecutor.submit(new Runnable(){
                @Override
                public void run() {
                    System.out.println("task : "+Thread.currentThread().getName());
                }
            },i);
        }
    }
}
