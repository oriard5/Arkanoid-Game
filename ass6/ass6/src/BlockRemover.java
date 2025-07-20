/**
 * @author Ori Arad
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * the constructor.
     *
     * @param gameLevel       a gameLevel.
     * @param remainingBlocks number of blocks.
     */

    public BlockRemover(GameLevel gameLevel, Counter remainingBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * method name: hitEvent.
     * the method remove the block from the gameLevel and decrease the number of blocks by 1.
     *
     * @param beingHit the block
     * @param hitter   the ball
     */

    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(gameLevel);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);
    }

    /**
     * getter for remainingBlocks.
     *
     * @return remainingBlocks.
     */

    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }

}
