package Server;

import java.lang.reflect.Constructor;
import java.net.Socket;
import java.util.ArrayList;

public class serverHead {
    String[] colors ={ "red", "yellow", "blue", "black", "purple", "green"};
    Player currentPlayer;
    ArrayList<Player> players;
    LogicBoard board;
    int amountPlayers;
    int currentX = -1;
    int currentY = -1;
    ArrayList<Rule> rules;
    ArrayList<RuleMove> moves;
    private String shape;

    public void init(LogicBoard board, int amountPlayers, ArrayList<Rule> listRule, ArrayList<RuleMove> listMove, String Shape) {
        try {
            this.amountPlayers = amountPlayers;
            this.board = board;
            this.rules = listRule;
            this.moves = listMove;
            this.shape = shape;

            serverPostman.start(this.board.getClass().getName(), amountPlayers, this);

        } catch (Exception e) {
            System.out.println("Nie udalo sie otworzyc socket");
        }
    }

    public Runnable newPlayer(Socket accept) {
        if (players.size() < amountPlayers) {
            players.add(new Player(accept, colors[players.size()], this));
        }
        return null;
    }

    public synchronized void newMessageRead(Player player, String command) {
        for(Rule rule : rules) {
            //if rule should stop
            if(rule.check(player, command)){
                return;
            }
        }
        for(Rule move : moves) {
            //if move done
            if(move.check(player, command)){
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




}
