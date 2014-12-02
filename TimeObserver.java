import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

//Project #3
public class TimeObserver implements Observer{
	private String lastUpdateTime;
	
	public TimeObserver() {
		lastUpdateTime = String.valueOf(System.currentTimeMillis());
	}
	@Override
	public void update(Observable obj, Object arg) {
		if (arg instanceof String) {
			lastUpdateTime = ((String) arg);
			//System.out.println("Time Observer: Time Changed to: " + lastUpdateTime);
		} else {
			//System.out.println("Something else was changed!");
		}
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}
}
