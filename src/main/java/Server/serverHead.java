package Server;

import java.lang.reflect.Constructor;
import java.net.Socket;
import java.util.ArrayList;

public class serverHead {
    public String[] colors ={ "red", "yellow", "blue", "black", "purple", "green"};
    ArrayList<Rule> bannedRules = new ArrayList<Rule>();
    ArrayList<Rule> rules;
    ArrayList<RuleMove> moves;
    String shape;
    ArrayList<Player> players = new ArrayList<Player>();
    LogicBoard board;

    int amountPlayers;
    int currentX = -1;
    int currentY = -1;
    int currentColor = 0;
    Player currentPlayer;

 //   private int amountMoves = 0;

    public void start(LogicBoard board, int amountPlayers, ArrayList<Rule> listRule, ArrayList<RuleMove> listMove, String shape) throws Exception {

            this.amountPlayers = amountPlayers;
            this.board = board;
            this.rules = listRule;
            this.moves = listMove;
            this.shape = shape;

            serverPostman.start(this.board.getClass().getSimpleName(), amountPlayers, this);
    }

    public Runnable newPlayer(Socket accept) {
        if (players.size() < amountPlayers) {
            players.add(new Player(accept, colors[players.size()], this));
            if (players.size() == 1){
                currentPlayer = players.get(0);
            }
            return players.get(players.size() - 1);
        }
        return null;
    }

    public synchronized void newMessageRead(Player player, String command) {
        for(Rule rule : rules) {
            if(rule.tryCheck(player, command)){
                return;
            }
        }
        for(RuleMove move : moves) {
            if(move.tryCheck(player, command)){
                return;
            }
        }
    }

    public void newMessageWrite(String message, Player player){
        player.sendMessage(message);
    }
    public int getCurrentX(){
        return currentX;
    }
    public int getCurrentY(){
        return currentY;
    }
    public void setCurrentX(int newX){
        currentX = newX;
    }
    public void setCurrentY(int newY){
        currentY = newY;
    }
    public ArrayList<Player> getPlayers(){
        return players;
    }
    public String getShape() {return shape; }
    public int getAmountPlayers() { return amountPlayers;}
    public String[] getColors() { return colors;}


    public void nextPlayer() {

        setCurrentX(-1);
        setCurrentY(-1);

        currentColor = (currentColor + 1) % amountPlayers;

        for(Player player: players){
            if(player.getColor().equals(colors[currentColor])){
                currentPlayer = player;
                break;
            }
        }
    }
}
