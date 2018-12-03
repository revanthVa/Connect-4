
public class Board {
	private char[][] board;
	private char p1 = 'X';
	private char p2 = 'O';

	
	Board(){
		board  = new char[6][7];
		for (int r = 0;r <board.length;r++){
			for (int c= 0;c<board[0].length;c++){
				board[r][c] = ' ';
			}
			
		}
	}
	
	Board(int row, int col){
		this.board = new char[row][col];
		for (int r = 0;r <board.length;r++){
			for (int c= 0;c<board[0].length;c++){
				board[r][c] = ' ';
			}
		}
	}
    public  void printBoard() {
        //prints the board
        for (int r = 0; board.length> r; r += 1) {
            for (int c = 0; board[0].length > c; c += 1) {
                System.out.print(board[r][c]+"|");
            }
            System.out.println();
        }
        System.out.println();
    }
    
	public int getNumRows(){
		return board.length;
	}
	public int getNumCols(){
		return board[0].length;
	}
	public char getPlayerOne(){
		return p1; 
	}
	public char getPlayerTwo(){
		return p2;
	}
	public void setPlayerOne(char o){
		if (o == p2)
			return;
		p1 = o;
	}
	public void setPlayerTwo(char t){
		if (t == p1)
			return;
		p2 = t;
	}
	public char getToken(int row, int col){
		if (row >= board.length || col >= board[0].length || row <0 || col < 0)
			return '\0';
		else
			return board[row][col];
	}
	public boolean canPlay(){
		for (int i =0;i<board.length;i++){
			for (int j = 0;j<board[0].length;j++){
				if (board[i][j] ==  ' '){
					return true;
				}
				
				
			}
		}
		return false;
	}
	public boolean play(int p, int c){
		
		if (c >= board[0].length || c < 0)
			return false;
		if (p == 1 || p == 2){
			for (int i = getNumRows()-1;i>=0;i--){
				if ((board[i][c] == ' ') && (p == 1)){
					board[i][c] = p1;
					return true;
				
				}
				if ((board[i][c] == ' ') && (p == 2)){
					board[i][c] = p2;
					return true;
				}
			}
		}
		return false;
	}
	public boolean checkHorizontalP1(){
		for (int r = 0;r <board.length;r++){
			for (int c = 0;c <board[0].length-3;c++){
				if ((board[r][c] == p1) && (board[r][c+1] == p1)  && (board[r][c+2] == p1) && (board[r][c+3] == p1))
					return true;
			}
		}
		return false;
	}
	public boolean checkHorizontalP2(){
		for (int r = 0;r <board.length;r++){
			for (int c = 0;c <board[0].length-3;c++){
				if ((board[r][c] == p2) && (board[r][c+1] == p2)  && (board[r][c+2] == p2) && (board[r][c+3] == p2))
					return true;
			}
		}
		return false;		
	}
	public boolean checkVerticalP1(){
		for (int r = 0;r <board.length-3;r++){
			for (int c = 0;c <board[0].length;c++){
				if ((board[r][c] == p1) && (board[r+1][c] == p1) && (board[r+2][c] == p1) && (board[r+3][c] == p1))
					return true;
			}
		}
		return false;
	}
	public boolean checkVerticalP2(){
		for (int r = 0;r <board.length-3;r++){
			for (int c = 0;c <board[0].length;c++){
				if ((board[r][c] == p2) && (board[r+1][c] == p2) && (board[r+2][c] == p2) && (board[r+3][c] == p2))
					return true;
			}
		}
		return false;
	}
	public boolean checkDiagonalP1(){
		for (int r = 0;r <board.length-3;r++){
			for (int c = 0;c< board[0].length-3;c++){
				if ((board[r][c] == p1) && (board[r+1][c+1] == p1)	&& (board[r+2][c+2] == p1) && (board[r+3][c+3] == p1))
					return true;
			}
		}
		for (int r =0;r<board.length-3;r++){
			for (int c = board[0].length-1;c>=3;c--){
				if ((board[r][c] == p1) && (board[r+1][c-1] == p1) && (board[r+2][c-2] == p1) && (board[r+3][c-3] == p1))
					return true;
			}
		}
		return false;
	}
	public boolean checkDiagonalP2(){
		for (int r = 0;r <board.length-3;r++){
			for (int c = 0;c< board[0].length-3;c++){
				if ((board[r][c] == p2) && (board[r+1][c+1] == p2)	&& (board[r+2][c+2] == p2) && (board[r+3][c+3] == p2))
					return true;
			}
		}
		for (int r =0;r<board.length-3;r++){
			for (int c = board[0].length-1;c>=3;c--){
				if ((board[r][c] == p2) && (board[r+1][c-1] == p2) && (board[r+2][c-2] == p2) && (board[r+3][c-3] == p2))
					return true;
			}
		}
		return false;
	}
	public int isFinished(){
		if (checkHorizontalP1() == true || checkVerticalP1() == true || checkDiagonalP1() == true)
			return 1;
		else if (checkHorizontalP2() == true || checkVerticalP2() == true || checkDiagonalP2() == true)
			return 2;
		else if (checkHorizontalP1() == false && checkVerticalP1() == false && checkDiagonalP1() == false && checkHorizontalP2() == false && checkVerticalP2() == false && checkDiagonalP2() == false && canPlay() == false)
			return 0;
		else return -1;
	}
}

	
	
