package guiHandling;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainFrameSetter extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel introLabel;
	
	private static int frameWidth = 600;
	private static int frameLength = 400;
	
	public mainFrameSetter() {
		setFrame();
		setSize(frameWidth, frameLength);
	}
	
	private void setFrame() {
		introLabel = new JLabel("Welcome!");
		
		JPanel panel = new JPanel();
		panel.add(introLabel);
		add(panel);
	}
	

}
