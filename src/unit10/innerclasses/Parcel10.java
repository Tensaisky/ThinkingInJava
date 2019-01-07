package unit10.innerclasses;


public class Parcel10 {
    public Destination destiantion(final String test, final float price){
        return new Destination(){
            private int cost;
            {
                cost = Math.round(price);
                if (cost > 100){
                    System.out.println("Over budget!");
                }
            }
            private String label = test;
            public String readLabel(){
                return label;
            }
        };
    }

    public static void main(String[] args){
        Parcel10 parcel10 = new Parcel10();
        Destination destiantion = parcel10.destiantion("Tas", 101.395F);
    }
}
