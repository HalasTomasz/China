package Server;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Player implements Runnable {
    Socket socket;
    String color;

    Scanner input;
    PrintWriter output;

    public Player(Socket socket, String color) {
        this.socket = socket;
        this.color= color;
    }

    @Override
    public void run() {
        try {
            setup();
            processCommands();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (true) { //jesli gracze istniejaa to
                System.out.println("Wypisz serwerowi ze wyszedlem");
            }
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

    private void processCommands() {
        while (input.hasNextLine()) {
            var command = input.nextLine();
            if (command.startsWith("QUIT")) {
                return;
            } else if (command.startsWith("MOVE")) {
                // wyslij serverowi x, y
            }
        }
    }

}
