package lab7;

/**
 */
import java.util.ArrayList;

/**
 * A contestant in the arena.
 * @authors Richard Moss, Alenn Wright
 */
public class Contestant{
    String ClassName, DamageType;
    int Health, Attack;
    
    /**
     * Default constructor
     */
    Contestant(){
        ClassName = "";
        Health = 0;
        Attack = 0;
        DamageType = "";
    }
    
    /**
     * Sets health according to damage received.
     * @param damage the damage amount to be decremented from health
     * @param attacker the contestant that dealt the damage
     * @return null if no action is taken after death
     */
    public String takeDamage(int damage, int attacker){
        this.Health -= damage;
        return null;
    }
    
    /**
     * Gets the amount of health left.
     * @return health left
     */
    public int getHealth(){
        return Health;
    }
    
    /**
     * Calculates damage that will be taken based on strengths/weaknesses
     * @param attack values of damage type and damage taken
     * @param attacker the index of the attacking contestant in the arena list
     * @return the damage that will be taken
     */
    public int damageCalc(String[][] attack, int attacker) {
        return 0;
    }
    
    /**
     * Gets the damage type, target(s), and damage to each target, with damage values in second dimension.
     * @param a the array list of contestants in the arena
     * @param attacker the index of this contestant in the arena array list
     * @return a two dimensional string array of damage type, target(s), and damage to each target.
     */
    public String[][] getAttack(ArrayList<Contestant> a,int attacker){
        int target = 0;
        return new String[][] {{this.DamageType, String.valueOf(target)}, {"", String.valueOf(this.Attack)}};
    }
    
    /**
     * The name and status of the contestant, default is "no one."
     * @return name and status of the contestant
     */
    @Override
    public String toString(){
        return "no one.";
    }
    
    /**
     * Description of the contestant's status.
     * @return 
     */
    public String getDescription(){
        return this.toString();
    }

}
