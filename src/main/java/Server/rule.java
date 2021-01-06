package Server;

/**
 *
 */
public abstract class rule {
    serverHead head;
    rule nextRule;
    rule(serverHead head) {
        this.head = head;
    }

    /**
     * checking rule is good for concret action
     * @param player who done sth
     * @param command what he said
     * @return true needs to stop
     */
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

    /**
     * specific whats action rule can claim
     * @param player who done action
     * @param command what action
     * @return true if rule whats to stop chain
     */
    abstract boolean check(player player, String command);

    /**
     * set nesxt Rule
     * @param nextRule next rule in chain
     */
    public void setNextRule(rule nextRule){
        this.nextRule = nextRule;
    }
}
