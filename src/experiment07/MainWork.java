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
			
			//	���1��ͳ��ָ��Ӣ���ĵ�����
				case 1:
					int [] count = mw.statistics(new String(args[1]));
					
				//	��ӡͳ����Ϣ
					System.out.println("The count of paragraphs: " + count[52]);
					System.out.println("The count of words: " + count[53]);
					System.out.println("The count of upperCase: ");
					for(int i = 0; i < 26; ++i)
						System.out.println("    The count of " + (char)(i + 'A') + ": " + count[i]);
					System.out.println("The count of lowerCase: ");
					for(int i = 26; i < 52; ++i)
						System.out.println("    The count of " + (char)(i + 'a' - 26) + ": " + count[i]);
					break;
			//	���2������ָ���ļ������ļ�
				case 2:
					try {
						ArrayList<String> list = mw.search(new String(args[1]), new String(args[2]));
						
					//	��ӡ�����������ļ���Ϣ
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
			//	���3������ָ���ļ�
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
	
//	����ʵ��ͳ��ָ��Ӣ���ĵ����ݹ���
	private int [] statistics(String file) throws FileNotFoundException, IOException {
		
	//	����File��
		File f = new File(file);
		
	//	���File�����Ƿ���ڣ����������׳��쳣
		if(!f.exists())
			throw new FileNotFoundException("The source file doesnot existed.");
		
	//	���ļ�������
		DataInputStream in=new DataInputStream(
								new BufferedInputStream(
										new FileInputStream(f)));
	//	������������������
		int paragraphCount = 0, wordCount = 0;
		int [] caseCount = new int[54];
	
	//	���ζ�ȡ�������жϼ���
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
		
	//	����͵��ʼ�������ת�洢������
		int [] ans = (int [])caseCount.clone();
		ans[52] = paragraphCount;
		ans[53] = wordCount;
		
		return ans;
	}

//	����ʵ������ָ���ļ������ļ�����
	private ArrayList<String> search(String folder, String searchInfo) throws FileNotFoundException, IOException, WrongTypeFileException {
	//	�����ļ���
		File f = new File(folder);
		
	//	����ļ����Ƿ����
		if(!f.exists())
			throw new FileNotFoundException("the folder has not been found");
		
	//	����Ƿ�Ϊ�ļ���
		if(!f.isDirectory()) {
			FileInputStream inputFile = new FileInputStream(f); 
		    String type = URLConnection.guessContentTypeFromStream(new BufferedInputStream(inputFile)); 
		    throw new WrongTypeFileException("it is not a directory", "folder", type);
		}
		
	//	���ļ������ļ�ת�洢��File�������У���������ʵ����ArrayList�����
		File [] ff = f.listFiles();
		ArrayList<String> list = new ArrayList<>();
		
	//	�����ļ������ļ�,�����Ƿ����ָ���ַ������ļ�
		for(File i: ff) {
			if(i.getName().indexOf(searchInfo) != -1)
				list.add(new String(i.getName()));
		}
		
		return list;
	}

//	����ʵ�ֽ�Դ�ļ�������Ŀ���ļ�����
	private void copy(String sourceFile, String objectFile) throws FileNotFoundException, IOException, FileHasExistedException {
		
	//	�������뼰����ļ���
		File sf = new File(sourceFile), of = new File(objectFile);
		
	//	���Դ�ļ�����Ŀ���ļ����Ƿ���ͬ������ͬ�׳�FileNotFoundException�쳣
		if(sourceFile.equals(objectFile))
			throw new FileNotFoundException("The Object File is as the Same as the Source File.");
		
	//	���Ŀ���ļ��Ƿ��Ѵ��ڣ����Ѵ����׳��Զ���FileHasExistedException�쳣
		if(of.exists()) {
			throw new FileHasExistedException("The Object File has Existed.");
		}
		
	//	���Դ�ļ��Ƿ�δ���ڣ��������׳�FileNotFoundException�쳣
		if(!sf.exists()) {
			throw new FileNotFoundException();
		}
		
	//	�����뼰����ļ���
		DataInputStream in = new DataInputStream(
									new BufferedInputStream(
											new FileInputStream(sf)));
		DataOutputStream out = new DataOutputStream(
									new BufferedOutputStream(
											new FileOutputStream(of)));
	//	��ȡ���ݲ�ͬʱ�����ֱ���ļ�����Ϊֹ
		int t = in.read();
		while(t != -1) {
			out.write(t);
			t = in.read();
		}
		
	//	�ر��ļ���
		in.close();
		out.close();
	}
}

//	�Զ���FileHasExistedException�쳣
class FileHasExistedException extends Exception {
	private static final long serialVersionUID = 8138551128783431315L;
	
	public FileHasExistedException() {
		super();
	}
	public FileHasExistedException(String info) {
		super(info);
	}

} 

//	�Զ���WrongTypeFileException�쳣
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
