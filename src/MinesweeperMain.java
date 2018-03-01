import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MinesweeperMain extends JFrame {
	MinesweeperPanel minesweeperPanel;

	public MinesweeperMain() {

		int dimensions = Integer.parseInt(JOptionPane.showInputDialog("Dimensions"));
		int mines = Integer.parseInt(JOptionPane.showInputDialog("Mines"));
		
		minesweeperPanel = new MinesweeperPanel(mines, dimensions, dimensions);
		this.add(minesweeperPanel);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();

	}

	public static void main(String[] args) {
		new MinesweeperMain();
	}

}