package Items;
import Characters.*;

/**
 * @author rougetet and lefevere
 * Create a potion that give some life to the player
 */
public class Life implements Items {
	
	private int value;
	
	/**
	 * Create a life potion
	 * @param value The life that the player win when he drink the potion
	 */
	public Life(int value) {
		this.value=value;
	}
	
	/**
	 * The player drink the potion and win some life
	 * @param p The player what win life
	 */
	public void isUsedBy(Player p) {
		p.addLife(this.value);
	}

	public String toString() {
		return "Life potion ("+this.value+")";
	}
    
	public boolean equals(Object o) {
		if (o instanceof Life) {
			Life theOther = ((Life) o);
			return this.value==theOther.value;
		} 
		else {
			return false;
		}
	}

	public int hashCode() {
        return (this.value+"$&@Life").hashCode();
    }
}
