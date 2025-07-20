import Geometry.Compare;
import Geometry.Point;

/**
 * @author Ori Arad
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * the contractor.
     * @param dx change in x.
     * @param dy change in y.
     */
    public Velocity(double dx, double dy) {
        this.dx = Compare.floatPoint(dx);
        this.dy = Compare.floatPoint(dy);

    }

    /**
     * method name: fromAngleAndSpeed.
     * the method converted the vector angle and speed to dx and dy.
     * and then the method return a new velocity with those dx and dy.
     * @param angle the angle of the vector.
     * @param speed the speed of the vector.
     * @return velocity.
     */

    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double rad = Math.toRadians(angle - 90);
        double dx = Math.cos(rad) * speed;
        double dy = Math.sin(rad) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * method name:applyToPoint.
     * the method add dx and dy to x and y of the point and return the
     * new point with those new x and y.
     * @param p point.
     * @return the new point after the adding.
     */
    public Point applyToPoint(Point p) {
        return new Point(Compare.floatPoint(p.getX() + dx), Compare.floatPoint(p.getY() + dy));
    }
    /**
     * getter for dx.
     * @return double, dx.
     */

    public double getDx() {
        return dx;
    }

    /**
     * getter for dy.
     * @return double, dy
     */

    public double getDy() {
        return dy;
    }
}
