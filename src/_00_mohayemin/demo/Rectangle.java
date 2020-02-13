package _00_mohayemin.demo;

public class Rectangle {
    private double height, width;
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double area() {
        //
        //
        return height * width;
    }

    public double perimeter(){
        return 2 * (height + width);
    }
}

