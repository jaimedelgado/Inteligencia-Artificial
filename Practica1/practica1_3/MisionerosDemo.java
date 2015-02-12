package practica1.practica1_3;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.*;
import aima.core.search.informed.AStarSearch;
import aima.core.search.uninformed.*;


public class MisionerosDemo {
	static EstadoMisioneros estadoInicial = new EstadoMisioneros();
	public static void main(String[] args){
		MisionerosBreadthSearch();
		MisionerosDepthSearch();
		MasMisionerosCorrectos();
		MisionerosPiezasBienColocadas();
		MisionerosBreadthSearch();
	}
	private static void MisionerosBreadthSearch(){
		System.out.println("\nMisionerosBreadthSearch-->");
		try{
			//Crear un objeto Problem con la representacion de estados y operadores
			Problem problem = new Problem(estadoInicial,
					MisionerosFunctionFactory.getActionsFunction(),MisionerosFunctionFactory.getResultsFunction(),
					new MisionerosGoalTest());//como no hay funcion de coste en el constructor se usa el coste por defecto
			//indicar el tipo de busqueda
			Search search = new BreadthFirstSearch(new GraphSearch());//busqueda en anchura
			//crear un agente que realice la busqueda sobre el problema
			SearchAgent agent=new SearchAgent(problem, search);
			//escribir la solucion encontrada (operadores aplicados) e informacion sobre los recursos utilizados
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void MisionerosDepthSearch(){
		System.out.println("\nMisionerosDepthSearch-->");
		try{
			Problem problem = new Problem(estadoInicial,
					MisionerosFunctionFactory.getActionsFunction(),MisionerosFunctionFactory.getResultsFunction(),
					new MisionerosGoalTest());
			//Search search = new DepthFirstSearch(new TreeSearch()); Sin control de ciclos hace una rama infinita
			Search search = new DepthFirstSearch(new GraphSearch()) ; //version limitada(10) de busqueda en profundidad
			SearchAgent agent=new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//Busqueda A* en grafo con heuristica Piezas Bien Colocadas
	private static void MisionerosPiezasBienColocadas() {
		System.out.println("\nMisionerosPiezasBienColocadas -->");
		try {
			Problem problem = new Problem(estadoInicial, MisionerosFunctionFactory
					.getActionsFunction(), MisionerosFunctionFactory
					.getResultsFunction(), new MisionerosGoalTest());
			Search search = new AStarSearch( new GraphSearch(),new FichasBienColocadas()) ;
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//Busqueda A* en grafo con heuristica Misioneros Correctos
		private static void MasMisionerosCorrectos() {
			System.out.println("\nMasMisionerosCorrectos -->");
			try {
				Problem problem = new Problem(estadoInicial, MisionerosFunctionFactory
						.getActionsFunction(), MisionerosFunctionFactory
						.getResultsFunction(), new MisionerosGoalTest());
				
				Search search = new AStarSearch( new GraphSearch(),new MasMisionerosCorrectos()) ;
				SearchAgent agent = new SearchAgent(problem, search);
				printActions(agent.getActions());
				printInstrumentation(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	private static void printActions(List<Action> actions) {
		for (int i = 0; i < actions.size(); i++) {
			String action = actions.get(i).toString();
			System.out.println(action);
		}
	}
	private static void printInstrumentation(Properties properties) {
		Iterator<Object> keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}

	}
	
}
