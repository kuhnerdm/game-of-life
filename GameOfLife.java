
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * This class represents the game board. It can draw a graphical rendering of
 * its current state and can calculate its next state.
 * 
 * @author kuhnerdm and guomy. Last updated 10/5/2014.
 */
public class GameOfLife extends JComponent {
	private static final int MAX_ROWS = 90;
	private static final int MAX_COLUMNS = 90;
	private static final double DOT_SIZE = 7;
	private int generation;
	private Coordinates[][] initialCells;
	private Coordinates[][] newCells;

	/**
	 * Constructs a new game board from the list of initially occupied
	 * coordinates.
	 * 
	 * @param initialCells list of initially occupied coordinates
	 */
	public GameOfLife(ArrayList<Coordinates> initialCells) {
		
		this.generation = 0;
		
		// populates initialCells as empty
		
		this.initialCells = new Coordinates[MAX_ROWS][MAX_COLUMNS];
		for (int i = 0; i < MAX_ROWS; i++) {
			for (int p = 0; p < MAX_COLUMNS; p++) {
				Coordinates temp = new Coordinates(i, p);
				this.initialCells[i][p] = temp;
			}
		}
		
		// fills occupied cells as specified with constructor parameter
		
		for (int i = 0; i < initialCells.size(); i++) {
			Coordinates temp = initialCells.get(i);
			temp.setOccupied(true);
			this.initialCells[temp.getRow()][temp.getColumn()] = temp;
		}
	}

	/**
	 * Returns whether the square in the given row/col is occupied
	 * 
	 * @param row
	 * @param column
	 * @return whether or not the square in the given row and column is occupied
	 */
	public boolean isOccupied(int row, int column) {
		return initialCells[row][column].getOccupied();
	}

	/**
	 * Takes a coordinate and returns an ArrayList of coordinates that neighbor
	 * the coordinate in question
	 * 
	 * @param cell
	 *            the coordinate in question
	 * @return an AL of coordinates that neighbor the coordinate
	 */

	public ArrayList<Coordinates> getNeighbors(int row, int col) {

		// Initialize variables
		
		ArrayList<Coordinates> neighbors = new ArrayList<Coordinates>();
		int rowToRight = row + 1;
		int rowToLeft = row - 1;
		int colAbove = col - 1;
		int colBelow = col + 1;

		// Adjust for wrapping around the grid
		
		if (rowToRight > MAX_ROWS-1)
			rowToRight = 0;
		if (rowToLeft < 0)
			rowToLeft = MAX_ROWS-1;
		if (colAbove < 0)
			colAbove = MAX_COLUMNS-1;
		if (colBelow > MAX_COLUMNS-1)
			colBelow = 0;

		// Populates neighbor AL

		neighbors.add(initialCells[rowToLeft][colAbove]);
		neighbors.add(initialCells[row][colAbove]);
		neighbors.add(initialCells[rowToRight][colAbove]);
		neighbors.add(initialCells[rowToLeft][col]);
		neighbors.add(initialCells[rowToRight][col]);
		neighbors.add(initialCells[rowToLeft][colBelow]);
		neighbors.add(initialCells[row][colBelow]);
		neighbors.add(initialCells[rowToRight][colBelow]);
		return neighbors;
	}
	/**
	 * Counts the number of occupied cells around the given square.
	 * 
	 * @param row
	 * @param column
	 * @return the number of occupied cells
	 */
	public int getNeighborCount(int row, int column) {
		int counter = 0;
		ArrayList<Coordinates> neighbors = getNeighbors(row, column);
		for (int i = 0; i < neighbors.size(); i++) {
			Coordinates temp = neighbors.get(i);
			if (temp.getOccupied()) {
				counter++;
			}
		}
	
		return counter;
	
	/**
	 * Returns the current generation of cells
	 * 
	 * @return the current generation	
	 */
	}
	public int getGeneration(){
		return generation;
	}
	
	/**
	 * Updates the state of this game board for the next generation.
	 */
	public void nextGeneration() {
		
		//creates next generation of cells
		
		newCells = new Coordinates[MAX_ROWS][MAX_COLUMNS];
		for(int i = 0; i < newCells.length; i++){
			for(int p = 0; p < newCells[i].length; p++){
				Coordinates temp = new Coordinates(i,p);
				newCells[i][p] = temp;
			}
		}
		generation++;
		
		//sets occupied cells based on initial cells and rules
		
		for (int i = 0; i < newCells.length; i++) {
			for (int p = 0; p < newCells[i].length; p++) {
				int cond = getNeighborCount(i, p);
				if((cond == 2 || cond == 3)&& initialCells[i][p].getOccupied()){
					newCells[i][p].setOccupied(true);
				}
				if (cond == 3 && !initialCells[i][p].getOccupied()) {
					newCells[i][p].setOccupied(true);
				}
				if (cond < 2 && initialCells[i][p].getOccupied()) {
					newCells[i][p].setOccupied(false);
				}
				if (cond > 3 && initialCells[i][p].getOccupied()) {
					newCells[i][p].setOccupied(false);
				}
				
				
			}
		}
		
		//replaces initial cells with new cells
		
		for(int i = 0; i < newCells.length; i++){
			for(int p = 0; p < newCells[i].length; p++){
				initialCells[i][p]=newCells[i][p];
			}
		}

	}
	
	/**
	 * Paints the game board
	 * 
	 * @param g the graphics object to paint to
	 */
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		// draws box
		
		g.drawRect(0, 0, (int) (MAX_ROWS * DOT_SIZE),
				(int) (MAX_COLUMNS * DOT_SIZE));
		
		// adds horizontal and vertical grid lines
		
		for (int i = (int) DOT_SIZE; i < MAX_ROWS * DOT_SIZE; i += DOT_SIZE) {
			g.drawLine(0, i, (int) (MAX_ROWS * DOT_SIZE), i);
		}
		for (int i = (int) DOT_SIZE; i < MAX_COLUMNS * DOT_SIZE; i += DOT_SIZE) {
			g.drawLine(i, 0, i, (int) (MAX_COLUMNS * DOT_SIZE));
		}
		
		// fills occupied cells
		
		for (int i = 0; i < initialCells.length; i++) {
			for (int p = 0; p < initialCells[i].length; p++) {
				if (initialCells[i][p].getOccupied()) {
					g.fillRect(initialCells[i][p].getColumn() * (int) DOT_SIZE,
							initialCells[i][p].getRow() * (int) DOT_SIZE,
							(int) DOT_SIZE, (int) DOT_SIZE);
					
				}
			}
		}
		
		//Show the current generation
		
		g.drawString("Generation :" + generation, 0, 670);
		
	}

}
