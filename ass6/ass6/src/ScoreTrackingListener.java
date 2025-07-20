/**
 * @author Ori Arad
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * the constructor.
     * @param scoreCounter a Counter.
     */

    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    /**
     * method name: hitEvent.
     * removes listener from the block list and increase counter by five.
     */

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        int points = 5;
        currentScore.increase(points);
        beingHit.removeHitListener(this);

    }
}
