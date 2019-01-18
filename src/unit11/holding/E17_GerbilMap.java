package unit11.holding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class E17_GerbilMap {
    public static void main(String[] args){
        Map<String,E01_Gerbil> map = new HashMap<>();
        map.put("Fuzzy", new E01_Gerbil(1));
        map.put("Spot", new E01_Gerbil(2));
        map.put("Joe", new E01_Gerbil(3));
        map.put("Ted", new E01_Gerbil(4));
        map.put("Heather", new E01_Gerbil(5));
        Iterator<Map.Entry<String, E01_Gerbil>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, E01_Gerbil> entry = iterator.next();
            System.out.println(entry.getKey() + ":");
            entry.getValue().hop();
        }
    }
}
