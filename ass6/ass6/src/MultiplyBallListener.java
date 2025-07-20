import java.awt.Color;

/**
 * @author Ori Arad
 */
public class MultiplyBallListener implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;
    private Counter remainingBlocks;

    /**
     * the constructor.
     * @param gameLevel the gameLevel.
     * @param remainingBalls number of balls.
     * @param remainingBlocks number of blocks.
     */

    public MultiplyBallListener(GameLevel gameLevel, Counter remainingBalls, Counter remainingBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * method name: hitEvent.
     * the method removes the block ,add another ball and update their counters accordingly.
     * @param beingHit block.
     * @param hitter a ball.
     */

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(gameLevel);
        beingHit.removeHitListener(this);
        Ball ball = new Ball(hitter.getX(), hitter.getY(), hitter.getSize(), Color.white);
        ball.setGameEnvironment(gameLevel.getEnvironment());
        ball.addToGame(gameLevel);
        ball.setVelocity(-1 * hitter.getVelocity().getDx(), -1 * hitter.getVelocity().getDy());
        remainingBalls.increase(1);
        remainingBlocks.decrease(1);

    }
}
