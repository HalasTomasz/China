package Server;

public class Rule_OnlyCurrentPlayer extends Rule {


    Rule_OnlyCurrentPlayer(serverHead head) {
        super(head);
    }

    @Override
    boolean check(Player player, String command) {
        return false;
    }
}
/*else if (players.size() != amountPlayers){
            player.sendMessage("WAIT");
        } else if (currentPlayer.equals(player)) {
            player.sendMessage("NOT_YOU");
        } */