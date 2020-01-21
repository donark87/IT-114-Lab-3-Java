/*
Name: Donark Patel (DP663)
Class: IS114-451
Professor: Maura Deek
Date: 11/1/2019
Information: This program create's a GUI for users to enter characters. When the user inputs the characters it print out palindrome words.
*/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

public class Frame1 {

	private JFrame frame;  //GUI Frame
	private JTextField textField; //Input Textbox
	private JTextArea textArea; //Output TextArea
	private JScrollPane scrollPane; //Panel

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Setting up the frame
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Label for Alphabets
		JLabel lblNewLabel = new JLabel("Enter Alphabets:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(45, 44, 118, 20);
		frame.getContentPane().add(lblNewLabel);
		
		//textbox for inpput
		textField = new JTextField();
		textField.setBounds(173, 46, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(5);
		
		//ScrollPane for text area. 
		scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 85, 353, 152);
		frame.getContentPane().add(scrollPane);
		
		//textArea for output
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		scrollPane.setViewportView(textArea);
		
		//ScrollPane for text area.
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(377, 85, 17, 152);
		frame.getContentPane().add(scrollBar);
		
		//Button for submit to input
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(275, 45, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		//Button for clearing the data
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textField.setText("");
			}
		});
		btnClear.setBounds(421, 45, 89, 23);
		frame.getContentPane().add(btnClear);
		
		//Button for exit
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(421, 99, 89, 23);
		frame.getContentPane().add(btnExit);
		btnSubmit.addActionListener(new SubmitButtonListner() {
			
			});
		
	}
	public class SubmitButtonListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			// TODO Auto-generated method stub
			
			
			String input = textField.getText();  //Inputed string
			if (input.length() > 5 || input.length() <= 0) // Validating input
			{
				JOptionPane.showMessageDialog(null,"Character length should be \n > 0 \n and \n <= 5");
				return;
			}
			else if (!isOnlyAlphabet(input)) 
			{
				JOptionPane.showMessageDialog(null,"Please, input only characters.");
				return;
			}
			input += textField.getText();
			int OutputLength = (input.length() -1); //Size of a combination to be printed
			int inputLength = input.length(); //length of the input. 
			
			char [] charArray =  new char [inputLength]; //Char array
			
			
			for(int i = 0; i < inputLength; i++) 
			{
				charArray[i] = input.charAt(i);
				
			}
			
			do {
			printCombinationData(charArray,inputLength, OutputLength );
			OutputLength--;
			}while(OutputLength>=1);
		}
		private boolean isOnlyAlphabet(String al) 
		{
			return ((!al.equals("")) && (al.matches("^[a-zA-Z]*$"))&& (al != null));
		}
		
		

		private void printCombinationData(char[] charArray, int inputLength, int OutputLength) {
			
			char data [] = new char[OutputLength];
			combination(charArray, data, 0, inputLength-1, 0, OutputLength); 
		}
		//recursion method. 
		private void combination(char[] charArray, char[] data, int start, int end, int index, int OutputLength) 
		{
			
			String input = "";
			
			if (index == OutputLength) 
	        { 
				if (OutputLength == 2 || OutputLength == 4 || OutputLength == 6 || OutputLength == 8 || OutputLength == 10) {
				for (int j=0; j<OutputLength; j++) 
	            	input = input + data[j];
	            
	             
	            StringBuilder input1 = new StringBuilder(); 
	    		
	    		input1.append(input);
	    		input1 = input1.reverse();
	    		String input2 = input1.substring(0);
	    		String input3 = input + input2;
	    		if(input3.length() <= (charArray.length))
	    			textArea.append(input3 +   "\n");
	    			
	            return; }
				else {
					for (int j=0; j<OutputLength; j++) 
		            	input = input + data[j];
		            
		             
		            StringBuilder input1 = new StringBuilder(); 
		    		
		    		input1.append(input);
		    		input1 = input1.reverse();
		    		String input2 = input1.substring(1);
		    		String input3 = input + input2;
		    		if(input3.length() <= charArray.length)
		    			textArea.append(input3 +   "\n");
		    			
		            return;
					
				}
	        } 
			
			
			
	        for (int i=start; i<=end && end-i+1 >= OutputLength-index; i++) 
	        { 
	            data[index] = charArray[i]; 
	            combination(charArray, data, i+1, end, index+1, OutputLength); 
	        }  
			
			
		}
		
		
		
		

	}
}

