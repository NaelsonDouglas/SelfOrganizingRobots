package IA2.SelfOrganizingRobots;

public class Cell {
	boolean ground;
	int xPos;
	int yPos;
	String sign;
	
	
	
	public boolean isGround(){
		return ground;
	}
	
	public String toString(){
		return sign;
	}
	
	public String locationtoString(){
		return "["+Integer.toString(xPos)+","+Integer.toString(yPos)+"]";
	}
}


