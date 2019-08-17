import java.util.Scanner;

public class TriangleDrawing {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, i, j, k;
		
		System.out.println("Enter n:");
		n = input.nextInt();
		
		for(i = 1; i <= n; i++) {
			for(j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for(k = 1; k <= i * 2 - 1; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		input.close();
	}

}
