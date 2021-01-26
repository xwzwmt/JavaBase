package concurrent.aqstest.blockingqueueTest;

public class Main {
    public static void main(String[] args){
        int BOUND=10;
        int N_PRODUCERS=16;
        int N_CONSUMERS=Runtime.getRuntime().availableProcessors();
        int poisonPill=Integer.MAX_VALUE;
        int poisonPillPerProducer=N_CONSUMERS/N_PRODUCERS;
        int mod=N_CONSUMERS%N_PRODUCERS;
    }
}
