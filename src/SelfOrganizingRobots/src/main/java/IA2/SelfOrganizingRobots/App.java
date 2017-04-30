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

    	
    	
        
        
        Playground p = new Playground(9);
        
        p.setGoal(new int[]{0,0,1,0,0,1,0,0,0,0,1,1,0,0,0,0});
        /*
        
        p.botsTable[3][0] = new Bot("1");
        p.botsTable[3][2] = new Bot("1");
        
        p.botsTable[3][4] = new Bot("1");
        p.botsTable[3][6] = new Bot("1");
        p.botsTable[3][8] = new Bot("1");
        
        p.botsTable[1][0] = new Bot("1");
        p.botsTable[1][2] = new Bot("1");
        
        p.botsTable[1][4] = new Bot("1");
        p.botsTable[1][5] = new Bot("1");
        p.botsTable[1][6] = new Bot("1");
        p.botsTable[1][8] = new Bot("1");
        
        
        p.botsTable[5][0] = new Bot("1");
        p.botsTable[5][2] = new Bot("1");
        
        p.botsTable[5][4] = new Bot("1");
        p.botsTable[5][6] = new Bot("1");
        p.botsTable[5][8] = new Bot("1");
        
        */
        
        
        
        
        
        
        //System.out.println("Acabou");
        p.printBots();   
        
        System.out.println();
        p.printSpots();
        
        
        
        
        
        
        for (Spot spot : p.spots){
        	
        	if (!spot.foundBot){
        		System.out.println("Spot locatoin "+spot.locationtoString());
        		spot.callBot(p);
        	}
        	
        	
        	
        }
        
        
        System.out.println("\n");
        p.printBots();
        
        
        
        
        
        
        
        
     
        
        
            
        
        
        
       
        
        
        

       	
    }
}

