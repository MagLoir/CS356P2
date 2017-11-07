package info;

import design.GroupComposite;
import design.User;

/**
 *
 * @author pungi
 */
public class VisitorComp implements Visitor {

    private int user = 0;
    private int group;

    public VisitorComp() {
        this.group = 0;
    }

    public int getTotalUsers() {
        return user;
    }

    public int getTotalGroups() {
        return group;
    }

    @Override
    public void visit(User user) {
        this.user += 1;
    }

    @Override
    public void visit(GroupComposite group) {
        this.group += 1;
    }
}
