package Geometry;

/**
 * @author Ori Arad
 */
public class LineEquation {
    private double a;
    private double b;
    private double c;

    /**
     * the constructor.
     * by getting two points of the line this method calculates  the line equation Ax + By = C.
     * by finding the value of each parameter.
     * @param line the line that contains the two points
     */

    public LineEquation(Line line) {
        this.a = line.end().getY() - line.start().getY();
        this.b = line.start().getX() - line.end().getX();
        this.c = a * line.start().getX() + b * line.start().getY();
    }

    /**
     * constructor.
     * another way to create a line equation is by getting two points.
     *
     * @param start point start.
     * @param end   point end.
     */
    public LineEquation(Point start, Point end) {
        this.a = end.getY() - start.getY();
        this.b = start.getX() - end.getX();
        this.c = a * start.getX() + b * start.getY();
    }

    /**
     * getter for a.
     *
     * @return double - a.
     */

    public double getA() {
        return a;
    }

    /**
     * getter for b.
     *
     * @return double - b.
     */

    public double getB() {
        return b;
    }

    /**
     * getter for c.
     *
     * @return double - c.
     */

    public double getC() {
        return c;
    }

    /**
     * method denominator
     * finds the denominator of the X and Y intersection's point values.
     * @param line the other line.
     * @return double - the denominator.
     */
    public double denominator(LineEquation line) {
        return Compare.floatPoint((a * line.getB() - b * line.getA()));
    }
    /**
     * method name : is in line.
     * this method checks if a points in on the line
     * @param p the point
     * @return boolean - true if the points is on the line and false if it isn't.
     */
    public boolean isInLine(Point p) {
        //when the x value of the point in is being placed in the line equation
        // and the result is the Y value of the points,
        // it means the point is on the line
        if (b != 0) {
            return (Compare.equal(((c - a * p.getX()) / b), p.getY()));
            // it means that the line equation is 0=0 so no point could be on the line
        } else if (a == 0) {
            return false;
        } else {
            // in case that the equation is ax=c
            return Compare.equal(p.getX(), (c / a));
        }
    }

    /**
     * method name: intersection
     * the method calculates the intersection points of the two lines.
     * if there isn't it returns null
     * @param other , the other line
     * @return the intersection point if there is, else null.
     */
    public Point intersection(LineEquation other) {
        if (denominator(other) != 0) {
            double x = ((other.getB() * c) - (b * other.getC())) / denominator(other);
            x = Compare.floatPoint(x);
            double y = ((a * other.getC()) - (other.getA() * c)) / denominator(other);
            y = Compare.floatPoint(y);
            return new Point(x, y);
        }
        return null;
    }
}

