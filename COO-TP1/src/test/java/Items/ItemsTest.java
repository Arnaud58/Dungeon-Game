package Items;

import Characters.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemsTest {
	
	private Player ourHero;
	private Items gold;
	private Items life;
	private Items strength;
	
	 
	
	@Before
	public void beforeTest() {
		
		this.ourHero = new Player(50,50,50,null, null);
		this.gold = new Gold(100);
		this.life = new Life(10);
		this.strength = new Strength(5);
	}

	@Test
	public void goldTest() {
		assertEquals(50,this.ourHero.getGold());
		this.gold.isUsedBy(this.ourHero);
		assertEquals(150,this.ourHero.getGold());
	}
	
	@Test
	public void lifeTest() {
		assertEquals(50,this.ourHero.getLife());
		this.life.isUsedBy(this.ourHero);
		assertEquals(60,this.ourHero.getLife());
		
	}
	
	@Test
	public void strengthTest() {
		assertEquals(50,this.ourHero.getPower());
		this.strength.isUsedBy(this.ourHero);
		assertEquals(55,this.ourHero.getPower());
	}

}


