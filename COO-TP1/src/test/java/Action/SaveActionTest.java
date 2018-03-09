package Action;


public class SaveActionTest extends ActionTest{

	public Action getAction() {return new LookAction();}
    public boolean reponce_isPossible_emptyRoom() {return true;}
    public boolean reponce_isPossible_MonsterRoom() {return true;}
    public boolean reponce_isPossible_ItemRoom() {return true;}

}