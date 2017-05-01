package IA2.SelfOrganizingRobots;

import java.util.ArrayList;
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
	
	public void comeToMe(Playground p, int botId){
		Bot bot = p.bots[botId];
		
		
		int oldXpos = bot.xPos;
		int oldYpos = bot.yPos;
		String botSign = bot.sign;
		
		Bot botNewPos = new Bot(botSign);
		
		botNewPos.xPos = this.xPos;
		botNewPos.yPos = this.yPos;
		
		p.botsTable[xPos][yPos] = botNewPos;
		p.botsTable[oldXpos][oldYpos] = new Ground("-");
		
		
		
		
		
		
		
		
	}
	
	
	public void callBot(Playground p){
		Bot[] bots = p.bots;
		int i=0;
		
		LinkedList<String> route = null;
		
		if (!p.botsTable[xPos][yPos].isGround()){
			p.botsTable[xPos][yPos].done = true;
			foundBot = true;
		} else {
		while(route == null){

			if (!p.bots[i].done && !foundBot){
				
				route = p.bots[i].calcPath(p, xPos, yPos);
				
				
				
				if (route != null){
					//System.out.print("Robô: "+p.bots[i].toString()+" <=> ");
					//System.out.println(route+"\n");
					System.out.println("\n\n");
					
					foundBot = true;					
					p.bots[i].done = true;
					comeToMe(p, i);		
					
				}
				
			}
			i++;
		}
		}
		
		
	
	}
	
	
		
		
		
	}
	
	
	
	


