import java.awt.Color;

public class ConnectFour{
	
	
	public static void main(String[] args){
		
		Board board = new Board();
		CFGUI boar = new CFGUI(board,ChipColor.BLACK,ChipColor.RED);
		
		board.setPlayerOne('X');
		board.setPlayerTwo('O');
		

		Player p1 = new HumanPlayer(1,6,7);
		//Player p2 = new HumanPlayer(2,6,7); //comment this line when testing AIPlayer
		
		Player p2 = new AIPlayer(2,6,7);
		
	

		System.out.println("Would you like to play against a Human? (Y/N)");
		char y = IO.readChar();
		while (y != 'y' && y != 'Y' && y != 'n' && y != 'N'){
			System.out.println("Invalid value! (Enter Y orn"
					+ " N)");
		y = IO.readChar();
		}
		if (y == 'y' || y == 'Y')
			p2 = new HumanPlayer(2,6,7);
		if (y == 'n' || y == 'N')
			p2 =  new AIPlayer(2,6,7);
		
	
			
		while (board.isFinished() == -1){
			boar.redraw();
			int c = p1.playToken();
			board.play(1, c);
			boar.redraw();
			p2.lastMove(c);
			if (board.isFinished() != -1)
				break;
			int c2 = p2.playToken();
			board.play(2, c2);
			p1.lastMove(c2);
			boar.redraw();
			if (board.isFinished() != -1){
				break;
			}
			
			
		}
		boar.gameOver(board.isFinished());


		boar.close();

		
		
	}
	
}