package experiment05;
import java.util.*;

public class FindDups {
	public static void main(String args[]) {
		
		// ����һ��HashSet����ȱʡ�ĳ�ʼ������16
		Set<String> s = new HashSet<String>();
		
		// ���������е�ÿ���ַ������뵽����s�У�
		//�����ظ����ַ��������ܼ��룬������ӡ���
		for (int i = 0; i < args.length; i++) {
		        if (!s.add(args[i]))
			System.out.println("Duplicate detected: " + args[i]);
		}
		
		// �������s��Ԫ�ظ����Լ������е�����Ԫ�أ�
		System.out.println(s.size() + " distinct words detected: " + s);
	}
}

