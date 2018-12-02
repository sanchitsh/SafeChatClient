package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {
    private Client client;

    public ButtonActionListener(Client client) {
        this.client = client;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        client.showMessage("\n"+client.getContact());
    }
}
