package IA2.SelfOrganizingRobots;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
		
    public static void main( String[] args )
    {

    	
    	
        
        
        Playground p = new Playground(25);
        
        p.setGoal(new int[]{0,0,1,0,0,1,0,0,0,0,1,1,0,0,0,0});
        
        
      
        
        
        
        
        
        
        
        
        //System.out.println("Acabou");
        p.printBots();   
        
        System.out.println();
        p.printSpots();
        
        
        
        
        System.out.println("\n");
        
        for (Spot spot : p.spots){
        	
        	if (!spot.foundBot){
        		System.out.println("Spot location "+spot.locationtoString());
        		spot.callBot(p);
        	}
        	
        	
        	
        }
        
        
        System.out.println("\n");
        p.printBots();
        
        
        
        
        
        
        
        
     
        
        
            
        
        
        
       
        
        
        

       	
    }
}

