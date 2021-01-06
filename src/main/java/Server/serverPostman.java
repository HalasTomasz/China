package Server;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

/**
 * listener on socket for new players
 */
public class serverPostman {

    /**
     * listen on socket for new players
     * @param amountPlayers how many should be welcomed
     * @param head whats server wants to talk
     * @throws Exception if sth wrong
     */
    public static void start( int amountPlayers, serverHead head) throws Exception {
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
