package Characters;
import Rooms.*;

/**
 * 
 * 
 * @author Arnaud Rougetet and Rodolphe Lefevere
 * @version 1.0
 */

abstract public class Charac {

	protected int life;
	protected int gold;
	protected int power;
	protected Room theRoom;
	
	/**
	 * Construct a Charac (= a Character)
	 * @param life An int that represent the life of the Character
	 * @param gold An int that represent the gold of the Character
	 * @param power An int that represent the power of the Character
	 */
	public Charac(int life, int gold, int power){
		this.life = life;
		this.gold = gold;
		this.power = power;
		this.theRoom=null;
	}
	
	/**
	* give the room where is the characters
	* @return object the room
	*/
	public Room getRoom() {
		return this.theRoom;
	}
	
	/**
	* give the hit point of character
	* @return a int value 
	*/
	public int getLife(){
		return this.life;
	}
	
	/**
	* give the character's gold
	* @return a int value
	*/
	public int getGold(){
		return this.gold;
	}
	
	/**
	* give the DPS
	* @return a int value 
	*/
	public int getPower(){
		return this.power;
	}
	
	/**
	* change the hit point for the new value 
	* @param point int value
	*/
	public void setLife(int point){
		this.life = point;
	} 
	
	/**
	* change number's gold for the new value
	* @param point a int value
	*/ 
	public void setGold(int point){
		this.gold = point;
	}
	
	/**
	* change DPS character for the new value 
	* @param point a int value 
	*/
	public void setPower(int point){
		this.power = point;
	}
	
	/**
	* change the room where is the character for the new Room r 
	* @param r object Room 
	*/
	public void setRoom(Room r){
		this.theRoom = r;
	}
	
	/**
	* remove hit point of character joueur for value DPS of character calling method 
	* @param joueur object Charac
	*/
	public void attack(Charac joueur){
		joueur.life -= this.power;
	}
	
	/**
	* add point gold of character
	* @param point int value 
	*/
	public void addGold(int point){
		this.gold+=point;

	}
	
	/**
	* add hit Point of character
	* @param point a int value 
	*/
	public void addLife(int point){
		this.life+=point;

	}
	
	/**
	 * add DPS of character
	 * @param point a int value
	 */
	public void addPower(int point){
		this.power+=point;

	}
	
	/**
	* check the character is dead, 
	* true if he is alive, false or not    
	* @return a boolean value
	*/
	public boolean isDead(){
		if (this.life > 0) {
			return true;			
		}
		else{
			return false;
		}
	}

	abstract public void die();

}
