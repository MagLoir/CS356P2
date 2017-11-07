package design;

import javax.swing.JTree;
import javax.swing.tree.TreeNode;

/**
 *
 * @author pungi
 */
public class TreeView {

    private JTree tree;
    private TreeNode root;

    public TreeView() {

        Composite r = new GroupComposite("Root", null);
        this.root = r;

        Composite user1Node = new User("John", (GroupComposite) r);
        Composite user2Node = new User("Bob", (GroupComposite) r);
        Composite user3Node = new User("Steve", (GroupComposite) r);

        r.add(user1Node);
        r.add(user2Node);
        r.add(user3Node);

        GroupComposite cs356 = new GroupComposite("CS356", (GroupComposite) r);
        r.add(cs356);

        cs356.add(new User("Eric", cs356));
        cs356.add(new User("Frank", cs356));
        cs356.add(new User("Sarah", cs356));
        cs356.add(new User("Dorothy", cs356));

        // this will create a tree that be passed in the root
        tree = new JTree(r);
    }

    public JTree getTree() {
        return tree;
    }

    public TreeNode getRoot() {
        return root;
    }

}
