// Imports
import java.util.Scanner;

public class Game {
	// Instance variables
	private Board board;
	private Bot bot;
	private Player player;
	private Scanner input;
	
	// Constructor
	public Game() {
		this.board = new Board(6, 7);
		this.bot = new Bot("X", "Opponent");
		this.player = new Player("O", "Player");
		this.input = new Scanner(System.in);
	}
	
	// Get methods
	public Bot getBot() { return this.bot; }
	public Player getPlayer() { return this.player; }
	
	// takeTurn methods
	public void takeTurn(Bot b) {
		int n = b.pickNum(7);
		if (this.board.changeValue(n, b.getTeam())) {
			System.out.println(this.board);
		} else {
			takeTurn(b);
		}
	}
	
	public void takeTurn(Player p) {
		System.out.println("Enter your next move: ");
		int n = input.nextInt() - 1;
		if (this.board.changeValue(n, p.getTeam())) {
			System.out.println(this.board);
		} else {
			takeTurn(p);
		}
	}
}
