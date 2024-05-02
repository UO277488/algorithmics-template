package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NumericSquareHelper {

	private String[][] square;
	private int size;

	public NumericSquareHelper(String option, String file) {
		start(option, file);
	}
	
	private void start(String option, String file) {
		loadData(file);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(file);
		System.out.println();
		printSquare();
		if (option.trim().compareToIgnoreCase("all") == 0) {
			NumericSquareAll nsa = new NumericSquareAll(square);
			nsa.compute();
		} else if(option.trim().compareToIgnoreCase("one") == 0){
			NumericSquareOne nso = new NumericSquareOne(square);
			nso.compute();
		}
		
	}

	private void loadData(String file) {

		try {
			Scanner reader = new Scanner(new FileReader(file));
			this.size = Integer.parseInt(reader.nextLine()); // size of the
			// board is x. Size of a square is x + (x-1) + 1 + 1
			// (x-1) for the operators
			// 1 for the equals
			// 1 for the result

			// thus, for x size of board, sizeSquare = 2x + 1
			this.square = new String[2 * size + 1][2 * size + 1];
			String[] parts;
			
			
			for (int i = 0; i < square.length; i++) {
				
				String line = reader.nextLine();
				
				if (i % 2 == 0 && i != square.length - 1) { // normal lines
					square[i] = line.split(" ");
					
				} else if (i % 2 != 0 || i == square.length - 1) { // operators or final result lines
					parts = line.split(" ");
					
					for (int j = 0; j < parts.length; j++) {
						square[i][j*2] = parts[j];
					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void printSquare() {
		System.out.println("\t \t SQUARE FOR THIS INPUT: ");
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[i].length; j++) {
				System.out.print(square[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
