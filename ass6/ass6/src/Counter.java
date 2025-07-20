/**
 * @author Ori Arad
 */
public class Counter {
    private int number;

    /**
     * the constructor.
     */

    public Counter() {
        this.number = 0;
    }

    /**
     * method name increase.
     * increase the counter by number.
     * @param number the number.
     */

    public void increase(int number) {
        this.number += number;
    }

    /**
     * method name decrease.
     * decrease the counter by number.
     * @param number the number.
     */

    public void decrease(int number) {
        this.number -= number;
    }

    /**
     * getter for number.
     * @return int, number.
     */

    public int getValue() {
        return this.number;
    }
}
