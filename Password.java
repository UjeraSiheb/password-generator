import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Password extends JFrame {
    private JTextField lengthField;
    private JCheckBox letters;
    private JCheckBox symbol;
    private JCheckBox numbers;
    private JTextArea passwordArea;

    Password() {
        setTitle("Password Generator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
        setLayout(new FlowLayout());
        setVisible(true);
    }

    private void initComponents() {
        JLabel lengthLabel = new JLabel("Password Length");
        lengthField = new JTextField(10);
        letters = new JCheckBox("Include Letters");
        symbol = new JCheckBox("Include Symbols");
        numbers = new JCheckBox("Include Numbers");
        passwordArea = new JTextArea(8, 20);
        passwordArea.setEditable(false);
        JButton generateButton = new JButton("Generate Password");

        generateButton.addActionListener(e -> generatePassword());

        add(lengthLabel);
        add(lengthField);
        add(letters);
        add(numbers);
        add(symbol);
        add(generateButton);
        add(passwordArea);
    }

    private void generatePassword() {
        int length = Integer.parseInt(lengthField.getText());
        boolean includeNumber = numbers.isSelected();
        boolean includeSymbol = symbol.isSelected();
        boolean includeLetters = letters.isSelected();
        String password = randomPassword(length, includeNumber, includeSymbol, includeLetters);
        passwordArea.setText(password);
    }

    private String randomPassword(int length, boolean includeNumber, boolean includeSymbol, boolean includeLetters) {
        StringBuilder password = new StringBuilder();
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()_+";
        String charsall = "";
        if (includeNumber) {
            charsall += numbers;
        }
        if (includeSymbol) {
            charsall += symbols;
        }
        if (includeLetters) {
            charsall += letters;
        }
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charsall.length());
            char randomChar = charsall.charAt(randomIndex);
            password.append(randomChar);
        }
        return password.toString();
    }

     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Password());
    }
}