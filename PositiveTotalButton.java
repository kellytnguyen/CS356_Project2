
public class PositiveTotalButton implements Visitable { //Visitor Pattern

	public PositiveTotalButton() {}
	
	@Override
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
