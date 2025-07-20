import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Ori Arad.
 */
public class ScoreIndicator implements Sprite {
    private Counter counter;

    private String string;

    private Counter lives;

    /**
     * the constructor.
     *
     * @param counter the counter of the score
     * @param string  the name of level.
     * @param lives   the remaining lives
     */

    public ScoreIndicator(Counter counter, String string, Counter lives) {

        this.counter = counter;
        this.string = string;
        this.lives = lives;
    }

    /**
     * method name: drawOn.
     * draws the score on the screen
     *
     * @param d drawSurface.
     */

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle(0, 0, 800, 20);
        d.setColor(Color.black);
        d.drawText(350, 16, "Score: " + counter.getValue(), 16);
        d.drawText(500, 16, "Level Name: " + string, 16);
        d.drawText(200, 16, "Lives: " + lives.getValue(), 16);
    }

    /**
     * method name :timePassed.
     * does nothing.
     */

    @Override
    public void timePassed() {
    }

    /**
     * method addToGame.
     * adds to the gameLevel list.
     *
     * @param gameLevel the gameLevel.
     */

    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}