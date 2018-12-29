package unit7.reusing;

class A2 {
    public A2(int i){ System.out.println("A2()"+i);}
}

class B2 {
    public B2(int i){ System.out.println("B2()"+i);}
}

class C2 extends A2{
    C2(){
        super(2);
        System.out.println("C2()");
    }
    B2 b2 = new B2(2);
}

public class E07_SimpleInheritance2 {
    public static void main(String[] args){
        new C2();
    }
}
