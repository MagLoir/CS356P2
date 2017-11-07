package design;

/**
 *
 * @author pungi
 */
public class userTweets {

    private String message;
    private boolean positive = false;

    public userTweets(String msg) {
        this.message = msg;
        checkPositive();
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isPositive() {
        return positive;
    }

    private void checkPositive() {
        String[] positiveWords = {"wonderful", "fantastic", "yes", "superb",
            "amazing", "awesome", "sweet"};
        for (String word : positiveWords) {
            if (message.toLowerCase().contains(word)) {
                this.positive = true;
                return;
            }
        }
    }
}
