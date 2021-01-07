package Server;

/**
 * if sb left game say to everybody
 */
public class Rule_SBLeft extends rule {
    Rule_SBLeft(serverHead head) {
        super(head);
    }

    /**
     * if sb left game say to everybody
     * @param player who done action
     * @param command what action
     * @return true if sb left
     */
    @Override
    protected boolean check(player player, String command) {
        System.out.println("Try " + this.getClass().getSimpleName());
        if (command.startsWith("LEFT")){
            System.out.println("Done " + this.getClass().getSimpleName());
            for (Server.player x : head.players){
                head.newMessageWrite("SB_LEFT", x);

            }
            return true;
        }
        return false;
    }
}
