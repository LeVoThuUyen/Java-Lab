import java.util.Scanner;
public class MatrixAddition {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int rows, columns;
		
		// Enter matrix size
		System.out.printf("*Enter matrix size:%n%n");
		do {
			System.out.print("Number of rows: ");
			rows = input.nextInt();
		}while(rows < 1);
		
		do {
			System.out.print("Number of columns: ");
			columns = input.nextInt();
		}while(columns < 1);
		
		// Enter value
		double[][][] matrix = new double[2][rows][columns];
		
		System.out.printf("%n*Enter value:%n%n");
		for(int k = 0; k < 2; k++) {
			System.out.printf("Matrix %d%n", k + 1);
			for(int i = 0; i < rows; i++) {
				System.out.printf("  Row %d%n", i + 1);
				for(int j = 0; j < columns; j++) {
					System.out.printf("    Column %d: ", j + 1);
					matrix[k][i][j] = input.nextDouble();
				}
			}
		}
		
		// Addition
		System.out.printf("%n*Result:%n");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				double result = matrix[0][i][j] + matrix[1][i][j];
				System.out.printf("%.2f ", result);
			}
			System.out.println("");
		}
		
		input.close();
	}

}
