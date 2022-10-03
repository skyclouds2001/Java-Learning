package experiment07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;

public class MainWork {

	public static void main(String[] args) {
		MainWork mw = new MainWork();
		
		try {
			int order = Integer.valueOf(args[0]);
			
			switch(order) {
			
			//	情况1：统计指定英文文档数据
				case 1:
					int [] count = mw.statistics(new String(args[1]));
					
				//	打印统计信息
					System.out.println("The count of paragraphs: " + count[52]);
					System.out.println("The count of words: " + count[53]);
					System.out.println("The count of upperCase: ");
					for(int i = 0; i < 26; ++i)
						System.out.println("    The count of " + (char)(i + 'A') + ": " + count[i]);
					System.out.println("The count of lowerCase: ");
					for(int i = 26; i < 52; ++i)
						System.out.println("    The count of " + (char)(i + 'a' - 26) + ": " + count[i]);
					break;
			//	情况2：搜索指定文件夹内文件
				case 2:
					try {
						ArrayList<String> list = mw.search(new String(args[1]), new String(args[2]));
						
					//	打印符合条件的文件信息
						Iterator<String> it = list.listIterator();
						while(it.hasNext()) {
							System.out.println(it.next());
						}
					}
					catch(IndexOutOfBoundsException e) {
						e.printStackTrace();
					}
					catch(WrongTypeFileException e) {
						e.printStackTrace();
					}
					break;
			//	情况3：拷贝指定文件
				case 3:
					try{
						mw.copy(new String(args[1]), new String(args[2]));
					}
					catch(FileHasExistedException e) {
						e.printStackTrace();
					}
					break;
				default:
					throw new Exception("UnExpected Order!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	方法实现统计指定英文文档数据功能
	private int [] statistics(String file) throws FileNotFoundException, IOException {
		
	//	创建File类
		File f = new File(file);
		
	//	检测File对象是否存在，不存在则抛出异常
		if(!f.exists())
			throw new FileNotFoundException("The source file doesnot existed.");
		
	//	打开文件输入流
		DataInputStream in=new DataInputStream(
								new BufferedInputStream(
										new FileInputStream(f)));
	//	声明计数变量及数组
		int paragraphCount = 0, wordCount = 0;
		int [] caseCount = new int[54];
	
	//	依次读取并进行判断计数
		int t = in.read();
		do {
			if(t == (int)'\n')
				++paragraphCount;
			
			if(Character.isWhitespace(t)) {
				++wordCount;
			}
			
			if(Character.isUpperCase(t)) {
				++caseCount[(int)(t - 'A')];
			}
			if(Character.isLowerCase(t)) {
				++caseCount[(int)(t - 'a' + 26)];
			}
			
			t = in.read();
			
		}while(t != -1);
		
		in.close();
		
	//	段落和单词计数变量转存储入数组
		int [] ans = (int [])caseCount.clone();
		ans[52] = paragraphCount;
		ans[53] = wordCount;
		
		return ans;
	}

//	方法实现搜索指定文件夹内文件功能
	private ArrayList<String> search(String folder, String searchInfo) throws FileNotFoundException, IOException, WrongTypeFileException {
	//	创建文件类
		File f = new File(folder);
		
	//	检测文件夹是否存在
		if(!f.exists())
			throw new FileNotFoundException("the folder has not been found");
		
	//	检测是否为文件夹
		if(!f.isDirectory()) {
			FileInputStream inputFile = new FileInputStream(f); 
		    String type = URLConnection.guessContentTypeFromStream(new BufferedInputStream(inputFile)); 
		    throw new WrongTypeFileException("it is not a directory", "folder", type);
		}
		
	//	将文件夹中文件转存储至File类数组中，并声明与实例化ArrayList类对象
		File [] ff = f.listFiles();
		ArrayList<String> list = new ArrayList<>();
		
	//	遍历文件夹内文件,搜索是否包含指定字符串的文件
		for(File i: ff) {
			if(i.getName().indexOf(searchInfo) != -1)
				list.add(new String(i.getName()));
		}
		
		return list;
	}

//	方法实现将源文件拷贝至目的文件功能
	private void copy(String sourceFile, String objectFile) throws FileNotFoundException, IOException, FileHasExistedException {
		
	//	声明输入及输出文件类
		File sf = new File(sourceFile), of = new File(objectFile);
		
	//	检测源文件名与目的文件名是否相同，若相同抛出FileNotFoundException异常
		if(sourceFile.equals(objectFile))
			throw new FileNotFoundException("The Object File is as the Same as the Source File.");
		
	//	检测目标文件是否已存在，若已存在抛出自定义FileHasExistedException异常
		if(of.exists()) {
			throw new FileHasExistedException("The Object File has Existed.");
		}
		
	//	检测源文件是否未存在，若存在抛出FileNotFoundException异常
		if(!sf.exists()) {
			throw new FileNotFoundException();
		}
		
	//	打开输入及输出文件流
		DataInputStream in = new DataInputStream(
									new BufferedInputStream(
											new FileInputStream(sf)));
		DataOutputStream out = new DataOutputStream(
									new BufferedOutputStream(
											new FileOutputStream(of)));
	//	读取数据并同时输出，直至文件结束为止
		int t = in.read();
		while(t != -1) {
			out.write(t);
			t = in.read();
		}
		
	//	关闭文件流
		in.close();
		out.close();
	}
}

//	自定义FileHasExistedException异常
class FileHasExistedException extends Exception {
	private static final long serialVersionUID = 8138551128783431315L;
	
	public FileHasExistedException() {
		super();
	}
	public FileHasExistedException(String info) {
		super(info);
	}

} 

//	自定义WrongTypeFileException异常
class WrongTypeFileException extends Exception {
	private static final long serialVersionUID = 4482200702340168490L;
	String formerType, presentType;
	
	
	public WrongTypeFileException() {
		super();
	}
	public WrongTypeFileException(String info) {
		super(info);
	}
	public WrongTypeFileException(String info, String formerType, String presentType) {
		super(info + " || " + presentType + " -> " + formerType);
		this.formerType = formerType;
		this.presentType = presentType;
	}
}
