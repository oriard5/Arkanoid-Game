package Geometry;

/**
 * @author Ori Arad.
 */
public class Point {
    private double x;
    private double y;

    /**
     * the constructor.
     * this class represents a point. the member of this class is the value
     * of x and y of the point.
     * @param x the x value of the point.
     * @param y the y value of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * method name: distance
     * the function calculate the distance between two points and returns that value.
     * @param other (point)
     * @return double
     */
    public double distance(Point other) {
        return Math.sqrt((Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2)));
    }

    /**
     * method name: equals
     * this method check by the class Geometry.Compare if this point is the same as the other.
     * @param other (point)
     * @return boolean - true if they are the same or false if they aren't
     */
    public boolean equals(Point other) {
        return (Compare.equal(other.getX(), getX()) && Compare.equal(other.getY(), getY()));
    }

    /**
     * method name: getX.
     * returns x.
     * @return double.
     */

    public double getX() {
        return x;
    }
    /**
     * method name: getY.
     * returns y.
     * @return double.
     */
    public double getY() {
        return y;
    }
}

