package IA2.SelfOrganizingRobots;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Agent extends Cell {
	
	boolean done;

	
	
	
	public Agent(String _sign){
		sign = _sign;
		done=false;	
		ground = false;
		
	}
	

public Queue<String> findRoute(Playground p, Spot caller,  Queue<String> route){
		
		
		
		
		Queue<String> localRoute = new LinkedList<>();
		localRoute = route;
		
		
		if (xPos == caller.xPos && yPos == caller.yPos){	
			

			caller.foundBot = true;
			caller.routeToMe = localRoute;
			return null;
		}
		
		
		
		if (caller.foundBot){
			
			
			
			
			System.out.println("Carnaval de salvadô");
			
		}
			
			
			if (down(p).isGround()){				
				localRoute.add("DOWN");			
				return down(p).findRoute(p, caller, localRoute);
			} else if (up(p).isGround()){
				localRoute.add("UP");			
				return up(p).findRoute(p, caller, localRoute);			
			} else if (left(p).isGround()){
				localRoute.add("LEFT");			
				return left(p).findRoute(p, caller, localRoute);			
			} else if (right(p).isGround()){
				localRoute.add("RIGHT");			
				return right(p).findRoute(p, caller, localRoute);			
			}
			
			
			
		
		
		
		
		
		return null;
		
		
		
		
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
