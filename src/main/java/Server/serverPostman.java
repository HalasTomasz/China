package Server;
import java.net.ServerSocket;
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


    public static void start(String board, int amountPlayers, serverHead head) throws Exception {
        var listener = new ServerSocket(58901);
            System.out.println("Cheese Cheeckers Server is Running...");
            var pool = Executors.newFixedThreadPool(200);

            while (true) {
                for(int x = 0; x<amountPlayers; x++){

                    pool.execute(head.newPlayer(listener.accept()));

                }
            }

    }
}
