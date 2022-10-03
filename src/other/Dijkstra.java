package other;

import java.util.Scanner;

public class Dijkstra {

//	ͼ�нڵ����
	public int N;
//	ͼ��ʼ��ͽ�����
	public int START;
	public int END;
	
//	�����������ó�ʼ���������㷨������������
	public static void main(String [] args) {
		Dijkstra dijk = new Dijkstra();
//		Integer [][] points = dijk.init_example1();
		Integer [][] points = dijk.read();
		
		int min = dijk.DijkstraAlgorithm(points);
		
		System.out.println("The min distance between " + dijk.START 
				+ " and " + dijk.END + " is " + min);
	}
	
//	����ʵ��Dijkstra�㷨
	private int DijkstraAlgorithm(Integer [][] p) {
	//	��¼��ǰ�ڵ���̾��뼰�Ƿ��ѷ�����Ϣ
		Point [] T = new Point[N + 1];
	
	//	����ʼ����Ϣ��ʼ��
		for(int i = 1; i <= N; ++i)
			T[i] = new Point(p[START][i]);
		

		//	������ʼ��
			T[this.START].setVisited(true);
		
	//	�ֱ�ö�ٸ��ڵ����
		for(int i = 1; i <= N; ++i) {
		//	Ѱ�ҵ�ǰδ���ʽڵ������±�
			int index = START;
			for(int j = 1, t = Integer.MAX_VALUE; j <= N; ++j) {
				if(!T[j].isVisited() && T[j].getValue() < t) {
					t = T[j].getValue();
					index = j;
				}
			}
			
		//	���ʸýڵ�
			T[index].setVisited(true);
			
		//	���ʸýڵ����б߲����½ڵ���̾���
			for(int j = 1; j <= N; ++j) {
				if(T[j].getValue() > T[index].getValue() + p[index][j] &&
						p[index][j] < Integer.MAX_VALUE) {
					T[j].setValue(T[index].getValue() + p[index][j]);
				}
			}
		}
		
	//	��ʱ���������̾��뼴Ϊ����
		return T[END].getValue();
	}
	
////	��ʼ������1����
//	private Integer [][] init_example1() {
//		int inf = Integer.MAX_VALUE;
//		N = 5;
//		START = 0;
//		END = 3;
//		Integer [][] pos = {
//				{0, 2, inf, 10, inf},
//				{2, 0, 3, 7, inf},
//				{inf, 3, 0, 6, 4},
//				{10, 7, 6, 0, 5},
//				{inf, inf, 4, 5, 0}
//				};
//		return pos;
//	}
	
//	��ȡ�����ʼ������
	private Integer [][] read() {
		Scanner input = new Scanner(System.in);
		System.out.println("������ͼ�Ľڵ������");
		N = input.nextInt();
		
		System.out.println("��������ʼ�㣺");
		START = input.nextInt();
		System.out.println("����������㣺");
		END = input.nextInt();
		
		Integer [][] p = new Integer[N + 1][N + 1];
		for(int i = 1; i <= N; ++i)
			for(int j = 1; j <= N; ++j)
				if(i != j)
					p[i][j] = Integer.MAX_VALUE;
				else
					p[i][j] = 0;
		
		System.out.println("��������ߵ���ʼ�㡢�����㼰�߳��ȣ�");
		System.out.println("(����3��-1�Խ���)");
		
		while(true) {
			int p1 = input.nextInt();
			int p2 = input.nextInt();
			int d = input.nextInt();
			
			if(p1 == -1)
				break;
			
			p[p1][p2] = d;
		}
		
		input.close();
		return p;
	}
	
//	�ڵ��ڲ���
	public class Point {
	//	��ǰ����
		private int value;
	//	����Ƿ��ѷ���
		private boolean visited = false;
		
	//	���췽��
		public Point(int value) {
			this(value, false);
		}
		public Point(int value, boolean isVisited) {
			this.setValue(value);
			this.setVisited(isVisited);
		}
		
	//	����������
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
	//	�޸�������
		public boolean isVisited() {
			return visited;
		}
		public void setVisited(boolean isVisited) {
			this.visited = isVisited;
		}
	}
}
