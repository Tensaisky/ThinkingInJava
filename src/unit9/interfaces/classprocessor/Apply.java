package unit9.interfaces.classprocessor;

import java.util.Arrays;

class Processor{
    public String name(){
        return getClass().getSimpleName();
    }
    Object process(Object input){
        return input;
    }
}

class Upcase extends Processor{
    String process(Object input){
        return ((String)input).toUpperCase();
    }
}

class Downcase extends Processor{
    String process(Object input){
        return ((String)input).toLowerCase();
    }
}

class Splitter extends Processor{
    String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}

public class Apply {
    public static void process(Processor processor, Object s){
        System.out.println("Using Processor " + processor.name());
        System.out.println(processor.process(s));
        System.out.println();
    }
    public static String string =
            "Disagreement with beliefs is by definition incorrect";
    public static void main(String[] args){
        process(new Upcase(),string);
        process(new Downcase(),string);
        process(new Splitter(),string);
    }
}
