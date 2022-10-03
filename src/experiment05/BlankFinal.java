package experiment05;

@SuppressWarnings("unused")
class Poppet {
	private int i;
	Poppet(int ii) { i = ii; }
}

@SuppressWarnings("unused")
public class BlankFinal {
	
	private final int i = 0; 	// ����ʼ����final
	private final int j; 	// �հ�final
	private final Poppet p; 	// �հ�final����
	
	public BlankFinal() {
		j = 1; 			// ��ʼ���հ�final
		p = new Poppet(1); 	// ��ʼ���հ�final����
	}
	
	public BlankFinal(int x) {
		j = x; 			// ��ʼ���հ�final
		p = new Poppet(x); 	// ��ʼ���հ�final����
	}
	
	public static void main(String[] args) {
		new BlankFinal();
		new BlankFinal(47);
	}
}
