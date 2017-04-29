package IA2.SelfOrganizingRobots;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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


public String[] startPathCalc(Playground p, int targetX, int targetY){
	
	
	SearchTreeLeaf tree[][] = new SearchTreeLeaf[p.numOfBots][p.numOfBots];
	
	for (int y=p.numOfBots-1; y>=0; y--){
		for (int x=0; x<p.numOfBots; x++){
			tree[x][y] = new SearchTreeLeaf(p.botsTable[x][y]);					
		}
	}
	
	
	tree[xPos][yPos].markVisited();
	tree[xPos][yPos].father=null;
	
	
	//Searching the first line ---->
	
		for (int x=xPos-1; x>=0; x--){ //starts in the left side of the bot
			SearchTreeLeaf previousLeaf = tree[x+1][yPos];
			SearchTreeLeaf currentLeaf = tree[x][yPos];
			if (previousLeaf.visited && currentLeaf.isGround()){
				currentLeaf.markVisited();
				currentLeaf.father = previousLeaf;
			} else {
				break;
			}
		}
		
		
		
		
		
		for (int x=xPos+1; x<p.numOfBots; x++){ //completes de line by sliding to the right side
			SearchTreeLeaf previousLeaf = tree[x-1][yPos];
			SearchTreeLeaf currentLeaf = tree[x][yPos];
			if (previousLeaf.visited && currentLeaf.isGround()){
				currentLeaf.markVisited();
				currentLeaf.father = previousLeaf;
			} else {
				break;
			}
		}
		// <-----Stops Searching the first line		
		
		
		//Start sliding bot
		for (int y=yPos-1; y>=0; y--){
			// to the left side
			for (int x=xPos; x>=0; x--){				
				visitLeaf(p, tree, x, y);
			}			
			
			// to the right side
			for (int x=xPos+1; x<p.numOfBots; x++){ 
				visitLeaf(p, tree, x, y);
			}
		}		
		
		for (int y=yPos; y<p.numOfBots; y++){
			// to the left side
			for (int x=xPos; x>=0; x--){				
				visitLeaf(p, tree, x, y);
			}			
			
			// to the right side
			for (int x=xPos+1; x<p.numOfBots; x++){ 
				visitLeaf(p, tree, x, y);
			}
		}
		
		
		
		
		
		
		
	System.out.println("\n\n ------");
	for (int iy = p.numOfBots-1; iy >= 0; iy--){
    	for (int ix = 0; ix < p.numOfBots; ix++){
	    	System.out.print(tree[ix][iy].toString()+"  ");
	    }
    	System.out.println("");
    }
	
	
	
	
	return null;
}


	public void visitLeaf(Playground p, SearchTreeLeaf tree[][], int x, int y){
		
		SearchTreeLeaf currentLeaf = SearchTreeLeaf.getLinkedLeaf(p, tree, x, y, "CURRENT");							
		SearchTreeLeaf topLeaf = SearchTreeLeaf.getLinkedLeaf(p, tree, x, y, "TOP");
		SearchTreeLeaf botLeaf = SearchTreeLeaf.getLinkedLeaf(p, tree, x, y, "BOT");
		SearchTreeLeaf rightLeaf = SearchTreeLeaf.getLinkedLeaf(p, tree, x, y, "RIGHT");				
		SearchTreeLeaf leftLeaf = SearchTreeLeaf.getLinkedLeaf(p, tree, x, y, "LEFT");
		
		if (currentLeaf.isGround() ){
			
			
			if (topLeaf.visited){
				currentLeaf.markVisited(topLeaf);
				
				leftLeaf.revisit(currentLeaf);
				rightLeaf.revisit(currentLeaf);
				botLeaf.revisit(currentLeaf);
				
			} else if (botLeaf.visited){
				currentLeaf.markVisited(botLeaf);
				
				leftLeaf.revisit(currentLeaf);
				rightLeaf.revisit(currentLeaf);
				topLeaf.revisit(currentLeaf);
				
			} else if (rightLeaf.visited){
				currentLeaf.markVisited(rightLeaf);
				
				leftLeaf.revisit(currentLeaf);
				botLeaf.revisit(currentLeaf);
				topLeaf.revisit(currentLeaf);
			} else if (leftLeaf.visited){
				currentLeaf.markVisited(leftLeaf);
				
				rightLeaf.revisit(currentLeaf);
				botLeaf.revisit(currentLeaf);
				topLeaf.revisit(currentLeaf);
			}
		}
		
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

