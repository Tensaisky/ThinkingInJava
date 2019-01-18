package unit14.typeinfo;

import java.util.Arrays;
import java.util.List;

class Rhomboid extends Shape{
    @Override
    public String toString() {
        return "Rhomboid";
    }
}

public class E03_Rhomboid {
    public static void main(String[] args){
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle(), new Rhomboid());
        for (Shape shape : shapeList){
            shape.draw();
        }
        Shape shape = new Rhomboid();
        if (shape instanceof Rhomboid){
            Rhomboid rhomboid = (Rhomboid)shape;
            rhomboid.draw();
        }
        else {
            System.out.println("shape not a Rhomboid");
        }
    }
}
