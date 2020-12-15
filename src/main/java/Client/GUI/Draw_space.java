package Client.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Draw_space extends JPanel {
	private final Land[][] shapes;
	private SetBoardShape setBoardShape = new SetBoardShape();
	ArrayList<int[]> createTables;
	ArrayList<Integer> Movements=new ArrayList<>();
	int[] tablica;
	int number=0;
	Point point;
	int sizeOfFieldComamnds;
	
	public Draw_space(Land[][] fields, ArrayList<int[]> domki) {
		this.addMouseListener(new MymouseAdapter());
		
		this.shapes = fields;
		createTables = setBoardShape.returnBoardShape("star").returnTables();
		sizeOfFieldComamnds = createTables.size();
		System.out.println(sizeOfFieldComamnds);
		createTables.addAll(domki);
		
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
		
		for (int j = 0; j < createTables.size(); j++) {
			tablica = createTables.get(j);
			
			if (tablica[0] == 1 || tablica[0] == -1) {
				for (int h = 3; h <= tablica.length - 1; h = h + 2) {
					for (int i = tablica[h]; i < tablica[2]; i++) {
						if(j>sizeOfFieldComamnds-1 && number<1){
							System.out.println("Help2");
							shapes[i][tablica[h + 1]].set_color(Color.cyan);
						}
						g2.setPaint(shapes[i][tablica[h + 1]].getcolor());
						g2.fill(shapes[i][tablica[h + 1]]);
						g2.setPaint(Color.RED);
						g2.draw(shapes[i][tablica[h + 1]]);
					}
					
				}
			} else {
				for (int h = 3; h <= tablica.length - 1; h = h + 2) {
					for (int i = tablica[h]; i >= tablica[2]; i--) {
						//PORAW
						if(j>sizeOfFieldComamnds-1 && number<1){
							System.out.println("Help");
							shapes[i][tablica[h + 1]].set_color(Color.cyan);
						}
						
						g2.setPaint(shapes[i][tablica[h + 1]].getcolor());
						g2.fill(shapes[i][tablica[h + 1]]);
						g2.setPaint(Color.RED);
						g2.draw(shapes[i][tablica[h + 1]]);
					}
				}
			}
		}
		number++;
	}
	
	class MymouseAdapter extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			point = new Point(e.getX(), e.getY());
			
			for (int i = 0; i < shapes.length; i++) {
				for(int j=0; j<shapes[i].length;j++)
					if (shapes[i][j].isHIt(point)) {
						Movements.add(i);
						Movements.add(j);
						
						if(Movements.size()==4){
							changeColor();
							break;
						}
						}
					}
			repaint();
		}
		public void changeColor(){
			int oldX,oldY,newX,newY;
			Color temporary;
			
			oldY=Movements.get(0);
			oldX=Movements.get(1);
			newY=Movements.get(2);
			newX=Movements.get(3);
			//dodaj
			temporary=shapes[oldY][oldX].getcolor();
			shapes[oldY][oldX].set_color(Color.white);
			shapes[newY][newX].set_color(temporary);
			
			Movements.clear();
		}
	}
}
	
	

