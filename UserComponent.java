import java.util.ArrayList;

public abstract class UserComponent { //Composite Pattern
	public void add(UserComponent newUserComponent) {
		throw new UnsupportedOperationException();
	}
	public UserComponent getComponent(int componentIndex) {
		throw new UnsupportedOperationException();
	}
	public String getUserID() {
		throw new UnsupportedOperationException();
	}
	public String displayUserInfo() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
}
