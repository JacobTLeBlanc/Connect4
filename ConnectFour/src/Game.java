/* -
 * Game - Object
 * -
 * This class uses all other classes together to create our
 * Connect 4 game.
 */

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
	public Board getBoard() { return this.board; }
	
	// takeTurn methods
	public void takeTurn(Bot b) {
		b.AI(this.board);
		int n = b.pickNum();
		if (this.board.changeValue(n, b.getTeam())) {
			System.out.println(this.board);
		} else {
			takeTurn(b);
		}
	}
	
	public void takeTurn(Player p) {
		System.out.println("Its your turn!");
		System.out.println("Enter your next move: ");
		int n = input.nextInt() - 1;
		if (this.board.changeValue(n, p.getTeam())) {
			System.out.println(this.board);
		} else {
			takeTurn(p);
		}
	}
	
	// delay method
	public void delay(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// thinking method
	public void thinking() {
		System.out.println("Its " + this.bot.getName() + "'s turn");
		System.out.print(this.bot.getName() + " is thinking");
		for (int i = 0; i < 5; i++) {
			this.delay((int) (Math.random() * 100 + 400)); 
			System.out.print(". ");
		}
		System.out.println();
	}
	 
	// play method
	public void play() {
		
		boolean gameOn = true;
		
		while (gameOn) {
			this.thinking();
			this.takeTurn(this.bot);
			if (this.board.checkWin()) {
				gameOn = false;
				System.out.print("You lost!");
				continue;
			}
			if (this.board.checkDraw()) {
				System.out.println("Draw!");
			}
			this.takeTurn(this.player);
			if (this.board.checkWin()) {
				gameOn = false;
				System.out.println("You won!");
			}
			if (this.board.checkDraw()) {
				System.out.println("Draw!");
			}
		}
		
	}
	
}
