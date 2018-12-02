package client;

import javax.swing.JFrame;

public class ClientTest {
public static void main(String args[]){
    Client c;
    c = new Client("127.0.0.1",  "nickname",  "Christopher" , "contact", "ethnicity", "gender", "age" );
    c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    c.startRunning();

}


}