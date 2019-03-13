
public class testConnectFour {

	public static void main(String[] args) {
		
		Game gm = new Game();
		for (int i = 0; i < 10; i++) {
			gm.takeTurn(gm.getBot());
			gm.takeTurn(gm.getPlayer());
		}

	}

}
