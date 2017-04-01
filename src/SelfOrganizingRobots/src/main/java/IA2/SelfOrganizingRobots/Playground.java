package IA2.SelfOrganizingRobots;

import java.util.Random;
import java.util.Random;

public class Playground {
	
	static int numOfBots;
	static Bot[][] table;
	static boolean[][] goal;
	
	
	
	
	public Playground(int _numOfBots){
		
		table = new Bot[_numOfBots][_numOfBots];
		goal = new boolean[_numOfBots][_numOfBots];
		
		
		numOfBots = _numOfBots;
		
		int placedBots = 0;
		int xAxis;
		int yAxis;
		Random rand = new Random();
		
		while(placedBots < numOfBots){
			xAxis = rand.nextInt(numOfBots);
			yAxis = rand.nextInt(numOfBots);
			
			if (table[xAxis][yAxis] == null){
				table[xAxis][yAxis] = new Bot();
				
				
				placedBots++;
			}						
			
		}
	}
	
	public static void printTable() {
	    for (int x=0; x<numOfBots; x++){	    	
	    	for (int y=0; y<numOfBots; y++){
		    	if(table[x][y] != null){
		    		System.out.print("*  ");
		    	} else {
		    		System.out.print("-  ");
		    	}
		    		
		    }	
	    	System.out.println("");
	    }	   
	    
	    System.out.println("\n\n");
	}
	
	
	public static void printGoal() {
	    for (int x=0; x<numOfBots; x++){	    	
	    	for (int y=0; y<numOfBots; y++){
		    	if(goal[x][y] == true){
		    		System.out.print("o  ");
		    	} else {
		    		System.out.print("-  ");
		    	}
		    		
		    }	
	    	System.out.println("");
	    }	   
	    
	    System.out.println("\n\n");
	}
	
	
	
	
	public void setGoal(String _goal){
		int blockSize = (int) Math.sqrt(numOfBots);
		
		Random rand = new Random();
		int startingPoint = rand.nextInt(numOfBots-blockSize);
				
				
		System.out.println("Starting point: "+startingPoint);
		
		for (int x=startingPoint; x<startingPoint+blockSize; x++){	    	
	    	for (int y=startingPoint; y<startingPoint+blockSize; y++){
		    	goal[x][y]=true;		    		
		    }	
	    	System.out.println("");
	    }	
		
	}
	
	public Bot[][] getTable(){
		return table;
	}
	
	public boolean[][] getGoal(){
		return goal;
	}

}
