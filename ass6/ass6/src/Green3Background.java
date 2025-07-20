import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Ori Arad
 */
public class Green3Background implements Sprite {
    private Sprite background;

    /**
     * the constructor.
     *
     * @param background background.
     */

    public Green3Background(Sprite background) {
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
        d.setColor(Color.BLACK);
        d.fillRectangle(110, 200, 10, 200);

        d.setColor(Color.RED);
        d.fillCircle(115, 200, 12);

        d.setColor(Color.ORANGE);
        d.fillCircle(115, 200, 8);

        d.setColor(Color.WHITE);
        d.fillCircle(115, 200, 3);

        d.setColor(Color.BLACK);
        d.fillRectangle(100, 400, 30, 200);

        d.setColor(Color.BLACK);
        d.fillRectangle(65, 450, 100, 200);

        d.setColor(Color.WHITE);

        for (int x = 0; x < 5; ++x) {
            for (int y = 0; y < 5; ++y) {
                d.fillRectangle(75 + x * 18, 460 + y * 32, 10, 25);
            }
        }
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
