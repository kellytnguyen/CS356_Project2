
public class MessageTotalButton implements Visitable { //Visitor Pattern

	public MessageTotalButton() {}
	
	@Override
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
