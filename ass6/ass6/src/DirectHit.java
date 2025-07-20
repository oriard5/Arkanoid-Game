import Geometry.Point;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ori Arad
 */
public class DirectHit implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> valList;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blockList;
    private int numberOfBlock;

    private List<Ball> ballList;

    /**
     * the constructor.
     */

    public DirectHit() {
        numberOfBalls = 1;
        valList = new ArrayList<>();
        valList.add(Velocity.fromAngleAndSpeed(0, 5));
        levelName = "Direct Hit";
        background = new DirectHitBackground(new Background(Color.black));
        paddleSpeed = 7;
        paddleWidth = 75;
        blockList = new ArrayList<>();
        blockList.add(new Block(400, 200, 45, 45, Color.red));
        numberOfBlock = 1;
        ballList = new ArrayList<>();
        this.createBall();
    }

    /**
     * getter for numberOfBalls.
     * @return numberOfBalls
     */
    public int numberOfBalls() {
        return numberOfBalls;
    }

    /**
     * getter for valList.
     * @return valList
     */

    public List<Velocity> initialBallVelocities() {
        return valList;
    }

    /**
     * getter for paddleSpeed.
     * @return paddleSpeed.
     */

    public int paddleSpeed() {
        return paddleSpeed;

    }

    /**
     * getter for paddleWidth.
     * @return paddleWidth
     */

    public int paddleWidth() {
        return paddleWidth;
    }

    /**
     * getter for levelName.
     * @return levelName.
     */

    public String levelName() {
        return levelName;

    }

    /**
     * getter for background.
     * @return background
     */

    public Sprite getBackground() {
        return background;
    }

    /**
     * getter for blockList.
     * @return blockList.
     */

    public List<Block> blocks() {
        return blockList;

    }

    /**
     * getter for numberOfBlock.
     * @return numberOfBlock.
     */

    public int numberOfBlocksToRemove() {
        return numberOfBlock;

    }

    /**
     * method name assignValToBall.
     * assign each velocity in valList to the correct ball in ballList.
     * @return ballList
     */

    public List<Ball> assignValToBall() {
        for (int i = 0; i < numberOfBalls; i++) {
            Ball b = ballList.get(i);
            b.setVelocity(valList.get(i));
            ballList.set(i, b);
        }
        return ballList;
    }

    /**
     * method name: removeAllBalls.
     * initialize ballList so the list is empty
     */

    public void removeAllBalls() {
       ballList = new ArrayList<>();
    }

    /**
     * method name createBall.
     * creates the balls
     */

    public void createBall() {
        ballList.add(new Ball(new Point(410, 500), 5, Color.white));

    }
}
