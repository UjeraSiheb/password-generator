import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.util.Random;
//password class
public class Password extends JFrame{
    //all components
    JTextField Lengthfield;
    JCheckBox letters;
    JCheckBox symbol;
    JCheckBox numbers;
    JTextArea passwordArea;
    //constructor
    Password(){
        setTitle("password genarator");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        initComponents();
        setLayout(new FlowLayout());
        setVisible(true);
    }
    private void initComponents(){

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Password());
    }


