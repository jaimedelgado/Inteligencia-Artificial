package practica1.practica1_3;

import aima.core.search.framework.HeuristicFunction;



public class FichasBienColocadas implements HeuristicFunction {
	public double h(Object state) {
		EstadoMisioneros board = (EstadoMisioneros) state;
		int suma=((3-board.getNumMisioneros())+(3-board.getNumCanibales()));
		return suma;
	}
}
