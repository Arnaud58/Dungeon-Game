package Items;

import Action.MapAction;
import Characters.Player;
import Displayer.DispGraph;
import Displayer.Display;

public class Map implements Items{

	public void isUsedBy(Player p) {
		if (!p.containAction("Map")) {
			Display dp = new DispGraph();
			dp.displayMessage("Now you can use a map to find the exit (ont the bottom right of the map)");
			dp.displayMessage("Use look to know your location on the map (the upper left is room (0,0))");
			p.addAction(new MapAction());
		}
		
	}
	
	public String toString() {
		return "Map";
	}
    
	public boolean equals(Object o) {
		if (o instanceof Map) {
			return true;
		} 
		else {
			return false;
		}
	}
}
