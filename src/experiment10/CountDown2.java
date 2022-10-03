package experiment10;

public class CountDown2 extends Thread{
	private static int idcnt=1;
	private final int threadid=idcnt++;
	int counter=3;
	
	public void run(){
		while(counter>=0){
			try{ 
				Thread.sleep(1000);
			} catch (Exception e){ e.printStackTrace(); }
			System.out.println("#"+threadid+
				(counter>0? "->"+counter: "->run!"));
			counter--;
		}
	}
	
	public static void main(String[] args){
		CountDown2 t1=new CountDown2();
		Thread t2=new CountDown2();		//	����ת��
		t1.start();
		t2.start();
		System.out.println("waiting for run...");
	}
}
