package Client;

import java.util.Scanner;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {


    private Socket socket;
    private Scanner in;
    private PrintWriter out;

    public Client(String serverAddress) throws Exception {

        socket = new Socket(serverAddress, 58901);
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream(), true);

    }


    public void readMessage() throws Exception {
        try {
            var response = in.nextLine();

            while (in.hasNextLine()) {
                response = in.nextLine();
                if (response.startsWith("VALID_MOVE")) {

                } else if (response.startsWith("OPPONENT_MOVED")) {

                } else if (response.startsWith("MESSAGE")) {

                } else if (response.startsWith("VICTORY")) {

                    break;
                } else if (response.startsWith("DEFEAT")) {

                    break;
                } else if (response.startsWith("TIE")) {

                    break;
                } else if (response.startsWith("OTHER_PLAYER_LEFT")) {

                    break;
                }
            }
            out.println("QUIT");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
            // zamknij GUI
        }
    }

    public void writeTouch(int x, int y){
        out.println("MOVE " + x + " " + y);

    }


    public static void main(String[] args) throws Exception {
        Client client = new Client("localhost");
        // start gui();
        client.readMessage();
    }
}