import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class User extends Observable { //Observer Pattern
	private UserID id;
	private ArrayList<String> tweets;
	private Newsfeed newsfeed;
	private long creationTime;
	private long lastUpdateTime;
	private TimeObserver timeObserver; //Project #3
	
	public User(String id) {
		this.id = new UserID(id);
		tweets = new ArrayList<String>();
		newsfeed = new Newsfeed();
		creationTime = System.currentTimeMillis();
		timeObserver = new TimeObserver();
		
		//Make the user also a follower of himself/herself (to display his/her Tweets too).
		addObserver(this.getNewsFeed());
		addTweet("This is " + this.id.getUserID() + "'s First Tweet!");
	}
	
	//Project #3
	public TimeObserver getTimeObserver() {
		return timeObserver;
	}
	
	public long getLastUpdateTime() {
		return lastUpdateTime;
	}
	public long getCreationTime() {
		return creationTime;
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
		updateTime();
		String temp = this.getID().getUserID() + ":  " + tweet + " (" + lastUpdateTime + "ms)  ";
		tweets.add(temp);
		setChanged(); //Observer Pattern
		notifyObservers(temp); //Observer Pattern 
	}
	
	//Project #3
	public void updateTime() {
		lastUpdateTime = System.currentTimeMillis();
		setChanged(); //Observer Pattern
		notifyObservers(lastUpdateTime); //Observer Pattern 
	}
	
}
