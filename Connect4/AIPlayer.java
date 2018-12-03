

public class AIPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	private int playerID;
	private int row, col;
	private Board board;
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public AIPlayer(int playerID, int row, int col){
		this.playerID = playerID;
		this.row = row;
		this.col = col;
		
		this.board = new Board(row,col);
	}
	
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
		if (getPlayerID() == 1)
			board.play(2,c);
		if (getPlayerID() == 2)
			board.play(1,c);
		
		
	}
	
	//returns column of where to play a token
	public int playToken(){
		int c = ((int)(Math.random() * ((col - 0) + 1)) + 0);


		if (getPlayerID() == 2){
		for (int r = 0;r <row;r++){
			for (int co = 0;co <board.getNumCols()-3;co++){
				if ((board.getToken(r, co) == board.getPlayerTwo()) && (board.getToken(r, co+1) == board.getPlayerTwo())  && (board.getToken(r, co+2) == board.getPlayerTwo())){
					c = co+3;
					break;
				}
				
			}
		}
		for (int r = 0; r< row;r++){
			for (int co = col-1;co>2;co--){
				if ((board.getToken(r, co) == board.getPlayerTwo()) && (board.getToken(r, co-1) == board.getPlayerTwo())  && (board.getToken(r, co-2) == board.getPlayerTwo())){
					c = co-3;
				break;
				}
			}
		}
		for (int r = 0; r< row;r++){
			for (int co = 0;co<col-3;co++){
				if ((board.getToken(r, co) == board.getPlayerTwo()) && (board.getToken(r, co+1) == board.getPlayerTwo())  && (board.getToken(r, co+3) == board.getPlayerTwo())){
					c = co+2;
				break;
				}
			}
		}
		for (int r = 0; r< row;r++){
			for (int co = 0;co<col-3;co++){
				if ((board.getToken(r, co) == board.getPlayerOne()) && (board.getToken(r, co+2) == board.getPlayerOne())  && (board.getToken(r, co+3) == board.getPlayerOne())){
					c = co+1;
				break;
				}
			}
		}
		}
		if (getPlayerID() == 1){
			for (int r = 0;r <row;r++){
				for (int co = 0;co <board.getNumCols()-3;co++){
					if ((board.getToken(r, co) == board.getPlayerOne()) && (board.getToken(r, co+1) == board.getPlayerOne())  && (board.getToken(r, co+2) == board.getPlayerOne())){
						c = co+3;
						break;
					}
					
				}
			}
			for (int r = 0; r< row;r++){
				for (int co = col-1;co>2;co--){
					if ((board.getToken(r, co) == board.getPlayerOne()) && (board.getToken(r, co-1) == board.getPlayerOne())  && (board.getToken(r, co-2) == board.getPlayerOne())){
						c = co-3;
					break;
					}
				}
			}
			for (int r = 0; r< row;r++){
				for (int co = 0;co<col-3;co++){
					if ((board.getToken(r, co) == board.getPlayerOne()) && (board.getToken(r, co+1) == board.getPlayerOne())  && (board.getToken(r, co+3) == board.getPlayerOne())){
						c = co+2;
					break;
					}
				}
			}
			for (int r = 0; r< row;r++){
				for (int co = 0;co<col-3;co++){
					if ((board.getToken(r, co) == board.getPlayerOne()) && (board.getToken(r, co+2) == board.getPlayerOne())  && (board.getToken(r, co+3) == board.getPlayerOne())){
						c = co+1;
					break;
					}
				}
			}
			}
		while (c>= col || c < 0){
			c = ((int)(Math.random() * ((col - 0) + 1)) + 0);
		}
		while (board.getToken(0, c) != ' '){
			c = ((int)(Math.random() * ((col - 0) + 1)) + 0);
		}
		board.play(getPlayerID(), c);
		return c;
	}
	
	//get this player's id
	public int getPlayerID(){
		return playerID;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		board = new Board(board.getNumRows(), board.getNumCols());
	}
}