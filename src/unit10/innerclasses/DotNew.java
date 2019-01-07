package unit10.innerclasses;

public class DotNew {
    public class Inner{}
    public static void main(String[] args){
        DotNew dotNew = new DotNew();
        DotNew.Inner dti = dotNew.new Inner();
    }
}
