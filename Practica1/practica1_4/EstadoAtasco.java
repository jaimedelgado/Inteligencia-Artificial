package practica1.practica1_4;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.util.datastructure.XYLocation;


public class EstadoAtasco {
	private Coche[] coches;
	private int[][] tablero; //tablero=0 libre, tablero=1 ocupado
	private int numCoches;
	//Operadores
	public static Action delanteA = new DynamicAction("delanteA");
	public static Action detrasA = new DynamicAction("detrasA");
	public static Action delanteR = new DynamicAction("delanteR");
	public static Action detrasR = new DynamicAction("detrasR");
	public static Action delanteZ = new DynamicAction("delanteZ");
	public static Action detrasZ = new DynamicAction("detrasZ");
	public static Action delanteV = new DynamicAction("delanteV");
	public static Action detrasV = new DynamicAction("detrasV");
	public static Action delanteS = new DynamicAction("delanteS");
	public static Action detrasS = new DynamicAction("detrasS");
	public static Action delanteG = new DynamicAction("delanteG");
	public static Action detrasG = new DynamicAction("detrasG");
	public static Action delanteC1 = new DynamicAction("delanteC1");
	public static Action detrasC1 = new DynamicAction("detrasC1");
	public static Action delanteC2 = new DynamicAction("delanteC2");
	public static Action detrasC2 = new DynamicAction("detrasC2");
	
	
	//constructores
	public EstadoAtasco(){
		Coche A = new Coche(new XYLocation(3, 0),new XYLocation(3,1), true, false);
		Coche R = new Coche(new XYLocation(2, 3),new XYLocation(2,4), true, true);
		Coche Z = new Coche(new XYLocation(5, 2),new XYLocation(5,3), true, false);
		Coche V = new Coche(new XYLocation(3, 2),new XYLocation(4,2), false, false);
		Coche S = new Coche(new XYLocation(3, 3),new XYLocation(4,3), false, false);
		Coche G = new Coche(new XYLocation(4, 1),new XYLocation(5,1), false, false);
		Coche C1 = new Coche(new XYLocation(0, 0),new XYLocation(2,0), false, false);
		Coche C2 = new Coche(new XYLocation(0, 1),new XYLocation(2,1), false, false);
		this.coches = new Coche[8];
		this.coches[0]=A;this.coches[1]=R;this.coches[2]=Z;this.coches[3]=V;
		this.coches[4]=S;this.coches[5]=G;this.coches[6]=C1;this.coches[7]=C2;
		this.numCoches=8;
		this.tablero=new int[6][6];
		ponVehiculosEnTablero();
		
	}
	public EstadoAtasco(Coche[] coches, int nCoches){
		this.coches=coches;
		this.numCoches=nCoches;
		this.tablero=new int[6][6];
		ponVehiculosEnTablero();
		
	}
	public EstadoAtasco(EstadoAtasco copy) {
		this.coches=copy.getCoches();
		this.numCoches=copy.getNumCoches();
		this.tablero=copy.getTablero();
		ponVehiculosEnTablero();
	}
	//methods
	/*public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coches == null) ? 0 : coches.hashCode());
		result = prime * result + 6;
		return result;
	}*/
	
	
	private void ponVehiculosEnTablero() {
		for(int i=0; i<this.numCoches; i++){
			int coInX = this.coches[i].getInicio().getXCoOrdinate();
			int coInY = this.coches[i].getInicio().getYCoOrdinate();
			int coFinX = this.coches[i].getFin().getXCoOrdinate();
			int coFinY = this.coches[i].getFin().getYCoOrdinate();
			boolean horizon = this.coches[i].isHorizontal();
			if(horizon){
				for(int j=coInY; j<=coFinY; j++){
					this.tablero[coInX][j]=1;
				}
			}else{
				for(int k=coInX; k<=coFinX; k++){
					this.tablero[k][coFinY]=1;
				}
			}
			
			
		}
		
	}
	public Coche[] getCoches(){
		return this.coches;
	}
	
	public int[][] getTablero(){
		return this.tablero;
	}
	public int getNumCoches(){
		return this.numCoches;
	}
	/*public void mueve(Coche coche, Action act){
		if(puedeMover(coche,act)){
			int Inx=coche.getInicio().getXCoOrdinate();
			int Iny=coche.getInicio().getYCoOrdinate();
			int Finx= coche.getFin().getXCoOrdinate();
			int Finy= coche.getFin().getYCoOrdinate();
			if(act == delante){
				if(coche.isHorizontal()){
					coche.setInicio(new XYLocation(Inx,Iny+1));
					coche.setFin(new XYLocation(Finx,Finy+1));
				}else{
					coche.setInicio(new XYLocation(Inx+1,Iny));
					coche.setFin(new XYLocation(Finx+1,Finy));
				}
			}else if(act==detras){
				if(coche.isHorizontal()){
					coche.setInicio(new XYLocation(Inx,Iny-1));
					coche.setFin(new XYLocation(Finx,Finy-1));
				}else{
					coche.setInicio(new XYLocation(Inx-1,Iny));
					coche.setFin(new XYLocation(Finx-1,Finy));
				}
			}
			this.ponVehiculosEnTablero();
		}
	}*/
	public void mueve(Action act){
	
		if(puedeMover(act)){
			if(act==EstadoAtasco.delanteA){
				int finx = coches[0].getFin().getXCoOrdinate();
				int finy = coches[0].getFin().getYCoOrdinate();
				int iny = coches[0].getInicio().getYCoOrdinate();
				this.tablero[finx][iny]=0;
				this.coches[0].setFin(new XYLocation(finx, finy+1));
				this.coches[0].setInicio(new XYLocation(finx, iny+1));
			}else if(act==EstadoAtasco.detrasA){
				int finx = coches[0].getFin().getXCoOrdinate();
				int finy = coches[0].getFin().getYCoOrdinate();
				int iny = coches[0].getInicio().getYCoOrdinate();
				this.tablero[finx][finy]=0;
				this.coches[0].setFin(new XYLocation(finx, finy-1));
				this.coches[0].setInicio(new XYLocation(finx, iny-1));
			}else if(act==EstadoAtasco.delanteR){
				int finx = coches[1].getFin().getXCoOrdinate();
				int finy = coches[1].getFin().getYCoOrdinate();
				int iny = coches[1].getInicio().getYCoOrdinate();
				this.tablero[finx][iny]=0;
				this.coches[1].setFin(new XYLocation(finx, finy+1));
				this.coches[1].setInicio(new XYLocation(finx, iny+1));
			}else if(act==EstadoAtasco.detrasR){
				int finx = coches[1].getFin().getXCoOrdinate();
				int finy = coches[1].getFin().getYCoOrdinate();
				int iny = coches[1].getInicio().getYCoOrdinate();
				this.tablero[finx][finy]=0;
				this.coches[1].setFin(new XYLocation(finx, finy-1));
				this.coches[1].setInicio(new XYLocation(finx, iny-1));
			}else if(act==EstadoAtasco.delanteZ){
				int finx = coches[2].getFin().getXCoOrdinate();
				int finy = coches[2].getFin().getYCoOrdinate();
				int iny = coches[2].getInicio().getYCoOrdinate();
				this.tablero[finx][iny]=0;
				this.coches[2].setFin(new XYLocation(finx, finy+1));
				this.coches[2].setInicio(new XYLocation(finx, iny+1));
			}else if(act==EstadoAtasco.detrasZ){
				int finx = coches[2].getFin().getXCoOrdinate();
				int finy = coches[2].getFin().getYCoOrdinate();
				int iny = coches[2].getInicio().getYCoOrdinate();
				this.tablero[finx][finy]=0;
				this.coches[2].setFin(new XYLocation(finx, finy-1));
				this.coches[2].setInicio(new XYLocation(finx, iny-1));
			}else if(act==EstadoAtasco.delanteV){
				int inx = coches[3].getInicio().getXCoOrdinate();
				int finy = coches[3].getFin().getYCoOrdinate();
				int finx = coches[3].getFin().getXCoOrdinate();
				this.tablero[inx][finy]=0;
				this.coches[3].setFin(new XYLocation(finx+1, finy));
				this.coches[3].setInicio(new XYLocation(inx+1, finy));
			}else if(act==EstadoAtasco.detrasV){
				int inx = coches[3].getInicio().getXCoOrdinate();
				int finy = coches[3].getFin().getYCoOrdinate();
				int finx = coches[3].getFin().getXCoOrdinate();
				this.tablero[finx][finy]=0;
				this.coches[3].setFin(new XYLocation(finx-1, finy));
				this.coches[3].setInicio(new XYLocation(inx-1, finy));
			}else if(act==EstadoAtasco.delanteS){
				int inx = coches[4].getInicio().getXCoOrdinate();
				int finy = coches[4].getFin().getYCoOrdinate();
				int finx = coches[4].getFin().getXCoOrdinate();
				this.tablero[inx][finy]=0;
				this.coches[4].setFin(new XYLocation(finx+1, finy));
				this.coches[4].setInicio(new XYLocation(inx+1, finy));
			}else if(act==EstadoAtasco.detrasS){
				int inx = coches[4].getInicio().getXCoOrdinate();
				int finy = coches[4].getFin().getYCoOrdinate();
				int finx = coches[4].getFin().getXCoOrdinate();
				this.tablero[finx][finy]=0;
				this.coches[4].setFin(new XYLocation(finx-1, finy));
				this.coches[4].setInicio(new XYLocation(inx-1, finy));
			}else if(act==EstadoAtasco.delanteG){
				int inx = coches[5].getInicio().getXCoOrdinate();
				int finy = coches[5].getFin().getYCoOrdinate();
				int finx = coches[5].getFin().getXCoOrdinate();
				this.tablero[inx][finy]=0;
				this.coches[5].setFin(new XYLocation(finx+1, finy));
				this.coches[5].setInicio(new XYLocation(inx+1, finy));
			}else if(act==EstadoAtasco.detrasG){
				int inx = coches[5].getInicio().getXCoOrdinate();
				int finy = coches[5].getFin().getYCoOrdinate();
				int finx = coches[5].getFin().getXCoOrdinate();
				this.tablero[finx][finy]=0;
				this.coches[5].setFin(new XYLocation(finx-1, finy));
				this.coches[5].setInicio(new XYLocation(inx-1, finy));
			}else if(act==EstadoAtasco.delanteC1){
				int inx = coches[6].getInicio().getXCoOrdinate();
				int finy = coches[6].getFin().getYCoOrdinate();
				int finx = coches[6].getFin().getXCoOrdinate();
				this.tablero[inx][finy]=0;
				this.coches[6].setFin(new XYLocation(finx+1, finy));
				this.coches[6].setInicio(new XYLocation(inx+1, finy));
			}else if(act==EstadoAtasco.detrasC1){
				int inx = coches[6].getInicio().getXCoOrdinate();
				int finy = coches[6].getFin().getYCoOrdinate();
				int finx = coches[6].getFin().getXCoOrdinate();
				this.tablero[finx][finy]=0;
				this.coches[6].setFin(new XYLocation(finx-1, finy));
				this.coches[6].setInicio(new XYLocation(inx-1, finy));
			}else if(act==EstadoAtasco.delanteC2){
				int inx = coches[7].getInicio().getXCoOrdinate();
				int finy = coches[7].getFin().getYCoOrdinate();
				int finx = coches[7].getFin().getXCoOrdinate();
				this.tablero[inx][finy]=0;
				this.coches[7].setFin(new XYLocation(finx+1, finy));
				this.coches[7].setInicio(new XYLocation(inx+1, finy));
			}else if(act==EstadoAtasco.detrasC2){
				int inx = coches[7].getInicio().getXCoOrdinate();
				int finy = coches[7].getFin().getYCoOrdinate();
				int finx = coches[7].getFin().getXCoOrdinate();
				this.tablero[finx][finy]=0;
				this.coches[7].setFin(new XYLocation(finx-1, finy));
				this.coches[7].setInicio(new XYLocation(inx-1, finy));
			}
			this.ponVehiculosEnTablero();
		}
	}
	
	
	public boolean puedeMover(Action act){
		boolean puede = false;
		
		if(act==EstadoAtasco.delanteA){
			int finx = coches[0].getFin().getXCoOrdinate();
			int finy = coches[0].getFin().getYCoOrdinate();
			if(finy+1<6&&this.tablero[finx][finy+1]==0){
				puede=true;
			}
		}else if(act==EstadoAtasco.detrasA){
			int inx = coches[0].getInicio().getXCoOrdinate();
			int iny = coches[0].getInicio().getYCoOrdinate();
			if(iny-1>=0&&this.tablero[inx][iny-1]==0){
				puede=true;
			}
		}else if(act==EstadoAtasco.delanteR){
			int finx = coches[1].getFin().getXCoOrdinate();
			int finy = coches[1].getFin().getYCoOrdinate();
			if(finy+1<6&&this.tablero[finx][finy+1]==0){
				puede=true;
			}
		}else if(act==EstadoAtasco.detrasR){
			int inx = coches[1].getInicio().getXCoOrdinate();
			int iny = coches[1].getInicio().getYCoOrdinate();
			if(iny-1>=0&&this.tablero[inx][iny-1]==0){
				puede=true;
			}
		}else if(act==EstadoAtasco.delanteZ){
			int finx = coches[2].getFin().getXCoOrdinate();
			int finy = coches[2].getFin().getYCoOrdinate();
			if(finy+1<6&&this.tablero[finx][finy+1]==0){
				puede=true;
			}
		}else if(act==EstadoAtasco.detrasZ){
			int inx = coches[2].getInicio().getXCoOrdinate();
			int iny = coches[2].getInicio().getYCoOrdinate();
			if(iny-1>=0&&this.tablero[inx][iny-1]==0){
				puede=true;
			}
		}else if(act==EstadoAtasco.delanteV){
			int finx = coches[3].getFin().getXCoOrdinate();
			int finy = coches[3].getFin().getYCoOrdinate();
			if(finx+1<6&&this.tablero[finx+1][finy]==0){
				puede=true;
			}
		}else if(act==EstadoAtasco.detrasV){
			int inx = coches[3].getInicio().getXCoOrdinate();
			int iny = coches[3].getInicio().getYCoOrdinate();
			if(inx-1>=0&&this.tablero[inx-1][iny]==0){
				puede=true;
			}
		}else if(act==EstadoAtasco.delanteS){
			int finx = coches[4].getFin().getXCoOrdinate();
			int finy = coches[4].getFin().getYCoOrdinate();
			if(finx+1<6&&this.tablero[finx+1][finy]==0){
				puede=true;
			}
		}else if(act==EstadoAtasco.detrasS){
			int inx = coches[4].getInicio().getXCoOrdinate();
			int iny = coches[4].getInicio().getYCoOrdinate();
			if(inx-1>=0&&this.tablero[inx-1][iny]==0){
				puede=true;
			}
		}else if(act==EstadoAtasco.delanteG){
			int finx = coches[5].getFin().getXCoOrdinate();
			int finy = coches[5].getFin().getYCoOrdinate();
			if(finx+1<6&&this.tablero[finx+1][finy]==0){
				puede=true;
			}
		}else if(act==EstadoAtasco.detrasG){
			int inx = coches[5].getInicio().getXCoOrdinate();
			int iny = coches[5].getInicio().getYCoOrdinate();
			if(inx-1>=0&&this.tablero[inx-1][iny]==0){
				puede=true;
			}
		}else if(act==EstadoAtasco.delanteC1){
			int finx = coches[6].getFin().getXCoOrdinate();
			int finy = coches[6].getFin().getYCoOrdinate();
			if(finx+1<6&&this.tablero[finx+1][finy]==0){
				puede=true;
			}
		}else if(act==EstadoAtasco.detrasC1){
			int inx = coches[6].getInicio().getXCoOrdinate();
			int iny = coches[6].getInicio().getYCoOrdinate();
			if(inx-1>=0&&this.tablero[inx-1][iny]==0){
				puede=true;
			}
		}else if(act==EstadoAtasco.delanteC2){
			int finx = coches[7].getFin().getXCoOrdinate();
			int finy = coches[7].getFin().getYCoOrdinate();
			if(finx+1<6&&this.tablero[finx+1][finy]==0){
				puede=true;
			}
		}else if(act==EstadoAtasco.detrasC2){
			int inx = coches[7].getInicio().getXCoOrdinate();
			int iny = coches[7].getInicio().getYCoOrdinate();
			if(inx-1>=0&&this.tablero[inx-1][iny]==0){
				puede=true;
			}
		}
		return puede;
	}
	
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		}
		EstadoAtasco aBoard = (EstadoAtasco) o;
		
		/*int [][] tablero = aBoard.tablero;
		boolean ok=true;
		for(int i=0; i<6;i++){
			for(int j=0; j<6; j++){
				if(tablero[i][j]!=this.tablero[i][j]){
					return false;
				}
			}
		}
		return ok;*/
		Coche[] coches = this.getCoches();
		Coche[] cochesG = aBoard.getCoches();
		for(int i=0; i<this.numCoches; i++ ){
			if(coches[i].isRojo()){
				if(cochesG[0].getFin().getYCoOrdinate()==coches[i].getFin().getYCoOrdinate()){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
		
	}
}
