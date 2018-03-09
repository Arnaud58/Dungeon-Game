package Action;

import static org.junit.Assert.*;

import org.junit.Test;

public class RestTest extends ActionTest {	
		
		@Test
		public void executeTest() {
			this.ourHero.setLife(this.ourHero.getLife()-10);
			assertEquals(40,this.ourHero.getLife());
			this.act.execute(this.ourHero);
			assertEquals(50,this.ourHero.getLife());
			
			this.ourHero.setLife(this.ourHero.getLife()+10);
			this.act.equals(this.ourHero);
			assertEquals(60,this.ourHero.getLife());
		}
		
		
		public Action getAction() {return new Rest();}
	    public boolean reponce_isPossible_emptyRoom() {return true;}
	    public boolean reponce_isPossible_MonsterRoom() {return false;}
	    public boolean reponce_isPossible_ItemRoom() {return true;}
	    
	}
