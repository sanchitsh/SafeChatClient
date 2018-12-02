package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ChatMenu extends JFrame {
    private JTextArea userNameTextInput;
    private JTextArea nameTextInput;
    private JTextArea phoneTextInput;
    private JComboBox genderTypesBox;
    private JComboBox ethnicityTypesBox;
    private JComboBox ageRangeBox;

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
        userNameTextInput = new JTextArea(1, 10);
        characterProfile.add(userNameTextInput);

        characterName.add(new JLabel("Name:"));
        nameTextInput = new JTextArea(1, 10);
        characterName.add(nameTextInput);

        contactInfo.add(new JLabel("Phone Number:"));
        phoneTextInput = new JTextArea(1, 10);
        contactInfo.add(phoneTextInput);

        characterOptions.add(new JLabel("Set your preferences:"));
        genderTypesBox = new JComboBox<>(genderTypes);
        characterOptions.add(genderTypesBox);

        ethnicityTypesBox = new JComboBox<>(ethnicityTypes);
        characterOptions.add(ethnicityTypesBox);

        ageRangeBox = new JComboBox<>(ageRange);
        characterOptions.add(ageRangeBox);

        cards.add(characterProfile);
        cards.add(characterOptions);
        cards.add(characterName);
        cards.add(contactInfo);
        JButton signUp = new JButton("Sign up!");
        signUp.setBackground(Color.PINK);
        signUp.addActionListener(new openChatBox(this));
        cards.add(signUp);
        add(cards, BorderLayout.CENTER);
        cards.setBorder(BorderFactory.createEmptyBorder(30,10,10,10));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JTextArea getUserNameTextInput() {
        return userNameTextInput;
    }

    public JTextArea getNameTextInput() {
        return nameTextInput;
    }

    public JTextArea getPhoneTextInput() {
        return phoneTextInput;
    }

    public JComboBox getGenderTypesBox() {
        return genderTypesBox;
    }

    public JComboBox getEthnicityTypesBox() {
        return ethnicityTypesBox;
    }

    public JComboBox getAgeRangeBox() {
        return ageRangeBox;
    }
}
