package Client;

import Client.Frame.GUI;

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

        readWelcomeMessage();
        readMessage();

    }

    public void readWelcomeMessage() throws Exception {
        try {
            var responseSetUP = in.nextLine();
            out.println("WAITNG");
            while (in.hasNextLine()) {
                responseSetUP = in.nextLine();
                if (responseSetUP.startsWith("WAIT_FOR_OTHER ")) {
                    String[] tmp = responseSetUP.substring(15).split(";");
                    GUI gui = new GUI(tmp[0], tmp[1], tmp[2], tmp[3]);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void readMessage() throws Exception {
        try {
            var response = in.nextLine();

            while (in.hasNextLine()) {
                response = in.nextLine();
                getResponse(response);
            }
            out.println("QUIT");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
            // zamknij GUI
        }
    }

    private void getResponse(String response){
        //if
        //else if
        //else System.out.println(response);
        //wysyła do GUI wiadomosc co ma zrobic

    }
    public void writeMessage(String message){
        out.println(message);

    }






}