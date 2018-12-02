package client;

import javax.swing.*;

public class uiClient {

    public void run(String nickname, String name ,String contact,String ethnicity,String gender,String age){
        Client c;
        c = new Client("127.0.0.1",  nickname,  name , contact, ethnicity, gender, age );
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.startRunning();
    }
}
