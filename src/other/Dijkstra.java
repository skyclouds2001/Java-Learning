package other;

import java.util.Scanner;

public class Dijkstra {

//	图中节点个数
	public int N;
//	图起始点和结束点
	public int START;
	public int END;
	
//	主方法：调用初始化方法及算法方法及输出结果
	public static void main(String [] args) {
		Dijkstra dijk = new Dijkstra();
//		Integer [][] points = dijk.init_example1();
		Integer [][] points = dijk.read();
		
		int min = dijk.DijkstraAlgorithm(points);
		
		System.out.println("The min distance between " + dijk.START 
				+ " and " + dijk.END + " is " + min);
	}
	
//	具体实现Dijkstra算法
	private int DijkstraAlgorithm(Integer [][] p) {
	//	记录当前节点最短距离及是否已访问信息
		Point [] T = new Point[N + 1];
	
	//	以起始点信息初始化
		for(int i = 1; i <= N; ++i)
			T[i] = new Point(p[START][i]);
		

		//	访问起始点
			T[this.START].setVisited(true);
		
	//	分别枚举各节点计算
		for(int i = 1; i <= N; ++i) {
		//	寻找当前未访问节点的最短下标
			int index = START;
			for(int j = 1, t = Integer.MAX_VALUE; j <= N; ++j) {
				if(!T[j].isVisited() && T[j].getValue() < t) {
					t = T[j].getValue();
					index = j;
				}
			}
			
		//	访问该节点
			T[index].setVisited(true);
			
		//	访问该节点所有边并更新节点最短距离
			for(int j = 1; j <= N; ++j) {
				if(T[j].getValue() > T[index].getValue() + p[index][j] &&
						p[index][j] < Integer.MAX_VALUE) {
					T[j].setValue(T[index].getValue() + p[index][j]);
				}
			}
		}
		
	//	此时结束点的最短距离即为所求
		return T[END].getValue();
	}
	
////	初始化样例1方法
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
	
//	读取输入初始化方法
	private Integer [][] read() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入图的节点个数：");
		N = input.nextInt();
		
		System.out.println("请输入起始点：");
		START = input.nextInt();
		System.out.println("请输入结束点：");
		END = input.nextInt();
		
		Integer [][] p = new Integer[N + 1][N + 1];
		for(int i = 1; i <= N; ++i)
			for(int j = 1; j <= N; ++j)
				if(i != j)
					p[i][j] = Integer.MAX_VALUE;
				else
					p[i][j] = 0;
		
		System.out.println("请输入各边的起始点、结束点及边长度：");
		System.out.println("(输入3个-1以结束)");
		
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
	
//	节点内部类
	public class Point {
	//	当前距离
		private int value;
	//	标记是否已访问
		private boolean visited = false;
		
	//	构造方法
		public Point(int value) {
			this(value, false);
		}
		public Point(int value, boolean isVisited) {
			this.setValue(value);
			this.setVisited(isVisited);
		}
		
	//	访问器方法
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
	//	修改器方法
		public boolean isVisited() {
			return visited;
		}
		public void setVisited(boolean isVisited) {
			this.visited = isVisited;
		}
	}
}
