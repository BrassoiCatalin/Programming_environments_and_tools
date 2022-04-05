import Models.User;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Login implements ActionListener {

    JFrame frame;
    JLabel label1, label2;
    JTextField textField;
    JPasswordField passwordField;
    JButton button1, button2;

    Login() {

        frame = new JFrame("Login");
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);

        label1 = new JLabel("Username");
        label1.setBounds(40, 20, 100, 30);
        frame.add(label1);

        label2 = new JLabel("Password");
        label2.setBounds(40, 70, 100, 30);
        frame.add(label2);

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        frame.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        frame.add(passwordField);

        ImageIcon i1 = new ImageIcon("C:/Images/login.jpg");
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        frame.add(l3);

        button1 = new JButton("Login");
        button1.setBounds(40, 140, 120, 30);
        button1.setFont(new Font("serif", Font.BOLD, 15));
        button1.addActionListener(this);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        frame.add(button1);

        button2 = new JButton("Cancel");
        button2.setBounds(180, 140, 120, 30);
        button2.setFont(new Font("serif", Font.BOLD, 15));
        button2.addActionListener(this);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        frame.add(button2);

        frame.getContentPane().setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setSize(600, 300);
        frame.setLocation(200, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String u = textField.getText();
            String v = passwordField.getText();

            if(u != null && v != null)
            {
                User user = new User(u,v);
                if(!Connect.verifyIfUserExists(user))
                {
                    JOptionPane.showMessageDialog(null, "Invalid Username And Password");
                }
                else
                {
                    Menu menu = new Menu();
                    frame.setVisible(false);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
