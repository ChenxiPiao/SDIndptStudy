package mediatorpattern;
import java.util.Date;

public class ClassAnnouncement {
	public static void showAnnouncement(User user, String announcement){
	      System.out.println(new Date().toString() + " [" + user.getName() + "] : " + announcement);
	   }
}
