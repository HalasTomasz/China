package Server;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Executors;

/**
 * A server for a multi-player tic tac toe game. Loosely based on an example in
 * Deitel and Deitel’s “Java How to Program” book. For this project I created a
 * new application-level protocol called TTTP (for Tic Tac Toe Protocol), which
 * is entirely plain text. The messages of TTTP are:
 *
 * Client -> Server MOVE <n> QUIT
 *
 * Server -> Client WELCOME <char> VALID_MOVE OTHER_PLAYER_MOVED <n>
 * OTHER_PLAYER_LEFT VICTORY DEFEAT TIE MESSAGE <text>
 */
public class serverPostman {


    public  serverPostman(String board, int amountPlayers) throws Exception {
        try (var listener = new ServerSocket(58901)) {
            System.out.println("Cheese Cheeckers Server is Running...");
            var pool = Executors.newFixedThreadPool(200);
            while (true) {
                for(int x = 0; x<amountPlayers; x++){
                    pool.execute(serverHead.newPlayer(listener.accept()));
                }
 //               pool.execute(serverHead.newPlayer(listener.accept()));
            }
        }catch (Exception e) {
            System.out.println("Nie udalo sie otworzyc socket");
        }
    }
}
