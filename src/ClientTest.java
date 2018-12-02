import javax.swing.JFrame;

public class ClientTest {
    public static void main(String[] args) {
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