package model.characters;

import java.awt.Point;
import java.util.ArrayList;

import model.world.CharacterCell;
import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughActionsException;

public abstract class Character {

	private String name;
	private int maxHp;
	private int currentHp;
	private Point location;
	private int attackDmg;
	private Character target;

	public Character(String name, int maxHp, int attackDamage) {
		this.name = name;
		this.maxHp = maxHp;
		this.attackDmg = attackDamage;
		this.currentHp = maxHp;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		if (currentHp <= 0) {
			this.currentHp = 0;
			onCharacterDeath();
			
		} else if (currentHp > maxHp) {
			this.currentHp = maxHp;
		} else
			this.currentHp = currentHp;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public Character getTarget() {
		return target;
	}

	public void setTarget(Character target) {
		this.target = target;
	}

	public String getName() {
		return name;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getAttackDmg() {
		return attackDmg;
	}

	public void attack() throws NotEnoughActionsException,
			InvalidTargetException {
		getTarget().setCurrentHp(getTarget().getCurrentHp() - getAttackDmg());
		getTarget().defend(this);
	}

	public void defend(Character c) {
		c.setCurrentHp(c.getCurrentHp() - getAttackDmg() / 2);
	}

	public void onCharacterDeath() {
		Point p = this.getLocation();
		
		if (this instanceof Zombie) {
			Game.zombies.remove(this);
			Game.spawnNewZombie();
		} else if (this instanceof Hero) {
			Game.heroes.remove(this);
		}
		Game.map[p.x][p.y] = new CharacterCell(null);
	}
	public String Locations(Point L) {
		if (L.x==14 && L.y==0) {
			return "down left corner";
		}
		else if(L.x==0 && L.y==0) {
			return "top left corner";
		}
		else if (L.x==0 && L.y==14) {
			return "top right corner";	
		}
		else if (L.x==14 && L.y==14 ) {
			return "down right corner";
		}
		else if (L.x==14) {
			return "down";
		}
		else if (L.x==0) {
			return "up";
		}
		else if (L.y==0) {
			return "left";
		}
		else if (L.y==14) {
			return "right";
		}
		else 
			return "center";
	}
	
	public ArrayList<Point> PossibleTarget(Point L){
		 ArrayList <Point> PL =  new ArrayList<Point>();
		 String S=Locations(L);
		 int x=L.x;
		 int y=L.y;
		 switch(S) {
		 case ("down right corner"): 
		 PL.add(new Point(x+1,y-1));
		 PL.add(new Point(x+1,y));
		 PL.add(new Point(x,y-1)); 
			break; 
		 case("top right corner"):
		 PL.add(new Point(x,y-1));
		 PL.add(new Point(x-1,y-1));
		 PL.add(new Point(x-1,y)); 
		 break;
		 case( "top left corner"):
			 PL.add(new Point(x-1,y));
			 PL.add(new Point(x,y+1));
			 PL.add(new Point(x-1,y+1)); 
			 break;
		 case( "down left corner"):
			 PL.add(new Point(x+1,y));
			 PL.add(new Point(x,y+1));
			 PL.add(new Point(x+1,y+1)); 
			 break;
		 case("down"): 
			
			PL.add(new Point(x,y-1));
			 PL.add(new Point(x+1,y-1));
			 PL.add(new Point(x+1,y)); 
			 PL.add(new Point(x+1,y+1));
			 PL.add(new Point(x,y+1));
			 break;
		 case( "up"):
			
			PL.add(new Point(x,y-1));
			 PL.add(new Point(x-1,y-1));
			 PL.add(new Point(x-1,y)); 
			 PL.add(new Point(x-1,y+1));
			 PL.add(new Point(x,y+1));
			 break;
			 
		 case("right" ):
			 
			PL.add(new Point(x-1,y));
			 PL.add(new Point(x-1,y-1));
			 PL.add(new Point(x,y-1)); 
			 PL.add(new Point(x+1,y-1));
			 PL.add(new Point(x+1,y));
			 break;
		 case("left"):
			
			PL.add(new Point(x+1,y));
			 PL.add(new Point(x+1,y+1));
			 PL.add(new Point(x,y+1)); 
			 PL.add(new Point(x-1,y+1));
			 PL.add(new Point(x-1,y));
			 break; 
		 case("center"):
			
			 PL.add(new Point(x+1,y-1));
			 PL.add(new Point(x+1,y));
			 PL.add(new Point(x+1,y+1));
			 PL.add(new Point(x,y+1));
			 PL.add(new Point(x-1,y+1));
			 PL.add(new Point(x-1,y));
			 PL.add(new Point(x-1,y-1));
			 PL.add(new Point(x,y-1));
			 break;
		 }
//		 for(int i=0; i < PL.size(); i++)
//		 {
//			 if (Game.map[PL.get(i).x][PL.get(i).y] == null)
//				 Game.map[PL.get(i).x][PL.get(i).y] = new CharacterCell(null);
//		 }
		 return PL;
	}
	public boolean isAdj(Character H,Character Z) {
		int xH=H.getLocation().x;
		int yH=H.getLocation().y;
		int xZ=Z.getLocation().x;
		int yZ=Z.getLocation().y;
		int Sx=Math.abs(xH-xZ);
		int Sy=Math.abs(yH-yZ);
		if(Sx==0 && Sy==1) {
			return true;
		}else if(Sx==0 && Sy==0) {
			return true;
		}else if(Sx==1 && Sy==1) {
			return true;
		}else if(Sx==1 && Sy==0) {
			return true;
		}else {
			return false;
		}
	}
	

}
