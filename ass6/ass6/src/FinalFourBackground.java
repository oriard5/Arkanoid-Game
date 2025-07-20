import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Ori Arad
 */
public class FinalFourBackground implements Sprite {
    private Background background;

    /**
     * the constructor.
     *
     * @param background background.
     */
    public FinalFourBackground(Background background) {
        this.background = background;
    }

    /**
     * method name: timePassed.
     * does nothing.
     */

    @Override
    public void timePassed() {

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
        d.setColor(Color.WHITE);
        for (int i = 0; i < 10; i++) {
            d.drawLine(200 + i * 10, 400, 230 + i * 10, 600);
        }
        d.setColor(new Color(100, 100, 100));
        d.fillCircle(200, 400, 25);
        d.fillCircle(220, 420, 27);
        d.setColor(new Color(150, 150, 150));
        d.fillCircle(240, 390, 29);
        d.setColor(new Color(200, 200, 200));
        d.fillCircle(260, 420, 23);
        d.fillCircle(280, 400, 35);

        d.setColor(Color.WHITE);
        for (int i = 0; i < 10; i++) {
            d.drawLine(500 + i * 10, 350, 530 + i * 10, 600);
        }

        d.setColor(new Color(100, 100, 100));
        d.fillCircle(500, 350, 25);
        d.fillCircle(520, 370, 27);
        d.setColor(new Color(150, 150, 150));
        d.fillCircle(540, 340, 29);
        d.setColor(new Color(200, 200, 200));
        d.fillCircle(560, 370, 23);
        d.fillCircle(580, 350, 35);

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
