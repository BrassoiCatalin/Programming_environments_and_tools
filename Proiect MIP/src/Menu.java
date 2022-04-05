import Models.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Vector;

public class Menu {

    private static JFrame frame;
    private static JTable table;
    private static JMenuBar menuBar = new JMenuBar();

    private static JFrame frameMore;
    private static JTable tableMore;
    private static DefaultTableModel modelMore;

    Menu() {
        Run();
    }

    private static DefaultTableModel model = new DefaultTableModel(0, 9) {
        public boolean isCellEditable(int row, int column) {
            return false;//This causes all cells to be not editable; this is for the first page
        }
    };

    public static void createFrame() {

        frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setJMenuBar(menuBar);

        frame.add(new JScrollPane(table));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public static void createMenuForAddEmployee() {

        JMenu add = new JMenu("Add");
        menuBar.add(add);

        JMenuItem newEmployee = new JMenuItem("New Employee");
        add.add(newEmployee);

        class addEmployee implements ActionListener {

            public void actionPerformed(ActionEvent ae) {

                AddEmployee addEmployee = new AddEmployee();
            }
        }

        newEmployee.addActionListener(new addEmployee());
    }

    public static void refreshTable() {

        model.setRowCount(0);
        model.fireTableDataChanged();

        Connect.employeeListForTable(model);
    }

    public static void createMenuForRefreshTable() {
        JMenu refresh = new JMenu("Refresh");
        menuBar.add(refresh);
        JMenuItem refreshTable = new JMenuItem("Refresh Table");
        refresh.add(refreshTable);

        class refreshTable implements ActionListener {
            public void actionPerformed(ActionEvent ae) {
                refreshTable();
            }
        }

        refreshTable.addActionListener(new refreshTable());
    }

    public static void createMenuForAbout() {
        JMenu about = new JMenu("About...");
        menuBar.add(about);

        JMenuItem aboutProject = new JMenuItem("This Project");
        about.add(aboutProject);

        class about implements ActionListener {
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Project Made By: Catalin Brassoi\n" +
                        "Coordinating Teachers: Duca Delia & Bocu Razvan");
            }
        }

        aboutProject.addActionListener(new about());
    }

    public static void createMenuForMoreOptionns() {
        JMenu more = new JMenu("More");
        menuBar.add(more);

        JMenuItem moreOptions = new JMenuItem("More Options");
        more.add(moreOptions);

        class moreOptions implements ActionListener {
            public void actionPerformed(ActionEvent ae) {
                frameMore = new JFrame("More");
                tableMore = new JTable();

                modelMore = new DefaultTableModel(0, 9);

                String columns[] = {//table titles
                        "Name", "Father's Name", "Age", "Date Of Birth", "Address", "Phone", "Email", "Education", "Post"
                };
                modelMore.setColumnIdentifiers(columns);

                tableMore = new JTable(modelMore);

                Connect.employeeListForTable(modelMore);

                creatingPopups();

                frameMore.add(new JScrollPane(tableMore));
                frameMore.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frameMore.setVisible(true);
            }
        }
        moreOptions.addActionListener(new moreOptions());
    }

    public static void initializeTable() {

        String columns[] = {//table titles
                "Name", "Father's Name", "Age", "Date Of Birth", "Address", "Phone", "Email", "Education", "Post"
        };

        model.setColumnIdentifiers(columns);

        table = new JTable(model);

        Connect.employeeListForTable(model);
    }

    public static void creatingPopups() {

        JPopupMenu popupMenu = new JPopupMenu();

        ActionListener actionListener1 = new RemoveActionListener();
        JMenuItem menuItemRemove = new JMenuItem("Remove Current Row");
        menuItemRemove.addActionListener(actionListener1);
        popupMenu.add(menuItemRemove);

        ActionListener actionListener2 = new UpdateActionListener();
        JMenuItem menuItemUpdate = new JMenuItem("Update Current Row");
        menuItemUpdate.addActionListener(actionListener2);
        popupMenu.add(menuItemUpdate);

        tableMore.setComponentPopupMenu(popupMenu);

    }

    static class RemoveActionListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            int selectedRow = tableMore.getSelectedRow();

            if (selectedRow >= 0) {

                Employee employee = new Employee();

                Object nameObject = modelMore.getValueAt(selectedRow, 0);
                employee.setName(nameObject.toString());

                Connect.removeEmployee(employee.getName(), employee);

                modelMore.removeRow(selectedRow);
                JOptionPane.showMessageDialog(null, "Employee Successfully Removed");
            } else {
                JOptionPane.showMessageDialog(null, "Could Not Remove Employee");
            }
        }
    }

    static class UpdateActionListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            int selectedRow = tableMore.getSelectedRow();

            if (selectedRow >= 0) {
                Employee employee = new Employee();

                Vector lineVector = (Vector) modelMore.getDataVector().elementAt(tableMore.getSelectedRow());

                employee.setName(lineVector.elementAt(0).toString());
                employee.setFatherName(lineVector.elementAt(1).toString());
                employee.setAge(lineVector.elementAt(2).toString());
                employee.setDOB(lineVector.elementAt(3).toString());
                employee.setAddress(lineVector.elementAt(4).toString());
                employee.setPhone(lineVector.elementAt(5).toString());
                employee.setEmail(lineVector.elementAt(6).toString());
                employee.setEducation(lineVector.elementAt(7).toString());
                employee.setPost(lineVector.elementAt(8).toString());

                try {
                    Connect.updateEmployee(employee);
                    JOptionPane.showMessageDialog(null, "Employee Successfully Updated");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Could Not Update Employee");
            }
        }
    }

    public static void Run() {

        createMenuForAddEmployee();
        createMenuForRefreshTable();
        createMenuForMoreOptionns();
        createMenuForAbout();

        initializeTable();

        createFrame();
    }
}

