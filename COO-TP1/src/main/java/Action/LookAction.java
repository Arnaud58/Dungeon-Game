package Action;
import Characters.*;
import Displayer.DispGraph;
import Displayer.Display;
import Rooms.*;

/**
 * @author rougetet and lefevere
 * Give a description of the current room
 */
public class LookAction implements Action{
	
	/**
	 * Say if a action is possible
	 * @param p The player we want to know if the action is possible
	 * @return Always @true
	 */
	public boolean isPossible(Player p) {
		return true;
	}
	
	
	/**
	 * Print the description of the room
	 * @param p The player that doing the action
	 */	
	public void execute(Player p) {
		Room thisRoom = p.getRoom();
		Display dp = new DispGraph();
		
		dp.displayMessage(thisRoom.toString());
		
	}
	
	public String toString() {
		return "Look the room";
	}

}
