package IA2.SelfOrganizingRobots;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        
        
        Playground p = new Playground(4);
        
        p.setGoal(new int[]{0,0,1,0,0,1,0,0,0,0,1,1,0,0,0,0});
        
        
        
        p.bots[1].sign = "x";
        Bot ponta = p.bots[1];
        
        
        p.printGoal();
        p.printTable();        
        
        
        
        ponta.findGoal(p);
        
        for (Bot i : p.bots){
        		i.findGoal(p);
        }
        
        p.printTable();   
       
      
        p.printGoal();
       	
    }
}

