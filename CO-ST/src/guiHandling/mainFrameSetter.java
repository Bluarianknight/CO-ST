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
	 * 
	 */
	
	JButton firstCmd,
	secondCmd,
	thirdCMD;
	
	JPanel panel;
	
	private static final long serialVersionUID = 1L;

	private JLabel introLabel;
	
	private static int frameWidth = 600;
	private static int frameLength = 300;
	
	public mainFrameSetter() {
		setFrame();
		setSize(frameWidth, frameLength);
		this.setLayout(new FlowLayout());
		
	}
	
	private void setFrame() {
		introLabel = new JLabel("Welcome!");
		firstCmd = new JButton("Continue");
		firstCmd.addActionListener(this);
		JPanel panel = new JPanel();
		panel.add(introLabel);
		panel.add(firstCmd);
		add(panel);
		
	}
	
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
