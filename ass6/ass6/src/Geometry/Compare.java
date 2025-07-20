package Geometry;

/**
 * @author Ori Arad.
 */
public class Compare {
    private static final double DELTA = 0.00001;

    /**
     * method name: equal
     * this method check if the subtraction of two double is less than delta.
     * if it is it means that those double are equal.
     * @param x first double
     * @param y second double
     * @return boolean - true if they are false if they aren't
     */
    public static boolean equal(double x, double y) {
        return (Math.abs(x - y) < DELTA);
    }

    /**
     * method name: floatPoint.
     * the method rounds the number d multiply and divide him by 10000.
     * @param d the number.
     * @return the rounded number.
     */

    public static double floatPoint(double d) {
        final double floatPoint = 10000;
        return Math.round(d * floatPoint) / floatPoint;
    }




    }
