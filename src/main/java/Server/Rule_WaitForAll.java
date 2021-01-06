package Server;

public class Rule_WaitForAll extends rule {

    Rule_WaitForAll(serverHead head) {
        super(head);
    }

    @Override
    boolean check(player player, String command) {
        System.out.println("Try " + this.getClass().getSimpleName());

        if(head.getAmountPlayers() != head.getPlayers().size()){
            System.out.println("Done " + this.getClass().getSimpleName());
            head.newMessageWrite("WAIT_FOR_ALL", player);
            return true;
        }
        return false;
    }
}
