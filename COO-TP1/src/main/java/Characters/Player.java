package Characters;


import java.util.*;
import Fichier.*;
import Action.*;
import Rooms.*;

import Displayer.DispGraph;
import Displayer.Display;

/**
 * 
 * 
 * @author Arnaud Rougetet and Rodolphe Lefevere
 * @version 1.0
 */
public class Player extends Charac {
	
	private List<Action> actionPossible;
	private List<Action> actionRealisable;
	private int initLife;
	private Direction comeFrom; 
	private Dungeon donjon;
	
	public Player(int life, int gold, int power, Room room,Dungeon dj){
		super(life,gold,power);
		this.initLife=life;
		this.theRoom=room;
		this.comeFrom=Direction.North;
		this.donjon=dj;
		
		this.actionPossible=new ArrayList<Action>();
		this.actionRealisable=new ArrayList<Action>();
		
		this.actionPossible.add(new SaveAction());
		this.actionPossible.add(new LookAction());
		this.actionPossible.add(new Rest());	
		this.actionPossible.add(new UseAction());
		this.actionPossible.add(new AtackAction());
		this.actionPossible.add(new MoveAction());	
		this.actionPossible.add(new chargeSaveAction());
	}
	
	public int getInitLife() {
		return this.initLife;
	}
	
	/**
	 * .
	 * Update the direction the player come in the current room
	 * @param d The new direction the player come from
	 */
	public void setComeFrom(Direction d) {
		this.comeFrom=d;
	}
	
	/**
	 * Give the direction the player come in the current room
	 * @return d The new direction the player come from in the current Room
	 */
	public Direction getComeFrom() {
		return this.comeFrom;
	}
	
	/**
	* 
	*
	*/
	public void act() {
		Display dp = new DispGraph();
		
		if (!this.isDead()) {
			this.die();
			return ;
		}
		if (this.getRoom().isFinal()) {
			dp.displayMessage("YOU WIN!!!!\n");
			return ;
		}

		this.actionNow();
		
		Action choose = dp.choose("What do you want to do","",this.actionRealisable,this);
		
		if (choose!=null) {
			choose.execute(this);
		}
		
		this.act();
	}

	private void actionNow() {
		this.actionRealisable.clear();
		for (Action a : this.actionPossible) {
            if (a.isPossible(this)) {
                this.actionRealisable.add(a);
            }
        }
	}
	
	public void die() {
		Display dp = new DispGraph();
		dp.displayMessage("YOU DIED\n");
		dp.displayMessage("New game\n"); 
	}
	
	/**
	 * Give the current dungeon the player is on
	 * @return the current dungeon
	 */
	public Dungeon getDungeon() {
		return this.donjon;
	}
	
	/**
	 * Add an possible action to do to the player
	 * @param act An action we want to add for the player
	 */
	public void addAction(Action act) {
		this.actionPossible.add(act);		
	}
	
	/**
	 * Say if a given action is possible for the player or not
	 * @param act A string that describe an action we want to know it is possible for the player
	 * @return true if the action is already possible for the player and false else
	 */
	public boolean containAction(String act) {
		Iterator<Action> itAct = this.actionPossible.iterator();
		Action possAct= null;
		while (itAct.hasNext()) {
			possAct=itAct.next();
			if (possAct.toString().equals(act)) {
				return true;
			}
		}
		return false;		
	}
	
	/**
	 * Remove a given action if it is a possible action and say true if it was remove 
	 * if it action isn't possible say false and remove nothing
	 * @param act A string that describe an action we want to remove
	 * @return true if the action has been deleted and false else
	 */
	public boolean removeAction(String act) {
		Iterator<Action> itAct = this.actionPossible.iterator();
		Action possAct= null;
		while (itAct.hasNext()) {
			possAct=itAct.next();
			if (possAct.toString().equals(act)) {
				this.actionPossible.remove(possAct);
				return true;
			}
		}
		return false;		
	}
	
	
	/**
	 * converts the attributes of the player to a string, separated by a string "!"
	 * @return str a String 
	 */
	public String toStringPlayer(){
		String str = new String();
		str+=Integer.valueOf(this.getLife()).toString();
		str+= ("!");
		str+=Integer.valueOf(this.getGold()).toString();
		str+= ("!");
		str+=Integer.valueOf(this.getPower()).toString();
		str+= ("!");
		str+=Integer.valueOf(this.theRoom.getHeight()).toString();
		str+= ("!");
		str+=Integer.valueOf(this.theRoom.getWidth()).toString();
		str+="&";
		return str;
		
	}
	/**
	* change the characteristic of the hero with the characteristic of the String str
	*@param str String represent player's attributs part String "!"
	*/
	public void recupPlayer(String str){
		String tableau[]=str.split("!");
		this.setLife(Integer.valueOf(tableau[0]));
		this.setPower(Integer.valueOf(tableau[2]));
		this.setGold(Integer.valueOf(tableau[1]));
		this.setRoom(this.getDungeon().getAllroom(Integer.valueOf(tableau[3]),Integer.valueOf(tableau[4])));
	}
	/**
	 * Save all Room of Dungeon with ListItem, ListMonster 
	 * @param path A string
	 */
	public void creatSave(String path){
		String str = "";
		Room room;
		for (int x=0; x<this.getDungeon().getWidth(); x++) {
			for (int y=0; y<this.getDungeon().getWidth(); y++) {
				room=this.donjon.getAllroom(x,y);
				str+=room.toStringRoom();
			}
		}
		Fichier.ecrire(path,str);
		str+=this.toStringPlayer();
		Fichier.ecrire(path,str);
	}
	/**
	* change the characteristic of the hero with the characteristic,the ListItem,ListMonster all the Rooms of Dungeon 
	* to information to save
	* @param path a String represent file path Save
	*/

	public void chargeSave(String path){
		Fichier name = new Fichier();
		String str = name.lire("game.sav");
		String tableau[]=str.split("&");
		int cmpt=0;
		for (int x =0; x<this.getDungeon().getHeight(); x++) {
			for (int y = 0; y<this.getDungeon().getWidth(); y++) {
				this.getDungeon().getAllroom(x,y).converStringRoom(tableau[cmpt++]);
			}
		}
		this.recupPlayer(tableau[cmpt]);
	}

}