import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Ori Arad
 */
public class DirectHitBackground implements Sprite {
    private Sprite background;

    /**
     * the constructor.
     *
     * @param background background.
     */

    public DirectHitBackground(Sprite background) {
        this.background = background;
    }

    /**
     * method name: drawOn.
     * draws the background.
     *
     * @param d drawSurface.
     */
    public void drawOn(DrawSurface d) {
        background.drawOn(d);
        Color color = new Color(23, 25, 241);
        d.setColor(color);
        d.drawCircle(422, 222, 60);
        d.drawCircle(422, 222, 90);
        d.drawCircle(422, 222, 120);
        d.drawLine(280, 222, 560, 222);
        d.drawLine(422, 90, 422, 350);
        d.drawCircle(200, 400, 70);
        d.drawLine(165, 360, 190, 380);
        d.drawLine(165, 380, 190, 360);
        d.drawLine(210, 360, 235, 380);
        d.drawLine(210, 380, 235, 360);
        d.drawLine(180, 420, 220, 420);
        d.drawCircle(600, 400, 70);
        d.drawLine(565, 360, 590, 380);
        d.drawLine(565, 380, 590, 360);
        d.drawLine(610, 360, 635, 380);
        d.drawLine(610, 380, 635, 360);
        d.drawLine(580, 420, 620, 420);

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

    public void addToGame(GameLevel gameLevel) {

        gameLevel.addSprite(this);
    }

}
