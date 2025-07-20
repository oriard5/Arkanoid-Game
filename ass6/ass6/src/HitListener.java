/**
 * @author Ori Arad
 */
public interface HitListener {
    /**
     * method name: hitEvent.
     *
     * @param beingHit block.
     * @param hitter   a ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
