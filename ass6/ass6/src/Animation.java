import biuoop.DrawSurface;

/**
 * @author Ori Arad
 */
public interface Animation {
    /**
     * method name: doOneFrame.
     * does one frame of the game
     * @param d draw face
     */
    void doOneFrame(DrawSurface d);

    /**
     * method name shouldStop.
     * return true if the game should be stopped and false if not.
     * @return boolean
     */
    boolean shouldStop();
}
