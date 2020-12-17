package Server;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Menu extends JFrame implements ActionListener{
	private final ArrayList<String> commonAnswers = new ArrayList<>();
	private int sizeOfFirst;
	JLabel rul, play, boar,shape,mov;
	JCheckBox rules,rules2,rules3;
	JCheckBox player,player2,player3,player4;
	JCheckBox board1,board2;
	JCheckBox shapes1,shapes2;
	JCheckBox move1,move2,move3;
	JButton b;
	Menu(){
		rul=new JLabel("Zasady:");
		rul.setBounds(40,100,100,20);
		rules=new JCheckBox("Zasada n1");
		rules.setBounds(200,100,150,20);
		rules2=new JCheckBox("Zasada n2");
		rules2.setBounds(400,100,150,20);
		rules3=new JCheckBox("Zasada n3");
		rules3.setBounds(600,100,150,20);
		
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
		board2=new JCheckBox("Kwadrat");
		board2.setBounds(400,300,150,20);
		
		shape=new JLabel("Ksztalt pol:");
		shape.setBounds(40,400,100,20);
		shapes1=new JCheckBox("Kolo");
		shapes1.setBounds(200,400,150,20);
		shapes2=new JCheckBox("Prostokat");
		shapes2.setBounds(400,400,150,20);
		
		mov=new JLabel("Ruch:");
		mov.setBounds(40,500,100,20);
		move1=new JCheckBox("Ruch1");
		move1.setBounds(200,500,150,20);
		move2=new JCheckBox("Ruch2");
		move2.setBounds(400,500,150,20);
		move3=new JCheckBox("Ruch3");
		move3.setBounds(400,500,150,20);
		
		b=new JButton("Utworz");
		b.setBounds(500,600,80,30);
		b.addActionListener(this);
		
		add(rul);add(rules);add(rules2);add(rules3);
		add(play);add(player);add(player2);add(player3);add(player4);
		add(boar);add(board1);add(board2);
		add(shape);add(shapes1);add(shapes2);
		add(mov);add(move1);add(move2);add(move3);
		add(b);
		
		setSize(1000,680);
		setLayout(null);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void returnArraylist(){
		Mainnnn.maine(commonAnswers,sizeOfFirst);
	}
	public void actionPerformed(ActionEvent e){
		
		ArrayList<String> rul = new ArrayList<>();
		ArrayList<String> play = new ArrayList<>();
		ArrayList<String> boar = new ArrayList<>();
		ArrayList<String> shape = new ArrayList<>();
		ArrayList<String> mov = new ArrayList<>();
		
		if(rules.isSelected()){
			rul.add("Zasada nr1");
		}
		if(rules2.isSelected()){
			rul.add("Zasada nr2");
		}
		if(rules3.isSelected()){
			rul.add("Zasada nr3");
		}
		
		if(player.isSelected()){
			play.add("2");
		}
		if(player2.isSelected()){
			play.add("3");
		}
		if(player3.isSelected()){
			play.add("4");
		}
		if(player4.isSelected()){
			play.add("6");
		}
		
		if(board1.isSelected()){
			boar.add("Classical");
		}
		if(board2.isSelected()){
			boar.add("Square");
		}
		
		if(shapes1.isSelected()){
			shape.add("Circle");
		}
		if(shapes2.isSelected()){
			shape.add("Rectangle");
		}
		
		if(move1.isSelected()){
			mov.add("Ruch1");
		}
		if(move2.isSelected()){
			mov.add("Ruch2");
		}
		if(move3.isSelected()){
			mov.add("Ruch3");
		}
		
		if(rul.isEmpty()) System.exit(0);
		if(play.size()!=1) System.exit(0);
		if(boar.size()!=1) System.exit(0);
		if(shape.size()!=1) System.exit(0);
		if(mov.isEmpty()) System.exit(0);
		
		commonAnswers.addAll(rul);
		commonAnswers.addAll(play);
		commonAnswers.addAll(boar);
		commonAnswers.addAll(shape);
		commonAnswers.addAll(mov);
		sizeOfFirst=rul.size();
		returnArraylist();
		dispose();
	}
}
