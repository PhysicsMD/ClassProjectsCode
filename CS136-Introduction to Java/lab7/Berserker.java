package lab7;

import java.util.ArrayList;
import java.util.Random;

/**
 * A contestant of Berserker vocation in the arena.
 * @authors Richard Moss, Alenn Wright
 */
public class Berserker extends Contestant{
    Random rand = new Random();
    
    /**
     * Default constructor
     */
    Berserker(){
        ClassName = "Berserker";
        Health = 35;
        Attack = 20;
        DamageType = "Smashing";
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
     * Calculates damage that will be taken based on strengths(fire)/weaknesses(slashing)
     * @param attack values of damage type and damage taken
     * @param attacker the index of the attacking contestant in the arena list
     * @return the damage that will be taken after calculation
     */
    @Override
    public int damageCalc(String[][] attack, int attacker) {
        /*Takes half damge from fire attacks*/
        if(attack[0][0].equals("Fire")) {
            return Integer.valueOf(attack[1][attacker]) / 2;
        }
        /*Takes double damage from slashing attacks*/
        else if(attack[0][0].equals("Slashing")){
            return Integer.valueOf(attack[1][attacker]) * 2;
        }
        /*Takes normal damage from smashing attacks*/
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
    public String[][] getAttack(ArrayList<Contestant> a, int attacker){
        int target = rand.nextInt(6); //hits a random contestant
        while(a.get(target).getHealth() <= 0) {
            target = rand.nextInt(6); //makes sure target is still alive, rechooses if not
        }
        return new String[][] {{this.DamageType, String.valueOf(target)}, {"", String.valueOf(this.Attack)}};
    }
    
    /**
     * The name and status of the Berserker.
     * @return name and status of the contestant
     */
    @Override
    public String toString(){
        if(this.getHealth() <= 0){
            return ("A slain Berserker ");
        }else{
            return ("A raging Berserker ("+this.getHealth()+") ");
        }
    }
}
