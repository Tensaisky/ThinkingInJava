package unit10.innerclasses;

interface I{
    void f();
    void g();
    class Nested{
        static void callI(I impl){
            System.out.println("Calling I.f()");
            impl.f();
            System.out.println("Calling I.g()");
            impl.g();
        }
    }
}

public class E21_InterFaceWithNested {
    public static void main(String[] args){
        I impl = new I() {
            @Override
            public void f() {

            }

            @Override
            public void g() {

            }
        };
        I.Nested.callI(impl);
    }
}
