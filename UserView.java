import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

public class UserView extends JFrame implements ActionListener {
	private Driver driver;
	int currentUserIndex = 0;
    ArrayList<String> temp;
    
	private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;
    private JTextArea jTextArea2;
    private JTextField jTextField1;
    
    public UserView(String name, Driver driver) {
    	this.driver = driver;
        initComponents(name);
    }
                        
    private void initComponents(String name) {
    	//Find the current User this User View is viewing.
		for (int i = 0; i < driver.getUsers().size(); i++) {
			if (driver.getUsers().get(i).getID().getUserID().equals(name)) {
				currentUserIndex = i;
				break;
			};
		}

		//Add Labels, Buttons, ScrollPanes, and TextAreas.
        jLabel2 = new JLabel(name);
        jButton1 = new JButton("Follow a User");
        jButton1.addActionListener(this);
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        
        //Get the Tweets of the Current User.
        temp = (driver.getUsers().get(currentUserIndex)).getNewsFeed().getTweets();
        String followingString = "";
        for (int i = 0; i < temp.size(); i++) {
        		followingString += temp.get(i) + "\n";
        }
        
        //Parse the String to display the Users that the User is following. 
        String[] newArray = followingString.split("  ");
        String newString = "";
        for (int i = 0; i < newArray.length; i++) {
        	String temp = newArray[i];
        	temp = temp.replaceAll("[^A-Za-z0-9]", "");
        	
        	//If the string doesn't already contain the Following User ID
        	if (!newString.contains(temp)) {
        		newString += temp + "\n";
        	}
        	i++;
        }
        
        //Display the Followings of the current User.
        jTextArea1.setText("List View (Current Following): \n" + newString);
        
        //Create the Textfield, Buttons, and ScrollPane.
        jTextField1 = new JTextField("Tweet Here");
        jButton2 = new JButton("Tweet");
        jButton2.addActionListener(this);
        jScrollPane2 = new JScrollPane();
        
        //Get all Tweets and display accordingly.
        String listString = "";
        for (int i = 0; i < temp.size(); i++) {
        	listString += temp.get(i) + "\n";
        }
        jTextArea2 = new JTextArea("List View (NewsFeed):\n" + listString);

        //Set the default close operation.
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Modify layout of JFrame.
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        
        //Set this JFrame to visible.
        this.setVisible(true);
    }                     

    public void actionPerformed(ActionEvent ae) { 
		//Create a Switch Statement to handle the user's Button selections.
		String button = ae.getActionCommand();
		
		if (button.equals("Follow a User")) {
			new FollowUser(driver, jLabel2.getText());
			this.setVisible(false);
		} else if (button.equals("Tweet")) {
			driver.getUsers().get(currentUserIndex).addTweet(jTextField1.getText());
			this.setVisible(false);
		}
		
    }

                   
    
                
}
