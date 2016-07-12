package com.scramblebot.app;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.awt.*;


public class SwingInterface extends JFrame implements ActionListener {
	JLabel ceasarLabel;
	JSlider ceasarSlider;
	JButton btnSubmit;
	JButton btnClear;
	JRadioButton btnEncode;
	JRadioButton btnDecode;
	JTextArea message;
	int charsToShift;
	
	public SwingInterface (){
		super("Scramblebot Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 430, 500);
				
		btnEncode = new JRadioButton("Encode", true
				);
		btnDecode = new JRadioButton("Decode");
		ButtonGroup ceasarGroup = new ButtonGroup();
		ceasarGroup.add(btnEncode);
		ceasarGroup.add(btnDecode);

		
		ceasarSlider = new JSlider(JSlider.HORIZONTAL, 0, 93, 3 );
		//Integer sliderVal = new Integer(ceasarSlider.getValue());
		charsToShift = ceasarSlider.getValue();
		ceasarLabel = new JLabel(String.valueOf(charsToShift));
		ceasarSlider.setMajorTickSpacing(10);
		ceasarSlider.setMinorTickSpacing(1);
		ceasarSlider.setPaintTicks(true);
		ceasarSlider.setPaintLabels(true);
		ceasarSlider.addChangeListener(new SliderChangeListener());
						
		message = new JTextArea(20, 35);
		
		JScrollPane scroll = new JScrollPane(message, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		message.setText("This is a ceasar cipher encoding/decoding tool.  " + 
				"Enter the text you would like to encode or decode. " + 
				"Next select the encode or decode radio button.  Then use the " + 
				"slider to set the number of characters to be shifted." );
		message.setLineWrap(true);
		message.setWrapStyleWord(true);		
		btnSubmit = new JButton("Submit");
		btnClear = new JButton("Clear");
		btnSubmit.addActionListener(this);
		btnClear.addActionListener(this);
		
		JPanel topPane = new JPanel();
		topPane.add(btnEncode);
		topPane.add(btnDecode);
		topPane.add(ceasarLabel);
		topPane.add(ceasarSlider);
		BoxLayout topBar = new BoxLayout(topPane, BoxLayout.X_AXIS);
		
		JPanel bottomPane = new JPanel();
		bottomPane.add(btnSubmit);
		bottomPane.add(btnClear);
		BoxLayout bottomBar = new BoxLayout(bottomPane, BoxLayout.X_AXIS);
		
		
		setLayout(new FlowLayout());
		
		add(topPane);
		add(scroll);
		add(bottomPane);
								
		//pack();
		setVisible(true);
				
	}
	
	public void actionPerformed(ActionEvent evt){
		Object source = evt.getSource();
		if (source == btnSubmit ){
			String text = new String(message.getText());
			if (btnEncode.isSelected()) {
			Ceasar secrets = new Ceasar(text, Cypher.ENCODE, charsToShift);
			message.setText(secrets.strOutput);
			} else if (btnDecode.isSelected()){
				Ceasar secrets = new Ceasar(text, Cypher.DECODE, charsToShift);
				message.setText(secrets.strOutput);
			}
			
		} else if (source == btnClear) {
			message.setText("");
		}
		
	}


	
	
	public static void main (String[] args) {
		
		SwingInterface eggbert = new SwingInterface();
	}
	

	class SliderChangeListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			charsToShift = ceasarSlider.getValue();
			ceasarLabel.setText(String.valueOf(ceasarSlider.getValue()));
		}
		
	}

}



