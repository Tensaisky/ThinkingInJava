package unit11.holding;

import java.util.ArrayList;

public class E01_Gerbil {
    int gerbilNumber;
    E01_Gerbil(int i){
        gerbilNumber = i;
    }
    public String toString(){
        return "gerbil" + gerbilNumber;
    }
    public void hop(){
        System.out.println(this + " is jumping");
    }

    public static void main(String[] args){
        ArrayList<E01_Gerbil> gerbils = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            gerbils.add(new E01_Gerbil(i));
        }
        for (int i = 0; i < gerbils.size(); i++){
            gerbils.get(i).hop();
        }
    }
}
