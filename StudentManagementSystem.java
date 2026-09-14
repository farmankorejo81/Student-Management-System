import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementSystem implements ActionListener {

    JFrame frame;
    JTextField idText, nameText, ageText, courseText;
    JButton addButton, deleteButton, clearButton;
    JTable table;
    DefaultTableModel model;

    StudentManagementSystem() {
        frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(null);

        JLabel titleLabel = new JLabel("Student Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(250, 10, 350, 30);
        frame.add(titleLabel);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(30, 60, 100, 25);
        frame.add(idLabel);

        idText = new JTextField();
        idText.setBounds(120, 60, 150, 25);
        frame.add(idText);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 100, 100, 25);
        frame.add(nameLabel);

        nameText = new JTextField();
        nameText.setBounds(120, 100, 150, 25);
        frame.add(nameText);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(30, 140, 100, 25);
        frame.add(ageLabel);

        ageText = new JTextField();
        ageText.setBounds(120, 140, 150, 25);
        frame.add(ageText);

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(30, 180, 100, 25);
        frame.add(courseLabel);

        courseText = new JTextField();
        courseText.setBounds(120, 180, 150, 25);
        frame.add(courseText);

        addButton = new JButton("Add");
        addButton.setBounds(30, 230, 100, 30);
        addButton.addActionListener(this);
        frame.add(addButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(140, 230, 100, 30);
        deleteButton.addActionListener(this);
        frame.add(deleteButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(85, 275, 100, 30);
        clearButton.addActionListener(this);
        frame.add(clearButton);

        String[] columns = {"ID", "Name", "Age", "Course"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(300, 60, 450, 370);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentManagementSystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (idText.getText().isEmpty() || nameText.getText().isEmpty() || 
                ageText.getText().isEmpty() || courseText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Sab fields fill karein!");
            } else {
                String[] rowData = {idText.getText(), nameText.getText(), ageText.getText(), courseText.getText()};
                model.addRow(rowData);
                clearFields();
            }
        }

        if (e.getSource() == deleteButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(frame, "Delete karne ke liye pehle row select karein!");
            }
        }

        if (e.getSource() == clearButton) {
            clearFields();
        }
    }

    private void clearFields() {
        idText.setText("");
        nameText.setText("");
        ageText.setText("");
        courseText.setText("");
    }
}