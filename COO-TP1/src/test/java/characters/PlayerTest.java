package characters;
import Characters.*;
import Rooms.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest{



	private Player gandalf;
	private Dungeon bar;

	@Before
	public void beforeTest(){
		Room room =new Room(9,9);
		this.gandalf=new Player(10,10,10,room,null);
	}

	@Test 
	public void getInitLifeTest(){
		int i = gandalf.getInitLife();
		assertEquals(i,gandalf.getInitLife());
	}
	@Test 
	public void getComeFromTest(){
		assertEquals(Direction.North,this.gandalf.getComeFrom());
	}
	@Test 
	public void setComeFromTest(){
		assertEquals(Direction.North,this.gandalf.getComeFrom());
		Direction pos = Direction.South;
		this.gandalf.setComeFrom(pos);
		assertEquals(Direction.South,this.gandalf.getComeFrom());
	}

	
}
