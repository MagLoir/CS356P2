package info;

import design.*;
import java.util.*;

/**
 *
 * @author pungi
 */
public class VisitorTweet implements Visitor {

    private int tweets = 0;
    private int positive = 0;

    public int getTotalTweets() {
        return tweets;
    }

    /**
     *
     * @return @throws IllegalArgumentException
     */
    public int getPositiveTwitter() throws IllegalArgumentException {
        if (tweets == 0) {
            throw new IllegalArgumentException("You have not posted any tweets");
        }
        return (int) Math.ceil(((double) positive / tweets) * 100);
    }

    @Override
    public void visit(User user) {
        ArrayList<userTweets> userTweets = user.getTweets();
        tweets += userTweets.size();

        userTweets.stream().filter((t) -> (t.isPositive())).forEachOrdered((_item) -> {
            this.positive += 1;
        });
    }

    @Override
    public void visit(GroupComposite group) {
    }
}
