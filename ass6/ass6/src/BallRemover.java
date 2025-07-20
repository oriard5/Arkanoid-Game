/**
 * @author Ori Arad
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * the constructor.
     *
     * @param gameLevel           a gameLevel.
     * @param remainingBalls number of balls
     */

    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.remainingBalls = remainingBalls;
        this.gameLevel = gameLevel;

    }

    /**
     * method name: hitEvent.
     * the method remove the ball from the gameLevel and decrease the number of ball by 1.
     *
     * @param beingHit the death region block.
     * @param hitter   the ball
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeBallFromGame(gameLevel);
        this.remainingBalls.decrease(1);
    }

    /**
     * getter for remainingBalls.
     *
     * @return remainingBalls.
     */

    public Counter getRemainingBalls() {
        return remainingBalls;
    }
}
