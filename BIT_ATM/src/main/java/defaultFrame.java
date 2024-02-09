import javax.swing.*;
import java.awt.*;

// This class creates a default settings for the frames 
public class defaultFrame extends JFrame {
    
    JFrame frame = new JFrame();
    ImageIcon image = new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\Logo.png");

    defaultFrame(){
        this.setSize(1050, 700);
        this.setVisible(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        this.setTitle("Bank of Inclusive Transactions");
        this.setResizable(false);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(255,255,255));
        this.setLocationRelativeTo(null);
    }
}

