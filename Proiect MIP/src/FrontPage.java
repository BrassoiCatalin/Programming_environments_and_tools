import javafx.beans.property.adapter.JavaBeanBooleanProperty;
import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;

class FrontPage implements ActionListener{
    JFrame frame;
    JLabel id;
    JButton button;

    FrontPage(){

        frame = new JFrame("Front Page");
        frame.setBackground(Color.RED);
        frame.setLayout(null);

        ImageIcon i1 = new ImageIcon("C:/Images/frontpage.jpg");
        Image i2 = i1.getImage().getScaledInstance(960,720,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);

        l1.setBounds(0,150,1360,530);
        frame.add(l1);

        button = new JButton("CLICK HERE TO CONTINUE");
        button.setFont(new Font("Serif", Font.BOLD, 15));
        button.setBackground(Color.GREEN);
        button.setForeground(Color.DARK_GRAY);
        button.setBounds(540, 610, 250, 50);
        button.addActionListener(this);

        id = new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);

        id.add(button);
        frame.add(id);

        frame.getContentPane().setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocation(0, 0);

    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == button){

            frame.setVisible(false);
            Login l = new Login();
        }
    }

    public static void main(String[] arg){

        FrontPage f = new FrontPage();
    }
}
