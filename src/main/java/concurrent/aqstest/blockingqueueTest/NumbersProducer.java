package concurrent.aqstest.blockingqueueTest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class NumbersProducer implements Runnable {
    private BlockingQueue<Integer> numbersQueue;
    private final int poisonPill;
    private final int poisonPillPerProducer;

    public NumbersProducer(BlockingQueue<Integer> numbersQueue, int poisonPill, int poisonPillPerProducer) {
        this.numbersQueue = numbersQueue;
        this.poisonPill = poisonPill;
        this.poisonPillPerProducer = poisonPillPerProducer;
    }

    @Override
    public void run() {
        try{
            generateNumber();
        }catch(Exception e){
            Thread.currentThread().interrupt();
        }
    }

    private void generateNumber() throws InterruptedException {
        for(int i=0;i<100;i++){
            numbersQueue.put(ThreadLocalRandom.current().nextInt(100));
            log.info("生产者{}，在生产生产",Thread.currentThread().getId());
        }
        for(int j=0;j<poisonPillPerProducer;j++){
            numbersQueue.put(poisonPill);
            log.info("生产者-{}，生产{}个东西",Thread.currentThread().getId(),j+1);
        }
    }
}
