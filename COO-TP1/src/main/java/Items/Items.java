package Items;
import Characters.*;


/**
 * @author rougetet and lefevere
 * Interface for item can be used by the player
 */
public interface Items {
	
	/**
	 * Define that the item must to do when it used.
	 * @param p The player than use the item
	 */
	public void isUsedBy(Player p);

	public String toString();

	public boolean equals(Object o);

}
