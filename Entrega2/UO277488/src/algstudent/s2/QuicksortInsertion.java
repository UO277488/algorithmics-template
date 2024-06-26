package algstudent.s2;

public class QuicksortInsertion {
		static int[] v;
		
		public static void quicksortInsertion(int[] a, int k) {
			quicksortInsertion(a, 0, a.length-1, k);
		}
		
		public static void insertion(int[] a, int left, int right) {
			int j;
			int pivot;
			int n = right;
			
			for (int i =  left+1; i < n; i++) {
				pivot = a[i];
				j = i-1;
				
				while (j >= 0 && pivot < a[j]) {
					a[j+1] = a[j];
					j--;
				}
				
				a[j+1] = pivot;
			}
		}

		/* Sorting by the Insertion method */
		public static void quicksortInsertion(int[] a, int left, int right, int k) {
			int i = left;
			int j = right - 1;
			int pivot;
			
			if (right-left>k){ //if the length of the vector is small enough, stop
				int center = Quicksort.median_of_three(a, left, right);
				//if there are less than or equal to 3 elements, there are just ordered
				if ((right - left) >= 3){ 
					pivot = a[center]; //choose the pivot
					Vector.interchange(a, center, right); //hide the pivot

					do {         
				    	while (a[i] <= pivot && i < right) i++; //first element > pivot
				    	while (a[j] >= pivot && j > left) j--; //first element < pivot
				        if (i < j) Vector.interchange(a, i, j);
				    } while (i < j);   //end while
					
					//we set the position of the pivot
					Vector.interchange(a, i, right);
					quicksortInsertion(a, left, i-1,k);
					quicksortInsertion(a, i+1, right,k);		
				} //if
			} //if
			else
				insertion(a, left, right);
		}

		public static void main(String arg[]) {
			int k = Integer.parseInt(arg[0]); //number of partitions
			v = new int[16000000];

			Vector.randomSorted(v);
			System.out.println("VECTOR TO BE SORTED");
			Vector.print(v);
			quicksortInsertion(v,k);
			System.out.println("SORTED VECTOR");
			Vector.print(v);
		} 


}
