package io.steria.pox3.got.war;

import io.steria.pox3.got.game.Player;
import io.steria.pox3.got.story.House;
import io.steria.pox3.got.tile.Domain;
import io.steria.pox3.got.tile.Tile;
import io.steria.pox3.got.tile.World;

public class Army implements IArmy {

	int readyTroops;
	int movedTroops = 0;
	House house;
	Tile position;

	public Army(int troops, House house, Domain position) {
		this.readyTroops = troops;
		this.house = house;
		this.position = position;

	}

	@Override
	public Player getPlayer() {
		return this.house.getPlayer();
	}

	@Override
	public boolean attack(IArmy ennemy) {

		return false;
	}

	@Override
	public Tile getPosition() {
		return this.position;
	}

	@Override
	public House getHouse() {
		// TODO Auto-generated method stub
		return this.house;
	}

	@Override
	public ArmyState getState() {

		return ArmyState.IDLE;
	}

	@Override
	public int getMovedTroops() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getReadyTroops() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalTroops() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override // quand on bouge que certainses troupes
	public void move(int troops, Direction direction) {
		if (troops > this.readyTroops) {
			throw new IllegalArgumentException();
		}
		World world= this.getPlayer().getGame().getWorld();
			if (troops == this.readyTroops) {
				// We move everything
			
			Tile destination= world.neighbour(this.getPosition(), direction)
					.orElseThrow(()-> new IllegalArgumentException());
			if(world.allowMove(destination, this.getHouse().hasBoat())){
			this.position= destination;	
			this.getPlayer().decreaseMoves();
			this.readyTroops=0;
			}else{
				throw new IllegalStateException("Sorry, you don't have boat");
			}
			}
			
			// TODO Nicolas GOT-2342: case where we split Army
			
		}
	
	

	@Override // quand on bouge toutes les unités
	public void move(Direction direction) {
		this.move(this.readyTroops, direction);

	}

}
