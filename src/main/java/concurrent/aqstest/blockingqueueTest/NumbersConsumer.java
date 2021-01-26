package concurrent.aqstest.blockingqueueTest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

@Slf4j
public class NumbersConsumer implements Runnable{
    private BlockingQueue<Integer> queue;
    private final int poisonPill;

    public NumbersConsumer(BlockingQueue<Integer> queue,int poisonPill){
        this.queue = queue;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run() {
        try{
            while(true){
                Integer number =queue.take();
                if(number.equals(poisonPill)){
                    return;
                }
                log.info("消费者-{}号，在消费编号：{}",
                        Thread.currentThread().getId(),number);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
