package unit10.innerclasses;

import unit10.innerclasses.exercise6.SimpleInterface;
import unit10.innerclasses.exercise6b.SimpleClass;

public class E06_ProtectedInnerClass extends SimpleClass {
    public SimpleInterface getSimpleInterface(){
        return new Inner();
    }
    public static void main(String[] args){
        new E06_ProtectedInnerClass().getSimpleInterface().f();
    }
}
