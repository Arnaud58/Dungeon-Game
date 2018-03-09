package Action;

import Characters.Player;

public class SaveAction implements Action {

	/**
	 * Say if a action is possible
	 * @param p The player we want to know if the action is possible
	 * @return Always @true
	 */
	public boolean isPossible(Player p) {
		return true;
	}
	/**
	* create file game.sav and save the game
	* @param p The player that doing the action
	*/
	public void execute(Player p) {
		p.creatSave("game.sav");
	}
	
	
	public String toString() {
		return "Save";
	}
}
