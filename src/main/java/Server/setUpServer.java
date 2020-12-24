package Server;

import java.util.ArrayList;

public class setUpServer {

	private static serverHead game = new serverHead();;
	public static void createNewGame(LogicBoard board, int howManyPlayers, String shape, ArrayList<Rule> listRule, ArrayList<RuleMove> listMove){

		for(RuleMove ruleMove: listMove){
			ruleMove.init(board);
		}

		try {
			game.start(board, howManyPlayers, listRule, shape);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void openMenuWindow(){
		new Menu(game);
	}
}
