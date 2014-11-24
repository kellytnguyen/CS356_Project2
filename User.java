import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class User extends Observable { //Observer Pattern
	private UserID id;
	private ArrayList<String> tweets;
	private Newsfeed newsfeed;
	
	public User(String id) {
		this.id = new UserID(id);
		tweets = new ArrayList<String>();
		newsfeed = new Newsfeed();
		
		//Make the user also a follower of himself/herself (to display his/her Tweets too).
		addObserver(this.getNewsFeed());
		addTweet("This is " + this.id.getUserID() + "'s First Tweet!");
	}
	
	public Newsfeed getNewsFeed() {
		return newsfeed;
	}
	public UserID getID () {
		return id;
	}
	
	public ArrayList<String> getTweets() {
		return tweets;
	}
	
	public String getTweet(int index) {
		return tweets.get(index);
	}
	
	public void setID(String id) {
		this.id.setID(id);
	}
	
	public void addTweet(String tweet) {
		String temp = this.getID().getUserID() + ":  " + tweet + "  ";
		tweets.add(temp);
		setChanged(); //Observer Pattern
		notifyObservers(temp); //Observer Pattern 
	}
	
}
