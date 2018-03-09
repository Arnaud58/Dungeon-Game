package Action;

public class MoveActionTest extends ActionTest {	
		public Action getAction() {return new MoveAction();}
	    public boolean reponce_isPossible_emptyRoom() {return true;}
	    public boolean reponce_isPossible_MonsterRoom() {return false;}
	    public boolean reponce_isPossible_ItemRoom() {return true;}
	    
	}