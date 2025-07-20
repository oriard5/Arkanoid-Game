/**
 * @author Ori Arad
 */
public interface HitNotifier {
    /**
     * method name: addHitListener
     * adds HitListener to the list.
     *
     * @param hi HitListener
     */
    void addHitListener(HitListener hi);

    /**
     * method name: removeHitListener
     * remove HitListener from the list.
     *
     * @param hi HitListener
     */

    void removeHitListener(HitListener hi);
}
