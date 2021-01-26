package JVM.classLoader;

public class TestClassLoader {
    public static void main(String[] args){
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.AESKeyGenerator.class.getClassLoader());
        System.out.println(TestClassLoader.class.getClassLoader());

        ClassLoader appClassLoader=ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader=appClassLoader.getParent();
        ClassLoader bootstrapLoader=extClassLoader.getParent();

        System.out.println("bootstraploader "+bootstrapLoader);
        System.out.println("extClassLoader "+extClassLoader);
        System.out.println("appClassLoader "+appClassLoader);
    }
}
