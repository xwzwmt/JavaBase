package concurrent.Atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicReferenceFieldUpdaterRunner {
    static AtomicReferenceFieldUpdater atomic=AtomicReferenceFieldUpdater.newUpdater(Student.class,String.class,
            "name");

    public static void main(String[] args){
        Student student = new Student("wmt",1);
        System.out.println(atomic.get(student));
        atomic.getAndSet(student,"tyj");
        System.out.println(atomic.get(student));

    }

    public static class Student{
        public volatile String name;
        public volatile int old;
        public Student(String name,int old){
            this.name = name;
            this.old = old;
        }
    }
}
