package io.steria.pox3.got.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.steria.pox3.got.story.House;
import io.steria.pox3.got.story.HouseFactory;
import io.steria.pox3.got.tile.World;

public class GameTest {
	World world;
	Game game;
	Player anne;
	Player nicolas;
	House stark, lannister;
	
	@Before
	public void setUp(){
		world = new World();
		world.generate();
		System.out.println("reinitialize new game");
		this.game= new Game(world);
	
		HouseFactory factory= new HouseFactory();
		this.stark= factory.getStark();
		this.lannister=factory.getLannister();
		
		this.anne= new Player(game, "Anne", lannister);
		this.nicolas= new Player(game, "Nicolas", stark);
	}
	


	@Test
	public void testGetAvailableHouses() {
		System.out.println(game.getAvailableHouses());
		assertEquals(8, game.getAvailableHouses().size());

		assertTrue(game.getAvailableHouses().size()==8);
		//assertTrue(game.players.size()==3);
	}

	@Test
	public void testSavePlayer() {
	assertTrue(game.getAvailableHouses().size()==8);

	
	anne.house= lannister;
	game.savePlayer(anne);
	System.out.println(game.houses);
	System.out.println(anne.house);
	System.out.println(game.availableHouses);
	assertTrue(game.getAvailableHouses().size()==7);
	
	nicolas.house= stark;
	System.out.println(nicolas.house);
	game.savePlayer(nicolas);
	assertTrue(game.getAvailableHouses().size()==6);
	System.out.println(game.availableHouses);
	}

}
