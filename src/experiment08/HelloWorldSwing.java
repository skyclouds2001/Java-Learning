package experiment08;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldSwing {
    
	public static void main(String[] args) {
        JFrame frame = new JFrame("HelloWorldSwing");
        
        final JLabel label = new JLabel("Hello World!");
        frame.getContentPane().add(label);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//	����Ĭ�ϵĹرղ����������ڹرմ���ʱ�˳�
        frame.setSize(400,400);
        frame.setVisible(true);
    }
	
}
