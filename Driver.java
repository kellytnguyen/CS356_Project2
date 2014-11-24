import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Driver {
	private static Driver instance = null; //Singleton Pattern
	private static Driver driver;
	private ArrayList<User> users;
	private AdminPanel ap;
	private UserGroup root;
	private int groupTotal = 0;
	
	private Driver() {} //Singleton Pattern
	
	public static Driver getInstance() { //Singleton Pattern
		if (instance == null) {
			instance = new Driver();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		driver = Driver.getInstance(); //Singleton Pattern
		
		driver.users = new ArrayList<User>();
		
		//Hard code users for Twitter Simulation.
		driver.addUser("John");
		driver.addUser("Bob");
		driver.addUser("Steve");
		driver.addUser("Stu1");
		driver.addUser("Stu2");
		driver.addUser("Stu3");
		driver.addUser("Stu8");
		driver.addUser("Stu9");
		driver.addUser("Stu10");
		driver.addUser("Stu4");
		driver.addUser("OOstu");
		driver.addUser("PPstu2");
		
		//Hard code groups for Twitter Simulation.
		driver.groupTotal++;
		driver.root = new UserGroup("Root", "This is the Root Group", driver.groupTotal);
		driver.groupTotal++;
		UserGroup cs356 = new UserGroup("CS356", "This is the CS356 Group", driver.groupTotal);
		driver.groupTotal++;
		UserGroup cs356s01 = new UserGroup("CS356Session01", "This is the CS356 Session 01 Group", driver.groupTotal);

		//Hard code members of each group for Twitter Simulation.
		driver.root.add(driver.users.get(0).getID());
		driver.root.add(driver.users.get(1).getID());
		driver.root.add(driver.users.get(2).getID());
		cs356.add(driver.users.get(3).getID());
		cs356.add(driver.users.get(4).getID());
		cs356.add(driver.users.get(5).getID());
		driver.root.add(cs356);
		cs356s01.add(driver.users.get(6).getID());
		cs356s01.add(driver.users.get(7).getID());
		cs356s01.add(driver.users.get(8).getID());
		cs356.add(cs356s01);
		cs356.add(driver.users.get(9).getID());
		driver.root.add(driver.users.get(10).getID());
		driver.root.add(driver.users.get(11).getID());
		
		//Hard code each User to understand what connections are being made more clearly.
		User john = (driver.getUsers().get(0));
		User bob = (driver.getUsers().get(1));
		User steve = (driver.getUsers().get(2));
		User stu1 = (driver.getUsers().get(3));
		User stu2 = (driver.getUsers().get(4));
		User stu3 = (driver.getUsers().get(5));
		User stu8 = (driver.getUsers().get(6));
		User stu9 = (driver.getUsers().get(7));
		User stu10 = (driver.getUsers().get(8));
		User stu4 = (driver.getUsers().get(9));
		User oostu = (driver.getUsers().get(10));
		User ppstu2 = (driver.getUsers().get(11));
		
		//Simulate followings between multiple users.
		john.addObserver(bob.getNewsFeed()); //Bob is following John
		john.addObserver(steve.getNewsFeed()); //Steve is following John
		steve.addObserver(bob.getNewsFeed()); //Bob is following Steve
		
		//John writes a Tweet.
		john.addTweet("Today is a great day!");
		
		//Steve writes a Tweet.
		steve.addTweet("I am happy that I got to see my mom today!");
		
		//Create the AdminPanel and set the Tree View.
		driver.ap = new AdminPanel(driver);
		driver.ap.setTree(driver.root.displayUserInfo());
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	//For the 4 Logistics Buttons on the AdminPanel.
	public void runLogisticsButton(int type) {
		ButtonVisitor bv = new ButtonVisitor(); //Visitor Pattern
		
		//Make all Tweets more easily accessible.
		ArrayList<String> allTweets = new ArrayList<String>();
		for (int i = 0; i < driver.users.size(); i++) {
			allTweets.addAll(driver.getUsers().get(i).getTweets());
		}
		
		//Prep string for Dialog Box.
		String message = "";
		
		//Switch statement to control which button has been clicked.
		switch (type) {
		case 1:
			UserTotalButton utb = new UserTotalButton();
			message = utb.accept(bv) + driver.getUsers().size(); //Visitor Pattern
			break;
		case 2:
			GroupTotalButton gtb = new GroupTotalButton();
			message = gtb.accept(bv) + groupTotal; //Visitor Pattern
			break;
		case 3:
			MessageTotalButton mtb = new MessageTotalButton();
			message = mtb.accept(bv) + allTweets.size(); //Visitor Pattern
			break;
		case 4:
			DecimalFormat df = new DecimalFormat("#.##");
			double positiveTotal = 0.00;
			for (int i = 0; i < allTweets.size(); i++) { //My "positive" words
				if (allTweets.get(i).contains("good") ||
					allTweets.get(i).contains("great") ||
					allTweets.get(i).contains("excellent") ||
					allTweets.get(i).contains("great")) {
					positiveTotal++;
				}
			}
			positiveTotal = positiveTotal / allTweets.size();
			PositiveTotalButton ptb = new PositiveTotalButton();
			message = ptb.accept(bv) + df.format(positiveTotal) + "%"; //Visitor Pattern
			break;
		default:
			System.out.println("Something went wrong!");
			break;
		}
		
		//Display the relevant data.
		JOptionPane.showMessageDialog(new JFrame(), message, "Logistics",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void addUser(String name) {
		users.add(new User(name));
	}
}
