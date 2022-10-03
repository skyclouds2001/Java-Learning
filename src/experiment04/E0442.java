package experiment04;

import other.C;

public class E0442{
	public static void main(String[] args){
		C obj=new C();
//		obj.func();			//不是C的子类，且与C非同一个包
        
		obj = new CSub();
//        ((CSub)obj).func();
        
        ((CSub)obj).mtd(obj, (CSub)obj);
//        obj.mtd(obj, obj);
	}
}
class CSub extends C{
	void mtd(C parent, CSub sub){
		func();
//		parent.func();      //不是C的子类，且与C非同一个包
		sub.func();			//C的子类，可以访问C的func()方法
	}
}

