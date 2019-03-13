
public class Bot {
	// Instance variables
	private String team;
	private String name;
	
	// Constructor
	public Bot(String team, String name) {
		this.team = team;
		this.name = name;
	}
	
	// get methods
	public String getTeam() { return this.team; }
	public String getName() { return this.name; }
	
	// set methods
	public void setTeam(String team) { this.team = team; }
	public void setName(String name) { this.name = name; }
	
	// pickNum method
	public int pickNum(int max) {
		return (int) (Math.random() * max);
	}
	
}
