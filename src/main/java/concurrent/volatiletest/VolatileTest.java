package concurrent.volatiletest;
import lombok.extern.slf4j.Slf4j;

/**
 * volatile解决可见性
 * 1、当while(!initFlag)为空循环时，不会出现initFlag的状态改变。空循环优先级高
 * 2、当while不为空循环时，几次过后会出现initFlag的状态改变
 * 3、当counter为integer或者volatile时，会出现initFlag的状态改变.因为他们可能在同一个缓存行
 */
@Slf4j
public class VolatileTest {
    private volatile static boolean initFlag = false;
//    private static Integer counter = 0;
//     private volatile static int counter = 0;
private static int counter = 0;
    public static void refresh(){
        log.info("refresh data...");
        initFlag=true;
        log.info("refresh data success");
    }
    public static void main(String[] args){
        Thread threadA=new Thread(()->{
            while(!initFlag){
                //及时性
//                counter++;
                System.out.println("running");
            }
            log.info("线程："+Thread.currentThread().getName()+"当前线程嗅探到" +
                    "initFlag的状态改变");
        },"ThreadA");
        threadA.start();

        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        Thread threadB=new Thread(()->{
            refresh();
        },"ThreadB");
        threadB.start();
    }
}
