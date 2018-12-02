package model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<ChatBubble> chatlog;
    private String nickname;
    private String name;
    private String contact;
    private String ethnicity;
    private String gender;
    private String age;

    public Person(String nickname, String name, String contact, String ethnicity, String gender, String age) {
        chatlog = new ArrayList<>();
        this.nickname = nickname;
        this.name = name;
        this.contact = contact;
        this.ethnicity = ethnicity;
        this.gender = gender;
        this.age = age;
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
        System.out.println("Flagged individual.");
    }

    public List<ChatBubble> getChatlog() {
        return chatlog;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }
}