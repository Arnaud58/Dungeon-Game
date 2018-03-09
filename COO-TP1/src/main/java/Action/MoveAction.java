package Action;

import Characters.*;
import Displayer.*;
import Rooms.*;

/**
 * @author rougetet and lefevere
 * Give the opportunity to the player of changing room (if there are no monster in this room)
 */
public class MoveAction implements Action{

	/**
	 * Say if a action is possible
	 * @param p The player we want to know if the action is possible
	 * @return A boolean than be @true if we can used the action and @false else
	 */
	public boolean isPossible(Player p) {
		Room thisRoom = p.getRoom();
		
		if (thisRoom.nbMonster()==0 && thisRoom.getDirection().size()!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * Move the player to the direction he want to go
	 * @param p The player that doing the action
	 */	
	public void execute(Player p) {
		Room thisRoom = p.getRoom();
		Display dp = new DispGraph();
		
		if (thisRoom.getDirection().size()==0) {
			dp.displayMessage("We are sorry but it seems your are traped in this room.\n Try a new dungeon !\n");
			return;
		}
		
		Direction chosenDirection = dp.choose("Which direction to go :","Go to",thisRoom.getDirection(),p);
		
		if (chosenDirection!=null) {
			thisRoom.newDirect(chosenDirection,p);
			p.setComeFrom(chosenDirection.Opposite());
		}
	}
	
	public String toString() {
		return "Move from here";
	}
	
}
