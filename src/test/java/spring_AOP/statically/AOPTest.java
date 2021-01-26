package spring_AOP.statically;

import org.junit.Test;

public class AOPTest {
    @Test
    public void test(){
        IGamePlayer gameplayer=new GameProxyPlayer("wmt");
        gameplayer.start();
        gameplayer.play();
    }
}
