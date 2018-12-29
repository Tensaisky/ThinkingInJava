package unit7.reusing;

class BaseNonDefault{
    public BaseNonDefault(int i){
        System.out.println("BaseNonDefault constructor" + i);
    }
}

class DerivedTwoConstructors extends BaseNonDefault{
    public DerivedTwoConstructors(){
        super(1);
    }
    public DerivedTwoConstructors(int i){
        super(i);
    }
}

public class E08_CallBaseConstructor {
    public static void main(String[] args){
        new DerivedTwoConstructors();
        new DerivedTwoConstructors(2);
        String s = "ssa";
    }
}
