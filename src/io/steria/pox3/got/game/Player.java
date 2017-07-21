package io.steria.pox3.got.game;

import io.steria.pox3.got.objectives.ObjectiveCard;
import io.steria.pox3.got.story.House;

public class Player {
	String name;
	House house;
	ObjectiveCard card;
	PlayerState state= PlayerState.PLAYING;
	RoundState roundState= RoundState.WAITING;
	
	// Bidirection, argh
	Game game;
	Round currentRound;
	
	public int moves= 3;
	
	public Player(Game game,String name, House house) {
		this.game = game;
		this.name = name;
		this.house = house;
		// argh, bidirection handling
		this.house.setPlayer(this);
		// but this link never moves. Not so bad
	}
	
	
	public Game getGame() {
		return game;
	}


	boolean chooseName (String pName) {
		
		this.name=pName;
		return true;
	} 
	
	boolean chooseHouse (House pHouse) {
		
		this.house= pHouse;
		return true;
	}
	
	ObjectiveCard selectCard(){
		return null;
	}
	
	public void decreaseMoves() {
		if(this.roundState== RoundState.WAITING){
			throw new PlayerRoundEndedException();
		}
		this.moves --;
}
}