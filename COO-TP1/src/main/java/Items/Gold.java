package Items;
import Characters.*;

/**
 * @author rougetet and lefevere
 * Create a stock of gold can be taken by the player
 */
public class Gold implements Items {
	
	private int value;
	
	/**
	 * Create a amount of gold
	 * @param value The value of gold we want to set in the stock 
	 */
	public Gold(int value) {
		this.value=value;
	}
	
	/**
	 * Give some gold to the player
	 * @param p The player what win golds
	 */
	public void isUsedBy(Player p) {
		p.addGold(this.value);
	}
	
	public String toString() {
		return "Gold ("+this.value+")";
	}

	public boolean equals(Object o) {
		if (o instanceof Gold) {
			Gold theOther = ((Gold) o);
			return this.value==theOther.value;
		} 
		else {
			return false;
		}
	}

	public int hashCode() {
        return (this.value+"$&@Gold").hashCode();
    }

}