package Rooms;

import Characters.*;
import Displayer.*;
import Items.*;
import Items.Map;

import java.io.File;
import java.lang.Math;
import java.util.*;


public class Dungeon {

	private Player ourHero;
	private List<Monster> theMonster;
	private List<Items> theItem;
	private boolean visited[][];
	private Room AllRoom[][] ;
	private int height;
	private int width;
	

	/**
	 *Create a randon dungeon with height*width rooms inside
	 * @param height The number of room in one column
	 * @param width The number of room in one line
	 */
	public Dungeon(int height,int width) {
		File name= new File("game.sav");
		name.delete();
		
		//Creation monstre et item
		this.theMonster=new ArrayList<Monster>();
		this.theItem=new ArrayList<Items>();
		
		this.createListMonster();
		this.createListItem();

		//Creation des salles du donjon
		this.AllRoom=new Room[height][width];
		this.visited= new boolean[height][width];
		this.height=height;
		this.width=width;

		for (int i=0;i<height;i++) {
			for (int j=0;j<width;j++) {
				this.AllRoom[i][j] = new Room(i,j);
				this.visited[i][j]=false;
			}
		}
		
		this.AllRoom[height-1][width-1] = new FinalRoom(height-1,width-1);
		

		//Connecte les salles entre elle selon un model de labyrinthe
		this.newLaby();	
		
		//this.display();

		//Créer le héro
		this.ourHero = new Player(70,10,50,this.AllRoom[0][0],this);
		//Place les monstres et les items
		this.placeMonster();
		this.placeItem();
		
		//Première action du hero (act est récursif et ne s'arrète que si le joueur meure ou gagne)
		this.ourHero.act();
		
		//Remet le donjon à 0 pour une nouvelle partie
		this.reinit();
	}
	
	
	public int getHeight(){
		return this.height;
	}
	public int getWidth(){
		return this.width;
	}
	/**
	 * return the dungeon's Room of coordinate x,y in Dungeon's table
	 * @param x a int represent the Room's Donjon line 
	 * @param y a int represent the Room's Donjon colonne
	 * @return a object Room 
	 */
	public Room getAllroom(int x,int y){
		return this.AllRoom[x][y];
	}
	/**
	* Create a dungeon from the current, the player return to 
	* the start room and all monster and items changing their location
	* the position between all room are change
	*/
	private void reinit() {
		this.ourHero.removeAction("Map");
		File name= new File("game.sav");
		name.delete();
		
		for (int i=0;i<this.height;i++) {
			for (int j=0;j<this.width;j++) {
				this.AllRoom[i][j].reinit();
			}
		}
		
		this.theMonster.clear();
		this.theItem.clear();
		this.createListMonster();
		this.createListItem();
		
		this.ourHero.setLife(70);
		this.ourHero.setPower(50);
		this.ourHero.setGold(10);
		
		this.ourHero.setRoom(this.AllRoom[0][0]);
		this.newLaby();
		this.placeMonster();
		this.placeItem();
		this.ourHero.act();
		this.reinit();
		}


	/**
	 * Change all the road on the dungeon (create a new map)
	 */
	private void newLaby() {

		List<Room> resteVoisinVisitable = new LinkedList<Room>();
		int roomWithNegNonVist=0;

		for (int i=0;i<height;i++) {
			for (int j=0;j<width;j++) {
				this.visited[i][j]=false;
			}
		}

		roomWithNegNonVist++;
		this.visited[0][0]=true;
		resteVoisinVisitable.add(AllRoom[0][0]); 

		while (roomWithNegNonVist>0) {
			int r = (int) Math.floor(Math.random()*roomWithNegNonVist);
			int i= resteVoisinVisitable.get(r).getHeight();
			int j= resteVoisinVisitable.get(r).getWidth();
			int breakDir = this.Neighbour(i,j);
			
			if (breakDir==-1) {
				roomWithNegNonVist--;
				resteVoisinVisitable.remove(r);
			}
			else {
				int i2;
				int j2;
				
				int pas=1;
                if (breakDir>1){
                    pas=-1;
                }
                if (breakDir%2==0){
                    i2=i+pas;
                    j2=j;
                }
                else{
                	i2=i;
                    j2=j+pas;
                }
	            if (!resteVoisinVisitable.contains(AllRoom[i2][j2])) {
                	resteVoisinVisitable.add(AllRoom[i2][j2]);
                	roomWithNegNonVist++;
                }
	            
	            this.AllRoom[i][j].breakWall(Direction.toDirection(breakDir),this.AllRoom[i2][j2]);
				this.AllRoom[i2][j2].breakWall(Direction.toDirection(breakDir).Opposite(),this.AllRoom[i][j]);
				this.visited[i2][j2]=true;
				
			}
		}

	}

	/**
	 * Search a non-visited neighbour of the localisation given (i,j) on the map of the dungeon 
	 * and given a int that represent the direction to take to go to this neighbour and -1 if there are no neighbour.
	 * @param i The pos x of the Room in the map
	 * @param j The pos x of the Room in the map
	 * @return 0 if the neighbour is on the South, 1 if the neighbour is on the East, 2 if the neighbour is on the North, 3 if the neighbour is on the West and else return -1
	 */
	private int Neighbour(int i,int j) {
		int nbPossible =0;
		int allPossible[];
		allPossible=new int[4];

		if (i>0 && !this.visited[i-1][j]) {
			allPossible[nbPossible]=2;
			nbPossible++;
		}

		if (j>0 && !this.visited[i][j-1]) {
			allPossible[nbPossible]=3;
			nbPossible++;
		}

		if (i<this.height-1 && !this.visited[i+1][j]) {
			allPossible[nbPossible]=0;
			nbPossible++;
		}

		if (j<this.width-1 && !this.visited[i][j+1]) {
			allPossible[nbPossible]=1;
			nbPossible++;
		}

		if (nbPossible>0) {
			int r = (int) Math.floor(Math.random()*nbPossible);
			return allPossible[r];
		}
		return -1;
	}

	/**
	 * Add monsters to the list of all monster of the dungeon
	 */
	private void createListMonster() {
		for (int i=0;i<15;i++) {
			this.theMonster.add(new Monster(10,20,2,"Imp"));
		}
		for (int i=0;i<1;i++) {
			this.theMonster.add(new Monster(120,500,80,"Horned Reaper"));
		}
		for (int i=0;i<2;i++) {
			this.theMonster.add(new Monster(150,75,30,"Suzanne"));
		}
		for (int i=0;i<10;i++) {
			this.theMonster.add(new Monster(60,25,20,"Suzanne"));
		}
		for (int i=0;i<6;i++) {
			this.theMonster.add(new Monster(80,50,30,"Bile Demon"));
		}
	}
	
	/**
	 * Add items to the list of all item of the dungeon
	 */
	private void createListItem() {
		for (int i=0;i<3;i++) {
			this.theItem.add(new Gold(20));
		}
		for (int i=0;i<6;i++) {
			this.theItem.add(new Life(25));
		}
		for (int i=0;i<6;i++) {
			this.theItem.add(new Strength(10));
		}
		for (int i=0;i<3;i++) {
			this.theItem.add(new Map());
		}
		for (int i=0;i<6;i++) {
			this.theItem.add(new One_armed_bandit(15));
		}
		for (int i=0;i<2;i++) {
			this.theItem.add(new One_armed_bandit(50));
		}
	}
	
	/**
	 * Place monsters in different rooms of the dungeon (random method) 
	 */
	private void placeMonster() {
		Iterator<Monster> itMonster = this.theMonster.iterator();
		Monster munch = null;
		
		while (itMonster.hasNext()) {
			munch=itMonster.next();
			int rx = (int) Math.floor(Math.random()*height);
			int ry = (int) Math.floor(Math.random()*width);
			munch.setRoom(AllRoom[rx][ry]);
			AllRoom[rx][ry].addMonster(munch);
		}
		
	}

	/**
	 * Place items in different rooms of the dungeon (random method) 
	 */
	private void placeItem() {
		Iterator<Items> itItem = this.theItem.iterator();
		Items item = null;
		
		while (itItem.hasNext()) {
			item=itItem.next();
			int rx = (int) Math.floor(Math.random()*height);
			int ry = (int) Math.floor(Math.random()*width);
			AllRoom[rx][ry].addItems(item);
		}
	}
	
	/**
	 * Display on the terminal a string that represent the map of the dungeon
	 */
	public void display() {
		Display dp = new DispGraph();
		String laby = "";
		for (int i=0;i<this.height;i++) {
			for (int j=0;j<this.width;j++) {
				laby=laby+this.AllRoom[i][j].printRoom();
			}
			laby=laby+"\n";
		}
		
		dp.displayMessage(laby);
	}

}