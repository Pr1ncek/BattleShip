import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PlayingState implements State {

	static PlayerScreen player1;
	static PlayerScreen player2;

	static boolean moveMade = false;

	// int tempCount = 0;

	public static boolean shipsSet() {

		if (PlayingState.player1.grid.getShips().size() == 15 && PlayingState.player2.grid.getShips().size() == 15)
			return true;
		else
			return false;

	}

	@Override
	public void nextMove(Game context) {

		player1 = new PlayerScreen("Player1", true, false);

		player2 = new PlayerScreen("Player2", true, true);

		player2.setVisible(true);

		// Game.gameOver = true;

	}

	public static void isHit(Object o) {

		if (moveMade)
			return;

		JPanel attackPanel = (JPanel) o;

		boolean isFound = false;

		if (player1.isVisible()) {

			for (int i = 0; i < player2.grid.getShips().size(); i++) {
				if (player2.grid.getShips().get(i).getLocation().equals(attackPanel.getLocation())) {
					attackPanel.setBackground(Color.GREEN);
					player1.pData.setNumberOfHits(player1.pData.getNumberOfHits() + 1);
					// System.out.println(player1.pData.getNumberOfHits());

					if (player1.pData.getNumberOfHits() % 3 == 0){
						player1.pData.enemyShips += 1;
						player2.pData.numberOfShips -= 1;
					}

					isFound = true;
					break;
				}
			}

			if (!isFound) {
				attackPanel.setBackground(Color.RED);
				player1.pData.setNumberOfMisses(player1.pData.getNumberOfMisses() + 1);
			}

			player1.getlabel5().setText("  Number of Hits: " + player1.pData.getNumberOfHits());

			player1.getlabel6().setText("  Number of Misses: " + player1.pData.getNumberOfMisses());

			player1.getlabel15().setText("Ships Sunk: " + player1.pData.getEnemyShips());
			
			player2.getlabel16().setText("Ships Left: " + player2.pData.getNumberOfShips());

		}

		if (player2.isVisible()) {

			for (int i = 0; i < player1.grid.getShips().size(); i++) {
				if (player1.grid.getShips().get(i).getLocation().equals(attackPanel.getLocation())) {
					attackPanel.setBackground(Color.GREEN);
					player2.pData.setNumberOfHits(player2.pData.getNumberOfHits() + 1);

					if (player2.pData.getNumberOfHits() % 3 == 0){
						player2.pData.enemyShips += 1;
						
						player1.pData.numberOfShips -= 1;
						
					}

					isFound = true;
					break;
				}
			}

			if (!isFound) {
				attackPanel.setBackground(Color.RED);
				player2.pData.setNumberOfMisses(player2.pData.getNumberOfMisses() + 1);
			}

			player2.getlabel5().setText("  Number of Hits: " + player2.pData.getNumberOfHits());

			player2.getlabel6().setText("  Number of Misses: " + player2.pData.getNumberOfMisses());

			player2.getlabel15().setText("Ships Sunk: " + player2.pData.getEnemyShips());
			
			player1.getlabel16().setText("Ships Left: " + player1.pData.getNumberOfShips());
		}

		moveMade = true;

		if (player1.pData.getNumberOfHits() == 15 || player2.pData.getNumberOfHits() == 15) {

			if (player1.isVisible()) {
				player1.label8.setText("YOU WIN!!!");

			} else {

				player2.label8.setText("YOU WIN!!!");
			}

			player1.setEnabled(false);
			player2.setEnabled(false);
		}

	}
}
