import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MinesweeperBtn extends JPanel {

	private int count = 0;
	public boolean isMine = false;
	private JLabel countLabel = new JLabel("");
	private int x;
	private int y;
	public boolean isExposed = false;
	public boolean flaged = false;

	public MinesweeperBtn(MouseListener m, int x, int y) {
		this.x = x;
		this.y = y;
		this.addMouseListener(m);
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		updateStates();
		this.setPreferredSize(new Dimension(25, 25));
		this.add(countLabel);
	}

	public void countUp() {
		count++;
		updateStates();
	}

	public int getCount() {
		return this.count;
	}

	public boolean getMine() {
		return this.isMine;
	}

	public void setMine() {
		this.isMine = true;
		updateStates();
	}

	public int expose() {
		this.isExposed = true;
		updateStates();
		if (isMine) {
			return -1;
		} else {
			return count;
		}
	}

	public void toggleFlag() {
		flaged = !flaged;
		updateStates();
	}

	public int getXpos() {
		return x;
	}

	public int getYpos() {
		return y;
	}

	public void updateStates() {
		if (flaged) {
			this.setBackground(Color.GREEN);
		} else {
			if (isExposed) {
				if (isMine) {
					this.setBackground(Color.RED);
				} else {
					this.countLabel.setText("" + count);
					switch (count) {
					case 0:
						countLabel.setForeground(Color.DARK_GRAY);
						break;
					case 1:
						countLabel.setForeground(Color.WHITE);
						break;
					case 2:
						countLabel.setForeground(Color.YELLOW);
						break;
					case 3:
						countLabel.setForeground(Color.ORANGE);
						break;
					case 4:
						countLabel.setForeground(Color.RED);
						break;
					case 5:
						countLabel.setForeground(Color.GREEN);
						break;
					case 6:
						countLabel.setForeground(Color.CYAN);
						break;
					case 7:
						countLabel.setForeground(Color.BLUE);
						break;
					case 8:
						countLabel.setForeground(Color.PINK);
						break;
					}
					this.setBackground(Color.BLACK);
				}
			} else {
				this.setBackground(Color.GRAY);
			}
		}

	}
}
