package commandpattern;

public class CommandPattern {
	public static void main(String[] args) {
	      Class sdClass = new Class();

	      RegisterClass registerClassRequest = new RegisterClass(sdClass);
	      WithdrawClass withdrawClassRequest = new WithdrawClass(sdClass);

	      Sys SIS_System = new Sys();
	      SIS_System.takeRegistration(registerClassRequest);
	      SIS_System.takeRegistration(withdrawClassRequest);

	      SIS_System.placeRegistration();
	   }
}