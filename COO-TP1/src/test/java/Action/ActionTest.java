package Action;

import Characters.*;
import Items.Gold;
import Rooms.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class ActionTest {
	
	protected Player ourHero;
	protected Room emptyRoom;
	protected Room MonsterRoom;
	protected Room ItemRoom;
	protected Action act;
	
	 
	
	@Before
	public void beforeTest() {
		this.emptyRoom = new Room(0,0);
		this.emptyRoom.breakWall(Direction.South, this.emptyRoom);
		
		this.MonsterRoom = new Room(0,0);
		this.MonsterRoom.addMonster(new Monster(20,20,20,"Gollum"));
		this.MonsterRoom.breakWall(Direction.South, this.emptyRoom);
		
		this.ItemRoom = new Room(0,0);
		this.ItemRoom.addItems(new Gold(20));
		this.ItemRoom.breakWall(Direction.South, this.emptyRoom);
		
        this.act=this.getAction();
        this.ourHero = new Player(50,50,50,this.emptyRoom, null);
	}
    
    abstract public Action getAction();
    abstract public boolean reponce_isPossible_emptyRoom();
    abstract public boolean reponce_isPossible_MonsterRoom();
    abstract public boolean reponce_isPossible_ItemRoom();

	@Test
	public void isPossibleTest() {
		this.ourHero.setRoom(emptyRoom);
        assertEquals(this.reponce_isPossible_emptyRoom(),this.act.isPossible(this.ourHero));
        
        this.ourHero.setRoom(MonsterRoom);
        assertEquals(this.reponce_isPossible_MonsterRoom(),this.act.isPossible(this.ourHero));
        
        this.ourHero.setRoom(ItemRoom);
        assertEquals(this.reponce_isPossible_ItemRoom(),this.act.isPossible(this.ourHero));
	}
	
}