
public class UserTotalButton implements Visitable { //Visitor Pattern

	public UserTotalButton() {}

	@Override
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
