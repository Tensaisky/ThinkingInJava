package unit10.innerclasses;

interface Incrementable{
    void increment();
}
class Callee1 implements Incrementable{
    private int i = 0;
    public void increment(){
        i++;
        System.out.println(i);
    }
}

class MyIncrement{
    public void increment() {
        System.out.println("My increment");
    }
    static void f(MyIncrement mi){
        mi.increment();
    }
}

class Callee2 extends MyIncrement{
    private int i = 0;
    public void increment(){
        System.out.println("外部类");
        super.increment();
        i++;
        System.out.println(i);
    }
    private class Closure implements Incrementable{
        public void increment(){
            System.out.println("内部类");
            // Callee2.this.increment();
            i++;
            System.out.println(i);
        }
    }
    Incrementable getCallbackReference(){
        return new Closure();
    }
}

class Caller{
    private Incrementable callbackReference;
    Caller(Incrementable cbh){
        callbackReference = cbh;
    }
    void go(){
        callbackReference.increment();
    }
}

public class Callbacks {
    public static void main(String[] args){
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
