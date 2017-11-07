package design;

import info.*;
import java.util.*;

/**
 *
 * @author pungi
 */
public class GroupComposite extends Composite {

    public GroupComposite(String name, GroupComposite parent) {
        this.name = name;
        this.parentComponent = parent;
        this.children = new ArrayList<>();
    }

    @Override
    public void printInfo() {
        System.out.println("GroupComponent: " + this.getName());
        if (!this.isLeaf()) {
            this.getChildren().forEach((c) -> {
                c.printInfo();
            });
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
