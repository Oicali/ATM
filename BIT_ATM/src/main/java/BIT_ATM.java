import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class BIT_ATM extends defaultFrame {
    
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

            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException e) {
                e.printStackTrace(); // Or handle the exception in a way that makes sense for your application
            } catch (LineUnavailableException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            

            // Open the Login frame as soon as the Opening frame closes
            openingFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    
                }
            });
        });

    }
}
