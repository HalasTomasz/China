package Server;

public abstract class rule {
    serverHead head;
    rule nextRule;
    rule(serverHead head) {
        this.head = head;
    }
     boolean tryCheck(player player, String command){
        if (head.bannedRules.contains(this)){
            return nextRule.tryCheck(player, command);
        }
        if(check(player, command)){
            return true;
        }else{
            if(nextRule != null) {
                return nextRule.tryCheck(player, command);
            }else{
                return true;
            }
        }
    }
    abstract boolean check(player player, String command);

    public void setNextRule(rule nextRule){
        this.nextRule = nextRule;
    }
}
