import Geometry.Compare;
import Geometry.Line;
import Geometry.Point;
import Geometry.Rectangle;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Ori Arad
 */
public class Ball implements Sprite {
    private Point p;
    private int r;
    private Color color;
    // a default velocity
    private Velocity val = new Velocity(4, 4);
    private GameEnvironment gameEnvironment;

    /**
     * the contractor.
     *
     * @param center the point of the ball.
     * @param r      the radius of the ball.
     * @param color  the color of the ball.
     *               if the velocity is not being set it has a default value.
     */
    public Ball(Point center, int r, Color color) {
        this.color = color;
        this.p = center;
        this.r = r;
    }

    /**
     * another contractor.
     * it creates a point form x and y and call the constructor above.
     *
     * @param x     x value of center
     * @param y     y value of center
     * @param r     radios
     * @param color color
     */

    public Ball(double x, double y, int r, Color color) {
        this(new Point(x, y), r, color);
    }

    /**
     * method name:changeRadius.
     * the method change the size of the radios if he is too big.
     *
     * @param r the radius
     *          .* @return the correct radius.
     */
    private void changeRadius(int r) {
        int appropriateSize = 15;
        int maxSize = 55;
        int minSize = 4;
        if (r <= 0) {
            this.r = minSize;
        }
        if (r > maxSize) {
            this.r = appropriateSize;
        }
    }

    /**
     * method name: setCenter.
     * changes the center of the ball to (x,y).
     *
     * @param x x value of point.
     * @param y y value of point.
     */
    private void setCenter(double x, double y) {
        this.p = new Point(x, y);
    }

    /**
     * getter for x of center.
     *
     * @return value of point x
     */
    public int getX() {
        return (int) Math.round(p.getX());
    }

    /**
     * getter for y of center.
     *
     * @return value of point y
     */
    public int getY() {
        return (int) Math.round(p.getY());
    }

    /**
     * getter for r.
     *
     * @return radius
     */
    public int getSize() {
        return r;
    }

    /**
     * getter for color.
     *
     * @return color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * method name drawOne.
     * the method draws the ball by his measurements
     *
     * @param surface DrawSurface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        p = new Point(Compare.floatPoint(p.getX()), Math.round(p.getY()));
        surface.fillCircle((int) p.getX(), (int) p.getY(), r);
        surface.setColor(Color.black);
        surface.drawCircle((int) p.getX(), (int) p.getY(), r);

    }

    /**
     * setter for velocity.
     *
     * @param v velocity
     */
    public void setVelocity(Velocity v) {
        this.val = v;

    }

    /**
     * setter for velocity.
     *
     * @param dx change in x
     * @param dy change in y
     */

    public void setVelocity(double dx, double dy) {
        this.val = new Velocity(dx, dy);
    }

    /**
     * getter for velocity.
     *
     * @return velocity
     */
    public Velocity getVelocity() {
        return val;
    }

    /**
     * method name: timePassed.
     * the method calls the methods moveOneStep and getBallOutTheBlock that,
     * move the ball one step and fix the center,
     * if he collides with the block or the paddle
     */
    public void timePassed() {
        this.getBallOutTheBlock();
        this.moveOneStep();
    }

    /**
     * method name moveOneStep.
     * the method move the ball one step and fix the center if he is out of range
     */
    public void moveOneStep() {
        // create a line from the center and the center next location.
        Point step = new Point(Compare.floatPoint(val.applyToPoint(this.p).getX()),
                Compare.floatPoint(val.applyToPoint(this.p).getY()));
        Line line = new Line(p, step);
        CollisionInfo info = gameEnvironment.getClosestCollision(line);
        // if there is no collision
        if (info == null) {
            p = step;
            return;
        }
        Point collisionPoint = info.collisionPoint();
        double fixedX = Compare.floatPoint(collisionPoint.getX());
        double fixedY = Compare.floatPoint(collisionPoint.getY());
        // if the collision point x value is the center of the ball x value
        if (Compare.equal(p.getX(), collisionPoint.getX())) {
            if (Compare.equal(collisionPoint.getX(),
                    // if the ball comes from the left
                    info.collisionObject().getCollisionRectangle().getUpperLeft().getX())) {
                fixedX -= r;
                // if the ball comes from the right
            } else if (Compare.equal(collisionPoint.getX(),
                    info.collisionObject().getCollisionRectangle().getBottomRight().getX())) {
                fixedX += r;
                // if the ball comes from above or bellow the block.
            } else {
                fixedX = Compare.floatPoint(collisionPoint.getX());
            }
            // if the ball comes from the right
        } else if (p.getX() < collisionPoint.getX()) {
            fixedX -= r;
            // the ball comes from the left
        } else {
            fixedX += r;
        }
        // if the collision point y value is the center of the ball y value
        if (Compare.equal(p.getY(), collisionPoint.getY())) {
            // if the ball comes from above
            if (Compare.equal(collisionPoint.getY(),
                    info.collisionObject().getCollisionRectangle().getUpperLeft().getY())) {
                fixedY -= r;
                // if the ball comes from bellow.
            } else if (Compare.equal(collisionPoint.getY(),
                    info.collisionObject().getCollisionRectangle().getBottomRight().getY())) {
                fixedY += r;
                // it means the ball comes from right or left.
            } else {
                fixedY = Compare.floatPoint(collisionPoint.getY());
            }
            //if the ball comes from above
        } else if (p.getY() < collisionPoint.getY()) {
            fixedY -= r;
            // it means the ball comes for bellow.
        } else {
            fixedY += r;
        }
        //change the center of the ball and it's velocity
        this.setCenter(fixedX, fixedY);
        val = info.collisionObject().hit(this, collisionPoint, val);
    }

    /**
     * methode name: addToGame.
     * add the ball to the Sprite collection of that game.
     *
     * @param g the game.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * setter for GameEnvironment.
     *
     * @param game the game.
     */

    public void setGameEnvironment(GameEnvironment game) {
        this.gameEnvironment = game;
    }

    /**
     * method name: isInsideBlock.
     * the method checks if the balls is being inside a collectible
     * (it should happen only with the paddle).
     * and returns that collidable.
     *
     * @return Collidable
     */
    public Collidable isInsideBlock() {
        for (Collidable c : gameEnvironment.getArrColl()) {
            if (c.getCollisionRectangle().getUpperLeft().getX() < p.getX()
                    && c.getCollisionRectangle().getUpperLeft().getY() < p.getY()
                    && c.getCollisionRectangle().getBottomRight().getX() > p.getX()
                    && c.getCollisionRectangle().getBottomRight().getY() > p.getY()) {
                return c;
            }
        }
        return null;
    }

    /**
     * method name: getBallOutTheBlock.
     * the method call the method isInsideBlock in order to check if
     * the ball is inside a block. if he is, the method move
     * the center of the ball so that it would be outside the block.
     */

    public void getBallOutTheBlock() {
        int height = 580;
        int startX = 20;
        int endX = 780;
        // it means he is not inside a block
        if (this.isInsideBlock() == null) {
            return;
        }
        Collidable collidable = this.isInsideBlock();
        Rectangle rec = collidable.getCollisionRectangle();
        // find from which edge of the range the ball came through
        // the closet edge is the one
        double distanceLeft = p.getX() - rec.getUpperLeft().getX();
        double distanceRight = rec.getBottomRight().getX() - p.getX();
        double minDistance = Math.min(distanceLeft, distanceRight);
        // if the block is near the edges of the frame
        if (Compare.equal(rec.getUpperLeft().getX(), startX)) {
            setCenter(p.getX(), height - rec.getHeight());
            return;
        }
        if (Compare.equal(rec.getBottomRight().getX(), endX)) {
            setCenter(p.getX(), height - rec.getHeight());
            return;
        }
        // if the ball is closer to the left edge
        if (Compare.equal(minDistance, distanceLeft)) {
            setCenter(p.getX() - minDistance, p.getY());
            // if the ball is closer to the right edge.
        } else if (Compare.equal(minDistance, distanceRight)) {
            setCenter(p.getX() + minDistance, p.getY());
        }
    }

    /**
     * method name: removeBallFromGame.
     * removes the ball from the sprite's list.
     *
     * @param g a game.
     */
    public void removeBallFromGame(GameLevel g) {
        g.removeSprite(this);
    }

}








