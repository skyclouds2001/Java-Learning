package experiment08;

import java.awt.*;
import javax.swing.*;

/*����һ�����п�JLabel��JFrame*/
public class JFrameDemo {
    public static void main(String s[]) {
        // ָ��ʹ�õ�ǰ��Look&Feelװ�δ��ڣ������ڴ�������ǰ�趨
        JFrame.setDefaultLookAndFeelDecorated(true);

        // �������趨�رմ��ڲ���
        JFrame frame = new JFrame("JFrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ����һ��JLable���ӵ�������
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        // ��ʾ����
        frame.pack();
        frame.setVisible(true);
    }
}

