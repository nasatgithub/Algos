package com.nasir.DesignPatterns;

import sun.security.provider.SHA;

/**
 * Created by nasir on 1/7/17.
 */

interface Shape {
public void draw();
}

class Square implements Shape{

    @Override
    public void draw() {
         System.out.println("Drawing Square");
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class ShapeFactory {

    public Shape getShape(Shapes s) {
        if(s == Shapes.square)
            return new Square();
        else if(s == Shapes.circle)
            return new Circle();
        else
            return null;
    }
}
enum Shapes {
    square, circle;
}
public class FactoryPattern {

    public static void main(String args[]) {
              ShapeFactory sF = new ShapeFactory();
              Shape shape;
              shape = sF.getShape(Shapes.square);
              shape.draw();
              shape = sF.getShape(Shapes.circle);
              shape.draw();
    }
}
