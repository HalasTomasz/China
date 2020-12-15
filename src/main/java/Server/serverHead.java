package Server;

import java.net.Socket;
import java.util.ArrayList;

public class serverHead {
    Player currentPlayer;

    public serverHead(String board, int amountPlayers, ArrayList<String> rules, ArrayList<String> moves){
        try {
            serverPostman postman = new serverPostman(board, amountPlayers);
        } catch (Exception e) {
            System.out.println("Nie udalo sie otworzyc socket");
        }
    }

    public static Runnable newPlayer(Socket accept) {
        Player player = new Player(accept, "blue");
        return null;
    }
}
