package IA2.SelfOrganizingRobots;

import java.util.Random;
import java.util.Random;

public class Playground {
	
	static int numOfBots;
	static Bot[][] table;
	static Bot[][] goal;
	static Bot[] bots;
	static Bot[] goalHolders;
	
	
	
	public Playground(int _numOfBots){
		
		table = new Bot[_numOfBots][_numOfBots];
		goal = new Bot[_numOfBots][_numOfBots];
		bots = new Bot[_numOfBots];
		goalHolders = new Bot[_numOfBots];	
		
		numOfBots = _numOfBots;
		
		int placedBots = 0;
		int xAxis;
		int yAxis;
		Random rand = new Random();
		
		while(placedBots < numOfBots){
			xAxis = rand.nextInt(numOfBots);
			yAxis = rand.nextInt(numOfBots);
			
			if (table[xAxis][yAxis] == null){
				Bot bot = new Bot("*");
				bot.xPos = xAxis;
				bot.yPos = yAxis;
				table[xAxis][yAxis] = bot;
				bots[placedBots] = bot;
				
				placedBots++;
			}						
			
		}
	}
	
	public void confirmAllGoals(){
		for (Bot i : bots){
			i.confirmGoal(goal);
		}
	}
	
	public static void printTable() {
	    for (int y=numOfBots-1; y>=0; y--){	    	
	    	for (int x=0; x<numOfBots; x++){
		    	if(table[x][y] != null){
		    		System.out.print(table[x][y].sign+"  ");
		    	} else {
		    		System.out.print("-  ");
		    	}
		    		
		    }	
	    	System.out.println("");
	    }	   
	    
	    System.out.println("\n\n");
	}
	
	

	
	

	
	public static void printGoal() {
	    for (int y=numOfBots-1; y>=0; y--){	    	
	    	for (int x=0; x<numOfBots; x++){
		    	if(goal[x][y] != null){
		    		System.out.print(goal[x][y].toString()+"  ");
		    	} else {
		    		System.out.print("-  ");
		    	}
		    		
		    }	
	    	System.out.println("");
	    }	   
	    
	    System.out.println("\n\n");
	}
	
	public boolean isOcupied(int x,int y){
		if (table[x][y] != null){
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	public void setGoal(int[] _goal){
		int character = 0;
		int placedHolders = 0;
		goal = new Bot[numOfBots][numOfBots];
		
	
		
		
		
		
		
		int blockSize = (int) Math.sqrt(numOfBots);
		
		Random rand = new Random();
		int startingPoint = rand.nextInt(numOfBots-blockSize);
		
				
		System.out.println("Starting point: "+startingPoint);
		
		for (int x=startingPoint; x<startingPoint+blockSize; x++){	    	
	    	for (int y=startingPoint; y<startingPoint+blockSize; y++){
		    	
	    		
	    		goal[x][y]=new Bot("o");
	    		goal[x][y].xPos=x;
	    		goal[x][y].yPos=y;
	    		
		    	goalHolders[placedHolders] = goal[x][y];
		    	placedHolders++;
		    }	
	    	System.out.println("");
	    }	
	    
		
	}
	
	public Bot[][] getTable(){
		return table;
	}
	
	public Bot[][] getGoal(){
		return goal;
	}

}
