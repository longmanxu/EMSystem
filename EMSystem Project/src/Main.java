import java.io.*;
import java.util.Properties;
import javax.swing.*;

/**
 *
 * @author longman and tommy
 * @version Date: 2018-05-02
 */
public class Main extends MainJFrame{
	// initizlize a bunch of IO stuff
	private EmployeeHashTable employeeTable;
	private BufferedWriter saveWriter;  // io for employee info
	private BufferedReader saveReader;
	private static BufferedWriter settingsWriter;  // io for setting info
	private static BufferedReader settingsReader;
	
	// settings stuffs
	private static Properties defSettingsProp = new Properties();
	private static Properties settingsProp;
	
	public Main() {
		super();
		employeeTable = new EmployeeHashTable(10);
		// TODO: get stuff done
	}

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
		// change the default theme on next startup
		System.out.println("If you are seeing this, it's working");
		JComboBox cb = (JComboBox) evt.getSource();
		settingsProp.setProperty("Look and Feel", (String)cb.getSelectedItem());
		settingsProp.list(System.out);
		try{
			settingsProp.store(settingsWriter, "pls work");
		} catch (IOException e){
			System.err.println(e);
		}
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		
		// set the settings properties
		try {
			settingsWriter = new BufferedWriter(new FileWriter("settings.cfg"));
			settingsReader = new BufferedReader(new FileReader("settings.cfg"));
			
			defSettingsProp.setProperty("Look and Feel", "Windows");
		
			settingsProp = new Properties(defSettingsProp);
			settingsProp.load(settingsReader);
			settingsProp.list(System.out);
			System.out.println("totally working");
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
				if (settingsProp.getProperty("Look and Feel").equals(info.getName())) {
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
