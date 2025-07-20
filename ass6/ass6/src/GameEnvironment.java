import Geometry.Line;
import Geometry.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ori Arad.
 */
public class GameEnvironment {
    private List<Collidable> arrColl;

    /**
     * the constructor.
     * initialize the list of Collidables;
     */
    public GameEnvironment() {
        arrColl = new ArrayList<>();
    }

    /**
     * getter for arrColl.
     *
     * @return arrColl.
     */
    public List<Collidable> getArrColl() {
        return arrColl;
    }

    /**
     * method name: addCollidable.
     * adds the collidable to arrColl
     *
     * @param c the collidable.
     */

    public void addCollidable(Collidable c) {
        /// need to check if his size and start point is okay
        arrColl.add(c);
    }

    /**
     * method name getClosestCollision.
     * the method creates a collision info of a collision.
     *
     * @param trajectory the line.
     * @return CollisionInfo.
     */

    public CollisionInfo getClosestCollision(Line trajectory) {
        Collidable closeColilidable = null;
        double minDistance = -1;
        Point collisionPoint = null;
        // if there is no collidables
        if (arrColl.size() == 0) {
            return null;
        }
        for (Collidable collidable : arrColl) {
            Point p = trajectory.closestIntersectionToStartOfLine(collidable.getCollisionRectangle());
            if (p != null) {
                double distance = trajectory.getDirectionStart().distance(p);
                // find the closet collidable to the line,
                // which the line and the collidable intersects.
                if (minDistance == -1 || minDistance > distance) {
                    minDistance = distance;
                    closeColilidable = collidable;
                    collisionPoint = p;
                }
            }
        }
        // it means there is no intersections between the line and all the collidables
        if (closeColilidable == null) {
            return null;
        } else {
            return new CollisionInfo(collisionPoint, closeColilidable);
        }

    }

    /**
     * method name: removeTheCollidable.
     *
     * @param c a Collidable.
     *          removes the collidable from the game.
     */
    public void removeTheCollidable(Collidable c) {
        arrColl.remove(c);
    }
}

