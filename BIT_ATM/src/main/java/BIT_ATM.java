import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

public class BIT_ATM extends defaultFrame {

    static Clip clip;
    
    BIT_ATM() {
        super();

        JLabel intro = new JLabel();

        intro.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\Opening.gif"));
        intro.setBounds(-95, -10, 1244, 700);
        this.add(intro);

        // Set up a timer to close the frame after the GIF duration (in milliseconds)
        int gifDuration = 5000; // 5 seconds
        Timer timer = new Timer(gifDuration, e -> {
            dispose();

        });

        // Start the timer
        timer.setRepeats(false); // Set to false to execute only once
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BIT_ATM openingFrame = new BIT_ATM();
            openingFrame.show();

            File file = new File("C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\Intro_sound.wav");

            // Code to play the opening sounds and handle exceptions
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException e) {
                e.printStackTrace(); // Or handle the exception in a way that makes sense for your application
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }

            // Force stop the sounds and open the Login frame
            openingFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    clip.stop();
                    logIn logInFrame = new logIn();
                    logInFrame.show();
                }
            });
        });

    }
}
