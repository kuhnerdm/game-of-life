/**
 * This class represents a pair of coordinates.
 * 
 * @author Curt Clifton. Created Sep 24, 2008.
 */
public class Coordinates {
	private int row;
	private int column;
	private boolean isOccupied;

	/**
	 * Constructs a coordinate pair.
	 * 
	 * @param row
	 * @param column
	 */
	public Coordinates(int row, int column) {
		this.row = row;
		this.column = column;
		isOccupied = false;
	}

	/**
	 * @return the row of this pair
	 */
	public int getRow() {
		return this.row;
	}

	
	/**
	 * @return whether this coordinate is occupied
	 */
	public boolean getOccupied() {
		return isOccupied;
	}

	/**
	 * @param isOccupied whether this coordinate is occupied
	 */
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	/**
	 * @return the column of this pair
	 */
	public int getColumn() {
		return this.column;
	}

}
