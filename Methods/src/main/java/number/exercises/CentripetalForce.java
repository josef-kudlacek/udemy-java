package number.exercises;

public class CentripetalForce {
    public static void main(String[] args) {
        double radius = 0.8;
        int period = 3;

//        System.out.println("Calculate path velocity:");
//        double pathVelocity = calculatePathVelocity(radius, period);
//        System.out.println(pathVelocity);
//        System.out.println("Calculate centripetal acceleration:");
//        double centripetalAcceleration = calculateCentripetalAcceleration(pathVelocity, radius);
//        System.out.println(centripetalAcceleration);
//        System.out.println("Calculate centripetal force:");
//        System.out.println(calculateCentripetalForce(0.2, centripetalAcceleration));

        System.out.println("Calculate centripetal force:");
        System.out.println(calculateCentripetalForce(0.2, radius, period));
    }

    /**
     * This method calculates the path of velocity
     * Formula is: (2 * PI * radius) / period
     * @param radius of circumference
     * @param period of falling ball
     * @return path velocity in double
     */
    private static double calculatePathVelocity(double radius, double period) {
        double circumference = 2 * Math.PI * radius;
        return circumference / period;
    }

    /**
     * This method calculate centripetal acceleration
     * Formula is: path of velocity ^2 / radius
     * @param pathVelocity
     * @param radius of circumference
     * @return
     */
    private static double calculateCentripetalAcceleration(double pathVelocity, double radius) {
        return Math.pow(pathVelocity, 2) / radius;
    }

    /**
     * This method calculate centripetal force
     * Formula is: mass * centripetal acceleration
     * @param mass of object (ball)
     * @param centripetalAcceleration
     * @return
     */
    private static double calculateCentripetalForce(double mass, double centripetalAcceleration) {
        return mass * centripetalAcceleration;
    }

    /**
     * This method calculate centripetal force by calling methods above
     * @param mass of falling object (ball)
     * @param radius of object
     * @param period of falling
     * @return
     */
    public static double calculateCentripetalForce(double mass, double radius, double period) {
        double pathVelocity = calculatePathVelocity(radius, period);
        double centripetalAcceleration = calculateCentripetalAcceleration(pathVelocity, radius);
        double centripetalForce = calculateCentripetalForce(mass, centripetalAcceleration);
        return centripetalForce;
    }
}
