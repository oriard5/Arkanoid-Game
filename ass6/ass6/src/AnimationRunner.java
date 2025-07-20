import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author Ori Arad
 */
public class AnimationRunner {
    private GUI gui;
    private int framePerSecond;
    private Sleeper sleeper = new Sleeper();

    /**
     * the constructor.
     * @param gui gui
     * @param framePerSecond indicates the number of frames that will
     *                      be showing for each second.
     */


    public AnimationRunner(GUI gui, int framePerSecond) {
        this.gui = gui;
        this.framePerSecond = framePerSecond;
    }

    /**
     * method name: run
     * the method runs in a loop the do one frame of the animation.
     * @param animation animation
     */

    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framePerSecond;
        while (!animation.shouldStop()) {
            DrawSurface d = gui.getDrawSurface();
            long startTime = System.currentTimeMillis();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long millisecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (millisecondLeftToSleep > 0) {
                this.sleeper.sleepFor(millisecondLeftToSleep);
            }
        }
    }

    /**
     * getter for GUI.
     * @return GUI
     */

    public GUI getGui() {
        return gui;
    }
}
