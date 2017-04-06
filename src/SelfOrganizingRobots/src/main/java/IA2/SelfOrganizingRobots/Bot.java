package IA2.SelfOrganizingRobots;

public class Bot {
	
	
	int xPos;
	int yPos;
	String sign;
	
	
	public Bot(String _sign){
		sign = _sign;
	}
	
	public Bot  up(Playground p){
		
		
		System.out.println("Meu yPos+1: "+yPos+1+" \n meu numOfBots: "+p.numOfBots);
		if (this.yPos+1 < p.numOfBots){
			return p.table[xPos][yPos+1];
		} else {
			System.out.println("Acima é um precipício");
			return null;
		}			
	}
	
	
public Bot  down(Playground p){
		
		if (yPos-1 >= 0 ){
			return p.table[xPos][yPos-1];
		} else {
			System.out.println("Abaixo é um precipício");
			return null;
		}			
	}



public Bot  left(Playground p){
	
	if (xPos-1 >= 0 ){
		return p.table[xPos-1][yPos];
	} else {
		System.out.println("Á esquerda é um precipício");
		return null;
	}			
}


public Bot  right(Playground p){
	
	if (xPos+1 <  p.numOfBots ){
		return p.table[xPos+1][yPos];
	} else {
		System.out.println("Á direita é um precipício");
		return null;
	}			
}




	
	
	
	
	
	
	
	
	
	public void move(String direction, Playground p){
		//direction == up, down, left or right
		
		
		switch (direction.toUpperCase()) {
		case "DOWN":
			if (this.down(p) != null){
				yPos--;			
				Playground.table[xPos][yPos] = this;
				Playground.table[xPos][yPos-1] = new Bot("-");
			}
		break;
			
		case "UP":
			if (this.up(p) != null){
				yPos--;	
				System.out.println("Acima não é nulo");
				Playground.table[xPos][yPos] = this;
				Playground.table[xPos][yPos+1] = new Bot("-");
			}
		break;
		
		case "LEFT":
			if (this.left(p) != null){
				xPos--;
				Playground.table[xPos][yPos] = this;
				Playground.table[xPos+1][yPos] = new Bot("-");
			}
		break;
		
		case "RIGHT":
			if (this.right(p) != null){
				xPos++;
				Playground.table[xPos][yPos] = this;
				Playground.table[xPos-1][yPos] = new Bot("-");
			}
		break;
			

		default:
			break;
		}
	}
	

	public void findPlace(Playground p){
		
	}
	
	
	
	public String toString(){
		return sign;
	}

}
