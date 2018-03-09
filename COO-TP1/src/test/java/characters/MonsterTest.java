package characters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Characters.Monster;
import Items.Gold;
import Rooms.Room;

public class MonsterTest {


	private Monster gollum;
	private Room room;


	@Before
	public void beforeTest() {
		this.room = new Room(10,10);
		this.gollum = new Monster(100, 100, 100,"Gollum");
		this.room.addMonster(gollum);
		this.gollum.setRoom(this.room);
	}
	/**
	*
	*
	*/
	@Test 
	public void getNameTest(){
		assertTrue(this.gollum.getName()=="Gollum");
	}
	/**
	*
	*
	*/
	@Test
	public void dieTest(){
		assertTrue(this.room.getAllItem().isEmpty());
		assertFalse(this.room.getListMonster().isEmpty());
		Gold gold = new Gold(this.gollum.getGold());
		this.gollum.die();
		assertFalse(this.room.getAllItem().isEmpty());
		assertEquals(gold,this.room.getAllItem().get(0));
		assertTrue(this.room.getListMonster().isEmpty());

	}
	/**
	*
	*
	*/
	@Test
	public void equalsTest(){
		Monster gollum2= new Monster(100, 100, 100,"Gollum");
		assertFalse(this.gollum.equals(gollum2));
	}
}