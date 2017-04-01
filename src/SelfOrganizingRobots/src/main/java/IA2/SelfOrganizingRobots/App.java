package IA2.SelfOrganizingRobots;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        
        
        Playground p = new Playground(25);
        p.setGoal("whatever");
        
        
        p.printTable();
        p.printGoal();
        
        if(p.getGoal()[1][1]){
        	System.out.println("é true");
        }
        	
    }
}
