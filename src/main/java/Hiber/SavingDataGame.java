package Hiber;

public class SavingDataGame {
	private int ID;
	private int NrGry;
	private int NrRuchu;
	private int NrRozkazu;
	private String info;
	
	public SavingDataGame(){
	
	}
	
	public SavingDataGame(int nrgry,int nrruchu,int nrrozkazu,String info){
		this.NrGry=nrgry;
		this.NrRuchu=nrruchu;
		this.NrRozkazu=nrrozkazu;
		this.info=info;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public int getNrGry() {
		return NrGry;
	}
	
	public void setNrGry(int nrGry) {
		NrGry = nrGry;
	}
	
	public int getNrRuchu() {
		return NrRuchu;
	}
	
	public void setNrRuchu(int nrRuchu) {
		NrRuchu = nrRuchu;
	}
	
	public int getNrRozkazu() {
		return NrRozkazu;
	}
	
	public void setNrRozkazu(int nrRozkazu) {
		NrRozkazu = nrRozkazu;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
}
