public class Rectangle {
    private double height;
    private double width;

    double getHeight() {
        return height;
    }

    double getWidth() {
        return 0;
    }

    boolean setHeight(double newHeight) {
        if (newHeight < 0) return false;
        height = newHeight;
        return true;
    }

    void setWidth(double newWidth) {
        width = newWidth;
    }

    double area() {
        return height * width;
    }

    double perimeter() {
        return 2 * (width + height);
    }

    void doubleThis() {
        height *= 2;
        width *= 2;
    }

    void increaseNTimes(int n) {
        height *= n;
        width *= n;
    }

    public String toString() {
        return "width: " + width + ", height: " + height;
    }
}
