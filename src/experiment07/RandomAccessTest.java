package experiment07;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessTest {
	public static void main(String[] args) throws IOException {
		
		long filePoint = 0;
		String s;
		RandomAccessFile file = new RandomAccessFile(
					"4.txt", "r");
		long fileLength = file.length(); 	// 获取文件长度
		
		while (filePoint < fileLength) {
			s = file.readLine(); 	// 读一行字符，并移动文件指针
			System.out.println(s); 		// 输出显示读入的一行字符
			file.skipBytes(5);
			filePoint = file.getFilePointer(); // 获取当前文件指针
		}
		file.close();
	}
}

