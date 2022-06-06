package lab2;


/*Alenn Wright,Jialei Chen
Agw73,jc3592
Lab02
9/12/18
*/
import java.util.Scanner;
public class TimeCalculator
{
	 public static void main(String[] args) {
		 @SuppressWarnings("resource")
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("Enter number of seconds: ");//user prompts
		 int second = Integer.parseInt(scanner.next());//user input
		 if(second < 60)//calculation for less than 60 seconds
		 {
			 System.out.println(second+" seconds is equal to"+second+"second(s).");
		 }
		 
		 else if (second == 60)// 1 minute condition
		 {
			 System.out.println(second+" seconds is equal to 1 minute(s).");
		 }
		 
		 else if (second > 60 && second < 3600)//calculation for less than 1 hour
		 {
			 int minute_1 = (second)/60;
			 int second_1 = (second-minute_1*60);
			 System.out.println(second+" seconds is equal to "+minute_1+" minute(s) and "+second_1+" second(s).");
		 }
		 
		 else if (second == 3600)// 1 hour condition
		 {
			 System.out.println(second+" seconds is equal to 1 hour(s).");
		 }
			 
		 else if (second >3600 && second < 86400)//calculation for less than 60 seconds
		 {
			 int hour_1 = second/3600;
			 int minute_2 = (second-hour_1*3600)/60;
			 int second_2 = (second-hour_1*3600-minute_2*60);
			 System.out.println(second+" seconds is equal to "+hour_1+" hour(s), "+minute_2+" minute(s) and "+second_2+" second(s).");
		 }
		 else if (second == 86400)// 1 day condition
		 {
			 System.out.println(second+" seconds is equal to 1 day(s).");
		 }
		 else if (second > 86400)//calculation for more than 1 day
		 {
			 int day = second/86400;
			 int hour_2 = (second-day*86400)/3600;
			 int minute_3 = (second-day*86400-hour_2*3600)/60;
			 int second_3 = (second-day*86400-hour_2*3600-minute_3*60);
			 System.out.println(second+" seconds is equal to "+day+" day(s), "+hour_2+" hour(s), "+minute_3+" minute(s) and "+second_3+" second(s).");
		 }
	 }
}
 