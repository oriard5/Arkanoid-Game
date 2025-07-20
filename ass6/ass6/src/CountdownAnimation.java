import biuoop.DrawSurface;


import java.awt.Color;

/**
 * @author Ori Arad
 */

public class CountdownAnimation implements Animation {
    private int countFrom;

    private double numOfSeconds;
    private SpriteCollection sprites;

    private boolean stop;

    private int counter;

    private int number;

    /**
     * the constructor.
     * @param sprites SpriteCollection.
     * @param countFrom from which number to count from.
     * @param numOfSeconds the time that the countDown will be active
     */

    public CountdownAnimation(SpriteCollection sprites, int countFrom, double numOfSeconds) {
        this.countFrom = countFrom;
        this.sprites = sprites;
        this.numOfSeconds = numOfSeconds;
        this.stop = false;
        counter = 0;
        number = countFrom;
    }

    /**
     * method name :doOneFrame
     * does one frame, draws the time that is left before the game will start.
     * @param d draw face.
     */
    @Override

    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        double time = (this.numOfSeconds / this.countFrom);
        int framePerSecond = 60;
        int timeShow = (int) (time * framePerSecond);
        counter += 1;
        if (counter % timeShow == 0) {
            number--;
        }
        if (counter == numOfSeconds * framePerSecond) {
            this.stop = true;
            return;
        }
        d.setColor(Color.black);
        d.drawText(20, 35, "the game will start in: " + number, 20);
    }
    /**
     * method name shouldStop.
     * return true if the game should be stopped and false if not.
     * @return boolean
     */
    public boolean shouldStop() {
        return stop;
    }
}
