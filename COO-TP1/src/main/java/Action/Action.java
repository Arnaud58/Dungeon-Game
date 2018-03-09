package Action;
import Characters.*;

/**
 * @author rougetet and lefevere
 * A interface for all possible actions, a action can say if it can be used and doing something
 */
public interface Action {
	
	/**
	 * Say if a action is possible
	 * @param p The player we want to know if the action is possible
	 * @return A boolean than be @true if we can used the action and @false else
	 */
	public boolean isPossible(Player p);
	
	
	/**
	 * Doing what the action must do
	 * @param p The player that doing the action
	 */	
	public void execute(Player p);


	public String toString();
}
