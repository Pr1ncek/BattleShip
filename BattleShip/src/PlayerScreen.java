import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class PlayerScreen extends JFrame {

	// public static int i = 2;

	SelfGrid grid;

	AttackGrid aGrid;

	PlayerData pData;

	JLabel label5;

	JLabel label6;

	JLabel label8;

	JLabel label9;

	JLabel label15;

	JLabel label16;

	boolean initialized = false;

	// boolean shipsSet = false;

	public JLabel getlabel5() {
		return label5;
	}

	public JLabel getlabel6() {
		return label6;
	}

	public JLabel getlabel8() {
		return label8;
	}

	public JLabel getlabel15() {
		return label15;
	}

	public JLabel getlabel16() {
		return label16;
	}

	public PlayerScreen(String name, boolean show, boolean alternate) {
		super(name);
		this.setLayout(new BorderLayout());

		Font font2 = new Font("Courier", Font.BOLD, 20);

		JLabel label = new JLabel("Self Grid");

		JLabel label2 = new JLabel("Attack Grid");

		grid = new SelfGrid(name);

		aGrid = new AttackGrid(name);

		pData = new PlayerData(grid, aGrid);

		if (!alternate) {
			this.add(label2, BorderLayout.SOUTH);
			// this.add(label, BorderLayout.SOUTH);
			this.add(grid, BorderLayout.EAST);
			this.add(aGrid, BorderLayout.WEST);
		} else {
			this.add(label, BorderLayout.SOUTH);
			this.add(aGrid, BorderLayout.EAST);
			this.add(grid, BorderLayout.WEST);
		}
		this.add(new JLabel(name), BorderLayout.NORTH);

		Box bv = Box.createVerticalBox();

		// JLabel label3 = new JLabel(" Number of Ships: " +
		// pData.getNumberOfShips());

		// JLabel label4 = new JLabel(" Number of Enemy Ships: " +
		// pData.getEnemyShips());

		label5 = new JLabel("Number of Hits: " + pData.getNumberOfHits());
		label5.setFont(font2);

		label6 = new JLabel("Number of Misses: " + pData.getNumberOfMisses());
		label6.setFont(font2);

		label15 = new JLabel("Ships Sunk: " + pData.getEnemyShips());

		label15.setFont(font2);

		label16 = new JLabel("Ships Left: " + pData.getNumberOfShips());

		label16.setFont(font2);

		JLabel label7 = new JLabel("15 Hits to Win");

		JLabel label10 = new JLabel("Red = Miss :: Green = Hit");
		label10.setFont(font2);

		// JLabel label11 = new JLabel("15 Hits to Win :: Red = Miss :: Green =
		// Hit");

		label7.setFont(font2);

		label8 = new JLabel();
		label8.setFont(new Font("Courier", Font.BOLD, 35));

		label9 = new JLabel();
		label9.setFont(font2);

		JButton next = new JButton("next");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				label9.setVisible(false);

				if (!initialized && PlayingState.player1.isVisible()) {
					if (PlayingState.player1.grid.getShips().size() != 15)
						return;

				}

				if (!initialized && PlayingState.player2.isVisible()) {
					if (PlayingState.player2.grid.getShips().size() != 15)
						return;

				}

				if (PlayingState.shipsSet())
					initialized = true;

				if (initialized && !PlayingState.moveMade)
					return;

				PlayingState.moveMade = false;

				// label5.setText(" Number of Hits: " +
				// pData.getNumberOfHits());

				hideScreen();

			}
		});

		next.setFont(new Font("Courier", Font.BOLD, 25));

		// bv.add(label3);
		// bv.add(label4);

		bv.add(label7);

		// bv.add(label8);

		bv.add(label10);

		bv.add(label5);
		bv.add(label6);

		bv.add(label9);
		bv.add(label15);

		bv.add(label16);
		bv.add(label8);
		
		

		bv.add(next);

		// bv.setSize(getMaximumSize());

		this.add(bv, BorderLayout.CENTER);
		// this.add(next, BorderLayout.CENTER);
		this.pack();
		// this.setVisible(show);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void hideScreen() {

		if (PlayingState.player1.isVisible()) {

			PlayingState.player1.setVisible(false);

			PlayingState.player2.setVisible(true);

		} else {

			PlayingState.player1.setVisible(true);
			PlayingState.player2.setVisible(false);

		}

	}
}