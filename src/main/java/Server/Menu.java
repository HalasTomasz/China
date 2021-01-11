package Server;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * gui to choose rulers
 */
public class Menu extends JFrame implements ActionListener{
	private ArrayList<String> commonAnswers = new ArrayList<>();
	JLabel rul, play, boar,shape,mov;
	JCheckBox rules;
	JCheckBox player,player2,player3,player4;
	JCheckBox board1;
	JCheckBox shapes1,shapes2;
	JCheckBox move1;
	JButton b;
	ServerHead game;

	Menu(ServerHead game){
		this.game = game;
		rul=new JLabel("Zasady:");
		rul.setBounds(40,100,100,20);
		rules=new JCheckBox("Podstawowy");
		rules.setBounds(200,100,150,20);
		
		play=new JLabel("Gracze:");
		play.setBounds(40,200,100,20);
		player=new JCheckBox("2");
		player.setBounds(200,200,150,20);
		player2=new JCheckBox("3");
		player2.setBounds(400,200,150,20);
		player3=new JCheckBox("4");
		player3.setBounds(600,200,150,20);
		player4=new JCheckBox("6");
		player4.setBounds(800,200,150,20);
		
		boar=new JLabel("Plansza:");
		boar.setBounds(40,300,100,20);
		board1=new JCheckBox("Classical");
		board1.setBounds(200,300,150,20);
		
		shape=new JLabel("Ksztalt pol:");
		shape.setBounds(40,400,100,20);
		shapes1=new JCheckBox("Kolo");
		shapes1.setBounds(200,400,150,20);
		shapes2=new JCheckBox("Prostokat");
		shapes2.setBounds(400,400,150,20);
		
		mov=new JLabel("Ruch:");
		mov.setBounds(40,500,100,20);
		move1=new JCheckBox("Ruchy podstawowe");
		move1.setBounds(200,500,150,20);
		
		b=new JButton("Utworz");
		b.setBounds(500,600,80,30);
		b.addActionListener(this);
		
		add(rul);add(rules);
		add(play);add(player);add(player2);add(player3);add(player4);
		add(boar);add(board1);
		add(shape);add(shapes1);add(shapes2);
		add(mov);add(move1);
		add(b);
		
		setSize(1000,680);
		setLayout(null);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	/**
	 * set rulers and check correctness
	 * @param e event
	 */
	public void actionPerformed(ActionEvent e){
		
		ArrayList<Rule> listRule = new ArrayList<>();
		int howManyPlayers = 2;
		ArrayList<LogicBoard> whatsBoard = new ArrayList<>();
		ArrayList<String> shape = new ArrayList<>();
		ArrayList<RuleMove> listMove = new ArrayList<>();
		
		if(rules.isSelected()){
			listRule.add(new RuleSayHello(game));
			listRule.add(new RuleSBLeft(game));
			listRule.add(new RuleWaitForAll(game));
			listRule.add(new RuleOnlyCurrentPlayer(game));
		}
		
		if(player.isSelected()){
			howManyPlayers = 2;
		}
		if(player2.isSelected()){
			howManyPlayers = 3;
		}
		if(player3.isSelected()){
			howManyPlayers = 4;
		}
		if(player4.isSelected()){
			howManyPlayers = 6;;
		}
		
		if(board1.isSelected()){
			switch (howManyPlayers){
				case 2:
					whatsBoard.add(new LogicBoardClassical2P());
					break;
				case 3:
					whatsBoard.add(new LogicBoardClassical3P());
					break;
				case 4:
					whatsBoard.add(new LogicBoardClassical4P());
					break;
				case 6:
					whatsBoard.add(new LogicBoardClassical6P());
					break;
			}
		}
		
		if(shapes1.isSelected()){
			shape.add("Circle");
		}
		if(shapes2.isSelected()){
			shape.add("Rectangle");
		}
		
		if(move1.isSelected()){
			listMove.add(new RuleMoveNoActiveField(game));
			listMove.add(new RuleMoveSkipTurn(game));
			listMove.add(new RuleMoveSimpleWalk(game));
			listMove.add(new RuleMoveSimpleJump(game));
			listMove.add(new RuleMoveToHause(game));
		}

		if(listRule.isEmpty()) System.exit(0);
		if(whatsBoard.size()!=1) System.exit(0);
		if(shape.size()!=1) System.exit(0);
		if(listMove.isEmpty()) System.exit(0);

		listRule.addAll(listMove);
		dispose();
		SetUpServer.createNewGame(whatsBoard.get(0), howManyPlayers, shape.get(0), listRule, listMove);
	}
}
