package algstudent.s3;

public class Mergesort {

	public void Mergesort(int left, int right, int[] els) {
		if (right > left) {
			int center = (right + left) / 2;
			Mergesort(left, center, els);
			Mergesort(center + 1, right, els);
		}
		if(right == left) {
			
		}
	}

	private void Combine(int x1, int x2, int y1, int y2, int[] elements) {
		int sizeX = x2 - x1 + 1;
		int sizeY = y2 - y1 + 1;

		int[] x = new int[sizeX];
		int[] y = new int[sizeY];

		for (int i = 0; i < sizeX; i++) {
			x[i] = elements[x1 + i];
		}

		for (int i = 0; i < sizeY; i++) {
			y[i] = elements[y1 + i];
		}

		
	}
}
