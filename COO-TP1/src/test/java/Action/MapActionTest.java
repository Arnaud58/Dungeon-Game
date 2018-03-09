package Action;


public class MapActionTest extends ActionTest {
	
	public Action getAction() {return new MapAction();}
    public boolean reponce_isPossible_emptyRoom() {return true;}
    public boolean reponce_isPossible_MonsterRoom() {return true;}
    public boolean reponce_isPossible_ItemRoom() {return true;}
    
}