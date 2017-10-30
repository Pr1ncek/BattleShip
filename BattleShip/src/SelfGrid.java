import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.peer.ComponentPeer;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the player's own grid
 */
public class SelfGrid extends BattleGrid {
	public SelfGrid(String name) {
		super();

	}

	public List<JPanel> ships = new ArrayList<>();

	public List<JPanel> getShips() {
		return ships;
	}

	public void setShipPosition(Object o) {

		if (ships.size() >= 15)
			return;

		JPanel panel = (JPanel) o;

		int x = panel.getX();
		int y = panel.getY();

		Container c = panel.getParent();

		JPanel p2 = (JPanel) c.getComponentAt(x + 20, y);

		JPanel p3 = (JPanel) c.getComponentAt(x + 40, y);

		if (!p2.isVisible() || !p3.isVisible())
			return;

		boolean Overlap = false;

		if (!ships.isEmpty()) {

			for (int i = 0; i < ships.size(); i++) {

				// panel.getBounds() == ships.get(i).getBounds()

				if (panel.getBackground().equals(Color.YELLOW) || p2.getBackground().equals(Color.YELLOW)
						|| p3.getBackground().equals(Color.YELLOW)) {

					Overlap = true;
					break;

				}

			}

		}

		if (!Overlap) {
			ships.add(panel);
			ships.add(p2);
			ships.add(p3);

			panel.setBackground(Color.YELLOW);

			p2.setBackground(Color.YELLOW);

			p3.setBackground(Color.YELLOW);

		}

		if (PlayingState.player1.grid.getShips().size() == 15)
			PlayingState.player1.label9.setText("Player 1 Make Your Move");

	}

	@Override
	protected JPanel getCell() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		panel.setPreferredSize(new Dimension(20, 20));

		MouseListener listener = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				setShipPosition(e.getSource());

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