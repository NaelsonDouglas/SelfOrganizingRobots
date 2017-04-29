package IA2.SelfOrganizingRobots;

import java.util.Random;
import java.util.Random;

public class Playground {
	
	static int numOfBots;
	static Agent[][] botsTable;
	static Spot[][] spotsTable;
	
	
	static Bot[] bots;
	static Spot[] spots;
	
	
	
	public Playground(int _numOfBots){
		numOfBots = _numOfBots;
		botsTable = new Agent[_numOfBots][_numOfBots];
		
		for (int y=0; y<_numOfBots; y++){
			for (int x=0; x<_numOfBots; x++){
				botsTable[x][y] = new Ground("-",x,y);
				
			}
		}
		
		
		
		bots = new Bot[_numOfBots];
		spots = new Spot[_numOfBots];	
		
		numOfBots = _numOfBots;
		
		int placedBots = 0;
		int xAxis;
		int yAxis;
		Random rand = new Random();
		
		while(placedBots < numOfBots){
			
			xAxis = rand.nextInt(numOfBots);
			yAxis = rand.nextInt(numOfBots);
			
			if (botsTable[xAxis][yAxis].isGround()){
				Bot bot = new Bot(Integer.toString(placedBots), _numOfBots);
				bot.xPos = xAxis;
				bot.yPos = yAxis;
				botsTable[xAxis][yAxis] = bot;
				bots[placedBots] = bot;
				
				
				placedBots++;
			}						
			
		}
	}
	
	
	
	
	

	
	

	
	
	
	private static void printTable(Cell[][] table){
		
		for (int y = numOfBots-1; y >= 0; y--){
	    	for (int x = 0; x < numOfBots; x++){
		    	System.out.print(table[x][y].toString()+"  ");
		    }
	    	System.out.println("");
	    }
		
	}

	
	public static void printSpots() {
	    printTable(spotsTable);	
	}
	
	public static void printBots() {
	    printTable(botsTable);	
	}
	
	public boolean isOcupied(int x,int y){
		if (botsTable[x][y] != null){
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	public void setGoal(int[] _goal){
		int character = 0;
		int placedHolders = 0;
		spotsTable = new Spot[numOfBots][numOfBots];
		
	
		
		
	    	
		
		
		
		
		int blockSize = (int) Math.sqrt(numOfBots);
		
		
				
		for (int x=0; x<numOfBots; x++){	    	
	    	for (int y=0; y<numOfBots; y++){
	    		spotsTable[x][y]=new Spot("-");
	    	}
	    	
		}
		

		Random rand = new Random();
		int startingPoint = rand.nextInt(numOfBots-blockSize);
		
		for (int x=startingPoint; x<startingPoint+blockSize; x++){	    	
	    	for (int y=startingPoint; y<startingPoint+blockSize; y++){
		    	
	    		
	    		spotsTable[x][y]=new Spot("o");
	    		spotsTable[x][y].xPos=x;
	    		spotsTable[x][y].yPos=y;
	    		
		    	spots[placedHolders] = spotsTable[x][y];
		    	placedHolders++;
		    }	
	    	System.out.println("");
	    }	
	    
		
	}
	

}
