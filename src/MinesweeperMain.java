import javax.swing.JFrame;

public class MinesweeperMain extends JFrame {
	MinesweeperPanel minesweeperPanel;

	public MinesweeperMain() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		minesweeperPanel = new MinesweeperPanel(12, 10, 10);
		this.add(minesweeperPanel);

		this.pack();

	}

	public static void main(String[] args) {
		new MinesweeperMain();
	}

}