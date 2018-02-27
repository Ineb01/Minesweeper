import javax.swing.JFrame;

public class MinesweeperMain extends JFrame{
	MinesweeperPanel minesweeperPanel;
	public MinesweeperMain() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		minesweeperPanel = new MinesweeperPanel();
		this.add(minesweeperPanel);
		
		
		for(int i = 0;i<1;i++) {
			minesweeperPanel.addRandMine();
		}
		this.pack();
		
	}
	
	public static void main(String[] args) {
		new MinesweeperMain();
	}

}