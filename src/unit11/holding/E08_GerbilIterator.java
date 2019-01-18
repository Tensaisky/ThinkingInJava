package unit11.holding;

import java.util.ArrayList;
import java.util.Iterator;

public class E08_GerbilIterator {
    public static void main(String[] args){
        ArrayList<E01_Gerbil> gerbils = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++){
            gerbils.add(new E01_Gerbil(i));
        }
        Iterator<E01_Gerbil> iterator = gerbils.iterator();
        while (iterator.hasNext()){
            E01_Gerbil gerbil = iterator.next();
            gerbil.hop();
        }
    }
}
