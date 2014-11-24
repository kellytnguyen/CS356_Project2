import javax.swing.JFrame;
import javax.swing.JOptionPane;


class ButtonVisitor implements Visitor { //Visitor Pattern

	public ButtonVisitor() {}
	
	@Override
	public String visit(UserTotalButton userTotal) {
		String message = "The total amount of users in this program is: ";
		return message;
	}

	@Override
	public String visit(GroupTotalButton groupTotal) {
		String message = "The total amount of groups in this program is: ";
		return message;
	}

	@Override
	public String visit(MessageTotalButton messageTotal) {
		String message = "The total amount of Tweets in this program is: ";
		return message;
	}

	@Override
	public String visit(PositiveTotalButton positiveTotal) {
		String message = "The total percentage of positive Tweets of all users is: ";
		return message;
	}

}
