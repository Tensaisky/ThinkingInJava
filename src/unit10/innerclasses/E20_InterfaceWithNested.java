package unit10.innerclasses;

/*
Even if an interface itself has no use, a nested class defined within it can
still be useful. If we define Nested within WithNested, that just means we
locate its name there, since all elements of an interface are public.
Nested has no added access to the elements of WithNested
 */
interface WithNested{
    class Nested{
        int i;
        public Nested(int i){
            this.i = i;
        }
        void f(){
            System.out.println("Nested.f()");
        }
    }
}

class B2 implements WithNested {

}

public class E20_InterfaceWithNested {
    public static void main(String[] args){
        B2 b2 = new B2();
        B2.Nested nested2 =new B2.Nested(3);
        nested2.f();
        // 这里与B2并无关系，因为Nested是static的，
        // 创建的仍为WithNested命名空间下的Nested类，可以看class编译文件代码
        WithNested.Nested nested = new WithNested.Nested(1);
        nested.f();
    }
}
