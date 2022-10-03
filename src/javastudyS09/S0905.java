package javastudyS09;
import java.awt.geom.Point2D;
//import javafx.geometry.Point2D;

public class S0905 {

	public static void main(String[] args) {
		
		Point2D p1 = new Point2D.Double(1.2, 2.1);
		Point2D p2 = new Point2D.Double(3.2, 2.3);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p1.distance(p2));
		
	}

}
