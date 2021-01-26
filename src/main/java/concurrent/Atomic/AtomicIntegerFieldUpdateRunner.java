package concurrent.Atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdateRunner  {
    static AtomicIntegerFieldUpdater aifu = AtomicIntegerFieldUpdater.newUpdater(Student.class,"old");

    public static void main(String[] args) {
        Student stu=new Student("wmt",18);
        System.out.println(aifu.getAndIncrement(stu));
        System.out.println(aifu.get(stu));
    }

    static class Student{
        private String name;
        public volatile int old;
        public Student(String name,int old){
            this.name = name;
            this.old = old;
        }
    }
}
