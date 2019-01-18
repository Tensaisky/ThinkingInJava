package unit14.typeinfo;
interface Interface1{
    void doSomething();
    void somethingElse(String arg);
}

class RealObject1 implements Interface1{
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy1 implements Interface1{
    private Interface1 proxied;
    private int ido;
    private int iSomeElse;
    public SimpleProxy1(Interface1 proxied){
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        ido++;
        System.out.println("SimpleProxy doSomething: " + ido);
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        iSomeElse++;
        System.out.println("SimpleProxy somethingElse " + arg + ": " + iSomeElse);
        proxied.somethingElse(arg);
    }
}
public class E21_SimpleProxyDemo {
    public static void consumer(Interface1 iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args){
        consumer(new RealObject1());
        System.out.println("---------------");
        consumer(new SimpleProxy1(new RealObject1()));
    }
}
