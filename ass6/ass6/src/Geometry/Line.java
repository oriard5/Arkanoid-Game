package Geometry;

import java.util.List;

/**
 * @author Ori Arad
 */
public class Line {
    // the point where the line begins.
    private Point directionStart;
    // the point where the line ends.
    //direction
    private Point directionEnd;
    // the leftest point between directionEnd and directionEnd.
    private Point start;
    // the rightest point between directionEnd and directionEnd.
    private Point end;

    /**
     * the contractor
     * this class represent a line between two points directionStart and directionEnd
     * the contractor set the end and start,so that start will be with the smallest values.
     * @param start the start point
     * @param end   the end point
     */


    public Line(Point start, Point end) {
        this.directionStart = start;
        this.directionEnd = end;
        // start x value should be smaller then end
        if (start.getX() < end.getX()) {
            this.start = start;
            this.end = end;
        } else if (start.getX() == end.getX()) {
            // start y value should be smaller then end
            if (start.getY() <= end.getY()) {
                this.start = start;
                this.end = end;
            } else {
                this.start = end;
                this.end = start;
            }
        } else {
            this.start = end;
            this.end = start;
        }
    }

    /**
     * the constructor
     * this class represent a line between two points directionStart and directionEnd
     * the contractor set the end and start,so that start will be with the smallest values.
     * @param x1 one of the x values
     * @param y1 one of the y values
     * @param x2 one of the x values
     * @param y2 one of the y values
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.directionStart = new Point(x1, y1);
        this.directionEnd = new Point(x2, y2);
        if (x1 < x2) {
            start = new Point(x1, y1);
            end = new Point(x2, y2);
        } else if (x1 == x2) {
            if (y1 <= y2) {
                start = new Point(x1, y1);
                end = new Point(x2, y2);
            } else {
                start = new Point(x1, y2);
                end = new Point(x2, y1);
            }
        } else {
            start = new Point(x2, y2);
            end = new Point(x1, y1);
        }
    }

    /**
     * method name: length.
     * the method calculates the distance between the two points of the line.
     * @return double, the length
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * getter for directionEnd. (where the line ends)
     * @return directionEnd.
     */
    public Point getDirectionEnd() {
        return directionEnd;
    }

    /**
     * getter for directionStart (where the line starts).
     * @return directionStart.
     */

    public Point getDirectionStart() {
        return directionStart;
    }

    /**
     * method name: middle.
     * the method calculates the point which is the middle between,
     * the start and end points.
     * @return the middle point.
     */

    public Point middle() {
        double x = (start.getX() + end.getX()) / 2;
        double y = (start.getY() + end.getY()) / 2;
        return new Point(x, y);
    }

    /**
     * getter for start. (the point with the smallest values).
     * @return start.
     */

    public Point start() {
        return start;
    }

    /**
     * getter for end. (the point with the smallest values).
     * @return end.
     */

    public Point end() {
        return end;
    }

    /**
     * method name: intersectionWith.
     * the method returns the intersection point between the two lines if there is.
     * if there isn't it returns null.
     * @param other the other line.
     * @return point, or null.
     */


    public Point intersectionWith(Line other) {
        LineEquation a = new LineEquation(start, end);
        LineEquation b = new LineEquation(other);
        double dom = a.denominator(b);
        // in case one of the lines is composed with the same point
        if (start.equals(end) || other.start().equals(other.end())) {
            if (start.equals(end)) {
                // check if it is on the line
                if (b.isInLine(start)) {
                    // check if it is between the other line start and end
                    if (isBetweenTwoLines(start, other)) {
                        return start;
                    }
                }
            }
            // if the other line is composed with the same point
            if (other.start().equals(other.end())) {
                if (a.isInLine(other.start())) {
                    if (isBetweenTwoLines(other.start(), other)) {
                        return other.start();
                    }
                }
            }
            //in case their all(all four points) the same point
            if (other.start().equals(start)) {
                return start;
            }
        }
        //in case the line equals
        if (equals(other)) {
            return null;
        }
        // if they are on the same line or on parallel lines
        if (dom == 0) {
            // to check if one line start point is the other line end point,
            // so they are intersecting in that point
            if (start.equals(other.end())) {
                return start;
            } else if (end.equals(other.start)) {
                return end;
                //it means that they have zero or infinity intersection points
            } else {
                return null;
            }
            // if the lines are not parallel and not the same it means that they have intersection point
        } else {
            Point intersection = a.intersection(b);
            //check if the point is in the rage of the points start and end in each line
            if (isBetweenTwoLines(intersection, other)) {
                return intersection;
                //it means the point is not in that range
            } else {
                return null;
            }
        }
    }
    /**
     * method name: isBetweenTwoLines.
     * the method check if the point is in the rage of the points start and end in each line.
     * @param intersection the point.
     * @param other        the other line.
     * @return true if it is in the rage/ false if it isn't.
     */

    public boolean isBetweenTwoLines(Point intersection, Line other) {
        // check that the point is in range in the value of X and Y
        // for each point of the lines
        return (intersection.getX() <= end.getX() && intersection.getX() >= start.getX()
                && other.start().getX() <= intersection.getX()
                && other.end().getX() >= intersection.getX()
                && intersection.getY() >= Math.min(start().getY(), end().getY())
                && intersection.getY() <= Math.max(start().getY(), end().getY())
                && intersection.getY() >= Math.min(other.start().getY(), other.end().getY())
                && intersection.getY() <= Math.max(other.start().getY(), other.end().getY()));
    }

    /**
     * method name: hasInfiniteIntersections.
     * the method checks if the two lines have infinite intersection points.
     * @param other the other line.
     * @return true if there is infinite points and false if not.
     */

    public boolean hasInfiniteIntersections(Line other) {
        // if they are the same they have infinite intersection points.
        if (equals(other)) {
            return true;
        }
        LineEquation a = new LineEquation(start, end);
        LineEquation b = new LineEquation(other);
        double dom = a.denominator(b);
        // it means that the line are not parallel or on the same line
        if (dom != 0) {
            return false;
        }
        // if they are on the same line
        if (b.isInLine(start)) {
            // the only two cases which they don't have infinite intersection points.
            if (end.getX() < other.start().getX() || start.getX() > other.end().getX()) {
                return false;
            }
            if (a.getB() == 0 && b.getB() == 0) {
                if (end.getY() < other.start().getY() || start().getY() > other.end.getY()) {
                    return false;
                }

            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * method name isIntersecting.
     * the method checks if the two line is intersecting.
     * @param other the other line.
     * @return true if they are intersecting and false if they aren't
     */

    public boolean isIntersecting(Line other) {
        // if they have infinite intersections they are intersecting
        if (hasInfiniteIntersections(other)) {
            return true;
        }
        // to check if they have only one intersection point
        return (intersectionWith(other) != null);
    }

    /**
     * method name: equals.
     * checks if the line are the same by checking if the start
     * and end points of the line are the same.
     * @param other the other line.
     * @return true if they are the same and false if not.
     */
    public boolean equals(Line other) {
        return start.equals(other.start()) && end.equals(other.end());
    }

    /**
     * method name: closestIntersectionToStartOfLine.
     * the method returns the closet point to directionStart that is on the rectangle.
     * @param rec a rectangle.
     * @return point.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rec) {
        //the list of intersection points between the line and the rectangle.
        List<Point> arrPoint = rec.intersectionPoints(new Line(directionStart, directionEnd));
        Point min = null;
        for (Point p : arrPoint) {
            if (min == null || min.distance(directionStart) > p.distance(directionStart)) {
                min = p;
            }
        }
        // return the point that it's distance from directionStart is the smallest.
        // min could be null it means that there is no
        // intersection between the rectangle and the line
        return min;
    }
}
