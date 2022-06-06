package lab2;


/*Alenn Wright,Jialei Chen
Agw73,jc3592
Lab02
9/12/18
*/
import java.util.Scanner;
class TaxCalculator{
	public static void main(String[] args){
		String Tax = ""; // Sets the tax to a string type so that it is easier to implement
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your status (Single or Married): "); //user prompt
		String Status = scanner.next();//user input
		System.out.print("Enter your taxable income: ");//user prompt
		Float Income = Float.valueOf(scanner.next());//user input
		
		if (Status.equals("Single")){
			if(Income >= 32000){//calculation for single and greater then 32,000 income
				Tax = Double.toString(Math.round(((4400 + Income*.25)*100.0))/100.0);
				System.out.println("You owe "+Tax+" in tax.");
			}
			else if(Income >= 8000){//calculation for single and greater then 8,000 income
				Tax = Double.toString(Math.round(((800 + Income*.15)*100.0))/100.0);
				System.out.println("You owe "+Tax+" in tax.");
			}else{//calculation for poor single tax
				Tax = Double.toString(Math.round(((Income*.1)*100.0))/100.0);
				System.out.println("You owe "+Tax+" in tax.");
			}
		}
		else if(Status.equals("Married")){
			if(Income >= 64000){//calculation for married and greater then 64,000 income
				Tax = Double.toString(Math.round(((8800 + Income*.25)*100.0))/100.0);
				System.out.println("You owe "+Tax+" in tax.");
			}
			else if(Income >= 16000){//calculation for married and greater then 16,000 income
				Tax = Double.toString(Math.round(((1600 + Income*.15)*100.0))/100.0);
				System.out.println("You owe "+Tax+" in tax.");
			}else{//calculation for poor married
				Tax = Double.toString(Math.round(((Income*.1)*100.0))/100.0);
				System.out.println("You owe "+Tax+" in tax.");
			}
		}
		else{//not a mentioned status
			System.out.println("Sorry, Not a valid status.");
		}
}
}