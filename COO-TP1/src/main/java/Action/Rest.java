package Action;
import Characters.*;


public class Rest implements Action {
	
	
	public boolean isPossible(Player p) {
        if (p.getRoom().nbMonster()==0) {
        	return true;
        }
        else{
        	return false;
        }
    }
	

	public void execute(Player p) {
        if (p.getLife()<=p.getInitLife()) {
            p.setLife(p.getInitLife());
        }
        
    }
    
    public String toString() {
		return "Rest";
	}

}
