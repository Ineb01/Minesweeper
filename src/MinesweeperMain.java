import javax.swing.JFrame;

public class MinesweeperMain extends JFrame {
	MinesweeperPanel minesweeperPanel;

	public MinesweeperMain() {

		minesweeperPanel = new MinesweeperPanel(12, 10, 10);
		this.add(minesweeperPanel);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();

	}

	public static void main(String[] args) {
		new MinesweeperMain();
	}

}