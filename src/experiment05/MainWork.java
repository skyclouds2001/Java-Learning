package experiment05;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class MainWork {

//	�洢���Map�����
//	����Ϊ��̬��Ա��������main()�������Բ�ʵ�������������ʹ��book����
	private static Map<String, Book> book = new HashMap<String, Book>();

/*	private static Map<String, Book> student = new HashMap<String, Book>();	*/

//	������Scanner�����
//	����main()������������ʵ���������ǰ�ر�
//	�����ڶ����Ա������ʹ��
	private static Scanner input = null;


//	������
//	����ʹ���쳣�Ժ���ʹ��sleep()����
	public static void main(String[] args) {
		
	//	��������
		input = new Scanner(System.in);
	//	��������
		MainWork.systemLoad();
		
	//	��ӡ�˵�����ȡѡ���Ժ���������Ӧ��ϵͳ
		MainWork.printMainMenu();
		System.out.print("��������Ӧ��ѡ��");
		int choice = input.nextInt();
		
	//	����ѡ��������Ӧϵͳ
		if(choice == 1) {
			
		//	ѭ������ϵͳָ��ֱ���û�ѡ���˳�ϵͳ
			while(true) {
				
			//	��ӡͼ��ݹݲ��鼮����ϵͳ�˵�
				MainWork.printAdministorMenu();
				
			//	��ʾ����ָ���ȡָ��
				System.out.print("��������Ӧ��ָ�");
				int order = input.nextInt();
				
			//	����ָ�������Ӧ����ʵ�ֶ�Ӧ����
			//	0  ��������  �˳�ϵͳ����
				if(order == 0)
					break;
			//	1  ��������  ���ͼ�鹦��
				else if(order == 1)
					MainWork.addBook();
			//	2  ��������  ɾ��ͼ����Ϣ����
				else if(order == 2)
					MainWork.deleteBook();
			//	3  ��������  ����ͼ�鹦��
				else if(order == 3)
					MainWork.searchBook();
			//	�����Ƿ�ָ���
				else
				//	��ӡ������ʾ��Ϣ
					MainWork.printWrongInfo("������ָ�����\t�������룡����");
			
			//	��ӡ�ָ���
				System.out.println("\n-------------------------------------------\n\n");
				
			//	ʹ��Thread.sleep()�����Է���ʹ���߹۲췴����Ϣ
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
/*		else if(choice == 2) {
			
		}*/
	//	�Ƿ�ѡ����
		else {
		//	��ӡ������ʾ��Ϣ
			MainWork.printWrongInfo("������ѡ�񣡣���\t�������룡����");
		//	���µ���������������ϵͳ  ������ȷ���������
			input.close();
			MainWork.main(null);
		}
	
	//	�ر�������
		input.close();
		
	}


//	ϵͳ�����ú������̻��洢���ֳ�ʼ����
	private static void systemLoad() {
		Book b = new Book();
		for(int i = 0; i < 10; ++i) {
			Integer integer = i;
			b.bookTitle = new String("ST" + integer.toString());
			b.bookAuthor.add("SA" + integer.toString());
			b.bookPublisher = new String("SP" + integer.toString());
			b.bookNumber = 10 + i;
			b.borrowedNumber = 0;
			book.put(b.bookTitle, b);
		}
	}


//	��ӡͼ��ݹ���ϵͳ�����˵�����
	private static void printMainMenu() {
		
		System.out.println("*******************************************");
		System.out.println("*****         ��ӭʹ��ͼ��ݹ���ϵͳ��        *****");
		System.out.println("*****                                 *****");
		System.out.println("*****     ����1������ͼ��ݹݲ��鼮������     *****");
		System.out.println("*****      ����2������ͼ��ݽ��Ĺ�����       *****");
		System.out.println("*****                                 *****");
		System.out.println("*******************************************");
	}


//	��ӡͼ��ݹݲ��鼮����ϵͳ�����˵�����
	private static void printAdministorMenu() {
		
		System.out.println("*******************************************");
		System.out.println("*****      ��ӭʹ��ͼ��ݹݲ��鼮����ϵͳ��     *****");
		System.out.println("*****                                 *****");
		System.out.println("*****         ����0���˳��鼮����ϵͳ        *****");
		System.out.println("*****          ����1����ӹݲ��鼮          *****");
		System.out.println("*****          ����2��ɾ��ͼ����Ϣ          *****");
		System.out.println("*****         ����3�Բ�ѯͼ���鼮��Ϣ        *****");
		System.out.println("*****                                 *****");
		System.out.println("*******************************************");
	}


//	��ӡ���ҷ�ʽѡ��˵�����
	private static void printChooseMenu() {
		
		System.out.println();
		System.out.println("*****          ����1��ͨ��������ѯ          *****");
		System.out.println("*****          ����2��ͨ�����߲�ѯ          *****");
		System.out.println("*****         ����3��ͨ���������ѯ          *****");
		System.out.println();
	}


//	��ӡ���ô�����ʾ�˵�����
//	������е��ַ���������ʾ��ͬ�ľ��������Ϣ
	private static void printWrongInfo(String s) {
		
		System.out.println("***WRONG***");
		System.out.println(s);
		System.out.println();
		System.out.println();
	}


//	��ʽ����ӡͼ����Ϣ����
	private static void printBookInfo(Book book) {
		System.out.println("ͼ��������        " + book.bookTitle);
		System.out.println("ͼ�����ߣ�        " + book.bookAuthor.get(0));
		for(int i = 2; i <= book.bookAuthor.size(); ++i)
			System.out.println("               " + book.bookAuthor.get(i));
		System.out.println("ͼ������磺       " + book.bookPublisher);
		System.out.println("ͼ��������        " + book.bookNumber);
		System.out.println("�ѽ��ͼ��������    " + book.borrowedNumber);
	}


//	ʵ�����ͼ�鹦�ܷ���
	private static void addBook() {
		
	//	��������ʼ��������it
		Iterator<Map.Entry<String, Book>> it = book.entrySet().iterator();
	//	������
		Map.Entry<String, Book> entry = null;
	//	��������ʼ��boolean���ͱ���isExisted�����ڱ�ʶҪ��ӵ�ͼ���Ƿ��Ѵ���
	//	Ĭ��ֵΪfalse
		boolean isExisted = false;
		
	//	��ʾ����ͼ����������ȡ����
		System.out.print("������ͼ��������");
		String name = input.next().strip();
		
	//	����ͼ���Ƿ��Ѿ�����
		while(it.hasNext()) {
		//	��������ȡ��
			entry = it.next();
			
		//	ͨ���Ƚ�ͼ�������Ƿ���ͬ�Ӷ��ж�ͼ���Ƿ���ڣ�ȷ�����ڱ��isExistedΪtrueȻ���˳��Ƚ�
		//	�˴���֧��ģ������
			if(entry.getKey().strip().equals(name)) {
				isExisted = true;
				break;
			}
		}
		
	//	��ͼ�鲻���ڣ�
		if(!isExisted) {
			
		//	����Book���󲢳�ʼ�����ֲ���
			Book ls = new Book();
			ls.bookTitle = new String(name);
		
		//	������ʾ����������������ȡ��Ȼ��������ʾ�������߲���ȡ��洢
			System.out.print("������ͼ������������");
			int bookArthurNumber = input.nextInt();
			System.out.println("����������ͼ�����ߣ�");
			for(int i = 0; i < bookArthurNumber; ++i) {
				System.out.print("�������" + i + "λ���ߣ�");
				ls.bookAuthor.add(input.next().strip());
			}
			
		//	������ʾ����ͼ������粢��ȡ
			System.out.print("������ͼ������磺");
			ls.bookPublisher = new String(input.next().strip());
			
		//	������ʾ����ͼ����������ȡ
			System.out.print("������ͼ��������");
			ls.bookNumber = input.nextInt();
			
		//	�� ͼ�顪��ͼ���� ���Żض���book
			MainWork.book.put(name, ls);
		}
	//	��ͼ����ڣ�ֻ���ȡ���޸�ͼ���������ɣ�
		else {
		
		//	������ʾ����ͼ����������ȡ
			System.out.print("������ͼ��������");
			int bookNumber = input.nextInt();
			
		//	��ȡͼ����
			Book ls = entry.getValue();
		//	�޸�ͼ����ͼ��������Ϣ
			ls.bookNumber += bookNumber;
		//	�� ͼ�顪��ͼ���� ���Żض���book
			MainWork.book.put(name, ls);
		}
		
	//	��ʾ���ͼ��ɹ�
		System.out.println();
		System.out.println("���ͼ��ɹ���");
		System.out.println();
	}


//	ʵ��ɾ��ͼ����Ϣ���ܷ���
	private static void deleteBook() {
		
	//	��������ʼ��������it
		Iterator<Map.Entry<String, Book>> it = book.entrySet().iterator();
	//	������
		Map.Entry<String, Book> entry = null;
	//	���ͼ���Ƿ���ڣ�Ĭ��Ϊfalse
		boolean isExisted = false;
		
	//	��ʾ����ͼ����������ȡ����
		System.out.print("������ͼ��������");
		String name = input.next().strip();
		
	//	����ͼ���Ƿ����
		while(it.hasNext()) {
		//	��ȡ��ֵ
			entry = it.next();
			
		//	ͨ���Ƚ�ͼ�������Ƿ���ͬ�Ӷ��ж�ͼ���Ƿ���ڣ�ȷ����������isExistedΪtrueȻ���˳��Ƚ�
		//	�˴���֧��ģ������
			if(entry.getKey().equals(name)) {
				isExisted = true;
				break;
			}
		}
		
	//	��ͼ������Ҳ����ڽ�����Ϣ������ɾ��ͼ����Ϣ
		if(isExisted && entry.getValue().borrowedNumber == 0) {
		
		//	����ʹ��iterator��remove()����
		//	ԭ������ͼ����������£�����next()���������һ�Σ����ҵ���ͼ����ǴΣ�
		//		��remove()����ɾ������next()���������һ�μ��ҵ���ͼ����ǴΣ�
		//		��remove()����ɾ�������Ǹ�ͼ�����Ϣ
			it.remove();
			
		//	���ɾ��ͼ��ɹ���Ϣ
			System.out.println();
			System.out.println("ɾ��ͼ��ɹ���");
			System.out.println();
		}
		
	//	��ͼ����ڵ����ڽ�����Ϣ��������ɾ��ͼ����Ϣ�����������ʾ��Ϣ
		else if(isExisted && entry.getValue().borrowedNumber > 0){
			MainWork.printWrongInfo("��ͼ�����н�����Ϣ��\n�޷�ɾ��ͼ����Ϣ��");
		}
	//	��ͼ����ڣ����������ʾ��Ϣ
		else {
			MainWork.printWrongInfo("�����ڸ�ͼ�飡�޷�ɾ����");
		}
	}


//	ʵ������ͼ�鹦�ܷ���
	private static void searchBook() {
	
	//	��ӡѡ��˵���Ϣ
		MainWork.printChooseMenu();
		
	//	�����ʾ��Ϣ����ȡѡ��
		System.out.print("��������Ӧ��ѡ����ѡ����ҷ�ʽ��");
		int chosen = input.nextInt();
		
	//	ѡ�� 1 ���� ͨ��ͼ�����Ʋ�ѯ
	//	ʵ��ģ����ѯ����
		if(chosen == 1) {
		//	����������it
			Iterator<Map.Entry<String, Book>> it = book.entrySet().iterator();
		//	����boolean�ͱ���isFound���ڱ�����ҵ���Ĭ��Ϊfalse
			boolean isFound = false;
			
		//	�����ʾ��Ϣ����ȡ����
			System.out.print("������ͼ��������");
			String bookName = new String(input.next().strip());
			
		//	���Ҳ����ͼ����Ϣ
			while(it.hasNext()) {
			//	����Map��ļ�Entry
				Map.Entry<String, Book> entry = it.next();
				
			//	�ҵ�ͼ�����ӡͼ����Ϣ����isFound���Ϊtrue
				if(entry.getKey().strip().indexOf(bookName) >= 0) {
					MainWork.printBookInfo(entry.getValue());
					isFound = true;
				}
				
			//	��ӡһ�����з������ڹ۲�
				System.out.println();
			}
			
		//	��δ�ҵ���ӡ��ʾ��Ϣ
			if(!isFound) {
				MainWork.printWrongInfo("δ���ҵ���ͼ�飡");
			}
		}
	//	ѡ�� 2 ���� ͨ��ͼ�����߲�ѯ
	//	֧�ַ��ض������
		else if(chosen == 2) {
		//	����������it
			Iterator<Map.Entry<String, Book>> it = book.entrySet().iterator();
		//	����boolean�ͱ���isFound���ڱ��ͼ�����ҵ���Ĭ��Ϊfalse
			boolean isFound = false;
			
		//	�����ʾ��Ϣ����ȡ����
			System.out.print("������ͼ�����ߣ�");
			String bookAuthor = new String(input.next().strip());
			
		//	���Ҳ����ͼ����Ϣ
			while(it.hasNext()) {
			//	����Map��ļ�Entry
				Map.Entry<String, Book> entry = it.next();
				
			//	�ҵ�ͼ�����ӡͼ����Ϣ����isFound���Ϊtrue
				if(entry.getValue().bookAuthor.indexOf(bookAuthor) >= 0) {
					MainWork.printBookInfo(entry.getValue());
					isFound = true;
				}
				
			//	��ӡһ�����з������ڹ۲�
				System.out.println();
			}
			
		//	��δ�ҵ���ӡ��ʾ��Ϣ
			if(!isFound) {
				MainWork.printWrongInfo("δ���ҵ���ͼ�飡");
			}
		}
	//	ѡ�� 3 ���� ͨ��ͼ��ĳ������ѯ
		else if(chosen == 3) {
		//	����������it
			Iterator<Map.Entry<String, Book>> it = book.entrySet().iterator();
		//	����boolean�ͱ���isFound���ڱ��ͼ�����ҵ���Ĭ��Ϊfalse
			boolean isFound = false;
			
		//	�����ʾ��Ϣ����ȡ��������Ϣ
			System.out.print("������ͼ������磺");
			String bookPublisher = input.next().strip();
			
		//	���Ҳ����ͼ����Ϣ
			while(it.hasNext()) {
			//	����Map��ļ�Entry
				Map.Entry<String, Book> entry = it.next();
				
			//	�ҵ�ͼ�����ӡͼ����Ϣ����isFound���Ϊtrue
				if(entry.getValue().bookPublisher.strip().equals(bookPublisher.strip())) {
					MainWork.printBookInfo(entry.getValue());
					isFound = true;
				}
				
			//	��ӡһ�����з������ڹ۲�
				System.out.println();
			}
			
		//	��δ�ҵ���ӡ��ʾ��Ϣ
			if(!isFound) {
				MainWork.printWrongInfo("δ���ҵ���ͼ�飡");
			}
		}
	//	��Ϊ�Ƿ�ѡ�����ӡ������ʾ��Ϣ
		else {
			MainWork.printWrongInfo("�����ڵĲ���ѡ�����\t�������룡����");
		}
	}


//	��ӡͼ��ݶ��߽��Ĺ���ϵͳ����
	@SuppressWarnings("unused")
	private static void printReaderMenu() {
		System.out.println("*******************************************");
		System.out.println("*****      ��ӭʹ��ͼ��ݶ��߽��Ĺ���ϵͳ��     *****");
		System.out.println("*****                                 *****");
		System.out.println("*****         ����0���˳����Ĺ���ϵͳ        *****");
		System.out.println("*****          ����1��ʹ�ý��鹦��          *****");
		System.out.println("*****          ����2��ʹ�û��鹦��          *****");
		System.out.println("*****          ����3�Բ�ѯ������Ϣ          *****");
		System.out.println("*****                                 *****");
		System.out.println("*******************************************");
	}
}


//	ͼ���ࣺ�洢ͼ����Ϣ
class Book {
	public String bookTitle;											//	ͼ�����
	public ArrayList<String> bookAuthor = new ArrayList<String>();		//	ͼ������
	public String bookPublisher;										//	ͼ�������
	public int bookNumber;												//	ͼ������
	public int borrowedNumber;											//	ͼ���ѽ�����
}


//	�����ࣺ�洢������Ϣ
class Student {
	public static final int MAXIUM_BORROW_BOOK_NUMBER = 4;		//	�������ɽ�ͼ������
	
	public String studentID;									//	����ID
	public String studentName;									//	��������
	public int borrowedBookNumber;								//	�����ѽ�ͼ������
}
