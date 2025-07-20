import biuoop.DrawSurface;


/**
 * @author Ori Arad
 */
public class PauseScreen implements Animation {

    private boolean stop;

    /**
     * the constructor.
     */

    public PauseScreen() {
        this.stop = false;
    }

    /**
     * method name: doOneFrame.
     * does one frame of the game
     *
     * @param d draw face
     */

    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
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
