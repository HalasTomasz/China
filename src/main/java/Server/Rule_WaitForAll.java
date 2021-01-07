package Server;

/**
 * check is all players to play
 */
public class Rule_WaitForAll extends rule {

    public Rule_WaitForAll(serverHead head) {
        super(head);
    }

    /**
     * check is all players to play
     * @param player who done action
     * @param command what action
     * @return true if there not enought players
     */
    @Override
    protected boolean check(player player, String command) {
        System.out.println("Try " + this.getClass().getSimpleName());

        if(head.getAmountPlayers() != head.getPlayers().size()){
            System.out.println("Done " + this.getClass().getSimpleName());
            head.newMessageWrite("WAIT_FOR_ALL", player);
            return true;
        }
        return false;
    }
}
