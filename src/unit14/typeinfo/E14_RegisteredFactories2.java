package unit14.typeinfo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SuppressWarnings("unchecked")
class Part2{
    public String toString(){
        return getClass().getSimpleName();
    }
    static List<Class<? extends Part2>> partClasses =
            Arrays.asList(FuelFilter2.class, AirFilter2.class,CabinAirFilter2.class,
                    OilFilter2.class,FanBelt2.class,PowerSteeringBelt2.class,GeneratorBelt2.class);
    private static Random random = new Random(47);
    public static Part2 createRandom(){
        int n = random.nextInt(partClasses.size());
        Part2 part2 = null;
        try {
            part2 = partClasses.get(n).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return part2;
    }
}
class Filter2 extends Part2 {}
class FuelFilter2 extends Filter2 {}
class AirFilter2 extends Filter2 {}
class CabinAirFilter2 extends Filter2 {}
class OilFilter2 extends Filter2 {}
class Belt2 extends Part2 {}
class FanBelt2 extends Belt2 {}
class GeneratorBelt2 extends Belt2 {}
class PowerSteeringBelt2 extends Belt2 {}
public class E14_RegisteredFactories2 {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++)
            System.out.println(Part2.createRandom());
    }
}
