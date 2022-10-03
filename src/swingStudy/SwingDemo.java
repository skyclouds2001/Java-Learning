package swingStudy;

import java.awt.*;
import javax.swing.*;

public class SwingDemo {

	public static void main(String[] args) {
		
		createGUI();
		
	}
	
	private static void createGUI() {
		JFrame frame = new JFrame("Swing Demo");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JLabel("Hello,World"));
		contentPane.add(new JButton("≤‚ ‘"));
		
		frame.setSize(400, 300);
		frame.setVisible(true);
	}

}
