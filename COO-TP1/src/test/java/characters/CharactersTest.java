package characters;

import Characters.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import Rooms.Room;

public class CharactersTest {

	public class MokeCharac extends Charac {

		public MokeCharac(int life, int gold, int power) {
			super(life, gold, power);
		}

		@Override
		public void die() {}
		
	}

	private Charac frodon;

	@Before
	public void beforeTest(){
		this.frodon=new MokeCharac(10,10,10);


	}
	/**
	*
	*
	*/
	@Test
	public void getLifeTest(){
		assertEquals(10,this.frodon.getLife());

	}
	/**
	*
	*
	*/
	@Test
	public void getGoldTest(){
		assertEquals(10,this.frodon.getGold());

	}
	/**
	*
	*
	*/
	@Test
	public void getPowerTest(){
		assertEquals(10,this.frodon.getPower());

	}
	/**
	*
	*
	*/
	@Test
	public void setLifeTest(){
		int a=(int) Math.floor(Math.random()*20);
		this.frodon.setLife(a);
		assertEquals(a,this.frodon.getLife());

	}
	/**
	*
	*
	*/
	@Test
	public void setGoldTest(){
		
		int a=(int) Math.floor(Math.random()*20);
		this.frodon.setGold(a);
		assertEquals(a,this.frodon.getGold());
	}
	/**
	*
	*
	*/
	@Test
	public void setPowerTest(){
		int a=(int) Math.floor(Math.random()*20);
		this.frodon.setPower(a);
		assertEquals(a,this.frodon.getPower());

	}
	/**
	*
	*
	*/
	@Test
	public void setRoomTest(){
		Room room = new Room(10,10);
		this.frodon.setRoom(room);
		assertEquals(room,this.frodon.getRoom());
	}
	/**
	*
	*
	*/
	@Test
	public void attackTest(){
		Charac mons = new MokeCharac(5,5,5);
		int i = this.frodon.getLife()-mons.getPower();
		mons.attack(this.frodon);
		assertEquals(i,this.frodon.getLife());

	}
	/**
	*
	*
	*/
	@Test
	public void addGoldTest(){

		int i=this.frodon.getGold();
		this.frodon.addGold(i);
		assertEquals(2*i,this.frodon.getGold());

	}
	/**
	*
	*
	*/
	@Test
	public void addLifeTest(){
		int i=this.frodon.getLife();
		this.frodon.addLife(i);
		assertEquals(2*i,this.frodon.getLife());

	}
	/**
	*
	*
	*/
	@Test
	public void addPowerTest(){
		int i=this.frodon.getPower();
		this.frodon.addPower(i);
		assertEquals(2*i,this.frodon.getPower());

	}
	/**
	*
	*
	*/
	@Test
	public void isDeadTest(){
		assertTrue(this.frodon.isDead());
		Charac mons = new MokeCharac(20,20,20);
		mons.attack(this.frodon);
		assertFalse(this.frodon.isDead());


	}
}
