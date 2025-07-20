package Geometry;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ori Arad
 */

public class Rectangle {
    private Point upperLeft;
    private Point bottomRight;
    private double width;
    private double height;

    /**
     * the constructor
     * the method creates the rectangle by the measurement and upper left point
     * and set the bottomRightPoint.
     * @param upperLeft upper left point.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.bottomRight = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
    }

    /**
     * method name intersectionPoints.
     * the method returns the list of intersection points with a line.
     * @param line the line.
     * @return list of points.
     */

    public java.util.List<Point> intersectionPoints(Line line) {
        // create an array of the rectangle's lines.
        Line[] arrLine = new Line[4];
        arrLine[0] = new Line(upperLeft, new Point(bottomRight.getX(), upperLeft.getY()));
        arrLine[1] = new Line(upperLeft, new Point(upperLeft.getX(), bottomRight.getY()));
        arrLine[2] = new Line(new Point(bottomRight.getX(), upperLeft.getY()),
                new Point(bottomRight.getX(), bottomRight.getY()));
        arrLine[3] = new Line(new Point(upperLeft.getX(), bottomRight.getY()),
                new Point(bottomRight.getX(), bottomRight.getY()));
        List<Point> arrPoint = new ArrayList<>();
        Point p;
        // check for every line in the array if it intersects with the line.
        for (Line k : arrLine) {
            p = line.intersectionWith(k);
            if (p != null) {
                // if it is, add the point
                arrPoint.add(p);
            }
        }
        return arrPoint;
    }

    /**
     * getter for height.
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * getter for upperLeft.
     * @return upperLeft
     */

    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * getter for width.
     * @return width
     */

    public double getWidth() {
        return width;
    }

    /**
     * getter for bottomRight.
     * @return bottomRight.
     */

    public Point getBottomRight() {
        return bottomRight;
    }


}
