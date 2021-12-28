package pt.up.fe.ldts.example2;

abstract class Shape {
    protected double x;
    protected double y;

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void draw(GraphicFramework graphics);
};

public class Rectangle extends Shape{
    private double width;
    private double height;
    public Rectangle(double x, double y, double width, double height) {
        this.x=x;
        this.y=y;
        this.width = width;
        this.height = height;
    }

    public double getArea() {return width*height;}
    public double getPerimeter() {return width * 2 + height * 2};
    public void draw(GraphicFramework graphics) {
        graphics.drawLine(x, y, x + width, y);
        graphics.drawLine(x + width, y, x + width, y + height);
        graphics.drawLine(x + width, y + height, x, y + height);
        graphics.drawLine(x, y + height, x, y);
    }
}

public class Circle extends Shape{
    private double radius;
    public Circle(double x, double y, double radius) {
        this.x=x;
        this.y=y;
        this.radius = radius;
    }

    public double getArea() {return radius*radius*Math.PI;}
    public double getPerimeter() {return 2*Math.PI*radius};
    public void draw(GraphicFramework graphics) {
        graphics.drawCircle(x, y, radius);
    }
}
