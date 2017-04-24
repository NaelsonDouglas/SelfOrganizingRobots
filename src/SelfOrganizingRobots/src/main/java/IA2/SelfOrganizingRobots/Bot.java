package IA2.SelfOrganizingRobots;

public class Bot {
	
	
	int xPos;
	int yPos;
	String sign;
	
	
	public Bot(String _sign){
		sign = _sign;
	}
	
	public Bot  up(Playground p){		
		
		
		if (this.yPos+1 < p.numOfBots && p.table[xPos][yPos+1] == null){
			return null;
		} else {
			System.out.println("Acima é um precipício");
			return new Bot("-");
		}			
	}
	
	
public Bot  down(Playground p){
		
		if (yPos-1 >= 0 ){
			if (p.table[xPos][yPos-1] == null){
				return null;
			} else {
				System.out.println("Abaixo está ocupado.");
				return p.table[xPos][yPos-1];
			}
		} else {
			System.out.println("Abaixo é um precipício");
			return new Bot("-");
		}
					
	}



public Bot  left(Playground p){
	
	if (xPos-1 >= 0){
		if (p.table[xPos-1][yPos] == null){
			return null;
		} else {
			System.out.println("À esquerda está ocupado.");
			return p.table[xPos-1][yPos];
		}
		
	} else {
		System.out.println("Á esquerda é um precipício");
		return new Bot("-");
	}
				
}


public Bot  right(Playground p){
	
	if (xPos+1 <  p.numOfBots ){
		return p.table[xPos+1][yPos];
	} else {
		System.out.println("Á direita é um precipício");
		return new Bot("-");
	}			
}




	
	
	
	
	
	
	
	
	
	public void move(String direction, Playground p){
		//direction == up, down, left or right
		
		
		switch (direction.toUpperCase()) {
		case "DOWN":
			if (this.down(p) == null){
				yPos--;			
				Playground.table[xPos][yPos] = this;
				Playground.table[xPos][yPos+1] = null;
			}
		break;
			
		case "UP":
			if (this.up(p) == null && yPos+1 < p.numOfBots){
				yPos++;
				
				Playground.table[xPos][yPos] = this;
				Playground.table[xPos][yPos-1] = null;
			}
		break;
		
		case "LEFT":
			if (this.left(p) == null && xPos-1 >=0){
				xPos--;
				Playground.table[xPos][yPos] = this;
				Playground.table[xPos+1][yPos] = null;
			}
		break;
		
		case "RIGHT":
			if (this.right(p) == null && xPos+1 < p.numOfBots){
				xPos++;
				Playground.table[xPos][yPos] = this;
				Playground.table[xPos-1][yPos] = null;
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
