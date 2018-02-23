import java.util.Scanner;

public class ConsoleUI {
	
	private Scanner scan = new Scanner(System.in);
	
	public void start(Game game) {
		while(!game.isEnded()) {
			System.out.println("-------------------");
			System.out.println(game.currentPlayer().getName() + "'s turn");
			System.out.println("Position: " + game.currentPlayerPosition());
			System.out.println("Please hit enter to roll the dice");
			
			scan.nextLine();
			
			int face = game.currentPlayerRollDice();
			System.out.println("Dice face = " + face);
			game.currentPlayerMovePiece(face);
			System.out.println("Position: " + game.currentPlayerPosition());
			if(game.currentPlayerWins()) {
				System.out.println(game.currentPlayerName() + " wins!!!");
				game.switchPlayer();
				System.out.println(game.currentPlayerName() + " loses!!!");
				game.end();
			}
			game.switchPlayer();
		}
	}
	
	public static void main(String[] args) {
		ConsoleUI console = new ConsoleUI();
		Game game = new Game();
		console.start(game);
	}
}
