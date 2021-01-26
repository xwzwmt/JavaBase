package spring_AOP.dynamic;

public class Calculator implements ICalculator {
    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
