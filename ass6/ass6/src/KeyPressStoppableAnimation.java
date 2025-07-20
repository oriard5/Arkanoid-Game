import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Ori Arad
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    private String key;

    private Animation animation;

    private boolean isAlreadyPressed;

    /**
     * the constructor.
     * @param sensor KeyboardSensor
     * @param key String
     * @param animation Animation
     */


    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.stop = false;
        this.key = key;
        this.animation = animation;
        isAlreadyPressed = true;

    }

    /**
     * method name doOneFrame.
     * does one frame of the animation.
     * @param d draw face
     */

    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (this.keyboard.isPressed(key) && !isAlreadyPressed) {
            this.stop = true;
        } else {
            isAlreadyPressed = false;
        }
    }

    /**
     * method name shouldStop.
     * return true if the game should be stopped and false if not.
     * @return boolean
     */

    public boolean shouldStop() {
        return this.stop;
    }
}
