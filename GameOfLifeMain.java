import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.JFrame;

/**
 * This class is the starting point for the simulator for Conway's Game of Life.
 * 
 * @author kuhnerdm and guomy. Last updated 10/5/2014.
 */
public class GameOfLifeMain {

	private static final int WIDTH = 650;
	private static final int HEIGHT = 750;

	/**
	 * Starts the program
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Conway's Game of Life");

		//Initialize
		
		ArrayList<Coordinates> coordList = getGliderList();
		final GameOfLife game = new GameOfLife(coordList);
		frame.add(game);

		//Add update button
		
		final UpdateButton updateButton = new UpdateButton(game);
		frame.add(updateButton, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//Add timer to automatically click update button
		
		Timer timer = new Timer(50, updateButton);
		timer.start();
			
	}

	/**
	 * @return a list of coordinates representing the glider configuration
	 */
	private static ArrayList<Coordinates> getGliderList() {
		ArrayList<Coordinates> coordList = new ArrayList<Coordinates>();
//glider
		coordList.add(new Coordinates(80, 1));
		coordList.add(new Coordinates(80, 2));
		coordList.add(new Coordinates(80, 3));
		coordList.add(new Coordinates(81, 3));
		coordList.add(new Coordinates(82, 2));
		

//r-pentomino		
//		coordList.add(new Coordinates(30, 20));
//		coordList.add(new Coordinates(30, 21));
//		coordList.add(new Coordinates(31, 20));
//		coordList.add(new Coordinates(31, 19));
//		coordList.add(new Coordinates(32, 20));


		return coordList;
	}

}
