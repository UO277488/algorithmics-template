package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		long t1, t2;

		Scanner ms = new Scanner(System.in);
		System.out.println("Introduce all if you want all solutions, one oderwise");
		String input = ms.nextLine();
		NumericSquareHelper ns;
		
		t1 = System.currentTimeMillis();
		ns = new NumericSquareHelper(input, String.format("src/test0%s.txt", 7));
		
		t2 = System.currentTimeMillis();
			System.out.println("TIME: " + (t2 - t1) + "\t" + "\t\t");
		}

//		for (int i = 0; i < 7; i++) {
//			t1 = System.currentTimeMillis();
//			for (int repetitions = 1; repetitions <= nTimes; repetitions++)
//				ns = new NumericSquareHelper(input, String.format("src/test0%s.txt", i));
//			t2 = System.currentTimeMillis();
//			System.out.println("\t" + (t2 - t1) + "\t" + nTimes + "\t\t");
//		}
		
	}


