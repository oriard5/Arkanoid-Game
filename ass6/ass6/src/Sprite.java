import biuoop.DrawSurface;

/**
 * @author Ori Arad
 */
public interface Sprite {
    /**
     *  method name drawOn.
     * draws the Sprite.
     * @param d drawSurface.
     */
      void drawOn(DrawSurface d);

    /**
     * method name: timePassed.
     * move the sprite
     */
     void timePassed();

    /**
     * method name : addToGame.
     * adds the sprite to the gameLevel.
     * @param gameLevel the gameLevel.
     */

     void addToGame(GameLevel gameLevel);
}
