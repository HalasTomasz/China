package Server;

/**
 * rule when sb try to clic but not a current
 */
public class Rule_OnlyCurrentPlayer extends rule {


    Rule_OnlyCurrentPlayer(serverHead head) {
        super(head);
    }

    /**
     * rule when sb try to clic but not a current
     * @param player who done action
     * @param command what action
     * @return true if player not current
     */
    @Override
    protected boolean check(player player, String command) {
        System.out.println("Try " + this.getClass().getSimpleName());
        if (!head.currentPlayer.equals(player)) {
            System.out.println("Done " + this.getClass().getSimpleName());
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