package unit9.interfaces.interfaceprocessor;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.Arrays;

public abstract class StringProcessor implements Processor {
    public String name(){
        return getClass().getSimpleName();
    }
    public abstract String process(Object input);
    public static String string =
            "If she weighs the same as a duck, she's made of wood";
    public static void main(String[] args){
        Apply.process(new Upcase(),string);
        Apply.process(new Downcase(),string);
        Apply.process(new Splitter(),string);
    }
}

class Upcase extends StringProcessor{
    public String process(Object input){
        return ((String)input).toUpperCase();
    }
}

class Downcase extends StringProcessor{
    public String process(Object input){
        return ((String)input).toLowerCase();
    }
}

class Splitter extends StringProcessor{
    public String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}