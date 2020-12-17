package Server;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Player implements Runnable {
    Socket socket;
    String color;
    serverHead head;

    Scanner input;
    PrintWriter output;

    public Player(Socket socket, String color, serverHead head) {
        this.socket = socket;
        this.color = color;
        this.head = head;
    }

    @Override
    public void run() {
        try {
            setup();
            listenClient();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            head.newMessageRead(this, "LEFT");
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }

    private void setup() throws IOException {
        input = new Scanner(socket.getInputStream());
        output = new PrintWriter(socket.getOutputStream(), true);
        output.println("WELCOME " + color);
    }

    private void listenClient() {
        while (input.hasNextLine()) {
            var command = input.nextLine();
            head.newMessageRead(this, command);
        }
    }

    public void sendMessage(String message){
        output.println(message);
    }

    public String getColor() {
        return color;
    }

}
