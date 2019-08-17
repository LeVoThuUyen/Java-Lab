import java.util.Arrays;

public class ArraySorting {

	public static void main(String[] args) {
		int[] my_array1 = {1789, 2035, 1899, 1456, 2013};
		int sum = 0;
		double average;
		
		System.out.println("Original:");
		for(int i = 0; i < my_array1.length; i++) {
			System.out.printf("%d ", my_array1[i]);
			sum = sum + my_array1[i];
		}
		System.out.println("");
		
		Arrays.sort(my_array1);
		
		System.out.println("Sorted:");
		for(int i = 0; i < my_array1.length; i++) {
			System.out.printf("%d ", my_array1[i]);
		}
		System.out.println("");
		
		// sum
		System.out.printf("Sum: %d%n", sum);
		
		// average
		average = ((double) sum) / my_array1.length;
		System.out.printf("Average: %.2f%n", average);
	}

}
