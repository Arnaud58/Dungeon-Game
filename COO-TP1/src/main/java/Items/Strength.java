package Items;
import Characters.*;

/**
 * @author rougetet and lefevere
 * Create a potion that reforce the power of the player
 */
public class Strength implements Items {

private int value;
	
	/**
	 * Create a strength potion
	 * @param value The power that the player win when he drink the potion
	 */
	public Strength(int value) {
		this.value=value;
	}
	
	/**
	 * The player drink the potion and win some power
	 * @param p The player what win strength
	 */
	public void isUsedBy(Player p) {
		p.addPower(this.value);
	}

	public String toString() {
		return "Power potion ("+this.value+")";
	}

	public boolean equals(Object o) {
		if (o instanceof Strength) {
			Strength theOther = ((Strength) o);
			return this.value==theOther.value;
		} 
		else {
			return false;
		}
	}

	public int hashCode() {
        return (this.value+"$&@Stgh").hashCode();
    }

}
