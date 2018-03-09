package Action;

import Characters.*;
import Displayer.DispGraph;
import Displayer.Display;
import Items.Items;
import Rooms.Room;

/**
 * @author rougetet and lefevere
 * Give the opportunity to use an object that is in this room (if there are no monster in this room)
 */
public class UseAction implements Action{
	
	/**
	 * Say if a action is possible
	 * @param p The player we want to know if the action is possible
	 * @return A boolean than be @true if we can used the action and @false else
	 */
	public boolean isPossible(Player p) {
		Room thisRoom = p.getRoom();
		
		if (thisRoom.nbItems()==0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	/**
	 * Use a object present in this room
	 * @param p The player that doing the action
	 */	
	public void execute(Player p) {
		Room thisRoom = p.getRoom();
		Display dp = new DispGraph();
		
		if (thisRoom.nbItems()==0) {
			dp.displayMessage("There are no item in this room.\n");
			return;
		}

		Items chosenItem = dp.choose("Which item :","Take",thisRoom.getAllItem(),p);
		if (chosenItem!=null) {
			chosenItem.isUsedBy(p);
			p.getRoom().removeItem(chosenItem);
		}
	}
	
	public String toString() {
		return "Use an item";
	}
}