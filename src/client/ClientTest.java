package client;

import javax.swing.JFrame;

public class ClientTest {
    String nickname="smallboi"; String name="jeff";
    String contact="0000012";
    String ethnicity="brown";
    String email="dsada@dnaksd.com";


    public void run(){
        Client c;
        c = new Client("127.0.0.1",  "smallboi",  "jeff",  "0012",  "America",  "Male",  "12");
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.startRunning();
    }

}