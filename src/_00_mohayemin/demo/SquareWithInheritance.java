package _00_mohayemin.demo;

public class SquareWithInheritance extends Rectangle {
    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public double area() {
        return super.area();
    }
}
