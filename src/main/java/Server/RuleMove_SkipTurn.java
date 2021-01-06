package Server;

public class RuleMove_SkipTurn extends RuleMove {


    RuleMove_SkipTurn(serverHead head) {
        super(head);
    }

    @Override
    protected boolean canDo(player player) {
        System.out.println("Try " + this.getClass().getSimpleName());
        if(head.getCurrentX() == new_x && new_y == head.getCurrentY()){
            System.out.println("Done " + this.getClass().getSimpleName());
            head.newMessageWrite("CHANGE " + head.currentX + ";" + head.currentY + ";" + head.currentPlayer.getColor(), player);
            head.nextPlayer();
            head.setCurrentX(-1);
            head.setCurrentY(-1);
            return true;
        }
        return false;
    }
}
