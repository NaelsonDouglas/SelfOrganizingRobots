package IA2.SelfOrganizingRobots;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Agent extends Cell {
	
	boolean done;
	boolean wall;
	
	
	public boolean isWall(){
		return wall;
	}

	
	
	
	public Agent(String _sign){
		sign = _sign;
		done=false;	
		ground = false;
		wall = false;
		
	}
	






public Agent  up(Playground p){
	
	if (yPos+1 < p.numOfBots){		
		
		return p.botsTable[xPos][yPos+1];
	} else {	
		Ground agent = new Ground("flag");
		agent.ground = false;		
		return agent;
	}			
}


public Agent down(Playground p){
	
	if (yPos-1 >= 0 ){
			return p.botsTable[xPos][yPos-1];
		} else {				
			Ground agent = new Ground("flag");
			agent.ground = false;
			return agent;
		}

				
}



public Agent  left(Playground p){	
	if (xPos-1 >= 0){
		return p.botsTable[xPos-1][yPos];			
	} else {			
		Ground agent = new Ground("flag");
		agent.ground = false;
		return agent;
	}				
}


public Agent  right(Playground p){

if (xPos+1 <  p.numOfBots ){
	return p.botsTable[xPos+1][yPos];
} else {		
	Ground agent = new Ground("flag");
	agent.ground = false;
	return agent;
}			
}
	
	
}
