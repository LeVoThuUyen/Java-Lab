import javax.swing.JOptionPane;

public class ChoosingOption {

	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null,
				"Do you want to change to the first class ticket?");
		
		JOptionPane.showMessageDialog(null, "You've chosen: "
				+ (option==JOptionPane.YES_OPTION?"Yes":"No"));
		
		/* "Cancel" being chosen means user chose "No" */
		
		
		/* display only "yes" and "no" */
		
//		int option = JOptionPane.showConfirmDialog(null,
//				"Do you want to change to the first class ticket?",
//				"Choose ticket",
//				JOptionPane.YES_NO_OPTION);
//		
//		JOptionPane.showMessageDialog(null, "You've chosen: "
//				+ (option==JOptionPane.YES_OPTION?"Yes":"No"));
		
		
		/* display "I do" and "I don't" */
	
//		Object[] options = {"I do", "I don't"};
//		int option = JOptionPane.showOptionDialog(null,
//				"Do you want to change to the first class ticket?",
//				"Choose ticket",
//				JOptionPane.DEFAULT_OPTION,
//				JOptionPane.PLAIN_MESSAGE,
//				null,
//				options,
//				options[0]);
//		
//		JOptionPane.showMessageDialog(null, "You've chosen: "
//				+ (option == 0 ? "Yes":"No"));
				
		System.exit(0);
	}

}
