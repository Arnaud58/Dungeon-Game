package Rooms;


/**
 * @author rougetet and lefevere
 * Describe all possible direction we can take when we are in a room of the dungeon
 */
public enum Direction {
	North,South,East,West;

	/**
	 * Give the opposite Direction of this Direction
	 * @return A direction that is the opposite of this direction
	 */
	public Direction Opposite() {
		if (this==North) {
			return South;
		}
		if (this==South) {
			return North;
		}
		if (this==East) {
			return West;
		}

		return East;
	}
	
	/**
	 * Give the Direction in the right of this Direction
	 * @return A direction that is in the right of this direction
	 */
	public Direction Right() {
		if (this==North) {
			return West;
		}
		if (this==South) {
			return East;
		}
		if (this==East) {
			return North;
		}

		return South;
	}
	
	/**
	 * Give the Direction in the left of this Direction
	 * @return A direction that is in the left of this direction
	 */
	public Direction Left() {
		if (this==North) {
			return East;
		}
		if (this==South) {
			return West;
		}
		if (this==East) {
			return South;
		}

		return North;
	}
	
	
	
	/**
	 * Transform an int to a direction
	 * @param i A int that represent a direction
	 * @return A direction that is the direction that correspond to this number
	 */
	public static Direction toDirection(int i) {
		if (i==0) {
			return South;
		}
		if (i==1) {
			return East;
		}
		if (i==2) {
			return North;
		}
		if (i==3) {
			return West;
		}

		throw new RuntimeException("This int doesn't represent a dirction");
	}
	
	/**
	 * Transform a Direction to an int
	 * @return An int 0(South) 1(East) 2(North) 3(West)
	 */
	public int toInt() {
		if (this==North) {
			return 2;
		}
		if (this==South) {
			return 0;
		}
		if (this==East) {
			return 1;
		}
		if (this==West) {
			return 3;
		}

		return -1;

	}


	public String toString() {
		if (this==North) {
			return "North";
		}
		if (this==South) {
			return "South";
		}
		if (this==East) {
			return "East";
		}

		if (this==West) {
			return "West";
		}

		return "not a direction";
	   
    }
}