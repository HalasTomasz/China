package Server;

import java.net.Socket;
import java.util.ArrayList;

public class serverHead {
    public String[] colors ={ "red", "yellow", "blue", "black", "purple", "green"};
    ArrayList<Rule> bannedRules = new ArrayList<Rule>();
    String shape;
    ArrayList<Player> players = new ArrayList<Player>();
    LogicBoard board;

    Rule firstRule;

    int amountPlayers;
    int currentX = -1;
    int currentY = -1;
    int currentColor = 0;
    Player currentPlayer;
    boolean endFlag;

    public void start(LogicBoard board, int amountPlayers, ArrayList<Rule> listRule, String shape) throws Exception {
        this.amountPlayers = amountPlayers;
        this.board = board;
        this.shape = shape;
        for(int tmp = 0; tmp < listRule.size()-1; tmp++){
            listRule.get(tmp).setNextRule(listRule.get(tmp+1));
        }
        firstRule = listRule.get(0);

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
        firstRule.tryCheck(player, command);
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
