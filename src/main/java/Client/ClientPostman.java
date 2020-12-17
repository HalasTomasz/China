package Client;

import Client.Frame.GUI;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientPostman {

    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    private Client client;

    public ClientPostman(String serverAddress, Client client) throws Exception {

        socket = new Socket(serverAddress, 58901);
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream(), true);
        this.client = client;
    }

    public void takeWelcomeMessage() throws Exception {
        try {
            var responseSetUP = in.nextLine();
            out.println("WAITING");
            while (in.hasNextLine()) {
                responseSetUP = in.nextLine();
                System.out.println(responseSetUP);
                if(client.WelcomeMassageRead(responseSetUP)){
                    break;
                }
                }
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForNewMessage() throws Exception {
        try {
            var response = in.nextLine();

            while (in.hasNextLine()) {
                response = in.nextLine();
                client.getResponse(response);;
            }
            out.println("QUIT");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();

        }
    }

    public void sendMessage(String message){
        System.out.println("TO SERVER: " + message);
        out.println(message);
    }

}
