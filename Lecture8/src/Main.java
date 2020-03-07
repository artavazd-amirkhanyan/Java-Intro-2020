import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle();
        boolean succeed = rectangle1.setHeight(10);
        if (!succeed) {
            rectangle1.setHeight(213);
        }

        double width = rectangle1.getWidth();

        System.out.println(rectangle1);
        rectangle1.increaseNTimes(2);
        System.out.println(rectangle1);
        rectangle1.increaseNTimes(3);
        System.out.println(rectangle1);

        rectangle1.setHeight(7);
        rectangle1.height = 8;
        System.out.println(rectangle1);
    }
}