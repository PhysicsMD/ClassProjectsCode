package lab7;

/**
 */
import java.util.ArrayList;
import java.util.Random;
/**
 * A contestant of Warrior vocation in the arena.
 * @authors Richard Moss, Alenn Wright
 */
public class Warrior extends Contestant{
    Random rand = new Random();
    
    /**
     * Default constructor, creates health value between 20-40
     */
    Warrior(){
        ClassName = "Warrior";
        Health = rand.nextInt(21)+20;
        Attack = 0;
        DamageType = "Slashing";
    }
    
    /**
     * Sets health according to damage received.
     * @param Damage the damage amount to be decremented from health
     * @param attacker the contestant that dealt the damage
     * @return null if no action is taken after death
     */
    @Override
    public String takeDamage(int Damage, int attacker){
        this.Health -= Damage;
        return null;
    }
    
    /**
     * Calculates damage that will be taken based on strengths/weaknesses
     * @param attack values of damage type and damage taken
     * @param attacker the index of the attacking contestant in the arena list
     * @return the damage that will be taken
     */
    @Override
    public int damageCalc(String[][] attack, int attacker) {
        /*Always takes all damage from a fire attack*/
        if(attack[0][0].equals("Fire")) {
            return Integer.valueOf(attack[1][attacker]);
        }
        
        int dodge = rand.nextInt(4);
        /*Has a 1/4 chance of doging a smashing/slashing attack and taking no damage*/
        if(dodge == 3) {
            return 0;
        }
        else {
            return Integer.valueOf(attack[1][attacker]);
        }
    }
    
    /**
     * Gets the damage type, target(s), and damage to each target, with damage values in second dimension.
     * @param a the array list of contestants in the arena
     * @param attacker the index of this contestant in the arena array list
     * @return a two dimensional string array of damage type, target(s), and damage to each target.
     */
    @Override
    public String[][] getAttack(ArrayList<Contestant> a,int attacker){
        int target = 0;
        this.Attack = rand.nextInt(7) + 10; //random damage
        /*Iterates through arena array list to choose target with highest remaining health*/
        for(int i =1; i<a.size(); i++) {
            /*Makes sure Warrior cannot hit self*/
            if(i == attacker) {
                //nothing
            }
            else if(a.get(i).getHealth() > a.get(target).getHealth()) {
                target = i;
            }
        }
        return new String[][] {{this.DamageType, String.valueOf(target)}, {"", String.valueOf(this.Attack)}};
    }
    
    /**
     * The name and status of the Warrior.
     * @return name and status of the contestant
     */
    @Override
    public String toString(){
        if(this.getHealth() <= 0){
            return ("A slain Warrior ");
        }else{
            return ("A disciplined Warrior ("+this.getHealth()+") ");
        }
    }
}
