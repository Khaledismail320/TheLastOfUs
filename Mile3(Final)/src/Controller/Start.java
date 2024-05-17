package Controller;

import java.io.IOException;

import engine.Game;
import model.characters.*;


public class Start {
	
	public static Hero StartingHero(int i) throws IOException {
		Game.loadHeroes("Heroes.csv");
		return Game.availableHeroes.get(i);
		
		
	}
	public static String Type(Hero h) throws IOException {
		if(h instanceof Fighter)
			return "Fighter";
		else if(h instanceof Explorer)
			return "Explorer";
		else
			return "Medic";
	}

}
