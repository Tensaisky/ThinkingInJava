package Atester;

import java.util.ArrayList;
import java.util.List;

public class InnerTest {
    static List<InnerInterface<? extends InnerTest>> testFactories =
            new ArrayList<>();
    static{
        testFactories.add(new Btest.InnerInterface(5));
    }

    public static void main(String[] args){
        new InnerTest();
    }

}

class Btest extends InnerTest{
    public static class InnerInterface implements Atester.InnerInterface<Btest>{
        InnerInterface(int i){}
        public Btest create(){
            return new Btest();
        }
    }
}