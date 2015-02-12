package practica1.practica1_4;

import aima.core.util.datastructure.XYLocation;

public class Coche {
	private XYLocation inicio;
	private XYLocation fin;
	private boolean horizontal; //pos=1 horizontal, pos=0 vertical
	private boolean rojo;
	//constructores
	public Coche(XYLocation in, XYLocation f, boolean horizontal, boolean rojo){
		this.inicio=in;
		this.fin=f;
		this.horizontal=horizontal;
		this.rojo=rojo;
	}
	public XYLocation getInicio(){
		return inicio;
	}
	public XYLocation getFin(){
		return fin;
	}
	public boolean isRojo(){
		return this.rojo;
	}
	public boolean isHorizontal(){
		return horizontal;
	}
	public void setInicio(XYLocation XY){
		this.inicio = XY;
	}
	public void setFin(XYLocation XY){
		this.fin = XY;
	}

	
}
