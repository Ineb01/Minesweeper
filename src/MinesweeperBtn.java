import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MinesweeperBtn extends JPanel {

	private int count = 0;
	public boolean isMine = false;
	private JLabel countLabel = new JLabel("0");
	private int x;
	private int y;
	public boolean isExposed = false;
	public boolean flaged = false;

	public MinesweeperBtn(MouseListener m, int x, int y) {
		this.x = x;
		this.y = y;
		this.addMouseListener(m);
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		this.setBackground(Color.BLACK);
		this.add(countLabel);
	}

	public void countUp() {
		count++;
		this.countLabel.setText("" + count);
	}

	public int getCount() {
		return this.count;
	}

	public boolean getMine() {
		return this.isMine;
	}

	public void setMine() {
		this.isMine = true;
		this.setBackground(Color.RED);
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
			if (isMine) {
				this.setBackground(Color.RED);
			} else {
				this.setBackground(Color.BLACK);
			}
		}
		if (isExposed) {
			countLabel.setForeground(Color.BLUE);
		}
	}
}
