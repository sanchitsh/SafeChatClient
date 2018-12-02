package model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<ChatBubble> chatlog;

    public Person() {
        chatlog = new ArrayList<>();
    }

    public void addText(String chattext) {
        chatlog.add(new ChatBubble(chattext));
    }

    public void removeText(int i) {
        if (i < chatlog.size()) {
            chatlog.remove(i);
        }
    }

    public void flagText(int i) {
        // TODO
    }
}