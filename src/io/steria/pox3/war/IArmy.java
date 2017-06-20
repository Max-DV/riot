package io.steria.pox3.war;

import io.steria.pox3.got.game.Player;
import io.steria.pox3.got.story.House;
import io.steria.pox3.got.tile.Tile;

public interface IArmy { // une interface dit ce que ca peut faire mais ne prends pas de mémoire

	int getTotalTroops();
	int getMovedTroops();
	int getReadyTroops();
	
	void move(int troops, Direction direction);
	
	void move(Direction direction);
	
	boolean attack(IArmy ennemy);
		
	
	Tile getPosition();
	House getHouse();
	
	ArmyState getState();
	
	Player getPlayer();
	
}