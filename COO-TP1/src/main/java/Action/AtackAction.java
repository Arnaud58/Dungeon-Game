package Action;
import Characters.*;
import Displayer.*;
import Rooms.*;

/**
 * @author rougetet and lefevere
 * Atack the monster of the room (if there are a monster in this room)
 */
public class AtackAction implements Action{
	
	/**
	 * Say if a action is possible
	 * @param p The player we want to know if the action is possible
	 * @return A boolean than be @true if we can used the action and @false else
	 */
	public boolean isPossible(Player p) {
		Room thisRoom = p.getRoom();
		
		if (thisRoom.nbMonster()==0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	/**
	 * Atack the monster of the room
	 * @param p The player that doing the action
	 */	
	public void execute(Player p) {
		Room thisRoom = p.getRoom();
		Display dp = new DispGraph();
		
		if (thisRoom.nbMonster()==0) {
			dp.displayMessage("There are no monster in this room.\n");
			return;
		}
		
		Monster chosenMonster = dp.choose("Which monster to attack :","Attack",thisRoom.getListMonster(),p);
		
		if (chosenMonster!=null) {
			p.attack(chosenMonster);
			
			if (chosenMonster.isDead()) {
				chosenMonster.attack(p);
			}
			else {
				chosenMonster.die();
			}
			
		}
	}
	
	public String toString() {
		return "Atack Monsters";
	}

}
