package algstudent.s3;

import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
		int[] array = new int[n];
		fillIn(array);

		System.out.println("Original array:");
		printArray(array);

		mergesort(array, 0, array.length - 1);

		System.out.println("\nOrdered array:");
		printArray(array);
	}

	public static void mergesort(int[] array, int start, int end) {
		if (start < end) { // divide it until we only have one element
			int medium = (start + end) / 2;
			mergesort(array, start, medium);
			mergesort(array, medium + 1, end);
			merge(array, start, medium, end);
		}
	}

	public static void merge(int[] array, int start, int med, int end) {
		int size1 = med - start + 1;
		int size2 = end - med;
		int[] copy1 = new int[size1];
		int[] copy2 = new int[size2];

		
		for (int i = 0; i < size1; ++i)
			copy1[i] = array[start + i];
		for (int j = 0; j < size2; ++j)
			copy2[j] = array[med + 1 + j];

		int i = 0;
		int j = 0;
		int k = start;
		
		
		while (i < size1 && j < size2) {
			if (copy1[i] <= copy2[j]) {
				array[k] = copy1[i];
				i++;
			} else {
				array[k] = copy2[j];
				j++;
			}
			k++;
		}

		while (i < size1) {
			array[k] = copy1[i];
			i++;
			k++;
		}

		while (j < size2) {
			array[k] = copy2[j];
			j++;
			k++;
		}
	}

	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	/* This method gives random values ​​to a vector of integers. 
	 * It uses the Random class, from the java.util package */
	public static void fillIn(int[]a) {
	 Random r= new Random();
	 int n=a.length;
	 for(int i=0;i<n;i++)
	  a[i]= r.nextInt(19)-9; //values between -9 and 9
	} 

}
