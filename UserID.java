
public class UserID extends UserComponent { //Composite Pattern
	private String id;
	
	public UserID (String id) {
		this.id = id;
	}
	
	public String getUserID() {
		return id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String displayUserInfo() {
		String temp = "";
		temp += "- " + getUserID() + "!";
		
		return temp;
	}
}
