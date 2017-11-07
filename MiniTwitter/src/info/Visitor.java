package info;

import design.GroupComposite;
import design.User;

/**
 *
 * @author pungi
 */
public interface Visitor {

    public void visit(User user);

    public void visit(GroupComposite group);

}
