import Geometry.Point;
import Geometry.Rectangle;

/**
 * @author Ori Arad
 */
public interface Collidable {
    /**
     * method name:getCollisionRectangle.
     * @return the rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * method name: hit.
     * @param collisionPoint the point where the collision happened.
     * @param currentVelocity the velocity of the ball.
     * @param hitter the ball.
     * @return velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
