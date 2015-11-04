import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Tests GameOfLife.
 * 
 * @author Curt Clifton. Created Sep 24, 2008.
 */
public class GameOfLifeTest {

	/**
	 * Test method for {@link GameOfLife#GameOfLife(java.util.ArrayList)} and
	 * {@link GameOfLife#isOccupied(int, int)}.
	 */
	@Test
	public void testGameOfLife() {
		// DONE 4: Test constructor and isOccupied()
		
		ArrayList<Coordinates> coordList = new ArrayList<Coordinates>();
		coordList.add(new Coordinates(80, 1));
		coordList.add(new Coordinates(80, 2));
		coordList.add(new Coordinates(80, 3));
		coordList.add(new Coordinates(81, 3));
		coordList.add(new Coordinates(82, 2));
		
		GameOfLife game = new GameOfLife(coordList);
		
		assertTrue(game.isOccupied(80, 1));
		assertTrue(game.isOccupied(81, 3));
		assertFalse(game.isOccupied(0, 0));
		assertFalse(game.isOccupied(89, 89));
	}

	/**
	 * Test method for {@link GameOfLife#getNeighborCount(int, int)}.
	 */
	@Test
	public void testGetNeighborCount() {
		// DONE 5: Test getNeighborCount
		
		ArrayList<Coordinates> coordList = new ArrayList<Coordinates>();
		
		coordList.add(new Coordinates(50, 50));
		coordList.add(new Coordinates(50, 51));
		coordList.add(new Coordinates(50, 49));
		coordList.add(new Coordinates(51, 50));
		coordList.add(new Coordinates(49, 50));
		coordList.add(new Coordinates(49, 49));
		coordList.add(new Coordinates(51, 51));
		
		coordList.add(new Coordinates(89, 50));
		coordList.add(new Coordinates(0, 50));
		coordList.add(new Coordinates(50, 89));
		coordList.add(new Coordinates(50, 0));
		
		GameOfLife game = new GameOfLife(coordList);
		
		
		//Test for normal cases
		assertEquals(game.getNeighborCount(50, 50), 6);
		assertEquals(game.getNeighborCount(49, 51), 3);
		
		//Test for wrapping
		assertEquals(game.getNeighborCount(89, 50), 1);
		assertEquals(game.getNeighborCount(0, 50), 1);
		assertEquals(game.getNeighborCount(50, 89), 1);
		assertEquals(game.getNeighborCount(50, 0), 1);
		
		//Test for no neighbors
		assertEquals(game.getNeighborCount(70, 70), 0);
		
	}

	/**
	 * Test method for {@link GameOfLife#nextGeneration()}.
	 */
	@Test
	public void testNextGen() {
		// DONE 6: test nextGen
		
		ArrayList<Coordinates> coordList = new ArrayList<Coordinates>();
		coordList.add(new Coordinates(80, 1));
		coordList.add(new Coordinates(80, 2));
		coordList.add(new Coordinates(80, 3));
		coordList.add(new Coordinates(81, 3));
		coordList.add(new Coordinates(82, 2));
		
		GameOfLife game = new GameOfLife(coordList);
		
		game.nextGeneration();
		
		assertFalse(game.isOccupied(82, 2));
		assertTrue(game.isOccupied(81, 3));
		assertTrue(game.isOccupied(80, 3));
		assertTrue(game.isOccupied(80, 2));
		assertFalse(game.isOccupied(80, 1));
		assertTrue(game.isOccupied(79,  2));
		assertTrue(game.isOccupied(81, 1));
	}

}
