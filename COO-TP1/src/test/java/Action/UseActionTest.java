package Action;

public class UseActionTest extends ActionTest {
	
	
    public Action getAction() {return new UseAction();}
    public boolean reponce_isPossible_emptyRoom() {return false;}
    public boolean reponce_isPossible_MonsterRoom() {return false;}
    public boolean reponce_isPossible_ItemRoom() {return true;}

	
}
