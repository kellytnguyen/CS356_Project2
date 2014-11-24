import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Newsfeed implements Observer { //Observer Pattern
	private ArrayList<String> tweets;
	
	public Newsfeed() {
		tweets = new ArrayList<String>();
	}
	@Override
	public void update(Observable obj, Object arg) {
		if (arg instanceof String) {
			tweets.add((String) arg);
			//System.out.println("Tweet Observer: Tweet Changed to: " + tweets.size());
		} else {
			//System.out.println("Something else was changed!");
		}
	}

	public ArrayList<String> getTweets() {
		return tweets;
	}

}
