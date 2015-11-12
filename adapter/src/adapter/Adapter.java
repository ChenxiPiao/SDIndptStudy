package adapter;

public class Adapter {
	   public static void main(String[] args) {
	      CourseReminder courseReminder = new CourseReminder();

	      courseReminder.remind("Operating Systems", "MR 2:00 PM - 3:50 PM");
	      courseReminder.remind("Software Development", "MR 10:00 AM - 11:50 AM");
	      courseReminder.remind("HCI Usability", "MR 4:00 PM - 5:50 PM ");
	      courseReminder.remind("Capstone", "MR 10:00 AM - 11:50 AM");
	      courseReminder.remind("Business Issues", "W 2:00 PM - 4:50 PM");
	   }
	}