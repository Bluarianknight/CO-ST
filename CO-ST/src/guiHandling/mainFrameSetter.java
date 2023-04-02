package guiHandling;

import javax.swing.*;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;

public class mainFrameSetter extends JFrame implements ActionListener {
	/**
	 * Acts as the introduction to the program. Used to learn how to make GUI, and kept for now.
	 */
	
	// Buttons are to continue from each popup.
	JButton firstCmd,
	secondCmd,
	thirdCMD;
	
	JPanel panel;
	
	private static final long serialVersionUID = 1L;
	
	// The label for all of the text in the popups.
	private JLabel introLabel;
	
	// The length and width of the window at popup.
	private static int frameWidth = 600;
	private static int frameLength = 300;
	
	
	// Sets up the program, automatically running SetFrame once it starts. 
	public mainFrameSetter() {
		setFrame();
		setSize(frameWidth, frameLength);
		this.setLayout(new FlowLayout());
		
	}
	// Makes the first frame, providing the first pop up.
	private void setFrame() {
		introLabel = new JLabel("Welcome!");
		firstCmd = new JButton("Continue");
		firstCmd.addActionListener(this);
		JPanel panel = new JPanel();
		panel.add(introLabel);
		panel.add(firstCmd);
		add(panel);
		
	}
	// Leading in from setFrame, it would set up for the main program. Once firstCmd is clicked here, MainScreen is ran.
	private void FrameStart() {
		introLabel.setText("This is currently an in beta program. Do you agree to not judge it too harshly?");
		firstCmd.setText("I agree.");
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) 
		{
		
		case "Continue":
			FrameStart();
			break;
		
		case "I agree.":
			@SuppressWarnings("unused") MainScreen main = new MainScreen();
			this.dispose();
			break;
		
		}
		
	}
	
	
	

}
