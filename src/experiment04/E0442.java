package experiment04;

import other.C;

public class E0442{
	public static void main(String[] args){
		C obj=new C();
//		obj.func();			//����C�����࣬����C��ͬһ����
        
		obj = new CSub();
//        ((CSub)obj).func();
        
        ((CSub)obj).mtd(obj, (CSub)obj);
//        obj.mtd(obj, obj);
	}
}
class CSub extends C{
	void mtd(C parent, CSub sub){
		func();
//		parent.func();      //����C�����࣬����C��ͬһ����
		sub.func();			//C�����࣬���Է���C��func()����
	}
}

