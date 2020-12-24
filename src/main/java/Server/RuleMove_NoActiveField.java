package Server;

public class RuleMove_NoActiveField extends RuleMove {

    RuleMove_NoActiveField(serverHead head) {
        super(head);
    }

    @Override
    protected boolean canDo(Player player) {
        System.out.println("Try " + this.getClass().getSimpleName());
        if (head.getCurrentX() == -1 && head.getCurrentY() == -1) {
            if (board.getFieldColor(new_x, new_y) == "white"){
                System.out.println("Done " + "Cliced white without active");

            } else {
                System.out.println("Done " + this.getClass().getSimpleName());
                head.setCurrentX(new_x);
                head.setCurrentY(new_y);
                head.newMessageWrite("ACTIVE " + head.getCurrentX() + ";" + head.getCurrentY(), player);
            }
            return true;
        }
        return false;
    }
}
