import Geometry.Point;


/**
 * @author Ori Arad.
 */
public class CollisionInfo {
    private Point point;
    private Collidable collidable;

    /**
     * the constructor.
     * @param point the collision point.
     * @param collidable the collidable.
     */
    public CollisionInfo(Point point, Collidable collidable) {
        this.point = point;
        this.collidable = collidable;
    }
    /**
     * getter for collisionPoint.
     * @return Geometry.Point
     */
    public Point collisionPoint() {
        return point;
    }
    /**
     * getter for collisionObject.
     * @return collidable
     */
    public Collidable collisionObject() {
        return collidable;
    }
}
