package Atester;

public class Duck {
    private FlyBehavior flyBehavior;
    private FlyBehavior2 flyBehavior2;
    Duck(){

    }
    Duck(FlyBehavior flyBehavior , FlyBehavior2 flyBehavior2){
        this.flyBehavior = flyBehavior;
        this.flyBehavior2 = flyBehavior2;
    }

    public void performFly(){
        flyBehavior.fly();
    }
    public void performFly2(){
        flyBehavior2.fly2();
    }
}
