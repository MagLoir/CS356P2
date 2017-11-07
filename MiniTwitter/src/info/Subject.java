package info;

/**
 *
 * @author pungi
 */
public interface Subject {

    public void register(Check newObs);

    public void unregister(Check existingObs);

    public void notifyObserver();
}
