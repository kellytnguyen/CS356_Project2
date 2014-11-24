import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class FollowUser extends JFrame implements ActionListener {
    private Driver driver;
    String currentUser;
    
    private JButton jButton1;
    private JLabel jLabel1;
    private JTextField jTextField1;
      
    public FollowUser(Driver driver, String currentUser) {
    	this.driver = driver;
    	this.currentUser = currentUser;
        initComponents();
    }
                     
    private void initComponents() {
    	//Create labels, Buttons, and TextFields.
        jLabel1 = new JLabel("Enter a User ID to Follow");
        jTextField1 = new JTextField();
        jButton1 = new JButton("Follow User ID");
        jButton1.addActionListener(this);

        //Set Default Close Operation.
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Modify the layout of the JFrame.
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(128, 128, 128))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        
        //Set the JFrame to visible.
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) { 
		//Create a Switch Statement to handle the user's Button selections.
		String button = ae.getActionCommand();
		
		if (button.equals("Follow User ID")) {
			//Identify the current User index.
			int currentUserIndex = 0;
			for (int i = 0; i < driver.getUsers().size(); i++) {
				if (driver.getUsers().get(i).getID().getUserID().equals(currentUser)) {
					currentUserIndex = i;
					break;
				};
			}
			
			//Identify the index of the User the current User wants to follow
			int toFollowIndex = 0;
			for (int i = 0; i < driver.getUsers().size(); i++) {
				if (driver.getUsers().get(i).getID().getUserID().equals(jTextField1.getText())) {
					toFollowIndex = i;
					break;
				};
			}
			
			//Follow the desired User accordingly. 
			driver.getUsers().get(toFollowIndex).addObserver(driver.getUsers().get(currentUserIndex).getNewsFeed());
			
			//Set the JFrame to not visible.
			this.setVisible(false);
		} 
		
    }

                     
}
