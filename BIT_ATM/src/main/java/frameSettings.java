import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

// This class creates a default settings for the frames 
public class frameSettings extends JFrame {

    ImageIcon image = new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\Logo.png");

    static Clip clip, clip1, clip2, clip3;;

    frameSettings() {
        this.setSize(1050, 700);
        this.setVisible(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setTitle("Bank of Inclusive Transactions");
        this.setResizable(false);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setLocationRelativeTo(null);
    }

    // Sound methods
    public static void playOpening() {
        File file = new File("C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\Intro_sound.wav");

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
    }

    public static void playError() {
        File file1 = new File("C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\error.wav");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file1);
            clip1 = AudioSystem.getClip();
            clip1.open(audioStream);
            clip1.start();
        } catch (UnsupportedAudioFileException | IOException error) {
            error.printStackTrace(); // Or handle the exception in a way that makes sense for your
                                     // application
        } catch (LineUnavailableException error) {
            error.printStackTrace();
        }
    }

    public static void playWarning() {
        File file2 = new File("C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\warning.wav");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file2);
            clip2 = AudioSystem.getClip();
            clip2.open(audioStream);
            clip2.start();
        } catch (UnsupportedAudioFileException | IOException error) {
            error.printStackTrace(); // Or handle the exception in a way that makes sense for your application
        } catch (LineUnavailableException error) {
            error.printStackTrace();
        }
    }

    public static void playConfirm() {
        File file3 = new File("C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\confirm.wav");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file3);
            clip3 = AudioSystem.getClip();
            clip3.open(audioStream);
            clip3.start();
        } catch (UnsupportedAudioFileException | IOException error) {
            error.printStackTrace(); // Or handle the exception in a way that makes sense for your application
        } catch (LineUnavailableException error) {
            error.printStackTrace();
        }
    }

    // Cancel button
    public static void addCancelButton(JPanel panel) {
        JLabel cancel_Button = new JLabel();
        cancel_Button.setIcon(
                new ImageIcon(
                        "C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\cancelButton.png"));
        cancel_Button.setBounds(18, 619, 156, 37);
        panel.add(cancel_Button);

        cancel_Button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // No action needed for mouseClicked
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // No action needed for mousePressed
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                playWarning();

                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel transaction?",
                        "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cancel_Button.setIcon(
                        new ImageIcon(
                                "C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\cancelButton2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancel_Button.setIcon(
                        new ImageIcon(
                                "C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\cancelButton.png"));
            }
        });

    }

}
