import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ori arad
 */

public class SpriteCollection {
    private List<Sprite> arrSprite;

    /**
     * the constructor.
     * this class contains a list of all the Sprites in the game.
     * the constructor initialize the list.
     */
    public SpriteCollection() {
        arrSprite = new ArrayList<>();
    }

    /**
     * method name: addSprite
     * the method adds the sprite to the list.
     *
     * @param s a sprite that should be in the list.
     */

    public void addSprite(Sprite s) {
        arrSprite.add(s);
    }

    /**
     * method name: notifyAllTimePassed.
     * the method calls the method timePassed in every sprite in the list.
     */
    public void notifyAllTimePassed() {
        List<Sprite> copy = new ArrayList<>(arrSprite);
        for (Sprite k : copy) {
            k.timePassed();
        }
    }

    /**
     * method name: drawAllOn.
     *
     * @param d DrawSurface.
     *          the method calls the method drawOn in every sprite in the list.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite k : arrSprite) {
            k.drawOn(d);
        }
    }

    /**
     * method name: removeTheSprite.
     * remove the sprite from the list.
     *
     * @param s Sprite
     */
    public void removeTheSprite(Sprite s) {
        arrSprite.remove(s);
    }

}
