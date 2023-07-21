package livechatapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepresentativeGUI extends JFrame {
    private JTextArea complaintsArea;
    private JComboBox<String> servicesComboBox;
    private JButton viewComplaintsButton;
    private JComboBox<String> techniciansComboBox;
    private JButton assignButton;
    private Map<String, List<String>> serviceComplaintsMap;

    private JPanel customerDetailsPanel;
    private JLabel customerIdLabel;
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JLabel contactLabel;
    private JLabel typeLabel;
    private JTextArea detailsArea;

    public RepresentativeGUI() {
        serviceComplaintsMap = new HashMap<>();
        initializeData();

        setTitle("Representative Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new FlowLayout());

        JLabel servicesLabel = new JLabel("Select a service:");
        servicesComboBox = new JComboBox<>(serviceComplaintsMap.keySet().toArray(new String[0]));
        viewComplaintsButton = new JButton("View Complaints");
        complaintsArea = new JTextArea(10, 40);
        complaintsArea.setEditable(false);

        viewComplaintsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedService = (String) servicesComboBox.getSelectedItem();
                showComplaints(selectedService);
                clearCustomerDetails();
            }
        });

        dashboardPanel.add(servicesLabel);
        dashboardPanel.add(servicesComboBox);
        dashboardPanel.add(viewComplaintsButton);
        dashboardPanel.add(new JScrollPane(complaintsArea));

        JPanel technicianPanel = new JPanel();
        technicianPanel.setLayout(new FlowLayout());

        JLabel techniciansLabel = new JLabel("Assign to Technician:");
        techniciansComboBox = new JComboBox<>(new String[]{"Bob Builder", "Jerry Fixit", "Cory Solvit"});
        assignButton = new JButton("Assign Complaint");
        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedService = (String) servicesComboBox.getSelectedItem();
                String selectedTechnician = (String) techniciansComboBox.getSelectedItem();
                assignComplaint(selectedService, selectedTechnician);
                showComplaints(selectedService);
            }
        });

        technicianPanel.add(techniciansLabel);
        technicianPanel.add(techniciansComboBox);
        technicianPanel.add(assignButton);

        customerDetailsPanel = new JPanel();
        customerDetailsPanel.setLayout(new BoxLayout(customerDetailsPanel, BoxLayout.Y_AXIS));
        customerIdLabel = new JLabel();
        nameLabel = new JLabel();
        emailLabel = new JLabel();
        contactLabel = new JLabel();
        typeLabel = new JLabel();
        detailsArea = new JTextArea(5, 30);
        detailsArea.setEditable(false);

        customerDetailsPanel.add(customerIdLabel);
        customerDetailsPanel.add(nameLabel);
        customerDetailsPanel.add(emailLabel);
        customerDetailsPanel.add(contactLabel);
        customerDetailsPanel.add(typeLabel);
        customerDetailsPanel.add(new JScrollPane(detailsArea));

        add(dashboardPanel, BorderLayout.NORTH);
        add(technicianPanel, BorderLayout.SOUTH);
        add(new JScrollPane(customerDetailsPanel), BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeData() {
        // data for representation purpose and should be replace with data from our wodda database
        List<String> internetcomplaints = new ArrayList<>();
        internetcomplaints.add("Complaint 1: Slow internet speed");
        internetcomplaints.add("Complaint 2: Connection drops frequently");

        List<String> setupComplaints = new ArrayList<>();
        setupComplaints.add("Complaint 3: Requesting new Installation Service");
        setupComplaints.add("Complaint 4: Requesting new setup Service");

        List<String> loginComplaints = new ArrayList<>();
        loginComplaints.add("Complaint 5: No access error");
        loginComplaints.add("Complaint 6: Invalid credentials");

        serviceComplaintsMap.put("Internet Speed Issues", internetcomplaints);
        serviceComplaintsMap.put("Installation and Setup Problems", setupComplaints);
        serviceComplaintsMap.put("Login Difficulties", loginComplaints);
    }

    private void showComplaints(String service) {
        List<String> complaints = serviceComplaintsMap.get(service);
        StringBuilder complaintsText = new StringBuilder();
        if (complaints != null) {
            for (String complaint : complaints) {
                complaintsText.append(complaint).append("\n");
            }
        } else {
            complaintsText.append("No complaints for this service.");
        }
        complaintsArea.setText(complaintsText.toString());
    }

    private void assignComplaint(String service, String technician) {
        List<String> complaints = serviceComplaintsMap.get(service);
        if (complaints != null) {
            String newComplaint = "Complaint " + (complaints.size() + 1) + ": Assigned to " + technician;
            complaints.add(newComplaint);
            serviceComplaintsMap.put(service, complaints);
        }
    }

    private void clearCustomerDetails() {
        customerIdLabel.setText("");
        nameLabel.setText("");
        emailLabel.setText("");
        contactLabel.setText("");
        typeLabel.setText("");
        detailsArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RepresentativeGUI();
            }
        });
    }
}


