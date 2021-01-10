package Server;

import java.net.Socket;
import java.util.ArrayList;

/**
 * main thinker, welcome players, COMMAND game's settings, communicat with players and analyze their words
 */
public class serverHead {
    public String[] colors ={ "red", "yellow", "blue", "black", "purple", "green"};
    public ArrayList<rule> bannedRules = new ArrayList<rule>();
    public ArrayList<player> players = new ArrayList<player>();
    public logicBoard board;
    public int currentX = -1;
    public int currentY = -1;
    public player currentPlayer;
    public rule firstRule;

    private String shape;
    private int amountPlayers;
    private int currentColor = 0;


    /**
     * init server
     * @param board on whats board we are playing
     * @param amountPlayers how many players
     * @param listRule chain of rules
     * @param shape what's field's shape
     * @throws Exception if sth wrong
     */
    public void start(logicBoard board, int amountPlayers, ArrayList<rule> listRule, String shape) throws Exception {
        this.amountPlayers = amountPlayers;
        this.board = board;
        this.shape = shape;

        for(int tmp = 0; tmp < listRule.size()-1; tmp++){
            listRule.get(tmp).setNextRule(listRule.get(tmp+1));
        }
        firstRule = listRule.get(0);


        serverPostman.start(amountPlayers, this);

    }

    /**
     * when sb wants to join
     * @param accept socket to talk
     * @return null if everything fine
     */
    public Runnable newPlayer(Socket accept) {


        if (players.size() < amountPlayers) {
            players.add(new player(accept, colors[players.size()], this));
            if (players.size() == 1){
                currentPlayer = players.get(0);
            }
            return players.get(players.size() - 1);
        }
        return null;
    }

    /**
     * read when sb write
     * @param player who have written
     * @param command what have written
     */
    public synchronized void newMessageRead(player player, String command) {
        firstRule.tryCheck(player, command);
    }

    /**
     * to write messages
     * @param message message to deliver
     * @param player to whom deliver
     */
    public void newMessageWrite(String message, player player){
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
    public ArrayList<player> getPlayers(){
        return players;
    }
    public String getShape() {return shape; }
    public int getAmountPlayers() { return amountPlayers;}
    public void setAmountPlayers(int amount) { amountPlayers = amount;}


    /**
     * when rule said that next player should play
     */
    public void nextPlayer() {

        setCurrentX(-1);
        setCurrentY(-1);

        currentColor = (currentColor + 1) % amountPlayers;

        for(Server.player player: players){
            if(player.getColor().equals(colors[currentColor])){
                currentPlayer = player;
                for(player playerr: players) {
                    newMessageWrite("NOW " + colors[currentColor], playerr);
                }
                break;
            }
        }
    }

    public void stop() {
        try {
            serverPostman.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
