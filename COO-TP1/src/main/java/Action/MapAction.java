package Action;

import Characters.Player;

public class MapAction implements Action {


	public boolean isPossible(Player p) {
		return true;
	}
	
	public void execute(Player p) {
		p.getDungeon().display();
	}
	
	public String toString() {
		return "Map";
	}

}
