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
    int[] currentField;
    ArrayList<Rule> rules;
    String stringConverter;
    public serverHead(String board, int amountPlayers, ArrayList<String> rules){
        try {
            this.amountPlayers = amountPlayers;

            stringConverter = serverHead.class.getPackage().getName() + "." + board;
            Class<?> clazz = Class.forName(stringConverter);
            Constructor<?> ctor = clazz.getConstructor(serverHead.class);
            this.board = (LogicBoard) ctor.newInstance(new Object[] { this });

            for(String rule: rules){
                stringConverter = serverHead.class.getPackage().getName() + "." + rule;
                clazz = Class.forName(stringConverter);
                ctor = clazz.getConstructor();
                this.rules.add((Rule) ctor.newInstance(new Object[] {}));
            }


            serverPostman.start(board, amountPlayers, this);

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
            if(rule.check(player, command)){
                return;
            }
        }
       /* for(MoveRule move : moves) {
            if(move.check(player, command)){
                //swap(currentField[0], currentField[1], x ,y);
            }
        }*/
        /*if (command.startsWith("LEFT")){
            for (Player x : players){
                x.sendMessage("SB_LEFT");
                // zacznij od nowa server
            }
        } else if (players.size() != amountPlayers){
            player.sendMessage("WAIT");
        } else if (currentPlayer.equals(player)) {
            player.sendMessage("NOT_YOU");
        } else if (command.startsWith("MOVE")) {
            try {
                move(Integer.parseInt(command.substring(5).split(";")[0]), Integer.parseInt(command.substring(5).split(";")[1]));
            }catch (Exception e){
                player.sendMessage("BAD_DATA");
            }
        }*/
    }

    public void newMessageWrite(String message, Player player){
        player.sendMessage(message);
    }

    private void swap(int old_x, int old_y, int x, int y){
        for (Player player : players){
            player.sendMessage("MOVED " +old_x + ";" + old_y + ";" + x + ";" + y);
        }
    }

  /*  private void move(int x, int y) {
        for(Rule rule : rules) {
            if(!rule.check(this, player, command)){
                return;
            }
        }
        for(MoveRule move : moves) {
            if(move.check(this, player, command)){
                swap(currentField[0], currentField[1], x ,y);
            }
        }
    }*/
}
