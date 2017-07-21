package io.steria.pox3.got.tile;

import io.steria.pox3.got.war.IArmy;

public abstract class Tile {


	int x;
	int y;
	IArmy army;
	
	public Tile (int x, int y){
		this.x=x;
		this.y=y;
	}
	
	boolean isWinter (){
		return false;
	}
	
	boolean isFree(){
		return true;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public IArmy getArmy() {
		return army;
	}

	public void setArmy(IArmy army) {
		this.army = army;
	}

}
