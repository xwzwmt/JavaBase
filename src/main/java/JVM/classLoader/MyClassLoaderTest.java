package JVM.classLoader;

import java.io.FileInputStream;
import java.lang.reflect.Method;

public class MyClassLoaderTest {
    static class MyClassLoader extends ClassLoader{
        private String classPath;
        public MyClassLoader(String classPath){
            this.classPath = classPath;
        }
        private byte[] loadByte(String name) throws Exception{
            name=name.replaceAll("\\.","/");
            FileInputStream fis=new FileInputStream(classPath+"/"+name
            +".class");
            int len=fis.available();
            byte[] data=new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try{
                byte[] data=loadByte(name);
                return defineClass(name,data,0,data.length);
            }catch(Exception e){
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        protected Class<?> loadClass(String name,boolean resolve) throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                    long t0 = System.nanoTime();

                    if (c == null) {
                        // If still not found, then invoke findClass in order
                        // to find the class.
                        long t1 = System.nanoTime();
                        if(!name.startsWith("spring_ioc")){
                            c=this.getParent().loadClass(name);
                        }
                        else{
                            c = findClass(name);
                        }


                        // this is the defining class loader; record the stats
                        sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                        sun.misc.PerfCounter.getFindClasses().increment();
                    }

                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader=new MyClassLoader("C:\\Users\\wmt\\Desktop");
        Class clazz=classLoader.loadClass("spring_ioc.User");
        Object obj=clazz.newInstance();
        System.out.println(obj);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }
}
