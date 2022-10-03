package experiment08;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldSwing {
    
	public static void main(String[] args) {
        JFrame frame = new JFrame("HelloWorldSwing");
        
        final JLabel label = new JLabel("Hello World!");
        frame.getContentPane().add(label);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//	设置默认的关闭操作，程序在关闭窗口时退出
        frame.setSize(400,400);
        frame.setVisible(true);
    }
	
}
