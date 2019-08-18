package hust.soict.ictglobal.garbage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NoGarbage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer s = new StringBuffer("");
		try {
			BufferedReader reader = new BufferedReader(new FileReader("t8_shakespeare.txt"));
			int c;
			
			try {
				while((c = reader.read()) != -1) {
					s.append((char)c);
					System.out.println(s.length());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
