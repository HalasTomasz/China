package Server;

import static java.lang.Math.abs;

public class RuleMove_SimpleWalk extends RuleMove{

    RuleMove_SimpleWalk(serverHead head) {
        super(head);
    }



    @Override
    protected boolean canDo(Player player) {
        if(board.getFieldColor(new_x, new_y).equals("white")){
            if(head.getCurrentX() % 2 == 0){
                if(new_x == head.getCurrentX()){
                    if(abs(head.getCurrentY()-new_y) == 1){
                        System.out.println("Done " + this.getClass().getSimpleName());
                        doMove();
                        head.nextPlayer();
                        return true;
                    }
                }else if(head.getCurrentX()-new_x == 1 && (head.getCurrentY()-new_y == 0 || head.getCurrentY()-new_y == -1 )){
                        System.out.println("Done " + this.getClass().getSimpleName());
                        doMove();
                        head.nextPlayer();
                        return true;
                }else if(head.getCurrentX()-new_x == -1 && (head.getCurrentY()-new_y == 0 || head.getCurrentY()-new_y == -1 )){
                        System.out.println("Done " + this.getClass().getSimpleName());
                        doMove();
                        head.nextPlayer();
                        return true;
                }
            }else {
                if(new_x == head.getCurrentX()){
                    if(abs(head.getCurrentY()-new_y) == 1){
                        System.out.println("Done " + this.getClass().getSimpleName());
                        doMove();
                        head.nextPlayer();
                        return true;
                    }
                }else if(head.getCurrentX()-new_x == 1 && (head.getCurrentY()-new_y == 0 || head.getCurrentY()-new_y == 1 )){
                    System.out.println("Done " + this.getClass().getSimpleName());
                    doMove();
                    head.nextPlayer();
                    return true;
                }else if(head.getCurrentX()-new_x == -1 && (head.getCurrentY()-new_y == 0 || head.getCurrentY()-new_y == 1 )){
                    System.out.println("Done " + this.getClass().getSimpleName());
                    doMove();
                    head.nextPlayer();
                    return true;
                }
            }
        }

        System.out.println("Failed " + this.getClass().getSimpleName());
        return false;
        }
}





