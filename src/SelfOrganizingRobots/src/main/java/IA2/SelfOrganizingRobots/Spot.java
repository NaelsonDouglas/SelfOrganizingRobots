package IA2.SelfOrganizingRobots;

import java.util.LinkedList;
import java.util.Queue;

public class Spot extends Agent{

	Queue<String> routeToMe;
	boolean foundBot;
	
	public Spot(String _sign) {
		super(_sign);
		ground = true;
		foundBot = false;
	}
	
	
	public void callBot(Playground p,Bot[] bots){
		
		
		foundBot = false;
		
		for (Bot bot : bots){			
				if(!foundBot){
					routeToMe = new LinkedList<>();
					bot.findRoute(p, this, routeToMe);
				}
			}
		
			while(routeToMe.size() > 0){
				System.out.println("teste");
				System.out.println(routeToMe.poll());
			}
		}
	
	
		
		
		
	}
	
	
	
	


