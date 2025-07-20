import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ori Arad
 */
public class Game {
    /**
     * the main.
     * the function creates and object of the class Game,
     * and calls his methods initialize and run it.
     *
     * @param args that indicts the list of levels that will be in the game.
     *             if there is no arguments the game will run with the four levels.
     */

    public static void main(String[] args) {
        int width = 800;
        int height = 600;
        int frameSecond = 60;
        GUI gui = new GUI("title", width, height);
        KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        AnimationRunner runner = new AnimationRunner(gui, frameSecond);
        List<LevelInformation> level = new ArrayList<>();
        if (args.length == 0) {
            level.add(new DirectHit());
            level.add(new WideEasy());
            level.add(new Green3());
            level.add(new FinalFour());
        } else {

            for (String s : args) {
                if (s.equals("1")) {
                    level.add(new DirectHit());
                }
                if (s.equals("2")) {
                    level.add((new WideEasy()));
                }
                if (s.equals("3")) {
                    level.add(new Green3());
                }
                if (s.equals("4")) {
                    level.add(new FinalFour());
                }

            }
        }
        GameFlow gameFlow = new GameFlow(runner, keyboardSensor);
        gameFlow.runLevels(level);
    }
}
