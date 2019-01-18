package Atester;

import java.util.HashMap;
import java.util.Map;

public class MapEntryTest {
    public static void main(String[] args){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
        }
    }
}
