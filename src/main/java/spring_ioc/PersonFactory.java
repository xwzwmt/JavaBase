package spring_ioc;

public class PersonFactory {
    public Person createPersonFactoryMethod(){
        Child child=new Child();
        child.setId(886);
        return child;
    }
}
