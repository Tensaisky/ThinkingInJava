package unit8.polymorphism;

class Meal{
    public static int print(String s){
        System.out.println(s);
        return 1;
    }
    private static int anInt = print("Meal get Print()");
    Meal(){
        System.out.println("Meal()");
    }
}

class Bread{
    Bread(){
        System.out.println("Bread()");
    }
}

class Cheese{
    Cheese(){
        System.out.println("Cheese()");
    }
}

class Lettuce{
    Lettuce(){
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal{
    Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch{
    private static int anInt = print("PortableLunch get Print()");
    PortableLunch() {
        System.out.println("PortableLunch()");
    }
}

public class Sandwich extends PortableLunch {
    private Bread bread = new Bread();
    private Cheese cheese = new Cheese();
    private Lettuce lettuce = new Lettuce();

    static int anInt = print("Sandwich Print()");

    public Sandwich(){
        System.out.println("Sandwich()");
    }
    public static void main(String[] args){
        new Sandwich();
    }
}
