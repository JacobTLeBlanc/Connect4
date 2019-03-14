/* -
 * Player - Object
 * -
 * A simple class used to keep of the user
 * -
 */

public class Player {
	// Instance variables
	private String team;
	private String name;
	
	// Constructor
	public Player(String team, String name) {
		this.team = team;
		this.name = name;
	}
	
	// get methods
	public String getTeam() { return this.team; }
	public String getName() { return this.name; }
	
	// set methods
	public void setTeam(String team) { this.team = team; }
	public void setName(String name) { this.name = name; }
}
