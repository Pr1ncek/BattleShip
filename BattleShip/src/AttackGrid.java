import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

/**
 * Represents the player's own grid
 */
public class AttackGrid extends BattleGrid {
	public AttackGrid(String name) {
		super();

	}
	
	boolean shipsSet = false;

	@Override
	protected JPanel getCell() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		panel.setPreferredSize(new Dimension(20, 20)); // for demo purposes only

		MouseListener listener = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				if(PlayingState.shipsSet())
					PlayingState.isHit(e.getSource());
				else
					return;

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			// THIS IS A COMMENT

		};

		panel.addMouseListener(listener);

		return panel;
	}

}