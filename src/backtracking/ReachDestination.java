package backtracking;

public class ReachDestination {
	public static boolean reachDestination(int sx, int sy, int dx, int dy) {
		// Write your code here
		if(sx>dx || sy>dy){
			return false;
		}
		if(sx==dx && sy==dy){
			return true;
		}
		
		return reachDestination(sx, sy, dx-dy, dy) || reachDestination(sx, sy, dx, dy-dx );
	}
}
