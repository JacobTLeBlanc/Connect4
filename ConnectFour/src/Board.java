import org.apache.commons.lang3.StringUtils;


public class Board {
	// Instance variables
	String[][] table;
	
	// Constructor 
	public Board(int rows, int cols) {
		int count = 1;
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
	public void changeValue(int row, int col, String value) {
		this.table[row][col] = value;
	}
	
	// toString method
	public String toString() {
		String str = "";
		String line = "-";
		
		str += "\n";
		
		for (int i = 0; i < this.table[0].length; i++) {
			str += "| ";
			str += i;
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
