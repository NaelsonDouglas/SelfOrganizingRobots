package IA2.SelfOrganizingRobots;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
		
    public static void main( String[] args )
    {

    	
    	
        
        
        Playground p = new Playground(16);
        
        p.setGoal(new int[]{0,0,1,0,0,1,0,0,0,0,1,1,0,0,0,0});
        
        
        
        
        
        //System.out.println("Acabou");
        p.printBots();   
        
        System.out.println();
       // p.printSpots();
        
        p.spots[1].callBot(p, p.bots);
        
        p.bots[0].calcPath(p, p.spots[0].xPos, p.spots[0].yPos);
        
        
        
        
        
        
        
        
     
        
        
            
        
        
        
       
        
        
        

       	
    }
}

