package Server;

public abstract class Rule {
    serverHead head;
    Rule nextRule;
    Rule(serverHead head) {
        this.head = head;
    }
     boolean tryCheck(Player player, String command){
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
    abstract boolean check(Player player, String command);

    public void setNextRule(Rule nextRule){
        this.nextRule = nextRule;
    }
}
