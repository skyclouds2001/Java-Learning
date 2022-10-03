package experiment10;

import java.util.ArrayList;

// 主方法：加载电影票并启动线程
public class MovieTheater {

	public static void main(String args[]) {
	//	加载门票
		load();
		
		TicketOffice t1 = new TicketOffice(1);
		TicketOffice t2 = new TicketOffice(2);
		TicketOffice t3 = new TicketOffice(3);
		
	//	启动线程：间隔随机时间开始售票
		long sleepTime;
		try {
			sleepTime = (int)(Math.random() * 1000 + 0.5);
			t1.start();
			Thread.sleep(sleepTime);
			t2.start();
			sleepTime = (int)(Math.random() * 1000 + 0.5);
			Thread.sleep(sleepTime);
			t3.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
//	电影票池：存储电影票
	public static ArrayList<Ticket> ticket;
//	存储电影票数量
	public static int ticketNumber;
	
//	默认行数和列数
	private static final int DEFAULT_ROW = 5;
	private static final int DEFAULT_COLUMN = 5;
	
//	初始化方法：作用是向电影票池中添加电影票
	private static void load() {
		ticket = new ArrayList<>();
		
		Ticket t = null;
		for(int i = 1; i <= DEFAULT_ROW * DEFAULT_COLUMN; ++i) {
			t = new Ticket(i, i / DEFAULT_COLUMN, i % DEFAULT_COLUMN);
			ticket.add(t);
		}
		
		ticketNumber = DEFAULT_ROW * DEFAULT_COLUMN;
	}
}

//	电影票类：存储电影票信息
class Ticket {
	private int row;		// 行
	private int column;		// 列
	private int id;			// 编号
	private boolean isSold;		// 标记是否已被售出
	
//	Ticket类构造方法
	public Ticket(int id, int row, int column) {
		this.setId(id);
		this.setRow(row);
		this.setColumn(column);
		this.setSold(false);
	}

//	私有属性的访问器和修改器
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isSold() {
		return isSold;
	}

	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}
}

//	进程类：执行售票操作
class TicketOffice extends Thread {
//	标记售票口编号
	private int id;
//	标记已售票数量：定义为静态变量从而实现不同进程的数据共享
	private static int soldTicketID = 1;
	
//	构造方法
	public TicketOffice(int id) {
		this.id = id;
	}
	
	public void run() {
	//	循环处理：直到售票完成
		while(MovieTheater.ticketNumber > 0) {
			synchronized(this) {
				
			//	售票环节
				MovieTheater.ticket.get(soldTicketID - 1).setSold(true);
				System.out.println("窗口" + id + "出售编号" + soldTicketID + "电影票");
				++soldTicketID;
				--MovieTheater.ticketNumber;
				
			//	线程睡眠适当时间：模拟随机出票间隔
				int sleepTime = (int)(Math.random() * 4000 + 1000 + 0.5);
				try {
					this.wait(sleepTime);
					this.notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

