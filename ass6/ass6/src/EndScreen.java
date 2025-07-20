import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Ori Arad
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    private Counter score;

    private String string;

    /**
     * the constructor.
     *
     * @param string string
     * @param score  score
     */

    public EndScreen(String string, Counter score) {
        this.string = string;
        this.score = score;
        this.stop = false;
    }

    /**
     * method name: doOneFrame.
     * draws the score of the player.
     *
     * @param d draw face
     */

    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, string + score.getValue() + ".", 32);
    }

    /**
     * method name shouldStop.
     * return true if the game should be stopped and false if not.
     *
     * @return boolean
     */
    public boolean shouldStop() {
        return this.stop;
    }

}
