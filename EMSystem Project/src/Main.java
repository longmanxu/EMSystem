import java.io.*;

/**
 *
 * @author longman and tommy
 * @version Date: 2018-05-02
 */
public class Main extends MainJFrame{
	
	private EmployeeHashTable employeeTable;
	private BufferedWriter saveWriter;
	private BufferedReader saveReader;
	private static BufferedWriter settingsWriter;
	private static BufferedReader settingsReader;
	
	
	
	public Main() {
		super();
		employeeTable = new EmployeeHashTable(10);
		// TODO: get stuff done
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			settingsWriter = new BufferedWriter(new FileWriter("settings.cfg"));
			settingsReader = new BufferedReader(new FileReader("settings.cfg"));
		} catch (IOException e) {
			System.err.println(e);
		} 
		
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
	
}
