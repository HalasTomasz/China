package Server;

public abstract class RuleMove extends Rule {
    int new_x;
    int new_y;
    RuleMove(serverHead head) {
        super(head);
    }
    @Override
    boolean check(Player player, String command){
        if (command.startsWith("MOVE")) {
            try {
                new_x = Integer.parseInt(command.substring(5).split(";")[0]);
                new_y = Integer.parseInt(command.substring(5).split(";")[1]);
                return canDo();
            }catch (Exception e){
                head.newMessageWrite("BAD_DATA", player);
            }
        }
        return false;

    }

    protected abstract boolean canDo();

}
