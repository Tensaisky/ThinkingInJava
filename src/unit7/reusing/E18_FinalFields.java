package unit7.reusing;

class SelfCounter{
    private static int count;
    private int id = count++;
    public String toString(){
        return "SelfCounter " + id +" " + count;
    }
}

class WithFinalFields{
    final SelfCounter scf = new SelfCounter();
    static final SelfCounter scsf = new SelfCounter();
    public String toString(){
        return "scf = " + scf + "\nscsf = " + scsf;
    }
}

public class E18_FinalFields {
    public static void main(String[] args){
        System.out.println("First object:");
        WithFinalFields w1 = new WithFinalFields();
        System.out.println(w1);
        System.out.println("Second object:");
        WithFinalFields w2 = new WithFinalFields();
        System.out.println(w2);
        System.out.println(w1);
    }
}
