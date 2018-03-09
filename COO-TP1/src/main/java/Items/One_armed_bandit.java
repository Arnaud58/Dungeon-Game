package Items;
import Action.MapAction;
import Characters.*;

/**
 * @author rougetet and lefevere
 * Create a trader with the player
 */
public class One_armed_bandit implements Items {
    
    
    private int value;
	
	/**
	 * Create a One-armed_bandit that is a man that give you a random object 
     * in echange of a mont of Gold
	 * @param value The value of gold you need to pay the bandit
	 */
	public One_armed_bandit(int value) {
		this.value=value;
	}
	
	/**
	 * Give a item to the player in echange of gold
     * if the player have not enought gold, nothing append
	 * @param p The player that trade with the bandit
	 */
	public void isUsedBy(Player p) {
        if (p.getGold()>this.value) {
            int chose = (int) Math.floor(Math.random()*2);
        
            if (chose==0) {
                p.addLife(this.value);
            }
            if (chose==1) {
                p.addPower(this.value+10);
            }
            if (chose==2) {
                p.addAction(new MapAction());
            }
            
            p.setGold(p.getGold()-this.value);
        }
	}
	
	public String toString() {
		return "Bandit ("+this.value+")";
	}

	public boolean equals(Object o) {
		if (o instanceof One_armed_bandit) {
			One_armed_bandit theOther = ((One_armed_bandit) o);
			return this.value==theOther.value;
		} 
		else {
			return false;
		}
	}

	public int hashCode() {
        return (this.value+"$&@One-armed_bandit").hashCode();
    }

}