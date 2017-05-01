package IA2.SelfOrganizingRobots;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.omg.CORBA.PRIVATE_MEMBER;

import junit.framework.Protectable;

public class Bot extends Agent{
	
	
	
	
	int xTarget;
	int yTarget;
	
	
	
	
	
	
	
	public Bot(String _sign, int _numOfBots){
		super(_sign);	
		ground = false;
	}
	
	public Bot(String _sign, int _numOfBots, int _xPos, int _yPos){
		super(_sign);	
		ground = false;
		xPos = _xPos;
		yPos = _yPos;
	}
	
	
	public Bot(String _sign){
		super(_sign);
		ground = false;
	}
	
	
	


private int calcMinDistance(int targetX, int targetY){	
	return xPos-targetX + yPos-targetY;
}



public boolean isReachable(SearchTreeLeaf tree[][], int targetX, int targetY){
	
	if (tree[targetX][targetY].visited){
		tree[targetX][targetX].sign = "X";
		//System.out.println("\n");
		//System.out.println("Tentando alcançar o alvo["+targetX+","+targetY+"]\n");
		
		
	}
	return tree[targetX][targetY].visited;
}

public LinkedList<String> calcPath(Playground p, int targetX, int targetY){
	
	
	SearchTreeLeaf tree[][] = new SearchTreeLeaf[p.numOfBots][p.numOfBots];
	
	for (int y=p.numOfBots-1; y>=0; y--){
		for (int x=0; x<p.numOfBots; x++){
			tree[x][y] = new SearchTreeLeaf(p.botsTable[x][y]);					
		}
	}
	
	
	tree[xPos][yPos].markVisited();
	tree[xPos][yPos].father = null;
	
	
	
	
	//Searching the first line ---->
	
		
			for (int x=xPos-1; x>=0; x--){ //starts in the left side of the bot
				if (isReachable(tree, targetX, targetY)){				
					return printTree(p, tree,targetX,targetY);					
				}
				
				
				SearchTreeLeaf previousLeaf = tree[x+1][yPos];
				SearchTreeLeaf currentLeaf = tree[x][yPos];
				
				
				//TODO: Ver a redundância desse father
				if (previousLeaf.visited && currentLeaf.isGround()){
					currentLeaf.markVisited(previousLeaf);
					currentLeaf.father = previousLeaf;
				} else {
					break;
				}
				
				
				
				
			}
		
		
		
		
		 //completes the line by sliding to the right side
		if (!isReachable(tree, targetX, targetY)){
			for (int x = xPos+1; x < p.numOfBots; x++){
				SearchTreeLeaf previousLeaf = tree[x-1][yPos];
				SearchTreeLeaf currentLeaf = tree[x][yPos];
				if (previousLeaf.visited && currentLeaf.isGround()){
					currentLeaf.markVisited(previousLeaf);
					currentLeaf.father = previousLeaf;
					
					if (isReachable(tree, targetX, targetY)){
						return printTree(p, tree,targetX,targetY);
						
					}
				} else {
					break;
				}
				
			}
		} else {
			return printTree(p, tree,targetX,targetY);
			
		}
		// <-----Stops Searching the first line		
		
		
		
		//Start sliding bot
		for (int y = yPos-1; y >= 0; y--){
			// to the left side
			for (int x=xPos; x>=0; x--){				
				visitLeaf(p, tree, x, y);
				if (isReachable(tree, targetX, targetY)){
					return printTree(p, tree,targetX,targetY);
					
				}
			}			
			
			// to the right side
			for (int x=xPos+1; x<p.numOfBots; x++){ 
				visitLeaf(p, tree, x, y);
				if (isReachable(tree, targetX, targetY)){
					return printTree(p, tree,targetX,targetY);
					
				}
			}
		}		
		
		for (int y=yPos; y<p.numOfBots; y++){
			// to the left side
			for (int x=xPos; x>=0; x--){				
				visitLeaf(p, tree, x, y);
				if (isReachable(tree, targetX, targetY)){
					return printTree(p, tree,targetX,targetY);
					
				}
			}			
			
			// to the right side
			for (int x=xPos+1; x<p.numOfBots; x++){ 
				visitLeaf(p, tree, x, y);
				if (isReachable(tree, targetX, targetY)){
					return printTree(p, tree,targetX,targetY);
					
				}
			}
		}	
	System.out.println("Impossível encontrar rota do robô ["+xPos+","+yPos+"] até o alvo ["+targetX+","+targetY+"]");
	
	
	return new LinkedList<String>();
}

private LinkedList<String> printTree(Playground p, SearchTreeLeaf tree[][], int targetX, int targetY){
	
	SearchTreeLeaf currentLeaf = tree[targetX][targetY];
	String lastMove = "no_route";
	LinkedList<String> moves = new LinkedList<String>();
	
	while (currentLeaf != null  && currentLeaf.isGround()){
		SearchTreeLeaf father = currentLeaf.father;
		
		if (currentLeaf.father != null){
			if (currentLeaf.xPos < father.xPos){ //if it's on left
				lastMove = "*";
				currentLeaf.sign = lastMove;
			} else if (currentLeaf.xPos > father.xPos){ //if it's on left
				lastMove = "*";
				currentLeaf.sign = lastMove;
			} 
			
			if (currentLeaf.yPos < father.yPos){ //if it's on left
				lastMove = "*";
				currentLeaf.sign = lastMove;
			} else if (currentLeaf.yPos > father.yPos){ //if it's on left
				lastMove = "*";
				currentLeaf.sign = lastMove;
			} 
		}
		
		moves.addFirst(lastMove);
		
		
		currentLeaf =currentLeaf.father;
		
		
	}
	
	
	
	for (int iy = p.numOfBots-1; iy >= 0; iy--){
    	for (int ix = 0; ix < p.numOfBots; ix++){
    		
    		if(tree[ix][iy].toString()!="-")
    			System.out.print(tree[ix][iy].toString()+"  ");
    		else if ((p.botsTable[ix][iy].toString() != "-"))
    			System.out.print(p.botsTable[ix][iy].toString()+"  ");
    		else if (p.spotsTable[ix][iy].toString() == "o")
    			System.out.print(p.spotsTable[ix][iy].toString()+"  ");
    		else
    			System.out.print(tree[ix][iy].toString()+"  ");
    		 
    			
    		
	    }
    	System.out.println("");
    }
	return moves;	
}



	public void visitLeaf(Playground p, SearchTreeLeaf tree[][], int x, int y){
		
		SearchTreeLeaf currentLeaf = SearchTreeLeaf.getLinkedLeaf(p, tree, x, y, "CURRENT");							
		SearchTreeLeaf topLeaf = SearchTreeLeaf.getLinkedLeaf(p, tree, x, y, "TOP");
		SearchTreeLeaf botLeaf = SearchTreeLeaf.getLinkedLeaf(p, tree, x, y, "BOT");
		SearchTreeLeaf rightLeaf = SearchTreeLeaf.getLinkedLeaf(p, tree, x, y, "RIGHT");				
		SearchTreeLeaf leftLeaf = SearchTreeLeaf.getLinkedLeaf(p, tree, x, y, "LEFT");
		
		if (currentLeaf.isGround()){
			
			
			if (topLeaf != null && topLeaf.visited){
				currentLeaf.markVisited(topLeaf);
				if (leftLeaf != null)
					leftLeaf.revisit(currentLeaf);
				if (rightLeaf != null)
					rightLeaf.revisit(currentLeaf);
				if (botLeaf != null)
					botLeaf.revisit(currentLeaf);
				
			} else if (botLeaf != null && botLeaf.visited){
				currentLeaf.markVisited(botLeaf);
				if (leftLeaf != null)
					leftLeaf.revisit(currentLeaf);
				if (rightLeaf != null)
					rightLeaf.revisit(currentLeaf);
				if (topLeaf != null)
					topLeaf.revisit(currentLeaf);
				
			} else if (rightLeaf != null && rightLeaf.visited){
				currentLeaf.markVisited(rightLeaf);
				if (leftLeaf != null)
					leftLeaf.revisit(currentLeaf);
				if (botLeaf != null)
					botLeaf.revisit(currentLeaf);
				if (topLeaf != null)
				topLeaf.revisit(currentLeaf);
			} else if (leftLeaf != null && leftLeaf.visited){
				currentLeaf.markVisited(leftLeaf);
				if (rightLeaf != null)
					rightLeaf.revisit(currentLeaf);
				
				if (botLeaf != null)
					botLeaf.revisit(currentLeaf);
				if (topLeaf != null)
					topLeaf.revisit(currentLeaf);
			}
		}
		
	}









	
	
	




public void move(Playground p, LinkedList<String> directions){
	
	int plusX=0;
	int plusY=0;
	
	
	
	while(!directions.isEmpty()){		
		String dir = directions.poll();
		//System.out.print(dir+" ");
		switch (dir) {
		case "↓":
			plusY--;
		break;
		
		case "↑":
			plusY++;
		break;		
		case "→":
			plusX++;
		break;
		
		case "←":
			plusX--;
		break;

		default:
			break;
		}
	}
	
	
	
	int newX = xPos+plusX;
	int newY = yPos+plusY;
	
	System.out.println("pos: ["+xPos+","+xPos+"]");
	System.out.println("newpos ["+newX+","+newY+"]");
	
	
	
	p.botsTable[newX][newY] = new Bot(sign, p.numOfBots);
	p.botsTable[xPos][yPos] = new Ground("-");
	
	
	
	xPos = newX;
	yPos = newY;
}


	
	
	
	
	
	
	

	


	
	
	
	
	

}

