package Rooms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Characters.Monster;
import Characters.Player;
import Items.Gold;
import Items.Items;
import Rooms.Room;

public class RoomTest {
	
	protected Room r;
	protected Player p;
	
	@Before
	public void beforeTest() {
		this.r = new Room(2,8);
		this.p = new Player(50,50,50,r, null);
	}
	/**
	*
	*
	*/
	@Test
	public void testRoom() {
		Room r = new Room(0,0);
		assertNotNull(r);
	}
	/**
	*
	*
	*/
	@Test
	public void testGetHeight() {
		assertEquals(2,r.getHeight());
	}
	/**
	*
	*
	*/
	@Test
	public void testGetWidth() {
		assertEquals(8,r.getWidth());
	}
	/**
	*
	*
	*/
	@Test (expected= RuntimeException.class)
	public void testNewDirectException() {
		r.newDirect(Direction.North,p);
	}
	
	public void testNewDirect() {
		Room r1 = new Room(1,8);
		r.breakWall(Direction.North, r1);
		r.newDirect(Direction.North,p);
		assertEquals(r1,p.getRoom());
	}
		/**
		*
		*
		*/
	@Test
	public void testGetListMonster() {
		assertEquals(0,r.getListMonster().size());
		Monster m = new Monster(10,20,2,"Imp");
		r.addMonster(m);
		assertTrue(r.getListMonster().contains(m));
		assertEquals(1,r.getListMonster().size());
	}
	/**
	*
	*
	*/
	@Test
	public void testGetAllItem() {
		assertEquals(0,r.getAllItem().size());
		Items gold = new Gold(10);
		r.addItems(gold);
		assertTrue(r.getAllItem().contains(gold));
		assertEquals(1,r.getAllItem().size());
	}
	/**
	*
	*
	*/
	@Test
	public void testGetDirection() {
		Room r1 = new Room(3,8);
		assertEquals(0,r.getDirection().size());
		r.breakWall(Direction.South,r1);
		assertEquals(1,r.getDirection().size());
		assertTrue(r.getDirection().contains(Direction.South));
	}
	/**
	*
	*
	*/
	@Test
	public void testNbItems() {
		Items gold = new Gold(10);
		assertEquals(0,r.getAllItem().size());
		r.addItems(gold);
		assertEquals(1,r.getAllItem().size());
	}
	/**
	*
	*
	*/
	@Test
	public void testNbMonster() {
		Monster m = new Monster(10,20,2,"Imp");
		assertEquals(0,r.getListMonster().size());
		r.addMonster(m);
		assertEquals(1,r.getListMonster().size());
	}
	/**
	*
	*
	*/
	@Test
	public void testRemoveMonster() {
		assertEquals(0,r.getListMonster().size());
		Monster m = new Monster(10,20,2,"Imp");
		r.addMonster(m);
		assertEquals(1,r.getListMonster().size());
		
		r.removeMonster(m);
		assertFalse(r.getListMonster().contains(m));
		assertEquals(0,r.getListMonster().size());
	}
	/**
	*
	*
	*/
	@Test
	public void testRemoveItem() {
		assertEquals(0,r.getAllItem().size());
		Items gold = new Gold(10);
		r.addItems(gold);
		
		assertEquals(1,r.getAllItem().size());
		
		r.removeItem(gold);
		assertFalse(r.getListMonster().contains(gold));
		assertEquals(0,r.getListMonster().size());
	}
	/**
	*
	*
	*/
	@Test
	public void testBreakWall() {
		Room r2 = new Room(1,8);
		assertEquals(0,r.getDirection().size());
		r.breakWall(Direction.North, r2);
		assertEquals(1,r.getDirection().size());
		r.newDirect(Direction.North, p);
	}
	/**
	*
	*
	*/
	@Test
	public void testBuildWall() {
		Room r2 = new Room(1,8);
		r.breakWall(Direction.North, r2);
		assertEquals(1,r.getDirection().size());
		r.buildWall(Direction.North);
		assertEquals(0,r.getDirection().size());
	}

}
