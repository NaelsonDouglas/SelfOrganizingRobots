package IA2.SelfOrganizingRobots;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bot extends Agent{
	
	
	
	
	int xTarget;
	int yTarget;
	
	
	
	
	
	
	
	public Bot(String _sign, int _numOfBots){
		super(_sign);	
		ground = false;
	}
	
	
	public Bot(String _sign){
		super(_sign);
		ground = false;
	}
	
	
	


private int calcMinDistance(int targetX, int targetY){	
	return xPos-targetX + yPos-targetY;
}


public String[] calcPath(Playground p, int targetX, int targetY, int[][] _distances){
	
	int[][] distances = _distances;
	
	if (distances == null){
		distances = new int[p.numOfBots][p.numOfBots];
	}
	
	if (up(p).isGround()){
		calcMinDistance(up(p).xPos, up(p).yPos);
	}
	
	
	return new String[10];
	
}






	
	
	
	
	
	
	
	public boolean move(String direction, Playground p){
		//direction == up, down, left or right
		
		
		switch (direction.toUpperCase()) {
		case "DOWN":
			if (this.down(p) == null){
				yPos--;			
				Playground.botsTable[xPos][yPos] = this;
				Playground.botsTable[xPos][yPos+1] = null;
				return true;
			}
			
					
			//System.out.println("Não pode descer");
			return false;
		
		case "UP":
			if (this.up(p) == null && yPos+1 < p.numOfBots){
				yPos++;
				
				Playground.botsTable[xPos][yPos] = this;
				Playground.botsTable[xPos][yPos-1] = null;
				return true;
			}
			
			
		System.out.println("Não pode subir");
		return false;
		
		case "LEFT":
			if (this.left(p) == null && xPos-1 >=0){
				xPos--;
				Playground.botsTable[xPos][yPos] = this;
				Playground.botsTable[xPos+1][yPos] = null;
				return true;
			}
			
			
			System.out.println("Não pode ir à esquerda");
		return false;
		
		case "RIGHT":
			if (this.right(p) == null && xPos+1 < p.numOfBots){
				xPos++;
				Playground.botsTable[xPos][yPos] = this;
				Playground.botsTable[xPos-1][yPos] = null;
				return true;
			}
			
			System.out.println("Não pode ir à direitaa");
		return false;
			

		default:
			return false;
		}
	}
	
	
	


	
	
	
	
	

}

