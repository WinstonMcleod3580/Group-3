package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import model.Livechat;

public class RepresentativeDashboard extends JFrame {
    private JButton viewServicesButton, viewComplaintsButton, liveChatButton;
    private DefaultTableModel serviceTableModel, complaintsTableModel;

    public RepresentativeDashboard() {
        super("Customer Service Representative Dashboard");
        initUI();
        addComponents();
    }

    private void initUI() {
        setSize(800, 500); // Resize window to be 2.5 times bigger
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.WHITE); // Set background color to white

        // Placeholder data for services, resolved, and outstanding complaints
        Vector<String> serviceData1 = new Vector<>();
        serviceData1.add("Broadband");
        serviceData1.add("10");
        serviceData1.add("5");

        Vector<String> serviceData2 = new Vector<>();
        serviceData2.add("Cable TV");
        serviceData2.add("5");
        serviceData2.add("3");
        
        Vector<String> serviceData3 = new Vector<>();
        serviceData3.add("Login Issues");
        serviceData3.add("5");
        serviceData3.add("3");
        
        Vector<String> serviceData4 = new Vector<>();
        serviceData3.add("Installation issue");
        serviceData3.add("5");
        serviceData3.add("3");

        serviceTableModel = new DefaultTableModel();
        serviceTableModel.addColumn("Service");
        serviceTableModel.addColumn("Resolved");
        serviceTableModel.addColumn("Outstanding");
        serviceTableModel.addRow(serviceData1);
        serviceTableModel.addRow(serviceData2);

        // Placeholder data for customer complaints
        Vector<String> complaintData1 = new Vector<>();
        complaintData1.add("C001");
        complaintData1.add("Mikhail Webb");
        complaintData1.add("Low: Broadband issue: Slow internet");
        complaintData1.add("2023-07-25");

        Vector<String> complaintData2 = new Vector<>();
        complaintData2.add("C002");
        complaintData2.add("Daniel Eccleston");
        complaintData2.add("Medium: Cable TV issue: No signal error");
        complaintData2.add("2023-07-27");
        
        Vector<String> complaintData3 = new Vector<>();
        complaintData3.add("C003");
        complaintData3.add("Winston Mcleod");
        complaintData3.add("Medium :Login Issues: No access error");
        complaintData3.add("2023-08-12");
        
        Vector<String> complaintData4 = new Vector<>();
        complaintData4.add("C004");
        complaintData4.add("Andre Grant");
        complaintData4.add("Medium: Installation issue: Input not found error");
        complaintData4.add("2023-10-27");
        
        Vector<String> complaintData5 = new Vector<>();
        complaintData5.add("C005");
        complaintData5.add("Abbygaye Stweart");
        complaintData5.add("Low: Connectivity issues: No internet");
        complaintData5.add("2023-09-24");

        complaintsTableModel = new DefaultTableModel();
        complaintsTableModel.addColumn("Customer ID");
        complaintsTableModel.addColumn("Name");
        complaintsTableModel.addColumn("Issue");
        complaintsTableModel.addColumn("Date");
        complaintsTableModel.addRow(complaintData1);
        complaintsTableModel.addRow(complaintData2);
        complaintsTableModel.addRow(complaintData3);
        complaintsTableModel.addRow(complaintData4);
        complaintsTableModel.addRow(complaintData5);
    }

    private void addComponents() {
        viewServicesButton = new JButton("View List of Services");
        viewServicesButton.setBackground(Color.CYAN); // Set background color to sky blue
        viewServicesButton.setPreferredSize(new Dimension(350, 50)); // Resize button
        viewServicesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle the action when View List of Services button is clicked
                String servicesInfo = getServiceInformation();
                JOptionPane.showMessageDialog(null, servicesInfo, "List of Services", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        viewComplaintsButton = new JButton("View Customer Complaints");
        viewComplaintsButton.setBackground(Color.CYAN); // Set background color to sky blue
        viewComplaintsButton.setPreferredSize(new Dimension(350, 50)); // Resize button
        viewComplaintsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle the action when View Customer Complaints button is clicked
                String complaintsInfo = getCustomerComplaintsInformation();
                JOptionPane.showMessageDialog(null, complaintsInfo, "Customer Complaints", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        liveChatButton = new JButton("Live Chat");
        liveChatButton.setBackground(Color.CYAN); // Set background color to sky blue
        liveChatButton.setPreferredSize(new Dimension(350, 50)); // Resize button
        liveChatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle the action when Live Chat button is clicked
            	 Livechat liveChat = new Livechat(); // Create an instance of the LiveChat class
            	
            }
        });

        add(viewServicesButton);
        add(viewComplaintsButton);
        add(liveChatButton);
    }

    private String getServiceInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Services\n");
        sb.append("--------------------------------------------------\n");
        for (int row = 0; row < serviceTableModel.getRowCount(); row++) {
            sb.append("Service: ").append(serviceTableModel.getValueAt(row, 0)).append("\n");
            sb.append("Resolved: ").append(serviceTableModel.getValueAt(row, 1)).append("\n");
            sb.append("Outstanding: ").append(serviceTableModel.getValueAt(row, 2)).append("\n");
            sb.append("--------------------------------------------------\n");
        }
        return sb.toString();
    }

    private String getCustomerComplaintsInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer Complaints\n");
        sb.append("--------------------------------------------------\n");
        for (int row = 0; row < complaintsTableModel.getRowCount(); row++) {
            sb.append("Customer ID: ").append(complaintsTableModel.getValueAt(row, 0)).append("\n");
            sb.append("Name: ").append(complaintsTableModel.getValueAt(row, 1)).append("\n");
            sb.append("Category:Type:Nature: ").append(complaintsTableModel.getValueAt(row, 2)).append("\n");
            sb.append("Date: ").append(complaintsTableModel.getValueAt(row, 3)).append("\n");
            sb.append("--------------------------------------------------\n");
        }
        return sb.toString();
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RepresentativeDashboard gui = new RepresentativeDashboard();
            gui.setVisible(true);
        });
    }
}


