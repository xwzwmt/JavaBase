package spring_AOP.statically;

public class GameProxyPlayer implements IGamePlayer{
    private String name;
    private GamePlayer gamePlayer;
    public GameProxyPlayer(String name) {
        this.name = name;
        this.gamePlayer = new GamePlayer(name);
    }
    @Override
    public void start(){
        System.out.println("拿到"+name);
        gamePlayer.start();
    }
    @Override
    public void play(){
        System.out.println("we win");
    }
}
