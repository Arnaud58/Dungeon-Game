package Characters;

import java.util.LinkedList;
import java.util.List;

import Items.*;

/**
 * 
 * 
 * @author Arnaud Rougetet and Rodolphe Lefevere
 * @version 1.0
 */

public class Monster extends Charac{
	

	private String name;
	private static int cpt;
	private int idMonster;

	/**
	* create a new monster	
	* @param life int value hit point monster
	* @param gold int value of monster's gold
	* @param power int value of monster's DPS 
	* @param name String the name of monster
	*/
	public  Monster(int life, int gold, int power,String name){
		super(life,gold,power);
		this.name=name;
		this.idMonster=Monster.cpt++;
	}
	/**
	* give monster's name
	* @return a String 
	*/
	public String getName(){
		return this.name;
	}

	public void setName(String name2){
		this.name = name2;
	}
	/**
	* create gold corresponding to this monster, add this gold to the room and remove the monster of the Room  
	*
	*/
	public void die(){
		Gold butin =new Gold(this.getGold());
		this.getRoom().addItems(butin);
		this.getRoom().removeMonster(this);
	}
	/**
	* check two Monster are the same 
	* @param o a object
	*/
	public boolean equals(Object o) {
		if (o instanceof Monster) {
			Monster theOther = ((Monster) o);
			return this.idMonster==theOther.idMonster;
		} else {
			return false;
		}
	}

	public String toString() {
		return this.name+" ("+this.life+"/"+this.power+")";
	}



	/**
	* changes all attributes of the monster
	* @param str a String with all the attributes of the monster, separated by ","
	*/
	public void converMonster(String str){
		String tableau[]=str.split(",");
		this.setLife(Integer.parseInt(tableau[0]));
		this.setGold(Integer.parseInt(tableau[1]));
		this.setPower(Integer.parseInt(tableau[2]));
		this.setName(tableau[3]);

	}

	/**
	* converts the attributes of the player to a string, separated by a string "!"
	* @return str a String 
	*/
	public String toStringMonster(){
		String str = new String();
		str+=String.valueOf(this.getLife());
		str+=(',');
		str+=String.valueOf(this.getGold());
		str+=(',');
		str+=String.valueOf(this.getPower());
		str+=(',');
		str+=String.valueOf(this.getName());
		return str;
	}


}