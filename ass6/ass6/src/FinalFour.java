import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ori Arad.
 */

public class FinalFour implements LevelInformation {
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

    public FinalFour() {
        numberOfBalls = 3;
        valList = new ArrayList<>();
        levelName = "Final Four";
        Color color = new Color(0, 99, 166, 255);
        background = new FinalFourBackground(new Background(color));
        paddleSpeed = 10;
        paddleWidth = 100;
        blockList = new ArrayList<>();
        numberOfBlock = 105;
        ballList = new ArrayList<>();
        this.createBlocks();
        this.createBall();
    }

    /**
     * getter for numberOfBalls.
     *
     * @return numberOfBalls
     */

    public int numberOfBalls() {
        return numberOfBalls;
    }

    /**
     * getter for valList.
     *
     * @return valList
     */

    public List<Velocity> initialBallVelocities() {
        return valList;
    }

    /**
     * getter for paddleSpeed.
     *
     * @return paddleSpeed.
     */

    public int paddleSpeed() {
        return paddleSpeed;

    }

    /**
     * getter for paddleWidth.
     *
     * @return paddleWidth
     */

    public int paddleWidth() {
        return paddleWidth;
    }

    /**
     * getter for levelName.
     *
     * @return levelName.
     */

    public String levelName() {
        return levelName;
    }

    /**
     * getter for background.
     *
     * @return background
     */

    public Sprite getBackground() {
        return background;
    }

    /**
     * getter for blockList.
     *
     * @return blockList.
     */

    public List<Block> blocks() {
        return blockList;

    }

    /**
     * getter for numberOfBlock.
     *
     * @return numberOfBlock.
     */

    public int numberOfBlocksToRemove() {
        return numberOfBlock;

    }

    /**
     * method name assignValToBall.
     * assign each velocity in valList to the correct ball in ballList.
     *
     * @return ballList
     */

    public List<Ball> assignValToBall() {
        this.createVelocity();
        for (int i = 0; i < numberOfBalls; i++) {
            Ball b = ballList.get(i);
            b.setVelocity(valList.get(i));
            ballList.set(i, b);
        }
        return ballList;
    }

    /**
     * method name: createBlocks.
     * creates blocks.
     */

    public void createBlocks() {
        int wide = 50;
        int wideP1 = 51;
        int height = 27;
        double x = 20;
        double y = 100;
        double rows = 7;
        double inRow = 15;
        Color[] arr = new Color[]{Color.gray, Color.red, Color.yellow, Color.gray, Color.lightGray,
                Color.pink, Color.cyan};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < inRow; j++) {
                Block b = new Block(x, y, wide, height, arr[i]);
                blockList.add(b);
                if (j < 4) {
                    x += wide;
                } else {
                    x += wide;
                    wide = wideP1;
                }
            }
            x = 20;
            y = y + height;
            wide = 50;
        }

    }

    /**
     * method name createBall.
     * creates the balls
     */

    public void createBall() {
        double x = 300;
        double y = 450;
        double k = 100;
        Ball ball1 = new Ball(x, y, 5, Color.white);
        ballList.add(ball1);
        Ball ball2 = new Ball(x + k, y - (k / 2), 5, Color.white);
        ballList.add(ball2);
        Ball ball3 = new Ball(x + 2 * k, y, 5, Color.white);
        ballList.add(ball3);

    }

    /**
     * method name: createVelocity.
     * creates the velocities and adds them to the list
     */

    public void createVelocity() {
        double angle = 330;
        double speed = 5;
        Velocity v = Velocity.fromAngleAndSpeed(angle, speed);
        valList.add(v);
        angle = 0;
        Velocity h = Velocity.fromAngleAndSpeed(angle, speed);
        valList.add(h);
        angle = 30;
        Velocity k = Velocity.fromAngleAndSpeed(angle, speed);
        valList.add(k);
    }

    /**
     * method name: removeAllBalls.
     * initialize ballList so the list is empty
     */

    public void removeAllBalls() {
        ballList = new ArrayList<>();
    }

}
