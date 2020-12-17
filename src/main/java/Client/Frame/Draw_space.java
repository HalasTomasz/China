package Client.Frame;

import Client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Draw_space extends JPanel {
	private final Land[][] lands;
	private final ArrayList<int[]> createTables;
	private String playerColor;
	private final int Players;
	private final int sizeOfFieldComamnds;
	ArrayList<Integer> Movements=new ArrayList<>();
	int[] tablica;
	private Client client;

	
	public Draw_space(Land[][] lands, ArrayList<int[]> Poles, String mycolor, int Players, int sizeOfFieldComamnds, Client client) {
		this.client=client;
		this.lands = lands;
		this.createTables=Poles;
		this.playerColor=mycolor;
		this.sizeOfFieldComamnds=sizeOfFieldComamnds;
		this.Players=Players;
		setColor();
		this.addMouseListener(new MymouseAdapter());
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawing(g);
	}
	
	private void drawing(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(2));
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));
		
		for (int[] createTable : createTables) {
			tablica = createTable;
			
			if (tablica[0] == 1) {
				for (int h = 3; h <= tablica.length - 1; h = h + 2) {
					for (int i = tablica[h]; i < tablica[2]; i++) {
						
						g2.setPaint(lands[i][tablica[h + 1]].getcolor());
						g2.fill(lands[i][tablica[h + 1]]);
						g2.setPaint(Color.RED);
						g2.draw(lands[i][tablica[h + 1]]);
					}
					
				}
			} else {
				for (int h = 3; h <= tablica.length - 1; h = h + 2) {
					for (int i = tablica[h]; i >= tablica[2]; i--) {
						
						g2.setPaint(lands[i][tablica[h + 1]].getcolor());
						g2.fill(lands[i][tablica[h + 1]]);
						g2.setPaint(Color.RED);
						g2.draw(lands[i][tablica[h + 1]]);
					}
				}
			}
		}
	}
	
	void setColor(){
		ArrayList<Color> colors = new ArrayList<>();
		ArrayList<int[]> houses = new ArrayList<>();
		int number=0;
		colors.add(Color.RED);
		colors.add(Color.YELLOW);
		colors.add(Color.BLUE);
		colors.add(Color.BLACK);
		colors.add(Color.PINK);
		colors.add(Color.GREEN);
		
		if(Players==2){
			houses.add(createTables.get(sizeOfFieldComamnds));
			houses.add(createTables.get(sizeOfFieldComamnds+1));
		}
		else if(Players==3){
			houses.add(createTables.get(sizeOfFieldComamnds));
			houses.add(createTables.get(sizeOfFieldComamnds+4));
			houses.add(createTables.get(sizeOfFieldComamnds+5));
		}
		else if(Players==4){
			houses.add(createTables.get(sizeOfFieldComamnds+5));
			houses.add(createTables.get(sizeOfFieldComamnds+2));
			houses.add(createTables.get(sizeOfFieldComamnds+4));
			houses.add(createTables.get(sizeOfFieldComamnds+3));
		}
		else{
			houses.add(createTables.get(sizeOfFieldComamnds+5));
			houses.add(createTables.get(sizeOfFieldComamnds+2));
			houses.add(createTables.get(sizeOfFieldComamnds+4));
			houses.add(createTables.get(sizeOfFieldComamnds+3));
			houses.add(createTables.get(sizeOfFieldComamnds));
			houses.add(createTables.get(sizeOfFieldComamnds+1));
		}
		
		for (int[] house : houses) {
			tablica = house;
			
			if (tablica[0] == 1) {
				for (int h = 3; h <= tablica.length - 1; h = h + 2) {
					for (int i = tablica[h]; i < tablica[2]; i++) {
						lands[i][tablica[h + 1]].set_color(colors.get(number));
					}
				}
			} else {
				for (int h = 3; h <= tablica.length - 1; h = h + 2) {
					for (int i = tablica[h]; i >= tablica[2]; i--) {
						lands[i][tablica[h + 1]].set_color(colors.get(number));
					}
				}
			}
			number++;
		   }
		}
		
	Color colorDecoder(String color) {
		
		if (color.equals("red")) {
			return Color.RED;
		}
		else if (color.equals("blue")) {
			return Color.BLUE;
		}
		else if (color.equals("black")) {
			return Color.BLACK;
		}
		else if (color.equals("yellow")) {
			return Color.YELLOW;
		}
		else if (color.equals("green")) {
			return Color.GREEN;
		}
		else if (color.equals("pink")) {
			return Color.PINK;
		}else if (color.equals("white")){
			return Color.WHITE;
		}
		return Color.WHITE;
	}
	public void sendInfo(){
		int x,y;
		x=Movements.get(0);
		y=Movements.get(1);
		String Data="MOVE "+x+";"+y;
		client.writeMessage(Data);
		Movements.clear();
	}
	public void change(int x, int y, String color){
		lands[x][y].set_color(colorDecoder(color));
		repaint();

	}
	
	class MymouseAdapter extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			Point point = new Point(e.getX(), e.getY());
			
			for (int i = 0; i < lands.length; i++) {
				for(int j = 0; j< lands[i].length; j++)
					if (lands[i][j].isHIt(point)) {
						Movements.add(i);
						Movements.add(j);
						
						if(Movements.size()==2){
							
							sendInfo();
							break;
						}
					}
			}
		}
		
		
		public void changeColor(){
			int oldX,oldY,newX,newY;
			Color temporary;
			
			oldY=Movements.get(0);
			oldX=Movements.get(1);
			newY=Movements.get(2);
			newX=Movements.get(3);
			//dodaj
			temporary= lands[oldY][oldX].getcolor();
			lands[oldY][oldX].set_color(Color.white);
			lands[newY][newX].set_color(temporary);
			
			Movements.clear();
		}
	}
}
	
	

