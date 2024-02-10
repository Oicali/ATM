import javax.swing.*;

public class BIT_ATM extends frameSettings {

    BIT_ATM() {
        super();

        JLabel intro = new JLabel();
        intro.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\Opening.gif"));
        intro.setBounds(-95, -10, 1244, 700);
        this.add(intro);


        // Set up a timer to close the frame after the GIF duration (in milliseconds)
        int gifDuration = 4500; // 5 seconds
        Timer timer = new Timer(gifDuration, e -> {
            this.dispose();

        });

        
        // Start the timer
        timer.setRepeats(false); // Set to false to execute only once
        timer.start();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BIT_ATM openingFrame = new BIT_ATM();
            openingFrame.show();
            playOpening();

            // Open the Login frame
            openingFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    new logIn();
                }
            });
        });

    }
}
