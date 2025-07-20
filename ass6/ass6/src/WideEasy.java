

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Ori Arad
 */
public class WideEasy implements LevelInformation {
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
    public WideEasy() {
        numberOfBalls = 10;
        valList = new ArrayList<>();
        levelName = "Wide Easy";
        background = new WideEasyBackground(new Background(Color.white));
        paddleSpeed = 10;
        paddleWidth = 600;
        blockList = new ArrayList<>();
        numberOfBlock = 15;
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
        int height = 30;
        double x = 20;
        double y = 200;
        Color[] arr = new Color[]{Color.red, Color.red, Color.orange, Color.orange, Color.yellow,
                Color.yellow, Color.green, Color.green, Color.green, Color.blue,
                Color.blue, Color.pink, Color.pink, Color.cyan, Color.cyan};
        for (int i = 0; i < arr.length; i++) {
            Block b = new Block(x, y, wide, height, arr[i]);
            blockList.add(b);
            if (i < 4) {
                x += wide;
            } else {
                x += wide;
                wide = wideP1;

            }
        }

    }

    /**
     * method name createBall.
     * creates the balls
     */

    public void createBall() {
        double x = 350;
        double y = 250;
        double k = 3;
        for (int i = 0; i < 5; i++) {
            Ball b = new Ball(x, y, 5, Color.white);
            ballList.add(b);
            x -= (50);
            if (i == 0) {
                y = y + 2 * k;
            } else {
                y = y + 25 + k;
            }

            k += k;
        }
        y = 250;
        k = 3;
        x = 400;
        for (int i = 0; i < 5; i++) {
            Ball b = new Ball(x, y, 5, Color.white);
            ballList.add(b);
            x += (50);
            if (i == 0) {
                y = y + 2 * k;
            } else {
                y = y + 25 + k;
            }

            k += k;
        }
    }

    /**
     * method name: createVelocity.
     * creates the velocities and adds them to the list
     */

    public void createVelocity() {
        double angle = 350;
        double speed = 6;
        for (int i = 0; i < 5; i++) {
            Velocity v = Velocity.fromAngleAndSpeed(angle, speed);
            valList.add(v);
            angle -= 15;
        }
        angle = 15;
        for (int i = 0; i < 5; i++) {
            Velocity v = Velocity.fromAngleAndSpeed(angle, speed);
            valList.add(v);
            angle += 15;
        }
    }

    /**
     * method name: removeAllBalls.
     * initialize ballList so the list is empty
     */
    public void removeAllBalls() {
        ballList = new ArrayList<>();
    }

}
