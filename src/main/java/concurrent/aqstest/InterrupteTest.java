package concurrent.aqstest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InterrupteTest extends Thread {
    public void run() {
        while(true){
            if(Thread.currentThread().isInterrupted()){
//                System.out.println("some one interrupted me");
            }
            else{
//                System.out.println("Thread is Going");
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        InterrupteTest t=new InterrupteTest();
        t.start();
        Thread.sleep(300);
        t.interrupt();
        Thread.sleep(300);
        log.info("t.interrupted(){}，{}",t.interrupted(),t.interrupted());

        Thread.sleep(300);
        System.out.println("====");

    }
}
