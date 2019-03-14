/* -
 * Bot - Object
 * -
 * A bot class that inherits from the Player class,
 * with a very simple attempt at "AI"
 * -
 */

// Imports
import java.util.ArrayList;

public class Bot extends Player {
	
	// Instance vars
	private ArrayList<Integer> options;
	
	// Constructor
	public Bot(String team, String name) {
		super(team, name);
		options = new ArrayList<Integer>();
		this.options.add(3);
	}
	
	// pickNum method
	public int pickNum() {
		int rand = (int) (Math.random() * this.options.size());
		return this.options.get(rand);
	}
	
	// AI
	public void AI(Board b) {
		// If there's an "X" to either the right or left, make it a higher chance of landing there.
		for (int i = 0; i < b.getBoard().length; i++) {
			for (int j = 0; j < b.getBoard()[i].length; j++) {
				if (j != 0) {
					if (b.getBoard()[i][j - 1].equals(super.getTeam())) {
						this.options.add(j);
					}
				}
				if (j != 6) {
					if (b.getBoard()[i][j + 1].equals(super.getTeam())) {
						this.options.add(j);
					}
				}
			}
		}
	}
	
}
