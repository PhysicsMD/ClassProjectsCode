package lab7;

/**
 */
import java.util.ArrayList;
import java.util.Random;
/**
 * A contestant of Wild Mage vocation in the arena.
 * @authors Richard Moss, Alenn Wright
 */
public class WildMage extends Contestant{
    Random rand = new Random();
    
    /**
     * Default constructor, creates health value between 10-60
     */
    WildMage(){
        ClassName = "WildMage";
        Health = rand.nextInt(51)+10;
        Attack = 0;
        DamageType = "Fire";
    }
    
    /**
     * Sets health according to damage received.
     * @param Damage the damage amount to be decremented from health
     * @param attacker the contestant that dealt the damage
     * @return null if not killed, otherwise returns the index of the attacker in the arena array list
     */
    @Override
    public String takeDamage (int Damage, int attacker){
        this.Health -= Damage;
        if (this.Health > 0) {
            return null;
        }
        else {
            return String.valueOf(attacker);
        }
    }
    
    /**
     * Calculates damage that will be taken
     * @param attack values of damage type and damage taken
     * @param attacker the index of the attacking contestant in the arena list
     * @return the damage that will be taken
     */
    @Override
    public int damageCalc(String[][] attack, int attacker) {
        return Integer.valueOf(attack[1][attacker]);
    }
    
    /**
     * Gets the damage type, target(s), and damage to each target, with damage values in second dimension.
     * @param a the array list of contestants in the arena
     * @param attacker the index of this contestant in the arena array list
     * @return a two dimensional string array of damage type, target(s), and damage to each target.
     */
    @Override
    public String[][] getAttack(ArrayList<Contestant> a, int attacker){
        /*Chooses everyone as a target, including self*/
        return new String[][] {{this.DamageType, String.valueOf(0), String.valueOf(1), String.valueOf(2), String.valueOf(3), String.valueOf(4), String.valueOf(5)}, 
            {"", String.valueOf(rand.nextInt(7)), String.valueOf(rand.nextInt(7)), String.valueOf(rand.nextInt(7)), String.valueOf(rand.nextInt(7)), String.valueOf(rand.nextInt(7)), String.valueOf(rand.nextInt(7))}};
    }
    
    /**
     * The name and status of the Wild Mage.
     * @return name and status of the contestant
     */
    @Override
    public String toString(){
        if(this.getHealth() <= 0){
            return ("A dead Mage ");
        }else{
            return ("A wild Mage ("+this.getHealth()+") ");
        }
    }
}
