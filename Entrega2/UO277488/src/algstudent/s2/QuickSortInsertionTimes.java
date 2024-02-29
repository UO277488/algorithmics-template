package algstudent.s2;

public class QuickSortInsertionTimes {
	static int[] v;

	public static void main(String arg[]) {
		long t1, t2;
		int k = Integer.parseInt(arg[0]);

		v = new int[16000000];

		Vector.randomSorted(v);

		t1 = System.currentTimeMillis();

		QuicksortInsertion.quicksortInsertion(v, k);

		t2 = System.currentTimeMillis();

		System.out.println((t2 - t1));

	}

}
