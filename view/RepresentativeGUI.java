package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class RepresentativeGUI extends JFrame {
    private JLabel titleLabel, serviceLabel, resolvedLabel, outstandingLabel;
    private JTable serviceTable, complaintsTable;
    private DefaultTableModel serviceTableModel, complaintsTableModel;
    private JScrollPane serviceScrollPane, complaintsScrollPane;

    public RepresentativeGUI() {
        super("Customer Service Representative Dashboard");
        initUI();
        addComponents();
    }

    private void initUI() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        titleLabel = new JLabel("Customer Service Representative", SwingConstants.CENTER);
        titleLabel.setBounds(20, 20, 740, 30);

        serviceLabel = new JLabel("Services", SwingConstants.LEFT);
        serviceLabel.setBounds(20, 70, 100, 30);

        resolvedLabel = new JLabel("Resolved Complaints", SwingConstants.CENTER);
        resolvedLabel.setBounds(20, 110, 200, 30);

        outstandingLabel = new JLabel("Outstanding Complaints", SwingConstants.CENTER);
        outstandingLabel.setBounds(230, 110, 200, 30);

        serviceTableModel = new DefaultTableModel();
        serviceTableModel.addColumn("Service");
        serviceTableModel.addColumn("Resolved");
        serviceTableModel.addColumn("Outstanding");

        // Placeholder data for services, resolved, and outstanding complaints
        Vector<String> serviceData1 = new Vector<>();
        serviceData1.add("Broadband");
        serviceData1.add("10");
        serviceData1.add("5");

        Vector<String> serviceData2 = new Vector<>();
        serviceData2.add("Cable TV");
        serviceData2.add("5");
        serviceData2.add("3");

        serviceTableModel.addRow(serviceData1);
        serviceTableModel.addRow(serviceData2);

        serviceTable = new JTable(serviceTableModel);
        serviceScrollPane = new JScrollPane(serviceTable);
        serviceScrollPane.setBounds(20, 150, 200, 100);

        complaintsTableModel = new DefaultTableModel();
        complaintsTableModel.addColumn("Customer ID");
        complaintsTableModel.addColumn("Name");
        complaintsTableModel.addColumn("Issue");

        // Placeholder data for customer complaints
        Vector<String> complaintData1 = new Vector<>();
        complaintData1.add("C001");
        complaintData1.add("Mikhail Webb");
        complaintData1.add("Broadband issue: Slow internet");
        complaintData1.add("2023-07-25");

        Vector<String> complaintData2 = new Vector<>();
        complaintData2.add("C002");
        complaintData2.add("Daniel Eccleston");
        complaintData2.add("Cable TV issue: No signal error");
        complaintData2.add("2023-07-27");
        
        Vector<String> complaintData3 = new Vector<>();
        complaintData3.add("C003");
        complaintData3.add("Winston Mcleod");
        complaintData3.add("Login Issues: No access error");
        complaintData3.add("2023-08-12");
        
        Vector<String> complaintData4 = new Vector<>();
        complaintData4.add("C004");
        complaintData4.add("Andre Grant");
        complaintData4.add("Installation issue: Input not found error");
        complaintData4.add("2023-10-27");
        
        Vector<String> complaintData5 = new Vector<>();
        complaintData5.add("C005");
        complaintData5.add("Abbygaye Stweart");
        complaintData5.add("Connectivity issues: No internet");
        complaintData5.add("2023-09-24");

        complaintsTableModel.addRow(complaintData1);
        complaintsTableModel.addRow(complaintData2);
        complaintsTableModel.addRow(complaintData3);
        complaintsTableModel.addRow(complaintData4);
        complaintsTableModel.addRow(complaintData5);

        complaintsTable = new JTable(complaintsTableModel);
        complaintsScrollPane = new JScrollPane(complaintsTable);
        complaintsScrollPane.setBounds(20, 280, 500, 200);
    }

    private void addComponents() {
        add(titleLabel);
        add(serviceLabel);
        add(resolvedLabel);
        add(outstandingLabel);
        add(serviceScrollPane);
        add(complaintsScrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	RepresentativeGUI gui = new RepresentativeGUI();
            gui.setVisible(true);
        });
    }
}
