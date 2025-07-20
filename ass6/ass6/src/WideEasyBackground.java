import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Ori Arad
 */
public class WideEasyBackground implements Sprite {
    private Sprite background;

    /**
     * the constructor.
     *
     * @param background background.
     */

    public WideEasyBackground(Sprite background) {
        this.background = background;
    }

    /**
     * method name: drawOn.
     * draws the background.
     *
     * @param d drawSurface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        background.drawOn(d);
        d.setColor(Color.red);
        d.fillCircle(400, 400, 320);
        d.setColor(Color.orange);
        d.fillCircle(400, 400, 300);
        d.setColor(Color.yellow);
        d.fillCircle(400, 400, 280);
        d.setColor(Color.green);
        d.fillCircle(400, 400, 260);
        d.setColor(Color.blue);
        d.fillCircle(400, 400, 240);
        Color color = new Color(133, 36, 215);
        d.setColor(color);
        d.fillCircle(400, 400, 220);
        d.setColor(Color.white);
        d.fillCircle(400, 400, 200);
        d.fillRectangle(80, 400, 660, 660);

    }

    /**
     * method name: timePassed.
     * does nothing.
     */
    @Override
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
