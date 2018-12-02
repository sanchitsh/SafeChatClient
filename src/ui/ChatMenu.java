package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ChatMenu extends JFrame {

    public ChatMenu() {
        super("Chat Menu");
    }

    public void main() {
        getContentPane().setBackground(Color.WHITE);
        setSize(500, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        String[] genderTypes = {"Straight", "Gay", "Bisexual", "Other"};
        String[] ethnicityTypes = {"White", "Black", "Asian", "Latino", "Other"};
        String[] ageRange = {"12-16","17-24","25-35","36-50","51+"};
        JPanel cards = new JPanel(new GridLayout(6,1));
        JPanel characterProfile = new JPanel();
        JPanel characterOptions = new JPanel();

        JPanel characterName = new JPanel();
        JPanel contactInfo = new JPanel();

        try {
            BufferedImage image = ImageIO.read(this.getClass().getResource("logo.jpg"));
            cards.add(new JLabel(new ImageIcon(image)));
        }
        catch (IOException e) {
            System.out.println("not found!");
        }

        characterProfile.add(new JLabel("Username:"));
        characterProfile.add(new JTextArea(1,10));

        characterName.add(new JLabel("Name:"));
        characterName.add(new JTextArea(1,10));

        contactInfo.add(new JLabel("Contact Information:"));
        contactInfo.add(new JTextArea(2, 10));

        characterOptions.add(new JLabel("Set your preferences:"));
        characterOptions.add(new JComboBox<>(genderTypes));
        characterOptions.add(new JComboBox<>(ethnicityTypes));
        characterOptions.add(new JComboBox<>(ageRange));

        cards.add(characterProfile);
        cards.add(characterOptions);
        cards.add(characterName);
        cards.add(contactInfo);
        JButton signUp = new JButton("Sign up!");
        signUp.addActionListener(new openChatBox(this));
        cards.add(signUp);
        add(cards, BorderLayout.CENTER);
        cards.setBorder(BorderFactory.createEmptyBorder(30,10,10,10));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
