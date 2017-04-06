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
        p.setGoal("whatever essa string não faz efeito ainda, mas vou manter a assinatura do método com ela para uma atualização futura");
        
        
        
        p.bots[1].sign = "x";
        Bot ponta = p.bots[1];
        
        System.out.println(ponta.yPos);
        p.printTable();
        //p.printGoal();
        
        ponta.move("UP",p);  
        ponta.up(p);
        ponta.down(p);
        p.printTable();
        
        
        
        
        ponta.move("DOWN",p);
        ponta.up(p);
        ponta.down(p);
        ponta.left(p);
        ponta.right(p);
        p.printTable();
        
        
        
        ponta.move("LEFT",p);
        ponta.up(p);
        ponta.down(p);
        p.printTable();
        
        ponta.move("RIGHT",p);
        ponta.up(p);
        ponta.down(p);
        p.printTable();
        
       	
    }
}

