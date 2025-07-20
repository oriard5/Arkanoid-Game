import java.util.List;

/**
 * @author Ori Arad
 */
public interface LevelInformation {
    /**
     * getter for numberOfBalls.
     *
     * @return numberOfBalls
     */
    int numberOfBalls();
    /**
     * getter for valList.
     *
     * @return valList
     */
    List<Velocity> initialBallVelocities();
    /**
     * getter for paddleSpeed.
     *
     * @return paddleSpeed.
     */
    int paddleSpeed();
    /**
     * getter for paddleWidth.
     *
     * @return paddleWidth
     */
    int paddleWidth();
    /**
     * getter for levelName.
     *
     * @return levelName.
     */
    String levelName();
    /**
     * getter for background.
     *
     * @return background
     */
    Sprite getBackground();
    /**
     * getter for blockList.
     *
     * @return blockList.
     */


    List<Block> blocks();
    /**
     * getter for numberOfBlock.
     *
     * @return numberOfBlock.
     */
    int numberOfBlocksToRemove();
    /**
     * method name assignValToBall.
     * assign each velocity in valList to the correct ball in ballList.
     *
     * @return ballList
     */
     List<Ball> assignValToBall();
    /**
     * method name: removeAllBalls.
     * initialize ballList so the list is empty
     */
     void removeAllBalls();
    /**
     * method name createBall.
     * creates the balls
     */
      void createBall();
}
