import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class logIn extends defaultFrame {

    static int attempt = 3;
    static String password = "123456"; 

    logIn() {
        super();
        this.setTitle("Log In");
        JDialog.setDefaultLookAndFeelDecorated(true);

        JPanel logInPanel = new JPanel();
        logInPanel.setSize(1244, 700);
        logInPanel.setBackground(Color.BLACK);
        logInPanel.setLayout(null);
        this.add(logInPanel);

        JLabel lbl1 = new JLabel("Log in to your Account");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(550, 35, 400, 40);
        logInPanel.add(lbl1);

        JLabel lbl2 = new JLabel("Enter your PIN");
        lbl2.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.setForeground(new Color(255, 222, 89));
        lbl2.setBounds(550, 170, 400, 40);
        logInPanel.add(lbl2);

        final JPasswordField PIN = new JPasswordField();
        PIN.setBounds(550, 220, 400, 65);
        PIN.setFont(new Font("Source Sans Pro", Font.BOLD, 28));
        PIN.setBorder(null);
        ((JTextField) PIN).setHorizontalAlignment(JTextField.CENTER);
        logInPanel.add(PIN);

        final JButton loginBtn = new JButton("Enter");
        loginBtn.setBounds(672, 318, 160, 46);
        loginBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        loginBtn.setContentAreaFilled(false);
        loginBtn.setBorderPainted(false);
        loginBtn.setFocusPainted(false);
        loginBtn.setOpaque(false);
        loginBtn.setForeground(new Color(255, 255, 255));
        logInPanel.add(loginBtn);

        final JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(37, 617, 100, 37);
        cancelBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 20));
        cancelBtn.setContentAreaFilled(false);
        cancelBtn.setBorderPainted(false);
        cancelBtn.setFocusPainted(false);
        cancelBtn.setOpaque(false);
        cancelBtn.setForeground(new Color(255, 255, 255));
        logInPanel.add(cancelBtn);

        final JButton changePass = new JButton("<html><i><u>Change Password</u></i></html>");
        changePass.setBounds(678, 430, 160, 35);
        changePass.setFont(new Font("Source Sans Pro", Font.ITALIC, 18));
        changePass.setContentAreaFilled(false);
        changePass.setBorderPainted(false);
        changePass.setFocusPainted(false);
        changePass.setOpaque(false);
        changePass.setForeground(new Color(255, 222, 89));
        logInPanel.add(changePass);

        PIN.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = PIN.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    PIN.setEditable(true);
                } else {
                    PIN.setEditable(false);

                }
            }
        });
        
        
        
        
        loginBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!PIN.getText().equals(password)) {
                    JOptionPane.showMessageDialog(null, "PIN incorrect", "", JOptionPane.ERROR_MESSAGE);
                    attempt--;
                    JOptionPane.showMessageDialog(null, "Attempts remaining: " + attempt, "", JOptionPane.WARNING_MESSAGE);
                    PIN.setText("");
                    PIN.requestFocus();
                    getRootPane().setDefaultButton(loginBtn);
                    if (attempt < 1) {
                        JOptionPane.showMessageDialog(null, "You have reached maximum attempt!", "",JOptionPane.WARNING_MESSAGE);
                        System.exit(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    dispose();
                }
            }
        });

        
        cancelBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel transaction?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        
        changePass.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int choice2 = JOptionPane.showConfirmDialog(null, "Are you sure you want to change your password?", "Change Password", JOptionPane.YES_NO_OPTION);
        if (choice2 == JOptionPane.YES_OPTION) {
            JPasswordField passwordField = new JPasswordField();
            
            // Add KeyListener to the password field
            passwordField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE)) {
                        e.consume();  // Ignore the event
                    }
                }
            });
            
            int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter your new password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.OK_OPTION) {
                char[] newPasswordChars = passwordField.getPassword();
                password = new String(newPasswordChars);
                
                // Process the new password (e.g., update it in your system)
                
                JOptionPane.showMessageDialog(null,"You have successfully changed your password!", "Change Password", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
});

        
        

        JLabel logInBG = new JLabel();
        logInBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\NetBeansProjects\\ATM\\src\\resources\\LogIn BG.png"));
        logInBG.setBounds(0, -21, 1050, 700);
        logInPanel.add(logInBG);

    }
}