
public class Game {
	
	private Player[] players;
	private Die die;
	private Board board;
	private int currentPlayerIndex;
	private boolean end;
	
	public Game() {
		players = new Player[2];
		players[0] = new Player("P1");
		players[1] = new Player("P2");
		
		die = new Die();
		board = new Board();
		end = false;
		
		board.addPiece(players[0].getPiece(), 0);
		board.addPiece(players[1].getPiece(), 0);
	}
	
	public boolean isEnded() {
		return end;
	}
	
	public void end() {
		end = true;
	}
	
	public Player currentPlayer() {
		return players[currentPlayerIndex];
	}
	
	public void switchPlayer() {
		currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
	}
	
	public String currentPlayerName() {
		return currentPlayer().getName();
	}

	public int currentPlayerPosition() {
		return board.getPiecePosition(currentPlayer().getPiece());
	}
	
	public int currentPlayerRollDice() {
		return currentPlayer().roll(die);
	}
	
	public void currentPlayerMovePiece(int steps) {
		currentPlayer().movePiece(board, steps);
	}
	
	public boolean currentPlayerWins() {
		return board.pieceIsAtGoal(currentPlayer().getPiece());  
	}
	
	public void start() {
		board.addPiece(players[0].getPiece(), 0);
		board.addPiece(players[1].getPiece(), 0);
		
		currentPlayerIndex = 0;
		while(true) {
			System.out.println("-----------------------------------------------------");
			Player currentPlayer = players[currentPlayerIndex];
			System.out.println("Current player is " + currentPlayer.getName());
			System.out.println("The piece is at " +
					board.getPiecePosition(currentPlayer.getPiece()));
			int face = currentPlayer.roll(die);
			currentPlayer.movePiece(board, face);
			// TODO Snake and Ladder
			if(board.pieceIsAtGoal(currentPlayer.getPiece())) {
				break;
			}
			currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
		}
		
	}
	
	public static void main(String[] args) {
		
	}
}
