package Displayer;

import java.util.List;

import Characters.Player;

/**
 * @author rougetet and lefevere
 *
 */

public interface Display {

	/**
	 * Display a given message to the user
	 * @param txt The message to print
	 */
	public void displayMessage(String txt);
	
	/**
	 * Give the possibility for the player to choose in a given list 
	 * of object T. The function wait for a player input and
	 * return the player chose
	 * @param <T> The type of the object we want to choose
	 * @param txt The text print before the list proposition 
	 * @param listText The text will be print with the list chose
	 * @param listElm The list of possible element, we wait until the player make a chose in that list or chose to do nothing
	 * @param p The player what make a chose
	 * @return The chosen element or null if the user chose nothing
	 */
	public <T> T choose(String txt,String listText, List<T> listElm,Player p);
	
	/**
	 * Display the first message the player will see before playing
	 * Use for explain game rules and functionment
	 */
	public void beginning();	
	
}
