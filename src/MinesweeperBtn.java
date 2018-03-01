import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MinesweeperBtn extends JPanel {

	// neighbour counter 
	private int neighbourCount = 0;
	private JLabel neighbourCountLabel = new JLabel("");
	
	// states
	public boolean isMine = false;
	public boolean isExposed = false;
	public boolean isFlagged = false;
	
	// x and y in mainArray in MinesweeperPanel
	private int x;
	private int y;

	public MinesweeperBtn(MouseListener m, int x, int y) {
		this.x = x;
		this.y = y;
		
		this.addMouseListener(m);
		
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		this.setPreferredSize(new Dimension(25, 25));
		this.add(neighbourCountLabel);
		
		updateStates();
	}

	public void countUp() {
		neighbourCount++;
		updateStates();
	}
	
	public void setMine() {
		this.isMine = true;
		updateStates();
	}

	public int expose() {
		if (!isFlagged) {
			this.isExposed = true;
			updateStates();
			if (isMine) {
				return -1;
			} else {
				return neighbourCount;
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
		isFlagged = !isFlagged;
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
		if (isFlagged) {
			this.setBackground(Color.GREEN);
			if (isExposed) {
				if (isMine) {
					this.setBackground(Color.RED);
					neighbourCountLabel.setForeground(Color.GREEN);
					neighbourCountLabel.setText("O");
				} else {
					neighbourCountLabel.setForeground(Color.BLACK);
					neighbourCountLabel.setText("" + neighbourCount);
				}
			}
		} else {
			if (isExposed) {
				if (isMine) {
					this.setBackground(Color.RED);
				} else {
					this.neighbourCountLabel.setText("" + neighbourCount);
					switch (neighbourCount) {
					case 0:
						neighbourCountLabel.setForeground(Color.DARK_GRAY);
						break;
					case 1:
						neighbourCountLabel.setForeground(Color.WHITE);
						break;
					case 2:
						neighbourCountLabel.setForeground(Color.YELLOW);
						break;
					case 3:
						neighbourCountLabel.setForeground(Color.ORANGE);
						break;
					case 4:
						neighbourCountLabel.setForeground(Color.RED);
						break;
					case 5:
						neighbourCountLabel.setForeground(Color.GREEN);
						break;
					case 6:
						neighbourCountLabel.setForeground(Color.CYAN);
						break;
					case 7:
						neighbourCountLabel.setForeground(Color.BLUE);
						break;
					case 8:
						neighbourCountLabel.setForeground(Color.PINK);
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
