package unit9.interfaces.interfaceprocessor;

public class Apply {
    public static void process(Processor processor, Object s){
        System.out.println("Using Processor " + processor.name());
        System.out.println(processor.process(s));
    }
}
