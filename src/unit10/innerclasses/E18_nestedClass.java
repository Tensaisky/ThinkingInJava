package unit10.innerclasses;
/*
You can refer to just the class name when inside the method of a class with a
defined nested (static inner) class, but outside the class, you must specify the
outer class and nested class, as shown in Other, above.
 */
public class E18_nestedClass {
    static class Nested{
        void f(){
            System.out.println("Nested.f()");
        }
    }
    public static void main(String[] args){
        Nested nested = new Nested();
        nested.f();
    }
}

class Other{
    void f(){
        E18_nestedClass.Nested nested = new E18_nestedClass.Nested();
    }
}
