import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MinesweeperBtn extends JPanel {

	// neighbour counter 
	private int count = 0;
	private JLabel countLabel = new JLabel("");
	
	// states
	public boolean isMine = false;
	public boolean isExposed = false;
	public boolean flagged = false;
	
	// x and y in mainArray in MinesweeperPanel
	private int x;
	private int y;

	public MinesweeperBtn(MouseListener m, int x, int y) {
		this.x = x;
		this.y = y;
		
		this.addMouseListener(m);
		
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		this.setPreferredSize(new Dimension(25, 25));
		this.add(countLabel);
		
		updateStates();
	}

	public void countUp() {
		count++;
		updateStates();
	}
	
	public void setMine() {
		this.isMine = true;
		updateStates();
	}

	public int expose() {
		if (!flagged) {
			this.isExposed = true;
			updateStates();
			if (isMine) {
				return -1;
			} else {
				return count;
			}
		} else {
			return 1;
		}
	}

	public void forceExpose() {
		this.isExposed = true;
		updateStates();
	}

	public void toggleFlag() {
		flagged = !flagged;
		updateStates();
	}

	public int getXpos() {
		return x;
	}

	public int getYpos() {
		return y;
	}

	// update all colors and texts according to states
	public void updateStates() {
		if (flagged) {
			this.setBackground(Color.GREEN);
			if (isExposed) {
				if (isMine) {
					this.setBackground(Color.RED);
					countLabel.setForeground(Color.GREEN);
					countLabel.setText("O");
				} else {
					countLabel.setForeground(Color.BLACK);
					countLabel.setText("" + count);
				}
			}
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
