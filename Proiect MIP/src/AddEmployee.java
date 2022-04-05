import Models.Employee;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

class AddEmployee implements ActionListener {

    JFrame frame;
    JLabel nameLabel, fatherLabel, ageLabel, DOBLabel, addressLabel, phoneLabel,
            emailLabel, educationLabel, postLabel, imageLabel, lab, lab1;

    JTextField t, nameTextBox, fatherTextBox, ageTextBox, DOBTextBox, addressTextBox,
            phoneTextBox, emailTextBox, educationTextBox, postTextBox;
    JButton add, cancel;

    public int count = 0;

    AddEmployee() {

        frame = new JFrame("Add Employee");
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);

        imageLabel = new JLabel();
        imageLabel.setBounds(0, 0, 900, 700);
        imageLabel.setLayout(null);
        ImageIcon imageIcon = new ImageIcon("C:/Images/addemployee.jpg");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(900, 900, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        imageLabel.setIcon(imageIcon);

        frame.add(imageLabel);

        {
            nameLabel = new JLabel("Name");
            nameLabel.setBounds(50, 250, 100, 30);
            nameLabel.setFont(new Font("serif", Font.BOLD, 20));
            nameLabel.setForeground(Color.BLACK);
            imageLabel.add(nameLabel);

            nameTextBox = new JTextField();
            nameTextBox.setBounds(200, 250, 150, 30);
            imageLabel.add(nameTextBox);
        }

        {
            fatherLabel = new JLabel("Father's name");
            fatherLabel.setBounds(400, 250, 200, 30);
            fatherLabel.setFont(new Font("serif", Font.BOLD, 20));
            fatherLabel.setForeground(Color.BLACK);
            imageLabel.add(fatherLabel);

            fatherTextBox = new JTextField();
            fatherTextBox.setBounds(600, 250, 150, 30);
            imageLabel.add(fatherTextBox);
        }

        {
            ageLabel = new JLabel("Age");
            ageLabel.setBounds(50, 300, 100, 30);
            ageLabel.setFont(new Font("serif", Font.BOLD, 20));
            ageLabel.setForeground(Color.BLACK);
            imageLabel.add(ageLabel);

            ageTextBox = new JTextField();
            ageTextBox.setBounds(200, 300, 150, 30);
            imageLabel.add(ageTextBox);

        }

        {
            DOBLabel = new JLabel("Date Of Birth");
            DOBLabel.setBounds(400, 300, 200, 30);
            DOBLabel.setFont(new Font("serif", Font.BOLD, 20));
            DOBLabel.setForeground(Color.BLACK);
            imageLabel.add(DOBLabel);

            DOBTextBox = new JTextField();
            DOBTextBox.setBounds(600, 300, 150, 30);
            imageLabel.add(DOBTextBox);
        }

        {
            addressLabel = new JLabel("Address");
            addressLabel.setBounds(50, 350, 100, 30);
            addressLabel.setFont(new Font("serif", Font.BOLD, 20));
            addressLabel.setForeground(Color.BLACK);
            imageLabel.add(addressLabel);

            addressTextBox = new JTextField();
            addressTextBox.setBounds(200, 350, 150, 30);
            imageLabel.add(addressTextBox);
        }

        {
            phoneLabel = new JLabel("Phone");
            phoneLabel.setBounds(400, 350, 100, 30);
            phoneLabel.setFont(new Font("serif", Font.BOLD, 20));
            phoneLabel.setForeground(Color.BLACK);
            imageLabel.add(phoneLabel);

            phoneTextBox = new JTextField();
            phoneTextBox.setBounds(600, 350, 150, 30);
            imageLabel.add(phoneTextBox);
        }

        {
            emailLabel = new JLabel("Email");
            emailLabel.setBounds(50, 400, 100, 30);
            emailLabel.setFont(new Font("serif", Font.BOLD, 20));
            emailLabel.setForeground(Color.BLACK);
            imageLabel.add(emailLabel);

            emailTextBox = new JTextField();
            emailTextBox.setBounds(200, 400, 150, 30);
            imageLabel.add(emailTextBox);
        }

        {
            educationLabel = new JLabel("Education");
            educationLabel.setBounds(400, 400, 100, 30);
            educationLabel.setFont(new Font("serif", Font.BOLD, 20));
            educationLabel.setForeground(Color.BLACK);
            imageLabel.add(educationLabel);

            educationTextBox = new JTextField();
            educationTextBox.setBounds(600, 400, 150, 30);
            imageLabel.add(educationTextBox);
        }

        {
            postLabel = new JLabel("Job Post");
            postLabel.setBounds(50, 450, 100, 30);
            postLabel.setFont(new Font("serif", Font.BOLD, 20));
            postLabel.setForeground(Color.BLACK);
            imageLabel.add(postLabel);

            postTextBox = new JTextField();
            postTextBox.setBounds(200, 450, 150, 30);
            imageLabel.add(postTextBox);
        }

        lab = new JLabel();
        lab.setBounds(200, 450, 250, 200);
        imageLabel.add(lab);

        lab1 = new JLabel("");
        lab1.setBounds(600, 450, 250, 200);
        imageLabel.add(lab1);

        add = new JButton("Submit");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(250, 550, 150, 40);

        imageLabel.add(add);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(450, 550, 150, 40);

        imageLabel.add(cancel);

        add.addActionListener(this);
        cancel.addActionListener(this);

        frame.setVisible(true);
        frame.setSize(900, 700);
        frame.setLocation(0, 0);
    }

    public void actionPerformed(ActionEvent ae) {

        String name = nameTextBox.getText();
        String fatherName = fatherTextBox.getText();
        String age = ageTextBox.getText();
        String DOB = DOBTextBox.getText();
        String address = addressTextBox.getText();
        String phone = phoneTextBox.getText();
        String email = emailTextBox.getText();
        String education = educationTextBox.getText();
        String post = postTextBox.getText();
        //String employeeId = idTextBox.getText();

        if (ae.getSource() == add) {
            try {
                Employee employee = new Employee(name, fatherName, age, DOB, address, phone, email, education, post);
                Connect.addEmployee(employee);

                JOptionPane.showMessageDialog(null, "Details Successfully Inserted");
                frame.setVisible(false);

            } catch (Exception ee) {
                System.out.println("The error is:" + ee);
            }
        } else if (ae.getSource() == cancel) {
            frame.setVisible(false);
        }
    }
}