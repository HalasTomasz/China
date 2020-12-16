package Server;

public class Rule_OnlyCurrentPlayer extends Rule {


    Rule_OnlyCurrentPlayer(serverHead head) {
        super(head);
    }

    @Override
    boolean check(Player player, String command) {
        if (!head.currentPlayer.equals(player)) {
            head.newMessageWrite("NOT_YOU", player);
            return true;
        }
        return false;
    }
}
/*else if (players.size() != amountPlayers){
            player.sendMessage("WAIT");
        } else if (currentPlayer.equals(player)) {
            player.sendMessage("NOT_YOU");
        } */