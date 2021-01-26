package concurrent.volatiletest;

import concurrent.uitils.UnsafeInstance;
import lombok.extern.slf4j.Slf4j;

/**
 * 验证指令优化
 */
@Slf4j
public class CodeRecorder {
    private static int x=0,y=0;
    private static int a=0,b=0;
    public static void main(String[] args) throws InterruptedException {
        int i=0;
        for(;;){
            i++;
            x=0;y=0;
            a=0;b=0;
            Thread t1=new Thread(new Runnable(){
                public void run(){
                    shortWait(1000);
                    a=1;
                    //手动加内存屏障 a=1,x=0,b=1,y=1
                    //b=1,y=0,a=1,y=1
                    UnsafeInstance.reflectGetUnsage().fullFence();
                    x=b;
                }
            });
            Thread t2=new Thread(new Runnable(){
                public void run(){
                    b=1;
                    //手动加内存屏障
//                    UnsafeInstance.reflectGetUnsage().fullFence();
                    y=a;
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();

            String Result ="第"+i+"次（"+x+","+y+")";
            if(x==0 && y==0){
                System.out.println(Result);
            }else{
                log.info(Result);
            }

        }
    }
    public static void shortWait(int interval){
        long start=System.currentTimeMillis();
        long end;
        do{
            end=System.currentTimeMillis();
        }while(start+interval>=end);
    }
}
