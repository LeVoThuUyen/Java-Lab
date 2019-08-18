package hust.soict.ictglobal.lab01;

import javax.swing.JOptionPane;

public class HelloWorld {

	public static void main(String args[]){
		// System.out.println("HelloWorld!");
		String result, result2;
		int int1, int2;
		result = JOptionPane.showInputDialog("Nhap so 1: ");
		// JOptionPane.showMessageDialog(null, "Xin chao ban " + result + "!");
		int1 = Integer.parseInt(result);
		result2 = JOptionPane.showInputDialog("Nhap so 2: ");
		int2 = Integer.parseInt(result2);

		int sum = int1 + int2;
		JOptionPane.showMessageDialog(null, "Sum " + sum);

		System.exit(0);
	}

}
