package unit9.interfaces;

/*
test1( ) needs the downcast to call f( ), while test2( ) doesn’t need a downcast
because f( ) is defined in the base class.
 */

abstract class NoMethods{}

class Extended1 extends NoMethods{
    public void f(){
        System.out.println("Extended1.f");
    }
}

abstract class WithMethods{
    abstract void f();
}

class Extended2 extends WithMethods{
    public void f(){
        System.out.println("Extended2.f");
    }
}

public class E04_AbstractBase {
    public static void test1(NoMethods nm){
        // must downcast to access f():
        // 向下转型
        ((Extended1)nm).f();
    }
    public static void test2(WithMethods wm){
        // 基类定义了 abstract f()方法，不需要向下转型调用子类方法
        wm.f();
    }
    public static void main(String[] args){
        NoMethods noMethods = new Extended1();
        test1(noMethods);
        WithMethods withMethods = new Extended2();
        test2(withMethods);
    }

}
