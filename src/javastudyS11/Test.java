package javastudyS11;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		
		//ArrayList<int> list = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		Integer [] array = {12, 23, 23, 45, 56};
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(array));
		
		Integer [] array0 = new Integer[list1.size()];
		list.toArray(array0);
		
		java.util.Collections.sort(list);
		
		java.util.Collections.max(list);
		java.util.Collections.min(list);
		
		java.util.Collections.shuffle(list);
		
	}

}
