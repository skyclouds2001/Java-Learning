package other;

public class SumOfArgs {

	public static void main(String[] args) {
		
		int sum = 0;
		
		for(int i = 0; i < args.length; ++i) {
			try {
				int num = Integer.valueOf(args[i]).intValue();
				sum += num;
			}
			catch(Exception e) {
			}
		}
		
		System.out.println(sum);
		
	}

}
