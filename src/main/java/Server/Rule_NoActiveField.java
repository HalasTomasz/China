package Server;

public class Rule_NoActiveField extends Rule{

    Rule_NoActiveField(serverHead head) {
        super(head);
    }

    @Override
    boolean check(Player player, String command) {
        System.out.println("Try " + this.getClass().getSimpleName());
        if (command.startsWith("MOVE") && head.getCurrentX() == -1 && head.getCurrentY() == -1) {
            System.out.println("Done " + this.getClass().getSimpleName());
            try {

                head.setCurrentX(Integer.parseInt(command.substring(5).split(";")[0]));
                head.setCurrentY(Integer.parseInt(command.substring(5).split(";")[1]));
                //head.newMessageWrite("ACTIVE " + head.getCurrentX() + ";" + head.getCurrentY(), player);
                return true;
            }catch (Exception e){
                player.sendMessage("BAD_DATA");
            }
        }
        return false;
    }
}
