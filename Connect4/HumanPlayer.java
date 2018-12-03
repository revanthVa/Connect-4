public class HumanPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	private int playerID;
	private int row, col;
	private Board board;
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public HumanPlayer(int playerID, int row, int col){
		this.playerID = playerID;
		this.row = row;
		this.col = col;
		
		this.board = new Board(row,col);
		
	}
	
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
		if (getPlayerID() == 1)
			board.play(2, c);
		if (getPlayerID() == 2)
			board.play(1, c);
	}
	
	//returns column of where to play a token
	public int playToken(){
		
		int c = GIO.readInt("which column?");
		while (c >= col || c < 0 ){
			c = GIO.readInt("Input error. Enter another column?");
		}
	while (board.getToken(0, c) != ' '){
		c = GIO.readInt("Input Error. Enter another column");
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