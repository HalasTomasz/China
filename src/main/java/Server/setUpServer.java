package Server;

import java.util.ArrayList;

/**
 * allow to set game setting, prepare settings and open server for game
 */
public class setUpServer {

	private static serverHead game = new serverHead();
	public static void createNewGame(logicBoard board, int howManyPlayers, String shape, ArrayList<rule> listRule, ArrayList<RuleMove> listMove){

		for(RuleMove ruleMove: listMove){
			ruleMove.init(board);
		}

		try {
			game.start(board, howManyPlayers, listRule, shape);

			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static serverHead createNewGameTest(logicBoard board, int howManyPlayers, String shape, ArrayList<rule> listRule, ArrayList<RuleMove> listMove, serverHead game){
		for(RuleMove ruleMove: listMove){
			ruleMove.init(board);
		}

		try {
			game.startTest(board, howManyPlayers, listRule, shape);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return game;
	}

	public static void openMenuWindow(){
		new menu(game);
	}
}
