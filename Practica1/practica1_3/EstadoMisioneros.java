package practica1.practica1_3;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;




public class EstadoMisioneros {
	private int numMisioneros; // numMisioneros en orilla izquierda
	private int numCanibales; // numCanibales en orilla izquierda
	private boolean barcaIzq; // true si barca en orilla izquierda
	public static Action M = new DynamicAction("M");
	public static Action MM = new DynamicAction("MM");
	public static Action C = new DynamicAction("C");
	public static Action CC = new DynamicAction("CC");
	public static Action MC = new DynamicAction("MC");
	//Constructors
	public EstadoMisioneros(){
		this(3,3,true);
	}
	public EstadoMisioneros(EstadoMisioneros mc){
		this(mc.getnMisioneros(), mc.getnCanibales(), mc.isBarcaizq());
	}
	public EstadoMisioneros(int nMisioneros, int nCanibales, boolean barcaIzq){
		this.setNumMisioneros(nMisioneros);
		this.setNumCanibales(nCanibales);
		this.setBarcaIzq(barcaIzq);
	}
	//Methods
	private int getnMisioneros() {
		return this.getNumMisioneros();
	}
	private int getnCanibales() {
		return this.getNumCanibales();
	}
	private boolean isBarcaizq() {
		return this.isBarcaIzq();
	}

	public boolean movimientoValido(Action where) {
		boolean valido = false;
		if(!this.peligro()){
			if(where.equals(M)){
				if(((isBarcaIzq()&&getNumMisioneros()>0)||(!isBarcaIzq()&&getNumMisioneros()<3))){
					EstadoMisioneros estadoSiguiente = new EstadoMisioneros(this);
					estadoSiguiente.move(M);
					if(estadoSiguiente.peligro()){
						valido=false;
					}else{
						valido=true;
					}
				}
				else valido=false;
			}
			else if (where.equals(MM)){
				if(((isBarcaIzq()&&getNumMisioneros()>1)||(!isBarcaIzq()&&getNumMisioneros()<2))){
					EstadoMisioneros estadoSiguiente = new EstadoMisioneros(this);
					estadoSiguiente.move(MM);
					if(estadoSiguiente.peligro()){
						valido=false;
					}else{
						valido=true;
					}
				}
				else valido=false;
			}else if (where.equals(C)){
				if(((isBarcaIzq()&&getNumCanibales()>0)||(!isBarcaIzq()&&getNumCanibales()<3))){
					EstadoMisioneros estadoSiguiente = new EstadoMisioneros(this);
					estadoSiguiente.move(C);
					if(estadoSiguiente.peligro()){
						valido=false;
					}else{
						valido=true;
					}
				}
				else valido=false;
			}else if (where.equals(CC)){
				if(((isBarcaIzq()&&getNumCanibales()>1)||(!isBarcaIzq()&&getNumCanibales()<2))){
					EstadoMisioneros estadoSiguiente = new EstadoMisioneros(this);
					estadoSiguiente.move(CC);
					if(estadoSiguiente.peligro()){
						valido=false;
					}else{
						valido=true;
					}
				}
				else valido=false;
			}else if (where.equals(MC)){
				if(((isBarcaIzq()&&getNumMisioneros()>0&&getNumCanibales()>0)
					||(!isBarcaIzq()&&getNumMisioneros()<3&&getNumCanibales()<3))){
					EstadoMisioneros estadoSiguiente = new EstadoMisioneros(this);
					estadoSiguiente.move(MC);
					if(estadoSiguiente.peligro()){
						valido=false;
					}else{
						valido=true;
					}
				}
				else valido=false;
			}else{
				valido=false;
			}
		}
		return valido;
	}
	private boolean peligro() {
		if(((getNumMisioneros()<getNumCanibales())&&(getNumMisioneros()!=0))
			||((getNumMisioneros()>getNumCanibales())&&(getNumMisioneros()!=3))){
				return true;
		}else{
				return false;
		}
	}
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if((o==null)||(this.getClass()!=o.getClass())){
			return false;
		}
		EstadoMisioneros otroEstado = (EstadoMisioneros) o;
		if((this.getNumMisioneros()==otroEstado.getnMisioneros())&&
				(this.getNumCanibales()==otroEstado.getnCanibales())&&
				(this.isBarcaIzq()==otroEstado.isBarcaizq()))
			return true;
		else
			return false;
	}
	public int hashCode(){
		return(100*getNumMisioneros())+(10*getNumCanibales())+(isBarcaIzq()?1:0);
	}
	public void move(Action m2) {
		if(isBarcaIzq()){
			if(m2==M){
				setNumMisioneros(getNumMisioneros() - 1);
			}else if(m2==MM){
				setNumMisioneros(getNumMisioneros() - 2);
			} else if(m2==C){
				setNumCanibales(getNumCanibales() - 1);
			}else if(m2==CC){
				setNumCanibales(getNumCanibales() - 2);
			}else if(m2==MC){
				setNumMisioneros(getNumMisioneros() - 1);
				setNumCanibales(getNumCanibales() - 1);
			}
			
		}else{
			if(m2==M){
				setNumMisioneros(getNumMisioneros() + 1);
			}else if(m2==MM){
				setNumMisioneros(getNumMisioneros() + 2);
			} else if(m2==C){
				setNumCanibales(getNumCanibales() + 1);
			}else if(m2==CC){
				setNumCanibales(getNumCanibales() + 2);
			}else if(m2==MC){
				setNumMisioneros(getNumMisioneros() + 1);
				setNumCanibales(getNumCanibales() + 1);
			}
		}
		cambiarDeOrilla();
	}
	private void cambiarDeOrilla() {
		if(this.isBarcaIzq()){
			this.setBarcaIzq(false);
		}else{
			this.setBarcaIzq(true);
		}
		
	}
	public boolean isBarcaIzq() {
		return barcaIzq;
	}
	public void setBarcaIzq(boolean barcaIzq) {
		this.barcaIzq = barcaIzq;
	}
	public int getNumMisioneros() {
		return numMisioneros;
	}
	public void setNumMisioneros(int numMisioneros) {
		this.numMisioneros = numMisioneros;
	}
	public int getNumCanibales() {
		return numCanibales;
	}
	public void setNumCanibales(int numCanibales) {
		this.numCanibales = numCanibales;
	}
	
	
	
}






