package concurrent.volatiletest;

/**
 * 演示原子性
 * volatile解决不了原子性，必须要sychronized
 */
public class AtomicTest {
    private volatile static int counter=0;
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            Thread thread=new Thread(()->{
                for(int j=0;j<1000;j++){
                    counter++;
                }
            });
            thread.start();
        }
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}
