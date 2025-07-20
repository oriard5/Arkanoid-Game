import biuoop.KeyboardSensor;

import java.util.List;

/**
 * @author Ori Arad
 */
public class GameFlow {
    private Counter scoreCounter;
    private AnimationRunner runner;
    private KeyboardSensor keyboard;

    private Counter lives;

    /**
     * the constructor.
     *
     * @param runner   AnimationRunner.
     * @param keyboard KeyboardSensor.
     */

    public GameFlow(AnimationRunner runner, KeyboardSensor keyboard) {
        this.keyboard = keyboard;
        this.scoreCounter = new Counter();
        this.runner = runner;
        this.lives = new Counter();
        lives.increase(5);
    }

    /**
     * method name : runLevels
     * runs each level in the levels list.
     *
     * @param levels levels list
     */

    public void runLevels(List<LevelInformation> levels) {
        int count = 0;
        String str;


        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, scoreCounter, runner, keyboard, lives);
            level.initialize();
            while (level.getCounterBlocks().getValue() > 0 && lives.getValue() >= 0) {
                level.run();
            }
            if (lives.getValue() < 0) {
                break;
            }
            // count the number of levels the user entered
            count++;
        }
        if (count == levels.size() && lives.getValue() >= 0) {
            str = "You win! Your Score is: ";
        } else {
            str = "Game Over. Your Score is: ";
        }
        EndScreen end = new EndScreen(str, scoreCounter);
        KeyPressStoppableAnimation stoppableAnimation =
                new KeyPressStoppableAnimation(keyboard, "space", end);
        runner.run(stoppableAnimation);
        runner.getGui().close();
    }
}
