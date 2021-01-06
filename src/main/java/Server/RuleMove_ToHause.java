package Server;


import static java.lang.Math.abs;

/**
 * rule anty-blocking-base
 */
public class RuleMove_ToHause extends RuleMove{

    RuleMove_ToHause(serverHead head) {
        super(head);
    }


    /**
     * when enemy block hause can swich cheeckers when close hause
     * @param player who done sth
     * @return true if cheeckers swiched
     */
    @Override
    protected boolean canDo(player player) {
        System.out.println("Try " + this.getClass().getSimpleName());

        if(abs(head.currentX-new_x) <=1 && abs(head.currentY-new_y) <= 1 && board.getFieldHause(new_x, new_y).equals(player.getColor()) && !board.getFieldColor(new_x, new_y).equals("white") && !board.getFieldColor(new_x, new_y).equals(player.getColor())){
            System.out.println("Done " + this.getClass().getSimpleName());
            switchFields();
            head.nextPlayer();
            return true;
        }

        System.out.println("Failed " + this.getClass().getSimpleName());
        return false;
    }

}





