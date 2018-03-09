package Rooms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import Characters.Monster;
import Characters.Player;
import Items.Gold;
import Items.Items;
import Items.Life;
import Items.Map;
import Items.One_armed_bandit;
import Items.Strength;




/**
 * @author ROUGETET and LEFEVERE
 * 
 */
public class Room {
	protected java.util.Map<Direction,Room> allDirections;
	protected int posX;
	protected int posY;
	protected List<Items> allItems;
	protected List<Monster> theMonster;
	protected Boolean isFinal;
	
	/**
	 * 
	 * @param x The pos x of the Room in the map
	 * @param y The pos y of the Room in the map
	 */
	public Room(int x,int y) {
		this.posX=x;
		this.posY=y;
		this.allDirections = new HashMap<Direction,Room>();
		this.allItems = new LinkedList<Items>();
		this.theMonster = new LinkedList<Monster>();
		this.isFinal=false;
	}

	/**
	 * Give the position in height in the map of this room.
	 * @return A int that represent the height position in the map
	 */
	public int getHeight() {
		return this.posX;
	}
	
	/**
	 * Give the position in width in the map of this room.
	 * @return A int that represent the width position in the map
	 */
	public int getWidth() {
		return this.posY;
	}
	
	
	/**
	 * Say if this room if the end of the dungeon
	 * @return true if this room is the final room of the dungeon and false else.
	 */
	public Boolean isFinal() {
		return this.isFinal;
	}
	
	/**
	 * Change the current Room of the player in fonction of given direction and the current room.
	 * @param d The Direction the player will take.
	 * @param p The Player that move.
	 */
	public void newDirect(Direction d, Player p) {		
		if (!this.allDirections.containsKey(d)) {
			throw new RuntimeException("The given direction is not possible in that room");
		}
		Room nextRoom =this.allDirections.get(d);
		p.setRoom(nextRoom);
	}

	/**
	 * Give a list of all monsters of the Room
	 * @return A list of all living Monster of this Room
	 */
	public List<Monster> getListMonster(){
		return this.theMonster;
	}
	
	/**
	 * Give a list of all items of the Room
	 * @return A list of all Items of this Room
	 */
	public List<Items> getAllItem(){
		return this.allItems;
	}
	
	/**
	 * Give a list of all direction we can take in the Room
	 * @return A list of all possible Direction in this Room
	 */
	public List<Direction> getDirection() {
		Set<Direction> set = allDirections.keySet();
		List<Direction> dirList = new ArrayList<Direction>();
		dirList.addAll(set);
		
		return dirList;
	}
	
	/**
	 * The number of Items in this Room
	 * @return A int that is the number of item in this Room
	 */
	public int nbItems(){
		return this.allItems.size();
	}
	
	
	/**
	 * The number of Monster in this Room
	 * @return A int that represent the number of Monster in this Room
	 */
	public int nbMonster() {
		return this.theMonster.size();
	}
	
	
	/**
	 * Destroy all item and monster of this room and 
	 * reset the ability to quit this room
	 */
	public void reinit() {
		this.allDirections.clear();
		this.allItems.clear();
		this.theMonster.clear();
	}
	
	/**
	 * Put an item in this Room
	 * @param item The item we want to put in the room
	 */
	public void addItems(Items item){
		this.allItems.add(item);
	}
	
	/**
	 * Put a monster in this Room
	 * @param m The monster we want to put in the room
	 */
	public void addMonster(Monster m){
		this.theMonster.add(m);
	}
	
	/**
	 * Take off the given Monster of this Room 
	 * @param mons The monster that will quit the room
	 */
	public void removeMonster(Monster mons) {
		if (!this.theMonster.contains(mons)) {
			throw new RuntimeException("This monster "+mons+" doesn't exit.");
		}
		this.theMonster.remove(mons);
	}
	
	/**
	 * Take off the given Items of this Room 
	 * @param item The monster that will quit the room
	 */
	public void removeItem(Items item) {
		if (!this.allItems.contains(item)) {
			throw new RuntimeException("This item "+item+" doesn't exit.");
		}
		this.allItems.remove(item);
	}
	
	
	/**
	 * Create a road in the given direction to the given room
	 * @param d The direction we want to create a road
	 * @param r The Room we want to join
	 */
	public void breakWall(Direction d,Room r) {
		if (this.allDirections.containsKey(d)) {
			this.allDirections.remove(d);
		}
		
		this.allDirections.put(d, r);
	}
	
	/**
	 * Build a wall in the direction given, block the direction  
	 * @param d A Direction that is the direction we want to block
	 */
	public void buildWall(Direction d) {
		if (this.allDirections.containsKey(d)) {
			this.allDirections.remove(d);
		}
	}


	
	/**
	 * Give a representation in a map symbol of the Room
	 * @return A string like ╬ that is the ASCII symbol that represent this Room
	 */
	public String printRoom() {
		if (!this.allDirections.containsKey(Direction.North)) {
			if (!this.allDirections.containsKey(Direction.South)) {
				if (!this.allDirections.containsKey(Direction.East)) {
					if (!this.allDirections.containsKey(Direction.West)) {
						return "╳";
					}
					else {
						return "╕";
					}
				}
				else {
					if (!this.allDirections.containsKey(Direction.West)) {
						return "╞";
					}
					else {
						return "═";
					}
				}
			}
			else {
				if (!this.allDirections.containsKey(Direction.East)) {
					if (!this.allDirections.containsKey(Direction.West)) {
						return "╥";
					}
					else {
						return "╗";
					}
				}
				else {
					if (!this.allDirections.containsKey(Direction.West)) {
						return "╔";
					}
					else {
						return "╦";
					}
				}
			}

		}

		else {
			if (!this.allDirections.containsKey(Direction.South)) {
				if (!this.allDirections.containsKey(Direction.East)) {
					if (!this.allDirections.containsKey(Direction.West)) {
						return "╨";
					}
					else {
						return "╝";
					}
				}
				else {
					if (!this.allDirections.containsKey(Direction.West)) {
						return "╚";
					}
					else {
						return "╩";
					}
				}
			}
			else {
				if (!this.allDirections.containsKey(Direction.East)) {
					if (!this.allDirections.containsKey(Direction.West)) {
						return "║";
					}
					else {
						return "╣";
					}
				}
				else {
					if (!this.allDirections.containsKey(Direction.West)) {
						return "╠";
					}
					else {
						return "╬";
					}
				}
			}
		}
	}
	
	/**
	 * A string representation of the object.
	 * @return A string representation of the object.
	 */
	public String toString() {
		String dplcm = "";
		
		if (this.allDirections.isEmpty()) {
			dplcm="nothing ";
		}
		
		if (this.allDirections.containsKey(Direction.North)) {
			dplcm="North,";
		}
		if (this.allDirections.containsKey(Direction.South)) {
			dplcm=dplcm+"South,";
		}
		if (this.allDirections.containsKey(Direction.East)) {
			dplcm=dplcm+"East,";
		}
		if (this.allDirections.containsKey(Direction.West)) {
			dplcm=dplcm+"West,";
		}
		
		return "The room ("+this.posX+","+this.posY+") with "+this.nbMonster()+" monster and "+this.nbItems()+" item.\nYou can go to "+dplcm+"\n";
	}
	
	/**
	 * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by {@link java.util.HashMap}.
	 * @return  a hash code value for this object.
	 */
	public int hashCode() {
        return (this.posX+"$&@"+this.posY+"$&@").hashCode();
    }

	/**
    * Indicates whether some other object is "equal to" this one.
    * @param o   the reference object with which to compare.
    * @return {@code true} if this object is the same as the o
    *          argument; {@code false} otherwise.
	*/
    public boolean equals(Object o) {
		if (o instanceof Room) {
			Room theOther = ((Room) o);
			return this.posX==theOther.posX && this.posY==theOther.posY ;
		} else {
			return false;
		}
	}
    /**
     * creat object Items 
     * @param str a string with toString ITems 
     * @return The item that conrespond to the given text
     */
    public Items converITems(String str){
    	int x=0;
    	String hdr="";
    	String value=new String();
    	String i = new String();
    	i=String.valueOf(str.charAt(x++));
    	if (str.equals("Map")) {
			Items mp = new Map();
			return mp;	
		}
    	while (!i.equals("(")) {
			hdr+=i;
			i=String.valueOf(str.charAt(x++));
		}
		i=String.valueOf(str.charAt(x++));
		while (!i.equals(")")) {
			value+=i;
			i=String.valueOf(str.charAt(x++));
		}
		if (hdr.equals("Gold ")) {
			Gold gold = new Gold(Integer.valueOf(value));
			return gold;
		}
		if (hdr.equals("Life potion ")) {
			Life life = new Life(Integer.valueOf(value));
			return life;
		}
		if (hdr.equals("Power potion ")) {
			Strength strength = new Strength(Integer.valueOf(value));
			return strength;
		}
		if (hdr.equals("Bandit ")) {
			Items bandit = new One_armed_bandit(Integer.valueOf(value));
			return bandit;
		}
		
		return null;
    }
    /**
     * built the monster list of the room thanks to the str
     * @param str a String represent the monster with life,gold,Strenght,name
     * @param nb int number monster of the List
     */
    public void reculistMonster(String str,int nb){
    	String tableau[]=str.split(";");
    	LinkedList<Monster> allMonster = new LinkedList<Monster>(); 			   		
    	for (int x=0;x<nb ;x++) {
    		Monster mons = new Monster(1,1,1,"huitre");
    		mons.converMonster(tableau[x]);
    		mons.setRoom(this);
    		allMonster.add(mons);
    	}
    	this.theMonster=allMonster;
    }
    /**
     * built the item list of the room thanks to the str
     * @param str a String represent the itm with type and it value 
     * @param nb int number Item of the List
     */
    public void recupListItem(String str,int nb){
    	String tableau[]=str.split(";");
    	LinkedList<Items> allItems = new LinkedList<Items>();
    	for (int x=0;x<nb ;x++) {
 			allItems.add(this.converITems(tableau[x]));
    	}
    	this.allItems= allItems;
    }


	/**
	* changes the attributes allItems,theMonster of the Room 
	* @param str a String with nbMonster,the Monsters,nbItems, all ITems of the Room, separated by ":"
	 */
	public void converStringRoom(String str){
		String tableau[]=str.split(":");
		int h=Integer.valueOf(tableau[0]);
		if (h!=0) {			
			this.reculistMonster(tableau[1],h);
			int k = Integer.valueOf(tableau[2]);
			if (k!=0) {
				this.recupListItem(tableau[3],k);
			}
		}
		else{
			int k = Integer.valueOf(tableau[1]);
			if (k!=0) {
				this.recupListItem(tableau[2],k);
			}
		}
	}
    /**
     * converts the attributes of the player to a string, separated by a string ":"
	 * @return str a String
	 */
	public String toStringRoom(){
		String str = new String();
		str+= Integer.valueOf(this.nbMonster()).toString();
		str+= (':');
		if (this.nbMonster()!=0) {
			for (int i=0; i<this.nbMonster(); i++) {
				if (i==this.nbMonster()-1) {
					str+=this.getListMonster().get(i).toStringMonster();					
				}
				else{
					str+=this.getListMonster().get(i).toStringMonster();
					str+=(";");
				}
			}
			
		str+= (':');
		}
		str+= this.nbItems();
		str+= (':');
		if (this.nbItems()!=0) {
			for (int i=0; i<this.nbItems(); i++) {
				if (i==this.nbItems()-1) {
					str+= this.getAllItem().get(i).toString();
				}
				else{	
				str+= this.getAllItem().get(i).toString();
				str+=(';');
				}
			}
		}
		str+= "&";
		return str;
	
	}
}
