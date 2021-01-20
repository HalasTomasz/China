package Hiber;

public class GameData {
	private int NrGRY;
	private String Plansza;
	private int Gracze;
	private String ksztalt;

	
	public GameData(){
	}
	public GameData(String Board, int Players, String shape){
		this.Plansza=Board;
		this.Gracze=Players;
		this.ksztalt=shape;
	}
	public int getNrGRY() {
		return NrGRY;
	}
	
	public void setNrGRY(int nrGRY) {
		NrGRY = nrGRY;
	}
	
	public String getPlansza() {
		return Plansza;
	}
	
	public void setPlansza(String plansza) {
		Plansza = plansza;
	}
	
	public int getGracze() {
		return Gracze;
	}
	
	public void setGracze(int gracze) {
		Gracze = gracze;
	}
	
	public String getKsztalt() {
		return ksztalt;
	}
	
	public void setKsztalt(String ksztalt) {
		this.ksztalt = ksztalt;
	}
}
