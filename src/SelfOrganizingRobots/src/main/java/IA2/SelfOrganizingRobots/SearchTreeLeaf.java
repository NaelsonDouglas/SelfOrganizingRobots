package IA2.SelfOrganizingRobots;

public class SearchTreeLeaf extends Cell {
	SearchTreeLeaf father;
	SearchTreeLeaf son;
	boolean visited;
	
	public SearchTreeLeaf(Agent agent) {
		xPos = agent.xPos;
		yPos = agent.yPos;
		visited = false;	
		sign="-";
		ground = agent.isGround();
		
	}
	
	public void revisit(SearchTreeLeaf neighboor){
		if (!visited && isGround())
			markVisited(neighboor);
	}
	
	
	public static SearchTreeLeaf getLinkedLeaf(Playground p, SearchTreeLeaf tree[][], int x, int y, String direction){
		
		SearchTreeLeaf currentLeaf;	
		SearchTreeLeaf rightLeaf;				
		SearchTreeLeaf topLeaf;
		SearchTreeLeaf botLeaf;
		SearchTreeLeaf leftLeaf;
		
		if (x == 0){
			leftLeaf = null;
			rightLeaf = tree[x+1][y];
		}
		else if (x == p.numOfBots-1){
			leftLeaf = tree[x-1][y];
			rightLeaf = null;
		}
		else{
			rightLeaf = tree[x+1][y];
			leftLeaf = tree[x-1][y];
		}
		
		
		if (y == 0){
			topLeaf = tree[x][y+1];
			botLeaf = null;					
		}
		else if (y == p.numOfBots-1){
			topLeaf = null;
			botLeaf = tree[x][y-1];					
		}
		else{
			topLeaf = tree[x][y+1];
			botLeaf = tree[x][y-1];					
		}
		
		currentLeaf = tree[x][y];
		
		if (direction.toUpperCase().equals("RIGHT")){
			return rightLeaf;
		} else if (direction.toUpperCase().equals("LEFT")){
			return leftLeaf;
		} else if (direction.toUpperCase().equals("TOP")){
			return topLeaf;
		} else if (direction.toUpperCase().equals("BOT")){
			return botLeaf;
		} if (direction.toUpperCase().equals("CURRENT")){
			return currentLeaf;
		} 
		
		return null;
		
	}
	
	
	
	
	
	public boolean isTarget(int targetX, int targetY){
		return((xPos == targetX) && (yPos == targetY));
	}
	
	
	public void markVisited(){
		visited = true;
		sign = "X";
	}
	
	public void markVisited(SearchTreeLeaf _father){
		
		if (!visited){
			visited = true;
			//sign = "*";
			father = _father;
			
			/*
			BUUUUUUUUUUUUUUG
			if (_father.xPos > xPos){
				father.sign = "←";
			} else if (_father.xPos < xPos){
				father.sign = "→";
			}else if (_father.yPos > yPos){
				father.sign = "↓";
			} else if (_father.yPos < yPos){
				father.sign = "↑";
			}
			
			*/
		} 
		
	}
			
	
	public void unmarkVisited(){
		visited = false;
	}
}
