package info;

import design.*;

/**
 *
 * @author pungi
 */
public class CheckUser implements Check {

    private Subject user;

    public CheckUser(Subject subjectUser) {
        this.user = subjectUser;
        subjectUser.register(this);
    }

    @Override
    public void update(Composite comp) {
        this.user = comp;
    }
}
