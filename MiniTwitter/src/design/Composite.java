package design;

import info.*;
import java.util.*;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 *
 * @author pungi
 */
public abstract class Composite implements MutableTreeNode, Subject, Visit {

    String name;
    GroupComposite parentComponent = null;
    List<Composite> children = null;
    private ArrayList<Check> obs;

    public Composite() {
        obs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public abstract void printInfo();

    public void add(MutableTreeNode child) {
        if (this.getAllowsChildren()) {
            this.getChildren().add((Composite) child);
        }
    }

    public GroupComposite getRoot() {
        GroupComposite parent = (GroupComposite) this.getParent();
        if (parent == null) {
            return (GroupComposite) this;
        }
        return parent.getRoot();
    }

    public static void treeTraversal(Composite component, Visitor v) {
        component.accept(v);
        if (!component.isLeaf()) {
            for (Composite c : component.getChildren()) {
                treeTraversal(c, v);
            }
        }
    }

    //Observer pattern
    @Override
    public void register(Check newObserver) {
        getObservers().add(newObserver);
        System.out.println("New observer added to component " + this.getName());
    }

    @Override
    public void unregister(Check existingObserver) {
        getObservers().remove(existingObserver);
        System.out.println("Observer removed from component " + this.getName());
    }

    @Override
    public void notifyObserver() {
        for (Check o : getObservers()) {
            o.update(this);
        }
        System.out.println("Observers from component " + this.getName() + " have been notified");
    }

    //Component implements MutableTreeNode so it can be used and displayed in the Tree view     
    @Override
    public void insert(MutableTreeNode child, int i) {
        if (this.getAllowsChildren()) {
            this.getChildren().add(i, (Composite) child);
        }
    }

    @Override
    public void remove(int index) {
        if (!this.isLeaf()) {
            this.getChildren().remove(index);
        }
    }

    @Override
    public void remove(MutableTreeNode node) {
        if (!this.isLeaf()) {
            this.getChildren().remove((Composite) node);
        }
    }

    @Override
    public void setUserObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeFromParent() {
        this.getParentComponent().getChildren().remove(this);
    }

    @Override
    public void setParent(MutableTreeNode newParent) {
        this.setParentComponent((GroupComposite) newParent);
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return this.isLeaf() ? null : this.getChildren().get(childIndex);
    }

    @Override
    public int getChildCount() {
        return this.isLeaf() ? 0 : this.getChildren().size();
    }

    @Override
    public TreeNode getParent() {
        return this.getParentComponent();
    }

    @Override
    public int getIndex(TreeNode node) {
        return -1;
    }

    @Override
    public boolean getAllowsChildren() {
        return (!(this instanceof User));
    }

    @Override
    public boolean isLeaf() {
        return this.getChildren() == null;
    }

    @Override
    public Enumeration children() {
        return this.isLeaf() ? null : (Enumeration) this.getChildren();
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the parentComponent
     */
    public GroupComposite getParentComponent() {
        return parentComponent;
    }

    /**
     * @param parentComponent the parentComponent to set
     */
    public void setParentComponent(GroupComposite parentComponent) {
        this.parentComponent = parentComponent;
    }

    /**
     * @return the children
     */
    public List<Composite> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<Composite> children) {
        this.children = children;
    }

    /**
     * @return the obs
     */
    public ArrayList<Check> getObservers() {
        return obs;
    }

    /**
     * @param observers the obs to set
     */
    public void setObservers(ArrayList<Check> observers) {
        this.obs = observers;
    }
}
