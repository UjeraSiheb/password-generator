import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Password extends JFrame {
    // UI components
    private JTextField lengthField;
    private JCheckBox letters;
    private JCheckBox symbol;
    private JCheckBox numbers;
    private JTextArea passwordArea;

    // Constructor
    Password() {
        setTitle("Password Generator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize components
        initComponents();
        setLayout(new FlowLayout());
        setVisible(true);
    }

    // Method to initialize components
    private void initComponents() {
        JLabel lengthLabel = new JLabel("Password Length");
        lengthField = new JTextField(10);
        letters = new JCheckBox("Include Letters");
        symbol = new JCheckBox("Include Symbols");
        numbers = new JCheckBox("Include Numbers");
        passwordArea = new JTextArea(8, 20);
        passwordArea.setEditable(false);
        JButton generateButton = new JButton("Generate Password");

        // Set up action listener for the Generate Password button
        generateButton.addActionListener(e -> generatePassword());

        // Add components to the frame
        add(lengthLabel);
        add(lengthField);
        add(letters);
        add(numbers);
        add(symbol);
        add(generateButton);
        add(passwordArea);
    }

    // Method to generate a random password
    private void generatePassword() {
        int length = Integer.parseInt(lengthField.getText());
        boolean includeNumber = numbers.isSelected();
        boolean includeSymbol = symbol.isSelected();
        boolean includeLetters = letters.isSelected();
        String password = randomPassword(length, includeNumber, includeSymbol, includeLetters);
        passwordArea.setText(password);
    }

    // Method to generate a random password 
    private String randomPassword(int length, boolean includeNumber, boolean includeSymbol, boolean includeLetters) {
        StringBuilder password = new StringBuilder();
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()_+";
        String charsAll = "";

        // Include selected character sets
        if (includeNumber) {
            charsAll += numbers;
        }
        if (includeSymbol) {
            charsAll += symbols;
        }
        if (includeLetters) {
            charsAll += letters;
        }

        // Generate the random password
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charsAll.length());
            char randomChar = charsAll.charAt(randomIndex);
            password.append(randomChar);
        }

        // Return the generated password
        return password.toString();
    }

    // Main method to start the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Password());
    }
}
