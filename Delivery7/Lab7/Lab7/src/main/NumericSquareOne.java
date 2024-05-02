package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class NumericSquareOne {
	private String[][] square;
	private String[][] stateSquare;
	int numberOfNodes = 0;


	public NumericSquareOne(String[][] square) {
		this.square = square;
		this.stateSquare = new String[square.length][];
		for (int i = 0; i < square.length; i++) {
			this.stateSquare[i] = square[i].clone();
		}
	}

	public void compute() {
		List<Point> points = computeEditablePoints();
		if (computeRec(points, 0)) {
			printSolution();
		}
	}

	private boolean computeRec(List<Point> editablePoints, int step) {
		if (step >= editablePoints.size())
			return false; // no sol

		int x = editablePoints.get(step).x;
		int y = editablePoints.get(step).y;

		for (int i = 0; i <= 9; i++) {
			stateSquare[x][y] = String.valueOf(i); // go to the first editable point
			numberOfNodes++;
			if (isFilledArray(stateSquare[x]) && !isSolutionOperation(stateSquare[x]))
				continue;

			if (isFilledArray(getColumn(stateSquare, y)) && !isSolutionOperation(getColumn(stateSquare, y)))
				continue;
			if (isSolution(stateSquare))
				return true;

			if (computeRec(editablePoints, step + 1)) {
				return true;
			}

		}
		if (stateSquare[x][y].equals("9")) {
			stateSquare[x][y] = "?"; // leave it as it was and compute again
			return false;
		}
		return true;

	}

	private boolean isSolution(String[][] status) {
		for (int i = 0; i < status.length - 1; i += 2) {
			if (!isFilledArray(status[i]) || !isFilledArray(getColumn(status, i)))
				return false;

			if (!isSolutionOperation(status[i]) || !isSolutionOperation(getColumn(status, i)))
				return false;

		}
		return true;
	}

	private boolean isSolutionOperation(String[] operation) {
		int prevRes = Integer.parseInt(operation[0]);
		boolean noSolutionCase = false;
		for (int i = 0; i < operation.length; i++) {
			switch (operation[i]) {
			case ("="):
				if (prevRes == Integer.parseInt(operation[i + 1])) {
					return true;
				}
				return noSolutionCase;
			case "+":
				prevRes = prevRes + Integer.parseInt(operation[i + 1]);
				break;
			case "-":
				prevRes = prevRes - Integer.parseInt(operation[i + 1]);
				break;
			case "/":
				if (Integer.parseInt(operation[i + 1]) != 0 &&
						Integer.parseInt(operation[i - 1])%Integer.parseInt(operation[i + 1])==0
						&& Integer.parseInt(operation[i - 1])>=Integer.parseInt(operation[i + 1]))
					prevRes = prevRes / Integer.parseInt(operation[i + 1]);
				break;
			case "*":
				prevRes = prevRes * Integer.parseInt(operation[i + 1]);
				break;
			default:
				break;

			}
		}
		return noSolutionCase;
	}

	private boolean isFilledArray(String[] operation) {
		for (int i = 0; i < operation.length; i++)
				if (operation[i].equals("?"))
					return false;

		return true;
	}

	private String[] getColumn(String[][] square, int columnIndex) {
		String[] ret = new String[square[0].length];
		for (int i = 0; i < square.length; i++)
			ret[i] = square[i][columnIndex];

		return ret;
	}

	private List<Point> computeEditablePoints() {
		List<Point> points = new ArrayList<Point>();
		for (int i = 0; i < square.length; i++)
			for (int j = 0; j < square.length; j++)
				if (square[i][j] != null)
					if (square[i][j].equals("?"))
						points.add(new Point(i, j));
		return points;
	}

	private void printSolution() {
		System.out
				.println("--------------------------------------SOLUTION FOUND BACKTRACKING--------------------------------------");
		for (int i = 0; i < stateSquare.length; i++) {
			for (int j = 0; j < stateSquare[i].length; j++)
				System.out.print(stateSquare[i][j] + "\t");

			System.out.println();
		}
		System.out.println("NUMBER OF TRAVERSED NODES: " + numberOfNodes);
	}
}
