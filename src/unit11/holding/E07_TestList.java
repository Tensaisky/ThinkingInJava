package unit11.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
The methods asList( ) and subList( ) return immutable Lists because they are
“backed” by the underlying array and list, respectively. If you structurally modify
the backing list as we did in the commented-out section, you get a concurrent
modification exception. Therefore, the program operates on the sublist instead
of the backing list. Alternatively, avoid errors by creating a separate copy of the
returned sublist and use that as an argument to removeAll( )
 */
class IDClass{
    private static int counter;
    private int count = counter++;
    public String toString(){
        return "IDClass " + count;
    }
}

public class E07_TestList {
    public static void main(String[] args){
        IDClass[] idc = new IDClass[10];
        for(int i = 0; i < idc.length; i++){
            idc[i] = new IDClass();
        }
        List<IDClass> lst = new ArrayList<>(Arrays.asList(idc));
        System.out.println("lst = " + lst);
        List<IDClass> subSet = lst.subList(lst.size()/4,lst.size()/2);
        System.out.println("subSet = " + subSet);
        System.out.println("lst = " + lst);
//        lst.removeAll(subSet);
//        System.out.println("lst = " + lst);
//        System.out.println("subSet = " + subSet);
        subSet.clear();
        System.out.println("lst = " + lst);
        System.out.println("subSet = " + subSet);
    }
}
