import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MinesweeperPanel extends JPanel {

	MinesweeperBtn[][] mainArray;
	
	private int ROWS;
	private int COLS;
	
	private JLabel bombCountDisplay = new JLabel();
	private int flagCounter = 0;
	private JLabel countLabel = new JLabel("0");
	private JPanel mineField = new JPanel();
	private JPanel counterPanel = new JPanel();

	public MinesweeperPanel(int bombCount, int cols, int rows) {
		
		ROWS = rows;
		COLS = cols;
		
		this.setLayout(new BorderLayout());

		counterPanel.setLayout(new GridLayout(1, 2));
		this.add(counterPanel, BorderLayout.NORTH);
		
		this.bombCountDisplay.setText(""+bombCount);
		counterPanel.add(bombCountDisplay);
		counterPanel.add(countLabel);
		
		mineField.setLayout(new GridLayout(ROWS, COLS));
		this.add(mineField, BorderLayout.CENTER);
		
		ExposeMouse exposeMouse = new ExposeMouse();
		
		this.mainArray = new MinesweeperBtn[COLS][];
		for (int i = 0; i < mainArray.length; i++) {
			mainArray[i] = new MinesweeperBtn[ROWS];
			for (int j = 0; j < mainArray[i].length; j++) {
				mainArray[i][j] = new MinesweeperBtn(exposeMouse, i, j);

			}
		}

		for (int j = 0; j < mainArray[0].length; j++) {
			for (int i = 0; i < mainArray.length; i++) {
				mineField.add(mainArray[i][j]);
			}
		}

		if(bombCount<COLS*ROWS) {
			for (int i = 0; i < bombCount; i++) {
				addRandMine();
			}
		} else {
			for (int i = 0; i < COLS*ROWS; i++) {
				addRandMine();
			}
		}
	}

	public void addRandMine() {
		int randCol = (int) (Math.random() * COLS);
		int randRow = (int) (Math.random() * ROWS);
		boolean mineSet = false;
		while (!mineSet) {
			if (!mainArray[randCol][randRow].getMine()) {
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						if ((randRow + j >= 0 && randRow + j < ROWS) && (randCol + i >= 0 && randCol + i < COLS)) {
							mainArray[randCol + i][randRow + j].countUp();
						}
					}
				}
				mainArray[randCol][randRow].setMine();
				mineSet = true;
			} else {
				randCol = (int) (Math.random() * COLS);
				randRow = (int) (Math.random() * ROWS);
			}
		}
	}

	private void exposeBtn(MinesweeperBtn mBtn) {
		int returnVal = mBtn.expose();
		int btnX = mBtn.getXpos();
		int btnY = mBtn.getYpos();
		if (returnVal == 0) {
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if ((btnY + j >= 0 && btnY + j < ROWS) && (btnX + i >= 0 && btnX + i < COLS)) {
						if (!mainArray[btnX + i][btnY + j].isExposed) {
							exposeBtn(mainArray[btnX + i][btnY + j]);
						}
					}
				}
			}
		} else if (returnVal < 0) {

			for (int j = 0; j < mainArray[0].length; j++) {
				for (int i = 0; i < mainArray.length; i++) {
					mainArray[i][j].forceExpose();
				}
			}
			JOptionPane.showMessageDialog(this, "Looser");
		}
	}

	private class ExposeMouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
		
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			boolean win = true;
			if (arg0.getButton() == MouseEvent.BUTTON1) {
				exposeBtn((MinesweeperBtn) arg0.getSource());
			} else if (arg0.getButton() == MouseEvent.BUTTON3) {
				if (!((MinesweeperBtn) arg0.getSource()).isExposed) {
					((MinesweeperBtn) arg0.getSource()).toggleFlag();
					if(((MinesweeperBtn) arg0.getSource()).flagged) {
						flagCounter++;
						countLabel.setText(""+flagCounter);
					} else {
						flagCounter--;
						countLabel.setText(""+flagCounter);
					}
				}
			}
			for (int j = 0; j < mainArray[0].length; j++) {
				for (int i = 0; i < mainArray.length; i++) {
					if(mainArray[i][j].flagged && !mainArray[i][j].isMine) {
						win = false;
					}
					if(!mainArray[i][j].flagged && mainArray[i][j].isMine) {
						win = false;
					}
				}
			}
			if(win) {
				for (int j = 0; j < mainArray[0].length; j++) {
					for (int i = 0; i < mainArray.length; i++) {
						mainArray[i][j].forceExpose();
					}
				}
				JOptionPane.showMessageDialog(mainArray[0][0], "Winner");
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}
