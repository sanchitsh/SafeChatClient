package client;

import model.Person;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Client extends JFrame{

    private JTextField userText;
    private JTextArea chatWindow;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String message = "";
    private String serverIP;
    private Socket connection;

    private String nickname;
    private String name;
    private String contact;
    private String ethnicity;
    private String gender;
    private String age;

    //constructor
    public Client(String host, String nickname, String name, String contact, String ethnicity, String gender, String age){
        super("client.Client");
        this.nickname = nickname;
        this.name = name;
        this.contact = contact;
        this.ethnicity = ethnicity;
        this.gender = gender;
        this.age = age;

        serverIP = host;
        userText = new JTextField();
        userText.setEditable(false);
        userText.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        sendMessage(event.getActionCommand());
                        userText.setText("");
                    }
                }
        );
        add(userText, BorderLayout.NORTH);
        chatWindow = new JTextArea();
        add(new JScrollPane(chatWindow));
        setSize(800, 500); //Sets the window size
        setVisible(true);
    }

    //connect to server
    public void startRunning(){
        shareInfo();
        try{
            connectToServer();
            setupStreams();
            whileChatting();
        }catch(EOFException eofException){
            showMessage("\n client.Client terminated the connection");
        }catch(IOException ioException){
            ioException.printStackTrace();
        }finally{
          //  closeConnection();
        }
    }

    //connect to server
    private void connectToServer() throws IOException{
        showMessage("Attempting connection... \n");
        connection = new Socket(InetAddress.getByName(serverIP), 6789);
        showMessage("Connection Established! Connected to: " + connection.getInetAddress().getHostName());
    }

    //set up streams
    private void setupStreams() throws IOException{
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        showMessage("\n The streams are now set up! \n");
    }

    //while chatting with server
    private void whileChatting() throws IOException{
        ableToType(true);
        do{
            try{
                message = (String) input.readObject();
                showMessage("\n" + message);
            }catch(ClassNotFoundException classNotFoundException){
                showMessage("Unknown data received!");
            }
        }while(!message.equals("SERVER - END"));
    }
    private void shareInfo(){
        JButton button = new JButton("Reveal Yourself");
        button.setBackground(Color.CYAN);
        add(button, BorderLayout.EAST);

    }

    //Close connection
    private void closeConnection(){
        showMessage("\n Closing the connection!");
        ableToType(false);
        try{
            output.close();
            input.close();
            connection.close();
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

    //send message to server
    private void sendMessage(String message){
        try{
            output.writeObject(nickname+" : " + message);
            output.flush();
            showMessage("\n"+nickname+" : " + message);
        }catch(IOException ioException){
            chatWindow.append("\n Oops! Something went wrong!");
        }
    }

    //update chat window
    private void showMessage(final String message){
        SwingUtilities.invokeLater(
                new Runnable(){
                    public void run(){
                        chatWindow.append(message);
                    }
                }
        );
    }

    //allows user to type
    private void ableToType(final boolean tof){
        SwingUtilities.invokeLater(
                new Runnable(){
                    public void run(){
                        userText.setEditable(tof);
                    }
                }
        );
    }
}