package unit10.innerclasses;
/*
产生的class名字为：
E19_InnerInsideInner.class
E19_InnerInsideInner$Inner1.class
E19_InnerInsideInner$Inner1$Inner2.class
E19_InnerInsideInner$Nested1.class
E19_InnerInsideInner$Nested1$Nested2.class

E19_InnerInsideInner是匿名类的命名空间
 */
public class E19_InnerInsideInner {
    class Inner1{
        class Inner2{
            void f(){}
        }
        Inner2 makeInner2(){
            return new Inner2();
        }
    }

    Inner1 makeInner1(){
        return new Inner1();
    }

    static class Nested1{
        static class Nested2{
            void f(){}
        }
        void f(){}
    }

    public static void main(String[] args){
        new E19_InnerInsideInner.Nested1().f();
        new E19_InnerInsideInner.Nested1.Nested2().f();
        E19_InnerInsideInner x = new E19_InnerInsideInner();
        //E19_InnerInsideInner.Inner1 x1 = x.new Inner1();
        E19_InnerInsideInner.Inner1 x1 = x.makeInner1();
        E19_InnerInsideInner.Inner1.Inner2 x2 = x1.makeInner2();
        x2.f();
    }

}
