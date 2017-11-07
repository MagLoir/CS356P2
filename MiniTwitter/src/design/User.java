package design;

import info.*;
import java.util.*;

/**
 *
 * @author pungi
 */
public class User extends Composite {

    private Set<User> following;
    private ArrayList<userTweets> tweets;

    public User(String n, GroupComposite p) {
        this.name = n;
        this.parentComponent = p;
        following = new HashSet<>();
        tweets = new ArrayList<>();
    }

    public List<User> getFollowing() {
        return new ArrayList<>(this.following);
    }

    public void addFollowing(String userName) throws Exception {
        if (userName.equals(this.getName())) {
            throw new UnsupportedOperationException("Sorry, can't follow yourself");
        }
        GroupComposite r = this.getRoot();
        User newFollowing = treeSearchTraversal(userName, r);
        if (newFollowing != null) {
            boolean added = this.following.add(newFollowing);
            if (added) {
                System.out.println(this.getName() + " started following: " + newFollowing.getName());
            } else {
                throw new UnsupportedOperationException(this.getName() + " is already following " + newFollowing.getName());
            }
        } else {
            throw new UnsupportedOperationException("Sorry, can't found usersname");
        }
    }

    public userTweets postTweet(String msg) {
        userTweets tweet = new userTweets(msg);
        tweets.add(tweet);
        System.out.println(this.getName() + " posted a tweet");
        return tweet;
    }

    public ArrayList<userTweets> getTweets() {
        return tweets;
    }

    @Override
    public void printInfo() {
        System.out.println("User: " + this.getName());
    }

    //search for the user
    public static User treeSearchTraversal(String name, Composite node) {
        if (node instanceof User && node.getName().equals(name)) {
            return (User) node;
        }
        User correctNode = null;
        if (!node.isLeaf()) {
            for (Composite c : node.getChildren()) {
                if (correctNode != null) {
                    break;
                }
                correctNode = treeSearchTraversal(name, c);
            }
        }
        return correctNode;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(this.getName(), user.getName());
    }

    @Override
    public int hashCode() {
        int result = 20;
        result = 31 * result + this.getName().hashCode();
        result = 31 * result + this.getParentComponent().hashCode();
        return result;
    }

}
