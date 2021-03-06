package ui;

import client.Client;
import client.ClientTest;
import client.uiClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class openChatBox implements ActionListener {
    private ChatMenu chatMenu;

    public openChatBox(ChatMenu chatMenu) {
        this.chatMenu = chatMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chatMenu.setVisible(false);
        String nickname = chatMenu.getUserNameTextInput().getText();
        String name = chatMenu.getNameTextInput().getText();
        String contact = chatMenu.getPhoneTextInput().getText();
        String ethnicity = String.valueOf(chatMenu.getEthnicityTypesBox().getSelectedItem());
        String gender = String.valueOf(chatMenu.getGenderTypesBox().getSelectedItem());
        String age = String.valueOf(chatMenu.getAgeRangeBox().getSelectedItem());

        uiClient c=new uiClient();
        c.run(nickname,  name,  contact,  ethnicity,  gender,  age);
    }
}
