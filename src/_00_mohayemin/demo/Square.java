package _00_mohayemin.demo;

public class Square {
    private Rectangle r = new Rectangle();

    public double getLength() {
        return r.getWidth();
    }

    public void setLength(double length) {
        r.setWidth(length);
        r.setHeight(length);
    }

    public double area() {
        return r.area();
    }

    public double perimeter(){
        return r.perimeter();
    }
}

