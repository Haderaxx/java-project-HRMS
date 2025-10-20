import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeDialog extends JDialog {
    private JTextField tfId;
    private JTextField tfName;
    private JTextField tfDept;
    private JTextField tfPos;
    private JTextField tfSal;
    private boolean succeeded;

    public EmployeeDialog(Object[] existingData) {
        setTitle(existingData == null ? "Add Employee" : "Edit Employee");
        setModal(true);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6,2,5,5));
        panel.add(new JLabel("ID:"));
        tfId = new JTextField();
        panel.add(tfId);

        panel.add(new JLabel("Name:"));
        tfName = new JTextField();
        panel.add(tfName);

        panel.add(new JLabel("Department:"));
        tfDept = new JTextField();
        panel.add(tfDept);

        panel.add(new JLabel("Position:"));
        tfPos = new JTextField();
        panel.add(tfPos);

        panel.add(new JLabel("Salary:"));
        tfSal = new JTextField();
        panel.add(tfSal);

        getContentPane().add(panel, BorderLayout.CENTER);

        JButton btnOk = new JButton("OK");
        JButton btnCancel = new JButton("Cancel");
        JPanel btnPanel = new JPanel();
        btnPanel.add(btnOk);
        btnPanel.add(btnCancel);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);

        if (existingData != null) {
            tfId.setText(existingData[0].toString());
            tfId.setEnabled(false); // ID maybe not editable
            tfName.setText(existingData[1].toString());
            tfDept.setText(existingData[2].toString());
            tfPos.setText(existingData[3].toString());
            tfSal.setText(existingData[4].toString());
        }

        btnOk.addActionListener(e -> {
            succeeded = true;
            dispose();
        });

        btnCancel.addActionListener(e -> {
            succeeded = false;
            dispose();
        });
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public Object[] getEmployeeData() {
        return new Object[] {
            Integer.parseInt(tfId.getText().trim()),
            tfName.getText().trim(),
            tfDept.getText().trim(),
            tfPos.getText().trim(),
            Double.parseDouble(tfSal.getText().trim())
        };
    }
}
