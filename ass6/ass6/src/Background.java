import Geometry.Point;
import Geometry.Rectangle;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Ori Arad
 */
public class Background implements Sprite {
   private Rectangle rectangle;
    private Color color;

    /**
     * the constructor.
     *
     * @param color color
     */
    public Background(Color color) {
        int width = 800;
        int height = 600;
        this.rectangle = new Rectangle(new Point(0, 0), width, height);
        this.color = color;
    }

    /**
     * method name: drawOn.
     * draws the background.
     *
     * @param d drawSurface.
     */

    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());

    }

    /**
     * method name: timePassed.
     * does nothing.
     */

    public void timePassed() {
    }

    /**
     * method name: addToGame.
     * add the background to the game spite's list
     *
     * @param gameLevel the gameLevel.
     */

    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}
