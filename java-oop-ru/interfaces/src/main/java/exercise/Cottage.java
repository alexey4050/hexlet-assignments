package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public java.lang.String toString() {
        return floorCount + " этажный коттедж "
                + "площадью " + area
                + " метров";
    }

    @Override
    public int compareTo(Home another) {
        double anotherArea = another.getArea();
        if (this.getArea() > anotherArea) {
            return 1;
        } else if (this.getArea() < anotherArea) {
            return -1;
        } else {
            return 0;
        }
    }
}
// END
