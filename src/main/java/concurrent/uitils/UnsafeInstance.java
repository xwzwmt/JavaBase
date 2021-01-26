package concurrent.uitils;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeInstance {
    public static Unsafe reflectGetUnsage(){
        try {
            Field field=Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}