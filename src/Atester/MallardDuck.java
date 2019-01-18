package Atester;

public class MallardDuck extends Duck {
    MallardDuck(){
       super(new FlyWithWings(),new FlyWithWings2());
    }

    @Override
    public void performFly() {
        super.performFly();
    }

    @Override
    public void performFly2() {
        super.performFly2();
    }
    public static void main(String[] args){
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performFly2();
    }
}
