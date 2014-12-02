import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AdminPanel extends JFrame implements ActionListener {
	private Driver driver; 
	private String[] inList;
	private boolean valid = true;
	
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JList list;
    private JScrollPane spList;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private DefaultListModel model;
    
    public AdminPanel(Driver driver) {
        initComponents();
        this.driver = driver;
    }
                      
    private void initComponents() {
    	this.setTitle("Kelly Nguyen's Twitter Application");
        jScrollPane1 = new JScrollPane();
        
        //Create a Jlist to store the Tree View.
        model = new DefaultListModel();
        list = new JList(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        spList = new JScrollPane(list);
        spList.setPreferredSize(new Dimension(200, 350));
        
        //Add a List Listener to the Tree View to handle user selection.
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent le) {
                int idx = list.getSelectedIndex();
                String temp = inList[idx];
                String groupTemp;
           
                if (temp.contains(">")) {
                	//If subject clicked is a Group.
                	groupTemp = temp.replaceAll("[^A-Za-z0-9]", "");
                	jTextField2.setText(groupTemp);
                	jTextField1.setText("");
                } else {
                	//If subject clicked is a User.
                	temp = temp.replaceAll("[^A-Za-z0-9]", "");
                  	jTextField1.setText(temp);
                }
            }
          });
        
        //To update when user clicks on something in the JList.
        jLabel1 = new JLabel("User ID");
        jLabel2 = new JLabel("Group ID");
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        
        //Disable the Add User and Add Group Buttons.
        jButton1 = new JButton("Check User Names");
        jButton1.addActionListener(this);
        jButton2 = new JButton("Check Last Updated User");
        jButton2.addActionListener(this);
        
        //To open the User View of currently clicked subject in JList.
        jButton3 = new JButton("Open User View");
        jButton3.addActionListener(this);
        
        //Buttons to handle the Logistics of the Twitter Simulation.
        jButton4 = new JButton("Show User Total");
        jButton4.addActionListener(this);
        jButton5 = new JButton("Show Group Total");
        jButton5.addActionListener(this);
        jButton6 = new JButton("Show Messages Total");
        jButton6.addActionListener(this);
        jButton7 = new JButton("Show Positive Percentage");
        jButton7.addActionListener(this);
        
        //Close window accordingly.
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jScrollPane1.setViewportView(spList);

        //Handle JFrame layout.
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(jButton6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jButton7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(jTextField2, GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton7)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
        
        //Set the frame to be visible.
        this.setVisible(true);
    }   
    
    public void setTree(String tree) {
    	//Add contents to JList to handle Tree View.
    	model.removeAllElements();
    	inList = tree.split("!");
    	for (int i = 0; i < inList.length; i++) {
    		model.addElement(inList[i]);
    	}
    }
    
    public void actionPerformed(ActionEvent ae) { 
		//Create a Switch Statement to handle the user's Button selections on the Admin Panel.
		String button = ae.getActionCommand();
	        
		if (button.equals("Open User View")) {	
			new UserView(jTextField1.getText(), driver);
		} else if (button.equals("Show User Total")) {
			driver.runLogisticsButton(1);
		} else if (button.equals("Show Group Total")) {
			driver.runLogisticsButton(2);
		} else if (button.equals("Show Messages Total")) {
			driver.runLogisticsButton(3);
		} else if (button.equals("Show Positive Percentage")) {
			driver.runLogisticsButton(4);
		} else if (button.equals("Check User Names")) { //Project #3
			//Grab the UserIDs (Strings) of each User in Application
			ArrayList<User> temp = driver.getUsers();
			ArrayList<String> usernames = new ArrayList<String>();
			for (int i = 0; i < temp.size(); i++) {
				usernames.add(driver.getUsers().get(i).getID().getUserID());
			}
			
			//Sort the new ArrayList.
			Collections.sort(usernames);
			
			//Check for Duplicates.
			for (int i = 1; i < usernames.size(); i++) {
				String previous = usernames.get(i - 1);
				if (usernames.get(i).equals(previous)) {
					valid = false;
				}
			}
			
			//Check for Spaces.
			for (int i = 0; i < usernames.size(); i++) {
				if (usernames.get(i).contains(" ")) {
					valid = false;
				}
			}
			
			//Prompt the proper message.
			String message;
			if (valid) {
				message = "All Usernames are valid!";
			} else {
				message = "There is an invalid Username in the program!";
			}
			
			JOptionPane.showMessageDialog(new JFrame(), message, "Check for Valid Usernames",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (button.equals("Check Last Updated User")) { //Project #3
			//Grab the Users ArrayList.
			ArrayList<User> temp = driver.getUsers();
			ArrayList<Long> times = new ArrayList<Long>();
			for (int i = 0; i < temp.size(); i++) {
				times.add(driver.getUsers().get(i).getLastUpdateTime());
			}
			
			//Create additional Array to Sort.
			ArrayList<Long> toSort = new ArrayList<Long>();
			for (int i = 0; i < times.size(); i++) {
				toSort.add(times.get(i));
			}
			
			Collections.sort(toSort);
			
			//Grab the index of the user with the most recently updated User.
			int user = times.indexOf(toSort.get(toSort.size() - 1));

			JOptionPane.showMessageDialog(new JFrame(), temp.get(user).getID().getUserID() + 
					" was the last updated User.", "Check for Last Updated User",
					JOptionPane.INFORMATION_MESSAGE);
		}
    }               
}
