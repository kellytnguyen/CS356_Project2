
public class GroupTotalButton implements Visitable { //Visitor Pattern

	public GroupTotalButton() {}
	
	@Override
	public String accept(Visitor visitor) {		
		return visitor.visit(this);
	}
}
