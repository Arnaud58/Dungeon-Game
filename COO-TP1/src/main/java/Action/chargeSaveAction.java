package Action;

import java.io.File;

import Characters.Player;

public class chargeSaveAction implements Action {


	/**
	 * Say if a action is possible
	 * @param p The player we want to know if the action is possible
	 * @return true if file game.sav exist else False 
	 */
	
	public boolean isPossible(Player p) {
		File name= new File("game.sav");
		if (name.exists()) {
			return true;
		}
		return false;
	}

	/**
	* loads the save into the file game.sav
	* @param p The player that doing the action
	*/
	public void execute(Player p) {
		p.chargeSave("game.sav");
		
	}
	
	public String toString() {
		return "Charge";
	}

}
