package experiment10;

import java.util.ArrayList;

// �����������ص�ӰƱ�������߳�
public class MovieTheater {

	public static void main(String args[]) {
	//	������Ʊ
		load();
		
		TicketOffice t1 = new TicketOffice(1);
		TicketOffice t2 = new TicketOffice(2);
		TicketOffice t3 = new TicketOffice(3);
		
	//	�����̣߳�������ʱ�俪ʼ��Ʊ
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
	
//	��ӰƱ�أ��洢��ӰƱ
	public static ArrayList<Ticket> ticket;
//	�洢��ӰƱ����
	public static int ticketNumber;
	
//	Ĭ������������
	private static final int DEFAULT_ROW = 5;
	private static final int DEFAULT_COLUMN = 5;
	
//	��ʼ�����������������ӰƱ������ӵ�ӰƱ
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

//	��ӰƱ�ࣺ�洢��ӰƱ��Ϣ
class Ticket {
	private int row;		// ��
	private int column;		// ��
	private int id;			// ���
	private boolean isSold;		// ����Ƿ��ѱ��۳�
	
//	Ticket�๹�췽��
	public Ticket(int id, int row, int column) {
		this.setId(id);
		this.setRow(row);
		this.setColumn(column);
		this.setSold(false);
	}

//	˽�����Եķ��������޸���
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

//	�����ִࣺ����Ʊ����
class TicketOffice extends Thread {
//	�����Ʊ�ڱ��
	private int id;
//	�������Ʊ����������Ϊ��̬�����Ӷ�ʵ�ֲ�ͬ���̵����ݹ���
	private static int soldTicketID = 1;
	
//	���췽��
	public TicketOffice(int id) {
		this.id = id;
	}
	
	public void run() {
	//	ѭ������ֱ����Ʊ���
		while(MovieTheater.ticketNumber > 0) {
			synchronized(this) {
				
			//	��Ʊ����
				MovieTheater.ticket.get(soldTicketID - 1).setSold(true);
				System.out.println("����" + id + "���۱��" + soldTicketID + "��ӰƱ");
				++soldTicketID;
				--MovieTheater.ticketNumber;
				
			//	�߳�˯���ʵ�ʱ�䣺ģ�������Ʊ���
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

