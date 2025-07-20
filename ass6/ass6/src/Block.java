import Geometry.Compare;
import Geometry.Point;
import Geometry.Rectangle;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ori Arad
 */

public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private java.awt.Color color;

    private List<HitListener> hitListener = new ArrayList<>();

    /**
     * the constructor.
     * create a rectangle.
     *
     * @param x     x value of the upper left point.
     * @param y     y value of the upper left point.
     * @param w     the width of the rectangle.
     * @param h     the height of the rectangle.
     * @param color the color of the block.
     */

    public Block(double x, double y, double w, double h, Color color) {
        rectangle = new Rectangle(new Point(x, y), w, h);
        this.color = color;
    }

    /**
     * another constructor.
     *
     * @param rectangle rectangle.
     * @param color     the color of the block.
     */

    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
    }

    /**
     * getter for rectangle.
     *
     * @return rectangle.
     */

    public Rectangle getCollisionRectangle() {
        return rectangle;

    }

    /**
     * method name: hit
     * the method changes the value of the ball velocity,
     * depending on where the ball hit the block.
     *
     * @param collisionPoint  the point where the collision happened.
     * @param currentVelocity the velocity of the ball.
     * @param hitter          the ball.
     * @return velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        // if the ball comes from above or bellow the block.
        if (Compare.equal(collisionPoint.getX(), rectangle.getUpperLeft().getX())
                || Compare.equal(collisionPoint.getX(), rectangle.getBottomRight().getX())) {
            dx = dx * -1;
        }
        // if the ball comes from the right or the left of the block.
        if (Compare.equal(collisionPoint.getY(), rectangle.getUpperLeft().getY())
                || Compare.equal(collisionPoint.getY(), rectangle.getBottomRight().getY())) {
            dy = dy * -1;
        }
        this.notifyHit(hitter);
        return new Velocity(dx, dy);


    }

    /**
     * method name: drawOn.
     * draws the block.
     *
     * @param surface drawSurface.
     */

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillRectangle((int) Math.round(rectangle.getUpperLeft().getX()),
                (int) Math.round(rectangle.getUpperLeft().getY()),
                (int) Math.round(rectangle.getWidth()),
                (int) Math.round(rectangle.getHeight()));
        surface.setColor(Color.black);
        surface.drawRectangle((int) Math.round(rectangle.getUpperLeft().getX()),
                (int) Math.round(rectangle.getUpperLeft().getY()),
                (int) Math.round(rectangle.getWidth()),
                (int) Math.round(rectangle.getHeight()));

    }

    /**
     * method name: timePassed.
     * in the meantime does nothing
     */
    @Override
    public void timePassed() {
    }

    /**
     * method name addToGame.
     * add the block to the sprite collection list,
     * and the collidables list
     *
     * @param g the game.
     */

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * method name: removeFromGame.
     * removes the block from the game
     *
     * @param g the game.
     */

    public void removeFromGame(GameLevel g) {
        g.removeCollidable(this);
        g.removeSprite(this);
    }

    /**
     * method name: addHitListener.
     * add the HitListener to the list.
     *
     * @param hi a HitListener.
     */
    public void addHitListener(HitListener hi) {
        hitListener.add(hi);
    }

    /**
     * method name: removeHitListener.
     * removes the HitListener from the list.
     *
     * @param hi a HitListener.
     */

    public void removeHitListener(HitListener hi) {
        hitListener.remove(hi);
    }

    /**
     * method name: notifyHit.
     * call hitEvent for every listener in the list.
     * @param hitter a ball
     */
    private void notifyHit(Ball hitter) {
        List<HitListener> listener = new ArrayList<>(this.hitListener);
        for (HitListener h : listener) {
            h.hitEvent(this, hitter);
        }

    }

}
