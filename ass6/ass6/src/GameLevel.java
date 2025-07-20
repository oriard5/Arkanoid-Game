import Geometry.Point;
import Geometry.Rectangle;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.Random;

/**
 * @author Ori Arad.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;

    private Counter counterBlocks;

    private Counter counterBalls;

    private Counter scoreCounter;

    private AnimationRunner runner;

    private boolean running;

    private KeyboardSensor keyboard;

    private LevelInformation levelInfo;

    private Counter lives;

    private Paddle paddle;

    /**
     * the constructor.
     *
     * @param levelInfo    LevelInformation
     * @param scoreCounter Counter
     * @param runner       AnimationRunner
     * @param keyboard     KeyboardSensor
     * @param lives        Counter
     */
    public GameLevel(LevelInformation levelInfo, Counter scoreCounter,
                     AnimationRunner runner, KeyboardSensor keyboard, Counter lives) {

        this.levelInfo = levelInfo;
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        counterBlocks = new Counter();
        counterBalls = new Counter();
        this.scoreCounter = scoreCounter;
        this.runner = runner;
        running = true;
        this.keyboard = keyboard;
        this.lives = lives;


    }

    /**
     * method name: addCollidable.
     * adds a collidable to environment list of collidables.
     *
     * @param c a Collidable
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * method name: addSprite.
     * adds a sprite to the spriteCollection list of sprites.
     *
     * @param s sprite
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * method name: initialize.
     * creates all the blocks, the paddle ,the balls and the listeners.
     */
    public void initialize() {
        BlockRemover remover = new BlockRemover(this, counterBlocks);
        BallRemover removerBall = new BallRemover(this, counterBalls);
        ScoreTrackingListener listener = new ScoreTrackingListener(scoreCounter);
        ScoreIndicator scoreIndicator = new ScoreIndicator(scoreCounter, levelInfo.levelName(), lives);
        KillerBlockListener killer = new KillerBlockListener(this, counterBalls, counterBlocks);
        MultiplyBallListener multiplyBallListener =
                new MultiplyBallListener(this, counterBalls, counterBlocks);
        createFrame();
        createBlocks(remover, listener, killer, multiplyBallListener);
        scoreIndicator.addToGame(this);
        createDeathRegion(removerBall);
        createPaddle();
        createBalls();
    }


    /**
     * method name :createBlocks.
     * creates the blocks and add 4 killerBalls and 4 multiply blocks in randomly.
     * and adds the right listener for the block's list.
     *
     * @param remover  a BlockRemover
     * @param listener a ScoreTrackingListener
     * @param killer   a KillerBlockListener
     * @param multi    a MultiplyBallListener
     */
    private void createBlocks(BlockRemover remover, ScoreTrackingListener listener, KillerBlockListener killer,
                              MultiplyBallListener multi) {
        if (levelInfo.blocks().size() < 39) {
            for (Block b : levelInfo.blocks()) {
                b.addToGame(this);
                b.addHitListener(listener);
                b.addHitListener(remover);
            }
        } else {
            int[] arr = this.randomArray(levelInfo.blocks().size());
            int counter = 1;
            for (Block b : levelInfo.blocks()) {
                b.addToGame(this);
                b.addHitListener(listener);
                for (int k = 0; k < 10; k++) {
                    if (arr[k] == counter) {
                        if (k < 3) {
                            b.addHitListener(killer);
                        } else {
                            b.addHitListener(multi);
                        }
                        break;
                    }
                    if (k == 9) {
                        b.addHitListener(remover);
                    }
                }
                counter++;
            }
        }
        this.counterBlocks.increase(levelInfo.blocks().size());
    }


    /**
     * method name: createFrame.
     * creates the four blocks that represents the frame of the game
     */
    private void createFrame() {
        int width = 800;
        int height = 600;
        int widthOfFrame = 20;
        levelInfo.getBackground().addToGame(this);
        new Block(0, 0, widthOfFrame, height, Color.gray).addToGame(this);
        new Block(width - widthOfFrame, 0, widthOfFrame,
                height, Color.gray).addToGame(this);
        new Block(0, 0, width, 2 * widthOfFrame, Color.gray).addToGame(this);
    }

    /**
     * method name : removeCollidable.
     * removes the Collidable from the list
     *
     * @param c a Collidable.
     */

    public void removeCollidable(Collidable c) {
        environment.removeTheCollidable(c);
    }

    /**
     * method name : removeSprite.
     * removes the Sprite from the list.
     *
     * @param s a Sprite.
     */


    public void removeSprite(Sprite s) {
        sprites.removeTheSprite(s);
    }

    /**
     * method name: createDeathRegion.
     * create the death region block.
     *
     * @param remover BallRemover.
     */

    private void createDeathRegion(BallRemover remover) {
        int width = 800;
        int height = 600;
        int widthOfFrame = 20;
        Block b = new Block(0, height, width,
                widthOfFrame, Color.gray);
        b.addToGame(this);
        b.addHitListener(remover);
    }

    /**
     * method name: createPaddle.
     * creates a paddle.
     */

    public void createPaddle() {
        double paddleY = 525;
        double width = levelInfo.paddleWidth();
        double paddleX = 400 - (levelInfo.paddleWidth() / 2);
        double height = 20;
        int speed = levelInfo.paddleSpeed();
        this.paddle = new Paddle(runner.getGui(),
                new Rectangle(new Point(paddleX, paddleY), width, height), speed);
        paddle.setColor(Color.yellow);
        paddle.addToGame(this);
    }

    /**
     * method name: createBalls.
     * creates balls.
     */

    public void createBalls() {
        for (Ball ball : levelInfo.assignValToBall()) {
            ball.setGameEnvironment(environment);
            ball.addToGame(this);
        }
        counterBalls.increase(levelInfo.numberOfBalls());
    }

    /**
     * getter for environment.
     *
     * @return gameEnvironment
     */

    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * name method : randomArray.
     * returns array the all his value are random and different from each other.
     * @param max the max number
     * @return array, int.
     */

    public int[] randomArray(int max) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            arr[i] = random.nextInt(max) + 1;
        }
        while (arr[0] == arr[1]) {
            arr[1] = random.nextInt(max) + 1;
        }
        while (arr[2] == arr[1] || arr[2] == arr[0]) {
            arr[2] = random.nextInt(max) + 1;
        }
        while (arr[3] == arr[2] || arr[3] == arr[1] || arr[3] == arr[0]) {
            arr[3] = random.nextInt(max) + 1;
        }
        while (arr[4] == arr[2] || arr[4] == arr[1] || arr[4] == arr[0]
                || arr[4] == arr[3]) {
            arr[4] = random.nextInt(max) + 1;
        }
        while (arr[5] == arr[2] || arr[5] == arr[1] || arr[5] == arr[0]
                || arr[5] == arr[3] || arr[5] == arr[4]) {
            arr[5] = random.nextInt(max) + 1;
        }
        while (arr[6] == arr[2] || arr[6] == arr[1] || arr[6] == arr[0]
                || arr[6] == arr[3] || arr[6] == arr[4] || arr[6] == arr[5]) {
            arr[6] = random.nextInt(max) + 1;
        }
        while (arr[7] == arr[2] || arr[7] == arr[1] || arr[7] == arr[0]
                || arr[7] == arr[3] || arr[7] == arr[4] || arr[7] == arr[5]
                || arr[7] == arr[6]) {
            arr[7] = random.nextInt(max) + 1;
        }
        while (arr[8] == arr[2] || arr[8] == arr[1] || arr[8] == arr[0]
                || arr[8] == arr[3] || arr[8] == arr[4] || arr[8] == arr[5]
                || arr[8] == arr[6] || arr[8] == arr[7]) {
            arr[8] = random.nextInt(max) + 1;
        }
        while (arr[9] == arr[2] || arr[9] == arr[1] || arr[9] == arr[0]
                || arr[9] == arr[3] || arr[9] == arr[4] || arr[9] == arr[5]
                || arr[9] == arr[6] || arr[9] == arr[7] || arr[9] == arr[8]) {
            arr[9] = random.nextInt(max) + 1;
        }
        return arr;
    }

    /**
     * method name: doOneFrame.
     * does one frame of the game
     *
     * @param d draw face
     */

    public void doOneFrame(DrawSurface d) {
        if (this.counterBlocks.getValue() == 0) {
            scoreCounter.increase(100);
            this.running = false;
        }
        if (this.counterBalls.getValue() == 0) {
            if (this.lives.getValue() > 0) {
                this.lives.decrease(1);
                levelInfo.removeAllBalls();
                this.removePaddle();
                this.createPaddle();
                levelInfo.createBall();
                this.createBalls();
                this.runner.run(new CountdownAnimation(this.getSprites(), 3, 2));
            } else {
                lives.decrease(1);
                this.running = false;
            }
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(keyboard, "space", new PauseScreen()));
            this.runner.run(new CountdownAnimation(this.getSprites(), 3, 2));
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

    }

    /**
     * method name shouldStop.
     * return true if the game should be stopped and false if not.
     *
     * @return boolean
     */

    public boolean shouldStop() {
        return !this.running;

    }

    /**
     * method name: run.
     * call the runner run to run the game
     */

    public void run() {
        this.running = true;
        this.runner.run(new CountdownAnimation(this.getSprites(), 3, 2));
        this.runner.run(this);
    }

    /**
     * getter for sprites.
     *
     * @return sprites.
     */

    public SpriteCollection getSprites() {
        return sprites;
    }

    /**
     * getter for counterBlocks.
     *
     * @return counterBlocks
     */

    public Counter getCounterBlocks() {
        return counterBlocks;
    }

    /**
     * getter for counterBalls.
     *
     * @return counterBalls
     */

    public Counter getCounterBalls() {
        return counterBalls;
    }

    /**
     * method name: remove paddle.
     * remove the paddle from the game's lists
     */

    public void removePaddle() {
        this.removeCollidable(this.paddle);
        this.removeSprite(this.paddle);
    }


}


