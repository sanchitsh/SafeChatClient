package ui;

import client.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class openChatBox implements ActionListener {
    ChatMenu chatMenu;

    public openChatBox(ChatMenu chatMenu) {
        this.chatMenu = chatMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chatMenu.setVisible(false);
        String nickname="bigboi"; String name="jeff";
        String contact="0000012";
        String ethnicity="brown";
        String email="dsada@dnaksd.com";
        Client c;
        c = new Client("127.0.0.1",nickname,name,email);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.startRunning();
        Client b;
    }
}
