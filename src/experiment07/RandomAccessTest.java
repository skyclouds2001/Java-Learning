package experiment07;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessTest {
	public static void main(String[] args) throws IOException {
		
		long filePoint = 0;
		String s;
		RandomAccessFile file = new RandomAccessFile(
					"4.txt", "r");
		long fileLength = file.length(); 	// ��ȡ�ļ�����
		
		while (filePoint < fileLength) {
			s = file.readLine(); 	// ��һ���ַ������ƶ��ļ�ָ��
			System.out.println(s); 		// �����ʾ�����һ���ַ�
			file.skipBytes(5);
			filePoint = file.getFilePointer(); // ��ȡ��ǰ�ļ�ָ��
		}
		file.close();
	}
}

