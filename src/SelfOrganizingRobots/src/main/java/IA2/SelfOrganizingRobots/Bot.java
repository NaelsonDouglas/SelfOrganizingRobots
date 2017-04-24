package IA2.SelfOrganizingRobots;

public class Bot {
	
	
	int xPos;
	int yPos;
	
	int xTarget;
	int yTarget;
	String sign;
	boolean done;
	
	
	
	public Bot(String _sign){
		done=false;
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



	public void moveY(Playground p){
		if (up(p) == null){
			System.out.println("Moveu DIreita");
			move("UP",p);
		} else if (down(p) == null) {
			System.out.println("Moveu DIreita");
			move("DOWN",p);
		}
	}
	public void moveX(Playground p){
		if (left(p) == null){
			System.out.println("Moveu DIreita");
			move("LEFT",p);
		} else if (right(p) == null) {
			System.out.println("Moveu DIreita");
			move("RIGHT",p);
		}
	}
	
	
	
	
	
	
	
	
	public boolean move(String direction, Playground p){
		//direction == up, down, left or right
		
		
		switch (direction.toUpperCase()) {
		case "DOWN":
			if (this.down(p) == null){
				yPos--;			
				Playground.table[xPos][yPos] = this;
				Playground.table[xPos][yPos+1] = null;
				return true;
			}
			
					
			//System.out.println("Não pode descer");
			return false;
		
		case "UP":
			if (this.up(p) == null && yPos+1 < p.numOfBots){
				yPos++;
				
				Playground.table[xPos][yPos] = this;
				Playground.table[xPos][yPos-1] = null;
				return true;
			}
			
			
		System.out.println("Não pode subir");
		return false;
		
		case "LEFT":
			if (this.left(p) == null && xPos-1 >=0){
				xPos--;
				Playground.table[xPos][yPos] = this;
				Playground.table[xPos+1][yPos] = null;
				return true;
			}
			
			
			System.out.println("Não pode ir à esquerda");
		return false;
		
		case "RIGHT":
			if (this.right(p) == null && xPos+1 < p.numOfBots){
				xPos++;
				Playground.table[xPos][yPos] = this;
				Playground.table[xPos-1][yPos] = null;
				return true;
			}
			
			System.out.println("Não pode ir à direitaa");
		return false;
			

		default:
			return false;
		}
	}
	
	
	public boolean confirmGoal(Bot[][] goal){
			if (goal[xPos][yPos] != null){
				System.out.println("Eu, "+xPos+" "+yPos+" estou em posição");
				done=true;
				return true;
			} else {
				done=false;
				return false;
			}		
	}
	
	
	
	
	
	public void getOut(Playground p, String direction){
		
		Bot tempBot = null;
		if (direction.toUpperCase() == "RIGHT"){
			tempBot = right(p);
			tempBot.moveY(p);
			tempBot.confirmGoal(p.getGoal());
		} else if(direction.toUpperCase() == "LEFT"){
			tempBot = left(p);
			tempBot.moveY(p);
			tempBot.confirmGoal(p.getGoal());
		} else if(direction.toUpperCase() == "UP"){				
			tempBot = up(p);
			tempBot.moveX(p);
			tempBot.confirmGoal(p.getGoal());
		} else if(direction.toUpperCase() == "DOWN"){					
			tempBot = down(p);
			tempBot.moveX(p);
			tempBot.confirmGoal(p.getGoal());
		}
		
	
				
		
		
		
		
		
		
		
			
		
	}
	
	private void storeTarget(){
		xTarget = xPos;
		yTarget = yPos;
	}
	
	public boolean findGoal(Playground p){
		Bot[] goalHolders = p.goalHolders;
		boolean lefttMov, rightMov, downMov = false, upMov = false;
		
		
		
		for (Bot i : goalHolders){
			if(!p.isOcupied(i.xPos, i.yPos)){
				
				while (xPos != i.xPos || yPos != i.yPos){
					lefttMov = false;
					rightMov = false;
					downMov = false;
					upMov = false;
					
					System.out.println("Tentando alcançar o espaço: x:"+i.xPos+" y:"+i.yPos);
					
					if (xPos > i.xPos){
						lefttMov = move("LEFT", p);
					} else if (xPos < i.xPos){
						rightMov = move("RIGHT", p);
					}
					
					p.printTable();	
					if (yPos > i.yPos){
						downMov = move("DOWN", p);
					} else if (yPos < i.yPos){
						upMov = move("UP",p);						
					}
					if (confirmGoal(p.getGoal()))
						break;
					
					//Caso nenhum movimento seja possível a peça muda a rota dando "ré"
					if (!(lefttMov || rightMov || downMov || upMov)){
						System.out.println("ENTALOU");
						if (yPos == i.yPos){
							if (xPos < i.xPos){
								getOut(p, "RIGHT");
							} else if (xPos > i.xPos){
								getOut(p, "LEFT");
							}
						}
						
						if (xPos == i.xPos){
							if (yPos < i.yPos){
								getOut(p, "UP");
							} else if (yPos > i.yPos){
								getOut(p, "DOWN");
							}
						}						
					}					
					p.printTable();	
					p.confirmAllGoals();
				}				
			}
		}
		
		return false;
	}
	

	
	
	
	public String toString(){
		return sign;
	}

}
