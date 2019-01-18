package unit10.innerclasses;

interface U{
    void f();
    void g();
    void h();
}

class A{
    public U getU(){
        return new U() {
            @Override
            public void f() {
                System.out.println("A.f");
            }

            @Override
            public void g() {
                System.out.println("A.g");
            }

            @Override
            public void h() {
                System.out.println("A.h");
            }
        };
    }
}

class B{
    U[] ua;
    public B(int i){
        ua = new U[i];
    }
    public boolean add(U u){
        for (int i = 0; i < ua.length; i++){
            if (ua[i] == null){
                ua[i] = u;
                return true; // 存储一个，return跳出循环
            }
        }
        return false;// 没有存储空间
    }
/*    public boolean set(){
        for (int i = 0; i < ua.length; i++){
            if (ua[i] != null){
                ua[i] = null;
            }
            else
                return true;
        }
        return false;
    }*/
    public boolean setNull(int i){
        if (i < 0 || i >= ua.length)
            return false;
        ua[i] = null;
        return true;
    }

    public void call(){
        for (int i = 0; i < ua.length; i++){
            if (ua[i] != null){
                ua[i].f();
                ua[i].g();
                ua[i].h();
            }
        }
    }
}

public class E23_UAB {
    public static void main(String[] args){
        A[] aa = { new A(), new A(), new A() };
        B b = new B(3);
        for(int i = 0; i < aa.length; i++)
            b.add(aa[i].getU());
        b.call();
        System.out.println("****");
        b.setNull(0);
        b.call();
    }
}
