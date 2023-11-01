package number.exercises;

public class AreaOfCircle {
    public static void main(String[] args) {
        System.out.println("Area of circle");
        System.out.println("radius = 2.1 cm");
        System.out.println("area = " + calculateAreaOfCircle(2.1) + " cm");
    }

    /**
     * This method calculates the area of a circle
     * It uses the formula: area = PI * radius^2
     * @param radius of circle
     * @return area of circle
     */
    public static double calculateAreaOfCircle(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }
}
