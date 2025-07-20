import Geometry.Compare;
import Geometry.Point;
import Geometry.Rectangle;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * @author Ori Arad
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    //default color
    private java.awt.Color color = Color.BLACK;
    // the limit of the value of x on the left and on the right.
    // the value represents the value of x of the upperLeft and bottom right.
    private double maxLeft = 20;
    private double maxRight = 780;

    private int speed;

    /**
     * the constructor.
     * create a paddle.
     *
     * @param gui       the gui
     * @param rectangle the  measurements of the paddle's rectangle
     * @param speed     the speed of the paddle.
     */

    public Paddle(biuoop.GUI gui, Rectangle rectangle, int speed) {
        this.keyboard = gui.getKeyboardSensor();
        this.rectangle = rectangle;
        this.speed = speed;

    }

    /**
     * method name setColor.
     * changes the paddle color
     *
     * @param color the requested color.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * setter for MaxLeft.
     *
     * @param maxLeft the limit of X value on the left.
     */

    public void setMaxLeft(double maxLeft) {
        this.maxLeft = maxLeft;
    }

    /**
     * setter for MaxRight.
     *
     * @param maxRight the limit of X value on the right
     */

    public void setMaxRight(double maxRight) {
        this.maxRight = maxRight;
    }

    /**
     * method name: moveLeft.
     * the method call the method moveRectangleBy with -5,
     * in order to move the paddle left.
     */

    public void moveLeft() {
        double moveBy = -speed;
        // if the paddle reach his limit in the left
        if (Compare.equal(rectangle.getUpperLeft().getX(), maxLeft)) {
            return;
        }
        // if the gap between the paddle and maxLeft is less than 5.
        if (this.rectangle.getUpperLeft().getX() + moveBy < this.maxLeft) {
            moveBy = this.rectangle.getUpperLeft().getX() - this.maxLeft;
        }
        this.rectangle = this.moveRectangleBy(moveBy, this.rectangle);
    }

    /**
     * method name: moveRight.
     * the method call the method moveRectangleBy with 5,
     * in order to move the paddle right.
     */
    public void moveRight() {
        double moveBy = speed;
        // if the paddle reach his limit in the right
        if (Compare.equal(rectangle.getBottomRight().getX(), maxRight)) {
            return;
        }
        // if the gap between the paddle and maxRight is less than 5.
        if (this.rectangle.getBottomRight().getX() + moveBy > this.maxRight) {
            moveBy = (this.maxRight - this.rectangle.getBottomRight().getX());
        }
        this.rectangle = this.moveRectangleBy(moveBy, this.rectangle);
    }

    /**
     * method name: timePassed.
     * the method check if the left key or the right key is being pressed
     * and calls the methods moveLeft and moveRight accordingly.
     */

    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * method name: drawOn.
     * draws the paddle.
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
     * method name: getCollisionRectangle.
     * a getter for rectangle.
     *
     * @return rectangle.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return rectangle;
    }

    /**
     * method name: hit.
     * the method changes the value of the ball velocity,
     * depending on where the ball hit the paddle
     *
     * @param collisionPoint  the point where the ball hit the paddle.
     * @param currentVelocity the velocity of the ball.
     * @param  hitter the ball
     * @return new velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // the speed of the ball
        double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                + Math.pow(currentVelocity.getDy(), 2));
        double angle = 0;
        // the five region of the paddle.
        double region = (rectangle.getWidth() / 5);
        double leftPointX = rectangle.getUpperLeft().getX();
        // it means the ball comes from above
        if (Compare.equal(rectangle.getUpperLeft().getY(), collisionPoint.getY())) {
            // region one.
            if (collisionPoint.getX() >= leftPointX
                    && collisionPoint.getX() <= leftPointX + region) {
                angle = 300;
            }
            // region two.
            if (collisionPoint.getX() > leftPointX + region
                    && collisionPoint.getX() <= leftPointX + 2 * region) {
                angle = 330;
            }
            // region three.
            if (collisionPoint.getX() > leftPointX + 2 * region
                    && collisionPoint.getX() <= leftPointX + 3 * region) {
                return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
            }
            // region four.
            if ((collisionPoint.getX() > leftPointX + 3 * region
                    && collisionPoint.getX() <= leftPointX * region)) {
                angle = 30;
            }
            // region five.
            if ((collisionPoint.getX() > 4 * region + leftPointX
                    && collisionPoint.getX() <= rectangle.getBottomRight().getX())) {
                angle = 60;
            }
            return Velocity.fromAngleAndSpeed(angle, speed);
        }
        // if the ball comes from the left or the right of the paddle.
        if (Compare.equal(collisionPoint.getX(), rectangle.getUpperLeft().getX())) {
            // in order to prevent the paddle to push the ball.
            if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
                moveRight();
            }
            // change the velocity horizontal direction.
            return new Velocity(-Math.abs(currentVelocity.getDx()), currentVelocity.getDy());
        }
        if (Compare.equal(collisionPoint.getX(), rectangle.getBottomRight().getX())) {
            // in order to prevent the paddle to push the ball.
            if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
                moveLeft();
            }
            // change the velocity horizontal direction.
            return new Velocity(Math.abs(currentVelocity.getDx()), currentVelocity.getDy());
        }
        // it means that there is no collision between the ball and the paddle.
        return currentVelocity;
    }

    /**
     * method name: addToGame.
     * adds the paddle to the sprite's and collidable's lists.
     *
     * @param g the game.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * method name: moveRectangleBy
     * the method changes the rectangle's upper left x value by the parameter x,
     * this creates the movement of the paddle to the left or the right.
     *
     * @param x   the change value of x in the point upper left of the paddle.
     * @param rec the rectangle.
     * @return the new rectangle
     */
    public Rectangle moveRectangleBy(double x, Rectangle rec) {
        Point p = new Point(rec.getUpperLeft().getX() + x, rec.getUpperLeft().getY());
        return new Rectangle(p, rec.getWidth(), rec.getHeight());
    }

}


