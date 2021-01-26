package concurrent.aqstest.SemphoreTest;

import javafx.concurrent.Task;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemphoreTest {
    public static void main(String[] args){
        Semaphore semphore=new Semaphore(2);
        for(int i=0;i<5;i++){
            new Thread(new Task(semphore,"wmt"+i)).start();
        }
    }

    static class Task extends Thread{
        Semaphore semaphore;
        public Task(Semaphore semaphore,String tname){
            this.semaphore=semaphore;
            this.setName(tname);
        }
        public void run(){
            try{
//                acquire演示

//                semaphore.acquire(2);
//                System.out.println(Thread.currentThread().getName()+":aquire() at time:"
//                +System.currentTimeMillis());
//                Thread.sleep(2000);
//                semaphore.release(2);

//                能够设置等待时间，设置服务降级的

                if(semaphore.tryAcquire(100, TimeUnit.MILLISECONDS)){
                    System.out.println(Thread.currentThread().getName() + ":aquire() at time"
                    +System.currentTimeMillis());
                    Thread.sleep(200);
                    semaphore.release();
                }else{
                    System.out.println("服务降级");
                }

            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
