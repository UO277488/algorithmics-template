package main;

public class Main {

	public static void main(String[] args) {
		long t1, t2, t3;
		NumericSquareHelper ns;

		ns = new NumericSquareHelper(String.format("src/test0%s.txt", 4));

		t1 = System.currentTimeMillis();
		ns.numericSquareBaB();
		t2 = System.currentTimeMillis();
		System.out.println("TIME BaB: " + (t2 - t1));
		ns.numericSquareOne();
		t3 = System.currentTimeMillis();
		System.out.println("TIME Backtracking: " + (t3 - t2));
	}

}
