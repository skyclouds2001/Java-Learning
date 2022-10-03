package javastudyS11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class T1111_T1112_T1113_T1114 {

	public static void main(String[] args) {
		
		Integer [] array = {1, 3, 2, 2, 1, 2, 3, 3, 6, 9};
		ArrayList<Integer> list0 = new ArrayList<>(Arrays.asList(array));
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		
		for(int i = 0; i < 10; ++i) {
			list1.add(i * i + i + 1);
			list2.add(i * i - i - 2);
		}
		
		print(list0);
		sort(list0);
		print(list0);
		
		ArrayList<Integer> list = union(list1, list2);
		print(list1);
		print(list2);
		print(list);
		
//		java.util.Collections.shuffle(list);
//		for(Integer it: list)
//			System.out.print(it.intValue() + " ");
//		System.out.println();
//		java.util.Collections.shuffle(list);
//		for(Integer it: list)
//			System.out.print(it.intValue() + " ");
//		System.out.println();
		
		print(list0);
		ArrayList<Integer> list3 = removeDuplicate(list0);
		print(list3);
		
		System.out.println(sum(list));
		System.out.println(sum(list1));
		System.out.println(sum(list2));
		
	}
	
	public static void sort(ArrayList<Integer> list) {
		
		for(int i = 0; i < list.size(); ++i) {
			for(int j = 0; j < list.size() - i - 1; ++j) {
				if(list.get(j) > list.get(j + 1)) {
					int t1 = list.get(j);
					int t2 = list.get(j + 1);
					list.set(j, t2);
					list.set(j + 1, t1);
				}
			}
		}
		
	}
	
	private static void print(ArrayList<Integer> list) {
		for(Integer it: list)
			System.out.print(it.intValue() + " ");
		System.out.println();
	}
	
	public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for(Integer it: list1)
			list.add(it);
		for(Integer it: list2)
			list.add(it);
		
		return list;
	}
	
	public static ArrayList<Integer> removeDuplicate(ArrayList<Integer> list){
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(Integer it: list) {
			if(ans.indexOf(it) == -1) {
				ans.add(it);
			}
		}
		
		return ans;
	}
	
	public static void removeDuplicate(ArrayList<Integer> list, int init){
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(ListIterator<Integer> it = list.listIterator(); it.hasNext();) {
			
			Integer value = (Integer)(it.next());
			if(ans.indexOf(value) == -1) {
				ans.add(value);
			}
			else {
				it.remove();
			}
			
		}
	}
	
	public static int sum(ArrayList<Integer> list) {
		int sum = 0;
		
		for(int it: list)
			sum += it;
		
		return sum;
	}

}
