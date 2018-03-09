package Action;

public class AtackActionTest extends ActionTest {
	
	
    public Action getAction() {return new AtackAction();}
    public boolean reponce_isPossible_emptyRoom() {return false;}
    public boolean reponce_isPossible_MonsterRoom() {return true;}
    public boolean reponce_isPossible_ItemRoom() {return false;}

	
}