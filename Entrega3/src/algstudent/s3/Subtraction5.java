package algstudent.s3;

public class Subtraction5 {
	static long cont;


	public static void rec5(int n) {
		if (n <= 0)
			cont++;
		else {
			cont++;
			rec5(n - 2);
			rec5(n - 2);
			rec5(n - 2);
		}
	}

	public static void main(String arg[]) {
		long t1, t2 = 0;
		int nTimes = Integer.parseInt (arg [0]);
		
		for (int n = 1; n <= 100; n++) {
			t1 = System.currentTimeMillis();

			for (int reps=1; reps<=nTimes;reps++)
			{ 
				cont = 0;
				rec5(n);
			} 

			t2 = System.currentTimeMillis();

			System.out.println("n=" + n + "**TIME=" + (t2 - t1) + "**cont=" + cont);
		} // for
	}
}
