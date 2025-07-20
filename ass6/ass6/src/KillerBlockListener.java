/**
 * @author Ori Arad.
 */
public class KillerBlockListener implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;
    private Counter remainingBlocks;

    /**
     * the constructor.
     *
     * @param gameLevel            a gameLevel
     * @param remainingBalls  number of balls.
     * @param remainingBlocks number of blocks.
     */

    public KillerBlockListener(GameLevel gameLevel, Counter remainingBalls, Counter remainingBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = remainingBlocks;
        this.remainingBalls = remainingBalls;


    }

    /**
     * method name :hitEvent
     * the method removes the block and the ball and decrease their counter by one.
     *
     * @param beingHit block.
     * @param hitter   a ball.
     */

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(gameLevel);
        hitter.removeBallFromGame(gameLevel);
        beingHit.removeHitListener(this);
        remainingBalls.decrease(1);
        remainingBlocks.decrease(1);

    }
}
