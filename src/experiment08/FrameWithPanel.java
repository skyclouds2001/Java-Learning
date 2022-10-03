package experiment08;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameWithPanel extends JFrame {
    private static final long serialVersionUID = 1343118904672401318L;

	public static void main(String args[]) {
        FrameWithPanel fr = new FrameWithPanel("Hello !");
        fr.setSize(200, 200);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pan = new JPanel(); /* 创建JPanel的实例 */
        pan.setBackground(Color.yellow);
        pan.setLayout(new GridLayout(2, 1));
        pan.add(new JButton("确定"));
        fr.setContentPane(pan);

        fr.setVisible(true);
    }
    
    public FrameWithPanel(String str) {
        super(str);
    }
}

