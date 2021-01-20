package Server;

import java.util.ArrayList;

public class RuleReplay extends Rule {
    RuleReplay(ServerHead head) {
        super(head);
    }
    @Override
    protected boolean check(Player player, String command) {
        if(command.startsWith("MOVE -1;-1")){
            ArrayList<String> tmp = DataBase.getInstance().backMove();
            if(tmp.get(0) == "None") {
                head.newMessageWrite("BEGIN" ,player);
            }
            tmp.forEach((something) -> head.newMessageWrite(something ,player));
            return true;
        }else if(command.startsWith("MOVE 1;1")){
            ArrayList<String> tmp = DataBase.getInstance().nextMove();
            if(tmp.get(0) == "None") {
                head.newMessageWrite("END" ,player);
            }
            tmp.forEach((something) -> head.newMessageWrite(something ,player));
            return true;
        }
        return true;
    }
}
