
import java.io.*;
import java.util.Properties;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author longm
 */
public class MainJFrame extends javax.swing.JFrame {
	// initialize tables and employees
	private static EmployeeHashTable employeeTable;
	
	// initizlize a bunch of IO stuff
	private BufferedWriter saveWriter;  // io for employee info
	private BufferedReader saveReader;
	private static BufferedWriter settingsWriter;  // io for setting info
	private static BufferedReader settingsReader;
	
	// settings stuffs
	private static Properties defSettings = new Properties();
	private static Properties settings;
	
	/**
	 * Creates new form MainJFrame
	 */
	public MainJFrame() {
		initComponents();
		jComboBox1.setSelectedItem(settings.getProperty("Look and Feel"));
		initEmployeeJTable(employeeTable, jTable1);
		
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		
		// set the settings properties
		try {
			try {
				employeeTable = EmployeeHashTable.open("saved_employees");
			} catch (Exception e) {
				System.err.println("xD: " + e.toString());
				System.err.println("creating new table");
				employeeTable = new EmployeeHashTable(10);
			}
			
			settingsWriter = new BufferedWriter(new FileWriter("settings.cfg", true));
			settingsReader = new BufferedReader(new FileReader("settings.cfg"));
			
			defSettings.setProperty("Look and Feel", "Windows");
		
			settings = new Properties(defSettings);
			settings.load(settingsReader);
			
			// close the settings reader, since it is unneeded
			if (settingsReader != null) {
				settingsReader.close();
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		
		/* Set the look and feel from the settings*/
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if (settings.getProperty("Look and Feel").equals(info.getName())) {
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
				new MainJFrame().setVisible(true);
			}
		});
	}
	
	private static void initEmployeeJTable(EmployeeHashTable hashTable, javax.swing.JTable table) {
		DefaultTableModel employeeTableModel = (DefaultTableModel) table.getModel();
		ArrayList<EmployeeInfo> employeeList = hashTable.returnAllEmployees();
		for (EmployeeInfo employee : employeeList) {
			Object[] rowData = {
				employee.getEmployeeNumber(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getWorkLocation(),
				employee.getClass()
			};
			employeeTableModel.addRow(rowData);
		}
		table.setModel(employeeTableModel);
	}
	
	private static void addToEmployeeJTable(EmployeeInfo newEmployee, javax.swing.JTable table) {
		DefaultTableModel employeeTableModel = (DefaultTableModel) table.getModel();
		Object[] rowData = {
			newEmployee.getEmployeeNumber(),
			newEmployee.getFirstName(),
			newEmployee.getLastName(),
			newEmployee.getWorkLocation(),
			newEmployee.getClass()
		};
		employeeTableModel.addRow(rowData);
		table.setModel(employeeTableModel);
	}
	
	private void changeSelection(int type) {
		if (type == 0) { // full time
			labelFull0.setVisible(true);
			fieldSalary.setVisible(true);
			
			labelPart0.setVisible(false);
			fieldHourWage.setVisible(false);
			labelPart1.setVisible(false);
			fieldHourWeek.setVisible(false);
			labelPart2.setVisible(false);
			fieldWeekYear.setVisible(false);
		}
		else if (type == 1) { // part time
			labelFull0.setVisible(false);
			fieldSalary.setVisible(false);
			
			labelPart0.setVisible(true);
			fieldHourWage.setVisible(true);
			labelPart1.setVisible(true);
			fieldHourWeek.setVisible(true);
			labelPart2.setVisible(true);
			fieldWeekYear.setVisible(true);
		}
	}
	
	public void getAngryAtUser(String msg) {
		errorPopup.setVisible(true);
		if(msg.isEmpty()) {
			errorMsgLabel.setText("Error");
		}
		else{
			errorMsgLabel.setText(msg);
		}
	}
	
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addPopup = new javax.swing.JDialog();
        backButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dropDownType = new javax.swing.JComboBox<>();
        fieldLName = new javax.swing.JTextField();
        fieldFName = new javax.swing.JTextField();
        fieldNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dropDownSexes = new javax.swing.JComboBox<>();
        addTheEmployee = new javax.swing.JButton();
        labelFull0 = new javax.swing.JLabel();
        labelRate = new javax.swing.JLabel();
        fieldSalary = new javax.swing.JTextField();
        fieldDedRate = new javax.swing.JTextField();
        labelPart0 = new javax.swing.JLabel();
        labelPart1 = new javax.swing.JLabel();
        labelPart2 = new javax.swing.JLabel();
        fieldHourWage = new javax.swing.JTextField();
        fieldHourWeek = new javax.swing.JTextField();
        fieldWeekYear = new javax.swing.JTextField();
        dropDownLocation = new javax.swing.JComboBox<>();
        errorPopup = new javax.swing.JDialog();
        errorMsgLabel = new javax.swing.JLabel();
        jDialog1 = new javax.swing.JDialog();
        jFileChooser1 = new javax.swing.JFileChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        ManagerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        delButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        filePanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        settingsPanel = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        helpPanel = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        addPopup.setTitle("Add an employee");
        addPopup.setMinimumSize(new java.awt.Dimension(600, 400));
        addPopup.setResizable(false);

        backButton.setText("cancel");
        backButton.setToolTipText("");
        backButton.setMaximumSize(new java.awt.Dimension(70, 25));
        backButton.setMinimumSize(new java.awt.Dimension(70, 25));
        backButton.setPreferredSize(new java.awt.Dimension(70, 25));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Emp. #");

        jLabel3.setText("First name");

        jLabel4.setText("Last name");

        jLabel5.setText("Location");

        jLabel7.setText("Emp. Type");

        dropDownType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full time", "Part time" }));
        dropDownType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropDownTypeActionPerformed(evt);
            }
        });

        jLabel8.setText("Sex");

        dropDownSexes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        addTheEmployee.setText("add");
        addTheEmployee.setToolTipText("");
        addTheEmployee.setMaximumSize(new java.awt.Dimension(70, 25));
        addTheEmployee.setMinimumSize(new java.awt.Dimension(70, 25));
        addTheEmployee.setPreferredSize(new java.awt.Dimension(70, 25));
        addTheEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTheEmployeeActionPerformed(evt);
            }
        });

        labelFull0.setText("Salary");

        labelRate.setText("Deductions rate");

        labelPart0.setText("Hourly Wage");

        labelPart1.setText("Hours per week");

        labelPart2.setText("Weeks per year");

        dropDownLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "loc a", "loc b", "loc c" }));

        javax.swing.GroupLayout addPopupLayout = new javax.swing.GroupLayout(addPopup.getContentPane());
        addPopup.getContentPane().setLayout(addPopupLayout);
        addPopupLayout.setHorizontalGroup(
            addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPopupLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldNumber)
                    .addComponent(fieldFName)
                    .addComponent(fieldLName)
                    .addComponent(dropDownSexes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dropDownType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dropDownLocation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPopupLayout.createSequentialGroup()
                        .addComponent(labelFull0)
                        .addGap(18, 18, 18)
                        .addComponent(fieldSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPopupLayout.createSequentialGroup()
                        .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPart0, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelPart1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelPart2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldWeekYear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fieldHourWage, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(fieldHourWeek))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(addPopupLayout.createSequentialGroup()
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addTheEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPopupLayout.createSequentialGroup()
                            .addComponent(labelRate)
                            .addGap(18, 18, 18)
                            .addComponent(fieldDedRate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(111, 111, 111))
        );
        addPopupLayout.setVerticalGroup(
            addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPopupLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFull0, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPopupLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(25, 25, 25)
                        .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(dropDownLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPopupLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelPart0, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldHourWage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPart1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldHourWeek, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldWeekYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPart2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)))
                .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPopupLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addTheEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addPopupLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dropDownType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(labelRate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldDedRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(addPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dropDownSexes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(29, 29, 29))
        );

        errorPopup.setTitle("ERROR");
        errorPopup.setMinimumSize(new java.awt.Dimension(300, 150));
        errorPopup.setSize(new java.awt.Dimension(300, 150));

        errorMsgLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        errorMsgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsPackage/error.png"))); // NOI18N
        errorMsgLabel.setText("Enter ur error msg here");
        errorMsgLabel.setMaximumSize(new java.awt.Dimension(300, 150));
        errorMsgLabel.setMinimumSize(new java.awt.Dimension(300, 150));
        errorMsgLabel.setName(""); // NOI18N
        errorMsgLabel.setPreferredSize(new java.awt.Dimension(300, 150));

        javax.swing.GroupLayout errorPopupLayout = new javax.swing.GroupLayout(errorPopup.getContentPane());
        errorPopup.getContentPane().setLayout(errorPopupLayout);
        errorPopupLayout.setHorizontalGroup(
            errorPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, errorPopupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorMsgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        errorPopupLayout.setVerticalGroup(
            errorPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorPopupLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(errorMsgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Management System");
        setMinimumSize(new java.awt.Dimension(640, 480));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(800, 600));

        ManagerPanel.setPreferredSize(new java.awt.Dimension(700, 600));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp #", "First", "Last", "Location", "Emp. Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {""},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Attribute"
            }
        ));
        jTable2.setColumnSelectionAllowed(true);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        delButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsPackage/trash.png"))); // NOI18N
        delButton.setText("remove");
        delButton.setActionCommand("delButton");

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsPackage/add.png"))); // NOI18N
        addButton.setText("add");
        addButton.setActionCommand("addButton");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ManagerPanelLayout = new javax.swing.GroupLayout(ManagerPanel);
        ManagerPanel.setLayout(ManagerPanelLayout);
        ManagerPanelLayout.setHorizontalGroup(
            ManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManagerPanelLayout.createSequentialGroup()
                .addGroup(ManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManagerPanelLayout.createSequentialGroup()
                        .addComponent(delButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ManagerPanelLayout.setVerticalGroup(
            ManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManagerPanelLayout.createSequentialGroup()
                .addGroup(ManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManagerPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton)
                            .addComponent(delButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("<html>Manage<br />& Add</html>", new javax.swing.ImageIcon(getClass().getResource("/iconsPackage/employee.png")), ManagerPanel, "cats"); // NOI18N

        filePanel.setPreferredSize(new java.awt.Dimension(700, 600));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsPackage/newfolder.png"))); // NOI18N
        jButton1.setText("buttonNew");
        jButton1.setMaximumSize(new java.awt.Dimension(187, 92));
        jButton1.setMinimumSize(new java.awt.Dimension(187, 92));
        jButton1.setName(""); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsPackage/open.png"))); // NOI18N
        jButton2.setText("buttonOpen");
        jButton2.setMaximumSize(new java.awt.Dimension(187, 92));
        jButton2.setMinimumSize(new java.awt.Dimension(187, 92));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsPackage/save.png"))); // NOI18N
        jButton3.setText("buttonSave");
        jButton3.setMaximumSize(new java.awt.Dimension(187, 92));
        jButton3.setMinimumSize(new java.awt.Dimension(187, 92));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsPackage/saveAs.png"))); // NOI18N
        jButton4.setText("buttonSaveAs");

        javax.swing.GroupLayout filePanelLayout = new javax.swing.GroupLayout(filePanel);
        filePanel.setLayout(filePanelLayout);
        filePanelLayout.setHorizontalGroup(
            filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filePanelLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(138, 138, 138))
        );
        filePanelLayout.setVerticalGroup(
            filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filePanelLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(200, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("File", new javax.swing.ImageIcon(getClass().getResource("/iconsPackage/file.png")), filePanel); // NOI18N

        settingsPanel.setPreferredSize(new java.awt.Dimension(700, 600));

        jComboBox1.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Windows", "Windows Classic", "Nimbus", "Metal", "Dark Metal", "Dark Nimbus" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("Look and Feel (requires restart):");

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(484, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Settings", new javax.swing.ImageIcon(getClass().getResource("/iconsPackage/settings.png")), settingsPanel); // NOI18N

        helpPanel.setPreferredSize(new java.awt.Dimension(700, 600));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsPackage/clippy.jpg"))); // NOI18N
        jButton5.setToolTipText("Clippy will solve all your problems!");

        jLabel6.setText("Made by Longman Xu and Tommy Huang");

        javax.swing.GroupLayout helpPanelLayout = new javax.swing.GroupLayout(helpPanel);
        helpPanel.setLayout(helpPanelLayout);
        helpPanelLayout.setHorizontalGroup(
            helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpPanelLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButton5)
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, helpPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(25, 25, 25))
        );
        helpPanelLayout.setVerticalGroup(
            helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, helpPanelLayout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabel6)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("<html>Help &<br />About</html>", new javax.swing.ImageIcon(getClass().getResource("/iconsPackage/help.png")), helpPanel); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
		// change the default theme on next startup
		JComboBox cb = (JComboBox) evt.getSource();
		settings.setProperty("Look and Feel", (String)cb.getSelectedItem());
		try{
			settings.store(settingsWriter, "");
		} catch (IOException e){
			System.err.println(e);
		}
		
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       // close the readers and writers
		try {
			employeeTable.save("saved_employees");
			
			if (saveWriter != null) saveWriter.close();
			if (saveReader != null) saveReader.close();
			if (settingsWriter != null) settingsWriter.close();
			if (settingsReader != null) settingsReader.close();
			System.out.println("Closed all IO");
		} catch (IOException e){
			System.err.println(e);
		}
		// save the employees
		try {
			employeeTable.save("saved_employees");
		} catch (IOException e) {
			System.err.println(e);
		}
    }//GEN-LAST:event_formWindowClosing

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:this.setVisible(false);
		// TODO: Toolkit.getDefaultToolkit().beep();
		addPopup.setVisible(true);
		if (dropDownType.getSelectedItem().equals("Full time")) {
			changeSelection(0);
        }
		else if (dropDownType.getSelectedItem().equals("Part time")) {
			changeSelection(1);
		}
		
    }//GEN-LAST:event_addButtonActionPerformed
	
    private void addTheEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTheEmployeeActionPerformed
        // TODO add your handling code here:
        // check to make sure none of the text fields are empty
        // Update this if everytime we add/del a field
        if (fieldNumber.getText().isEmpty() || fieldFName.getText().isEmpty() || fieldLName.getText().isEmpty()){
			getAngryAtUser("Some of the fields are empty!!! :(");
        }
        else if(dropDownType.getSelectedItem().equals("Full time") && fieldNumber.getText().isEmpty() == false) {
            // do full time stuff
			FullTimeEmployee temp = new FullTimeEmployee(Integer.parseInt(fieldNumber.getText()), fieldFName.getText(), fieldLName.getText(),
					dropDownSexes.getSelectedIndex(), dropDownLocation.getSelectedIndex(), Double.parseDouble(fieldDedRate.getText()), Double.parseDouble(fieldSalary.getText()));
			if (employeeTable.add(temp)) {
				addToEmployeeJTable(temp, jTable1);
			}
			else {
				getAngryAtUser("Duplicate employee number!");
			}
			addPopup.setVisible(false);
			clearFields();
			
        }
        else if (dropDownType.getSelectedItem().equals("Part time") && fieldHourWage.getText().isEmpty() == false && fieldHourWeek.getText().isEmpty() == false && fieldWeekYear.getText().isEmpty() == false) {
            // do part time stuff
			PartTimeEmployee temp = new PartTimeEmployee(Integer.parseInt(fieldNumber.getText()), fieldFName.getText(), fieldLName.getText(),
					dropDownSexes.getSelectedIndex(), dropDownLocation.getSelectedIndex(), Double.parseDouble(fieldDedRate.getText()), Double.parseDouble(fieldHourWage.getText()), Double.parseDouble(fieldHourWeek.getText()), Double.parseDouble(fieldWeekYear.getText()));
			if (employeeTable.add(temp)) {
				addToEmployeeJTable(temp, jTable1);
			}
			else {
				getAngryAtUser("Duplicate employee number!");
			}
			addPopup.setVisible(false);
			clearFields();
			
        }
    }//GEN-LAST:event_addTheEmployeeActionPerformed
	// clears all the text in the "add" popup menu
	private void clearFields() {
		// clear all text fields
		fieldNumber.setText("");
		fieldFName.setText("");
		fieldLName.setText("");
		fieldDedRate.setText("");
		fieldHourWage.setText("");
		fieldHourWeek.setText("");
		fieldWeekYear.setText("");
		fieldSalary.setText("");
		// reset all drop down menus
		dropDownLocation.setSelectedIndex(0);
		dropDownSexes.setSelectedIndex(0);
		dropDownLocation.setSelectedIndex(0);
		
	}
	
    private void dropDownTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropDownTypeActionPerformed
        // TODO add your handling code here:
        if (dropDownType.getSelectedItem().equals("Full time")) {
			changeSelection(0);
        }
		else if (dropDownType.getSelectedItem().equals("Part time")) {
			changeSelection(1);
		}
    }//GEN-LAST:event_dropDownTypeActionPerformed
	
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.setFocusableWindowState(true);
        addPopup.setVisible(false);

    }//GEN-LAST:event_backButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
		if (jTable1.getRowSelectionAllowed()) {
			int selRow = jTable1.getSelectedRow();
			DefaultTableModel employeeTableModel = (DefaultTableModel) jTable1.getModel();
			int selectedEmpNumber = (int) employeeTableModel.getValueAt(selRow, 0)
			;
			EmployeeInfo selectedEmployee = employeeTable.find(selectedEmpNumber);
			System.out.println(selectedEmployee.getFirstName());
			
			DefaultTableModel attributeTableModel = (DefaultTableModel) jTable2.getModel();
			ArrayList<EmployeeInfo> employeeList = employeeTable.returnAllEmployees();
			
			attributeTableModel.setColumnCount(1);
			// run through every employee in employeeList
				// add the part time employee info as a column
				if (selectedEmployee instanceof PartTimeEmployee) {
					Object[] info = {
						selectedEmployee.getEmployeeNumber(),
						selectedEmployee.getFirstName(),
						selectedEmployee.getLastName(),
						selectedEmployee.getWorkLocation(),
						selectedEmployee.getClass(),
						((PartTimeEmployee) selectedEmployee).getHourlyWage(),
						((PartTimeEmployee) selectedEmployee).getHoursPerWeek(),
						((PartTimeEmployee) selectedEmployee).getWeeksPerYear()
					};
					attributeTableModel.addColumn("information", info);
				}
				else if (selectedEmployee instanceof FullTimeEmployee) {
					Object[] info = {
						selectedEmployee.getEmployeeNumber(),
						selectedEmployee.getFirstName(),
						selectedEmployee.getLastName(),
						selectedEmployee.getWorkLocation(),
						selectedEmployee.getClass(),
						((FullTimeEmployee) selectedEmployee).getYearlySalary()
					};
					attributeTableModel.addColumn("information", info	);
				}
			
			// int colIndex = jTable1.getSelectedColumn();
		}
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
		jDialog1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ManagerPanel;
    private javax.swing.JButton addButton;
    private javax.swing.JDialog addPopup;
    private javax.swing.JButton addTheEmployee;
    private javax.swing.JButton backButton;
    private javax.swing.JButton delButton;
    private javax.swing.JComboBox<String> dropDownLocation;
    private javax.swing.JComboBox<String> dropDownSexes;
    private javax.swing.JComboBox<String> dropDownType;
    private javax.swing.JLabel errorMsgLabel;
    private javax.swing.JDialog errorPopup;
    private javax.swing.JTextField fieldDedRate;
    private javax.swing.JTextField fieldFName;
    private javax.swing.JTextField fieldHourWage;
    private javax.swing.JTextField fieldHourWeek;
    private javax.swing.JTextField fieldLName;
    private javax.swing.JTextField fieldNumber;
    private javax.swing.JTextField fieldSalary;
    private javax.swing.JTextField fieldWeekYear;
    private javax.swing.JPanel filePanel;
    private javax.swing.JPanel helpPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel labelFull0;
    private javax.swing.JLabel labelPart0;
    private javax.swing.JLabel labelPart1;
    private javax.swing.JLabel labelPart2;
    private javax.swing.JLabel labelRate;
    private javax.swing.JPanel settingsPanel;
    // End of variables declaration//GEN-END:variables
}
