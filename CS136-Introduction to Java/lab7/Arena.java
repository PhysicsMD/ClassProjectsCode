package lab7;
/*
*/
import java.util.ArrayList;
/**
 * 
 * @authors Richard Moss, Alenn Wright
 */
class Arena {

    ArrayList<Contestant> list; //arrayList that holds the contestants
    /**
     * Constructor for the Arena that initializes the array list.
     */
    public Arena() {
        list = new ArrayList<Contestant>();
    }

    /**
     * Adds to the arena array list, list.
     * @param contestant one of the competitors being added.
     */
    public void add(Contestant contestant) {
        list.add(contestant);
    }

    /**
     * Plays a round of the arena.
     */
    public void playRound() {
        String[][] printer1; //variable holding the returned value of a getAttack method
        String[][] printer2; //secondary variable holding the returned value of a getAttack method
        int damage = 0;
        /*Loop to display the attack of every alive contestant*/
        for(int i = 0; i<list.size(); i++) {
            /*Only applies a contestant's attack if they have health left*/
            if(list.get(i).getHealth() > 0) {

                printer1 = list.get(i).getAttack(list, i); //the attack(s) of the current contestant
                /*Second loop to display every attack of a contestant, in case they attack multiple times in a turn*/
                for(int j = 1; j < printer1[0].length; j++){
                    String target = null; //initializing a variable that may change when a contestant takes damage
                    /*Makes sure the target of the attack has health*/
                    if(list.get(Integer.valueOf(printer1[0][j])).getHealth() > 0) {

                        System.out.print(list.get(Integer.valueOf(printer1[0][j])).toString()); //prints the target's current toString
                        damage = list.get(Integer.valueOf(printer1[0][j])).damageCalc(printer1, j); //calculates the damage dealt to target based on strengths/weaknesses
                        System.out.println("takes "+ damage +" "+ printer1[0][0] +" damage from "+ list.get(i).toString()); //displays the damage taken, damage type, and attacker's toString
                        target = list.get(Integer.valueOf(printer1[0][j])).takeDamage(damage, i); //sets target's new health, stores return statement
                    }
                    /*If takeDamage returns the attacker's index in list, and the attacker did not target themself*/
                    if (target != null && !(Integer.valueOf(printer1[0][j]).equals(Integer.valueOf(target)))) {
                        printer2 =list.get(Integer.valueOf(printer1[0][j])).getAttack(list, Integer.valueOf(printer1[0][j])); //set the secondary getAttack varialbe
                        System.out.print(list.get(i).toString()); //print the original attacker's name
                        damage = list.get(i).damageCalc(printer2, j); //calculate the damage to be dealt to the original attacker
                        System.out.println("takes "+ damage +" "+ printer2[0][0] +" damage from "+ list.get(Integer.valueOf(printer1[0][j])).toString()); //print the aftermath damage
                        list.get(Integer.valueOf(target)).takeDamage(damage, i); //decrement the original attacker's health
                    }
                }
            }
            /*If there is a winner*/
            if(this.getWinner() != null) {
                break; //break from this round
            }
        }
        System.out.println();
    }

    /**
     * Prints the names and health of all contestants.
     * @return a new line
     */
    public String getDescription() {
        System.out.println("In the Arena...");
        /*Iterate through the list, print every toString*/
        for(Contestant i: list) {
            System.out.println(i.toString());
        }
        return "\n";
    }

    /**
     * Sees if there is a winner in the arena.
     * @return the winning contestant if one remains, null if multiple remain, or "no one" if every one has died.
     */
    public Contestant getWinner() {
        int hp_count = 0;
        ArrayList<Contestant> alive = new ArrayList<Contestant>();
        /*Iterates through the list to check if anyone has health left*/
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).getHealth() > 0) {
                hp_count++;
                alive.add(list.get(i)); //adds each contestant with health left to this array list
            }
        }
        /*Returns null if multiple contestants have health left*/
        if(hp_count > 1) {
            return null;
        }
        /*If every contestant is dead, return the default contestant toString stating "no one."*/
        else if(hp_count == 0) {
            return new Contestant();
        }
        
        return alive.get(0); //return the winner
    }

}
