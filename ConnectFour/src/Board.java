/* -
 * Board - Object
 * -
 * A class that represent the Connect 4 Board
 * -
 */

// Imports
import org.apache.commons.lang3.StringUtils;


public class Board {
	// Instance variables
	String[][] table;
	
	// Constructor 
	public Board(int rows, int cols) {
		this.table = new String[rows][cols];
		for (int i = 0; i < this.table.length; i++) {
			for (int j = 0; j < this.table[i].length; j++) {
				this.table[i][j] = " ";
			}
		}
	}
	
	// getMethods
	public int getRows() { return this.table.length; }
	public int getCols() { return this.table[0].length; }
	public String[][] getBoard() { return table; }
	
	// changeValue method
	public boolean changeValue(int col, String value) {
		for (int i = this.table.length - 1; i >= 0; i-- ) {
			if (this.table[i][col].equals(" ")) {
				this.table[i][col] = value;
				return true;
			}
		}
		return false;
	}
	
	// checkWin method
	public boolean checkWin() {
		// Check rows
		for (int i = 0; i < this.table.length; i++) {
			for (int j = 2; j < this.table[i].length - 1; j++) {
				if (!this.table[i][j - 2].equals(" ")                 &&
					this.table[i][j - 1].equals(this.table[i][j - 2]) &&
					this.table[i][j].equals(this.table[i][j - 1])     &&
					this.table[i][j + 1].equals(this.table[i][j])       ) {
					return true;
				}
			}
		}
		// Check cols
		for (int i = 2; i < this.table.length - 1; i++) {
			for (int j = 0; j < this.table[i].length; j++) {
				if (!this.table[i - 2][j].equals(" ")                 &&
				    this.table[i - 1][j].equals(this.table[i - 2][j]) &&
				    this.table[i][j].equals(this.table[i - 1][j])     &&
				    this.table[i + 1][j].equals(this.table[i][j])) {
					return true;
				}
			}
		}
		// Check diagonals
		for (int i = 0; i < this.table.length - 3; i++) {
			for (int j = 0; j < this.table[i].length - 3; j++) {
				if (!this.table[i][j].equals(" ")                             && 
					this.table[i + 1][j + 1].equals(this.table[i][j])         &&
					this.table[i + 2][j + 2].equals(this.table[i + 1][j + 1]) &&
					this.table[i + 3][j + 3].equals(this.table[i + 2][j + 2])) {
					return true;
				}
			}
			for (int j = 3; j < this.table[i].length; j++) {
				if (!this.table[i][j].equals(" ")                             && 
						this.table[i + 1][j - 1].equals(this.table[i][j])         &&
						this.table[i + 2][j - 2].equals(this.table[i + 1][j - 1]) &&
						this.table[i + 3][j - 3].equals(this.table[i + 2][j - 2])) {
						return true;
				}
			}
		}
		return false;
	}
	
	// checkDraw
	public boolean checkDraw() {
		for (int i = 0; i < this.table.length; i++) {
			for (int j = 0; j < this.table[i].length; j++) {
				if (this.table[i][j].equals(" ")) {
					return false;
				}
			}
		}
		return false;
	}
	
	// toString method
	public String toString() {
		String str = "";
		String line = "-";
		
		str += "\n";
		
		for (int i = 0; i < this.table[0].length; i++) {
			str += "| ";
			str += i + 1;
			str += " ";
		}
		
		str += "|";
		str += "\n";
		
		for (int i = 0; i < this.table.length; i++) {
			str += StringUtils.repeat(line, (this.getCols() * 4 + 1));
			str += "\n";
			str += "| ";
			for (int j = 0; j < this.table[i].length; j++) {
				str += this.table[i][j];
				str += " | ";
			}
			str += "\n";
		}
		str += StringUtils.repeat(line, (this.getCols() * 4 + 1));
		return str;
	}
}
