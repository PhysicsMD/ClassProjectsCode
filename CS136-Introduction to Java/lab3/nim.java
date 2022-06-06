package lab3;


/* Alenn Wright Lauren Botten
agw73,leb294
NIM-Lab 03
9/19/18
*/
import java.util.Scanner;
import java.util.Random;

public class nim {
    public static void main(String[] args){
	Random rand = new Random();
	int marbles = rand.nextInt(91) + 10;
	int player = rand.nextInt(2);
	start(player, marbles);
    }
    
    public static Integer start(int player, int marbles){
        Random rand = new Random();
	Scanner user = new Scanner(System.in);
        if (marbles > 0){
            //game
            if(player == 0){
                //player
                System.out.println("There are currently "+ Integer.toString(marbles) +" marble(s) in the pile.");
                System.out.print("How many marbles do you wish to remove: ");
                int input = user.nextInt();
                while(input > (Math.ceil(marbles/2)+1)){
                    System.out.print("How many marbles do you wish to remove: ");
                    input = user.nextInt();
                }
                marbles = marbles - input;
                start(1,marbles);
            }else if(player == 1){
                //pc
                int pc = rand.nextInt(2);
                if(pc == 0){
                    int pctake = rand.nextInt(marbles/2+1)+1; 
                    marbles = marbles - pctake;
                    System.out.println("Computer removes "+Integer.toString(pctake)+" marble(s)");
                    start(0,marbles);
                }else{//smart
                    if(marbles > 63){
                        int pctake = marbles - 63;
                        marbles = marbles - pctake;
                        System.out.println("Computer removes "+Integer.toString(pctake)+" marble(s)");
                        start(0,marbles);
                    }else if(marbles > 31){
                        int pctake = marbles - 31;
                        marbles = marbles - pctake;
                        System.out.println("Computer removes "+Integer.toString(pctake)+" marble(s)");
                        start(0,marbles);
                    }else if(marbles > 15){
                        int pctake = marbles - 15;
                        marbles = marbles - pctake;
                        System.out.println("Computer removes "+Integer.toString(pctake)+" marble(s)");
                        start(0,marbles);
                    }else if(marbles > 7){
                        int pctake = marbles - 7;
                        marbles = marbles - pctake;
                        System.out.println("Computer removes "+Integer.toString(pctake)+" marble(s)");
                        start(0,marbles);
                    }else if(marbles > 3){
                        int pctake = marbles - 3;
                        marbles = marbles - pctake;
                        System.out.println("Computer removes "+Integer.toString(pctake)+" marble(s)");
                        start(0,marbles);
                    }else if(marbles == 1){//take one
                        marbles = 0;
                        System.out.println("Computer removes 1 marble");
                        start(0,marbles);
                    }else{
                        int pctake = rand.nextInt(marbles/2)+1; 
                        marbles = marbles - pctake;
                        System.out.println("Computer removes "+Integer.toString(pctake)+" marble(s)");
                        start(0,marbles);
                    }
                }
            }else{
                //woops
                System.out.println("Woops...");
            }
        }else if((player == 1)&&(marbles == 0)){
            System.out.println("User took last marble, Computer WINS!");
            user.close();
        }else if((player == 0) && (marbles == 0)){
            System.out.println("Computer took last marble, User WINS!");
            user.close();
	}else{
            System.out.println("Sorry, there was an error...");
        }
        return null;
    }
}
