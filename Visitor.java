
interface Visitor { //Visitor Pattern
	public String visit(UserTotalButton userTotal);
	public String visit(GroupTotalButton groupTotal);
	public String visit(MessageTotalButton messageTotal);
	public String visit(PositiveTotalButton positiveTotal); 
}
