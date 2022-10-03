package experiment04;
import other.A;

public class E0473 {
    int i = 0;
    A a0 = new A();
    {    
    	System.out.println("In Base Initial block in class E0473:i=" + i++);  // j++;
    }
    A a1 = new A();
    E0473() {
    	System.out.println("In Base constructor in class E0473:i=" + i++); // Base(0);   }
    }
    E0473(int j) {
    	this.j = j;
    }
    int j = 0;
    public static void main(String[] args) {
            @SuppressWarnings("unused")
			Child c = new Child();
    }
}

class Child extends E0473 {
    int i = 0;
    {    
    	System.out.println("In Base Initial block in class Child:i=" + i++);  // j++;
    }
    Child(){
    	System.out.println("In Child constructor in class Child:i=" + i);  //super();
    }
}
