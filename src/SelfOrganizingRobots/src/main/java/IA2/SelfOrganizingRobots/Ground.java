package IA2.SelfOrganizingRobots;

public class Ground extends Agent {

	public Ground(String _sign,int x, int y) {
		super(_sign);
		ground = true;
		
		xPos = x;
		yPos = y;
		// 
	}
	
	
	public Ground(String _sign) {
		super(_sign);
		ground = true;
		
		xPos = -1;
		yPos = -1;
		// 
	}
	
	
	
	

	

}
