package experiment05;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class MainWork {

//	存储书的Map类对象
//	定义为静态成员变量以在main()函数中以不实例化类的条件下使用book对象
	private static Map<String, Book> book = new HashMap<String, Book>();

/*	private static Map<String, Book> student = new HashMap<String, Book>();	*/

//	输入流Scanner类对象
//	仅在main()函数中启动后实例化与结束前关闭
//	便于在多个成员函数中使用
	private static Scanner input = null;


//	主函数
//	这里使用异常以后面使用sleep()方法
	public static void main(String[] args) {
		
	//	打开输入流
		input = new Scanner(System.in);
	//	加载数据
		MainWork.systemLoad();
		
	//	打印菜单并读取选择，以后续启动相应的系统
		MainWork.printMainMenu();
		System.out.print("请输入相应的选择：");
		int choice = input.nextInt();
		
	//	根据选择启动相应系统
		if(choice == 1) {
			
		//	循环处理系统指令直至用户选择退出系统
			while(true) {
				
			//	打印图书馆馆藏书籍管理系统菜单
				MainWork.printAdministorMenu();
				
			//	提示输入指令并读取指令
				System.out.print("请输入相应的指令：");
				int order = input.nextInt();
				
			//	根据指令调用相应函数实现对应功能
			//	0  ————  退出系统功能
				if(order == 0)
					break;
			//	1  ————  添加图书功能
				else if(order == 1)
					MainWork.addBook();
			//	2  ————  删除图书信息功能
				else if(order == 2)
					MainWork.deleteBook();
			//	3  ————  搜索图书功能
				else if(order == 3)
					MainWork.searchBook();
			//	其他非法指令处理
				else
				//	打印错误提示信息
					MainWork.printWrongInfo("不存在指令！！！\t请检查输入！！！");
			
			//	打印分割线
				System.out.println("\n-------------------------------------------\n\n");
				
			//	使用Thread.sleep()方法以方便使用者观察反馈信息
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
/*		else if(choice == 2) {
			
		}*/
	//	非法选择处理
		else {
		//	打印错误提示信息
			MainWork.printWrongInfo("不存在选择！！！\t请检查输入！！！");
		//	重新调用主函数即重启系统  ？？不确定后果？？
			input.close();
			MainWork.main(null);
		}
	
	//	关闭输入流
		input.close();
		
	}


//	系统启动用函数，固化存储部分初始数据
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


//	打印图书馆管理系统的主菜单方法
	private static void printMainMenu() {
		
		System.out.println("*******************************************");
		System.out.println("*****         欢迎使用图书馆管理系统！        *****");
		System.out.println("*****                                 *****");
		System.out.println("*****     输入1以启动图书馆馆藏书籍管理功能     *****");
		System.out.println("*****      输入2以启动图书馆借阅管理功能       *****");
		System.out.println("*****                                 *****");
		System.out.println("*******************************************");
	}


//	打印图书馆馆藏书籍管理系统的主菜单方法
	private static void printAdministorMenu() {
		
		System.out.println("*******************************************");
		System.out.println("*****      欢迎使用图书馆馆藏书籍管理系统！     *****");
		System.out.println("*****                                 *****");
		System.out.println("*****         输入0以退出书籍管理系统        *****");
		System.out.println("*****          输入1以添加馆藏书籍          *****");
		System.out.println("*****          输入2以删除图书信息          *****");
		System.out.println("*****         输入3以查询图书书籍信息        *****");
		System.out.println("*****                                 *****");
		System.out.println("*******************************************");
	}


//	打印查找方式选择菜单方法
	private static void printChooseMenu() {
		
		System.out.println();
		System.out.println("*****          输入1以通过书名查询          *****");
		System.out.println("*****          输入2以通过作者查询          *****");
		System.out.println("*****         输入3以通过出版社查询          *****");
		System.out.println();
	}


//	打印共用错误提示菜单方法
//	输入独有的字符串参数显示不同的具体错误信息
	private static void printWrongInfo(String s) {
		
		System.out.println("***WRONG***");
		System.out.println(s);
		System.out.println();
		System.out.println();
	}


//	格式化打印图书信息方法
	private static void printBookInfo(Book book) {
		System.out.println("图书书名：        " + book.bookTitle);
		System.out.println("图书作者：        " + book.bookAuthor.get(0));
		for(int i = 2; i <= book.bookAuthor.size(); ++i)
			System.out.println("               " + book.bookAuthor.get(i));
		System.out.println("图书出版社：       " + book.bookPublisher);
		System.out.println("图书数量：        " + book.bookNumber);
		System.out.println("已借出图书数量：    " + book.borrowedNumber);
	}


//	实现添加图书功能方法
	private static void addBook() {
		
	//	声明并初始化迭代器it
		Iterator<Map.Entry<String, Book>> it = book.entrySet().iterator();
	//	声明键
		Map.Entry<String, Book> entry = null;
	//	声明并初始化boolean类型变量isExisted，用于标识要添加的图书是否已存在
	//	默认值为false
		boolean isExisted = false;
		
	//	提示输入图书书名并读取书名
		System.out.print("请输入图书书名：");
		String name = input.next().strip();
		
	//	查找图书是否已经存在
		while(it.hasNext()) {
		//	声明并提取键
			entry = it.next();
			
		//	通过比较图书书名是否相同从而判断图书是否存在，确定存在标记isExisted为true然后退出比较
		//	此处不支持模糊搜索
			if(entry.getKey().strip().equals(name)) {
				isExisted = true;
				break;
			}
		}
		
	//	若图书不存在：
		if(!isExisted) {
			
		//	创建Book对象并初始化部分参数
			Book ls = new Book();
			ls.bookTitle = new String(name);
		
		//	下面提示输入作者数量并读取，然后依次提示输入作者并读取与存储
			System.out.print("请输入图书作者数量：");
			int bookArthurNumber = input.nextInt();
			System.out.println("请依次输入图书作者：");
			for(int i = 0; i < bookArthurNumber; ++i) {
				System.out.print("请输入第" + i + "位作者：");
				ls.bookAuthor.add(input.next().strip());
			}
			
		//	下面提示输入图书出版社并读取
			System.out.print("请输入图书出版社：");
			ls.bookPublisher = new String(input.next().strip());
			
		//	下面提示输入图书数量并读取
			System.out.print("请输入图书数量：");
			ls.bookNumber = input.nextInt();
			
		//	把 图书——图书类 键放回对象book
			MainWork.book.put(name, ls);
		}
	//	若图书存在，只需读取并修改图书数量即可：
		else {
		
		//	下面提示输入图书数量并读取
			System.out.print("请输入图书数量：");
			int bookNumber = input.nextInt();
			
		//	提取图书类
			Book ls = entry.getValue();
		//	修改图书类图书数量信息
			ls.bookNumber += bookNumber;
		//	把 图书——图书类 键放回对象book
			MainWork.book.put(name, ls);
		}
		
	//	提示添加图书成功
		System.out.println();
		System.out.println("添加图书成功！");
		System.out.println();
	}


//	实现删除图书信息功能方法
	private static void deleteBook() {
		
	//	声明并初始化迭代器it
		Iterator<Map.Entry<String, Book>> it = book.entrySet().iterator();
	//	声明键
		Map.Entry<String, Book> entry = null;
	//	标记图书是否存在，默认为false
		boolean isExisted = false;
		
	//	提示输入图书书名并读取书名
		System.out.print("请输入图书书名：");
		String name = input.next().strip();
		
	//	查找图书是否存在
		while(it.hasNext()) {
		//	提取键值
			entry = it.next();
			
		//	通过比较图书书名是否相同从而判断图书是否存在，确定存在则标记isExisted为true然后退出比较
		//	此处不支持模糊搜索
			if(entry.getKey().equals(name)) {
				isExisted = true;
				break;
			}
		}
		
	//	若图书存在且不存在借阅信息，可以删除图书信息
		if(isExisted && entry.getValue().borrowedNumber == 0) {
		
		//	可以使用iterator的remove()方法
		//	原因是在图书存在条件下，调用next()方法的最后一次，即找到该图书的那次，
		//		而remove()方法删除调用next()方法的最后一次即找到该图书的那次，
		//		即remove()方法删除的正是该图书的信息
			it.remove();
			
		//	输出删除图书成功信息
			System.out.println();
			System.out.println("删除图书成功！");
			System.out.println();
		}
		
	//	若图书存在但存在借阅信息，不可以删除图书信息，输出错误提示信息
		else if(isExisted && entry.getValue().borrowedNumber > 0){
			MainWork.printWrongInfo("此图书仍有借阅信息！\n无法删除图书信息！");
		}
	//	若图书存在，输出错误提示信息
		else {
			MainWork.printWrongInfo("不存在该图书！无法删除！");
		}
	}


//	实现搜索图书功能方法
	private static void searchBook() {
	
	//	打印选择菜单信息
		MainWork.printChooseMenu();
		
	//	输出提示信息并读取选项
		System.out.print("请输入相应的选项以选择查找方式：");
		int chosen = input.nextInt();
		
	//	选项 1 —— 通过图书名称查询
	//	实现模糊查询功能
		if(chosen == 1) {
		//	声明迭代器it
			Iterator<Map.Entry<String, Book>> it = book.entrySet().iterator();
		//	声明boolean型变量isFound用于标记已找到，默认为false
			boolean isFound = false;
			
		//	输出提示信息并读取书名
			System.out.print("请输入图书书名：");
			String bookName = new String(input.next().strip());
			
		//	查找并输出图书信息
			while(it.hasNext()) {
			//	声明Map类的键Entry
				Map.Entry<String, Book> entry = it.next();
				
			//	找到图书则打印图书信息并把isFound标记为true
				if(entry.getKey().strip().indexOf(bookName) >= 0) {
					MainWork.printBookInfo(entry.getValue());
					isFound = true;
				}
				
			//	打印一个换行符，便于观察
				System.out.println();
			}
			
		//	若未找到打印提示信息
			if(!isFound) {
				MainWork.printWrongInfo("未查找到该图书！");
			}
		}
	//	选项 2 —— 通过图书作者查询
	//	支持返回多条结果
		else if(chosen == 2) {
		//	声明迭代器it
			Iterator<Map.Entry<String, Book>> it = book.entrySet().iterator();
		//	声明boolean型变量isFound用于标记图书已找到，默认为false
			boolean isFound = false;
			
		//	输出提示信息并读取书名
			System.out.print("请输入图书作者：");
			String bookAuthor = new String(input.next().strip());
			
		//	查找并输出图书信息
			while(it.hasNext()) {
			//	声明Map类的键Entry
				Map.Entry<String, Book> entry = it.next();
				
			//	找到图书则打印图书信息并把isFound标记为true
				if(entry.getValue().bookAuthor.indexOf(bookAuthor) >= 0) {
					MainWork.printBookInfo(entry.getValue());
					isFound = true;
				}
				
			//	打印一个换行符，便于观察
				System.out.println();
			}
			
		//	若未找到打印提示信息
			if(!isFound) {
				MainWork.printWrongInfo("未查找到该图书！");
			}
		}
	//	选项 3 —— 通过图书的出版社查询
		else if(chosen == 3) {
		//	声明迭代器it
			Iterator<Map.Entry<String, Book>> it = book.entrySet().iterator();
		//	声明boolean型变量isFound用于标记图书已找到，默认为false
			boolean isFound = false;
			
		//	输出提示信息并读取出版社信息
			System.out.print("请输入图书出版社：");
			String bookPublisher = input.next().strip();
			
		//	查找并输出图书信息
			while(it.hasNext()) {
			//	声明Map类的键Entry
				Map.Entry<String, Book> entry = it.next();
				
			//	找到图书则打印图书信息并把isFound标记为true
				if(entry.getValue().bookPublisher.strip().equals(bookPublisher.strip())) {
					MainWork.printBookInfo(entry.getValue());
					isFound = true;
				}
				
			//	打印一个换行符，便于观察
				System.out.println();
			}
			
		//	若未找到打印提示信息
			if(!isFound) {
				MainWork.printWrongInfo("未查找到该图书！");
			}
		}
	//	若为非法选项则打印错误提示信息
		else {
			MainWork.printWrongInfo("不存在的查找选项！！！\t请检查输入！！！");
		}
	}


//	打印图书馆读者借阅管理系统方法
	@SuppressWarnings("unused")
	private static void printReaderMenu() {
		System.out.println("*******************************************");
		System.out.println("*****      欢迎使用图书馆读者借阅管理系统！     *****");
		System.out.println("*****                                 *****");
		System.out.println("*****         输入0以退出借阅管理系统        *****");
		System.out.println("*****          输入1以使用借书功能          *****");
		System.out.println("*****          输入2以使用还书功能          *****");
		System.out.println("*****          输入3以查询借阅信息          *****");
		System.out.println("*****                                 *****");
		System.out.println("*******************************************");
	}
}


//	图书类：存储图书信息
class Book {
	public String bookTitle;											//	图书标题
	public ArrayList<String> bookAuthor = new ArrayList<String>();		//	图书作者
	public String bookPublisher;										//	图书出版社
	public int bookNumber;												//	图书数量
	public int borrowedNumber;											//	图书已借数量
}


//	读者类：存储读者信息
class Student {
	public static final int MAXIUM_BORROW_BOOK_NUMBER = 4;		//	读者最大可借图书数量
	
	public String studentID;									//	读者ID
	public String studentName;									//	读者姓名
	public int borrowedBookNumber;								//	读者已借图书数量
}
