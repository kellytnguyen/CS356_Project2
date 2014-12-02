import java.util.ArrayList;
import java.util.Iterator;

public class UserGroup extends UserComponent { //Composite Pattern
	ArrayList userComponents = new ArrayList();
	String groupName;
	String groupDesc;
	long creationTime; //Project #3
	int count;
	
	public UserGroup(String groupName, String groupDesc, int count) {
		this.groupName = groupName;
		this.groupDesc = groupDesc;
		this.count = count;
		creationTime = System.currentTimeMillis();
		System.out.println(groupName + " was created at " + getCreationTime() + " ms."); //Project #3
	}
	
	//Project #3
	public long getCreationTime() {
		return creationTime;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	public String getGroupDesc() {
		return groupDesc;
	}
	public void add(UserComponent newUserComponent) {
		userComponents.add(newUserComponent);
	}
	public UserComponent getComponent(int componentIndex) {
		return (UserComponent)userComponents.get(componentIndex);
	}
	
	//'!' symbols are for parsing later.
	public String displayUserInfo() {
		String temp = "";
		for(int i = 0; i < count; i++) {
			temp += ">";
		}
		temp += getGroupName() + "!";
		
		Iterator userIterator = userComponents.iterator();
		while (userIterator.hasNext()) {
			UserComponent userInfo = (UserComponent) userIterator.next();
			for(int i = 0; i < count; i++) {
				temp += "  ";
			}
			temp += userInfo.displayUserInfo();
		}
		
		temp += "!";
		return temp;
	}	
}
