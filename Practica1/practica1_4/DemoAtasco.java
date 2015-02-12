package practica1.practica1_4;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.uninformed.*;


public class DemoAtasco {
	static EstadoAtasco estadoInicial = new EstadoAtasco();
	public static void main(String[] args){
		
		AtascoDepthSearch();
		AtascoBreadthSearch();
	}
	private static void AtascoBreadthSearch(){
		System.out.println("\nAtascoBreadthSearch-->");
		try{
			//Crear un objeto Problem con la representacion de estados y operadores
			Problem problem = new Problem(estadoInicial,
					AtascoFunctionFactory.getActionsFunction(),AtascoFunctionFactory.getResultFunction(),
					new AtascoGoalTest());//como no hay funcion de coste en el constructor se usa el coste por defecto
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
	private static void AtascoDepthSearch(){
		System.out.println("\nAtascoDepthSearch-->");
		try{
			//Crear un objeto Problem con la representacion de estados y operadores
			Problem problem = new Problem(estadoInicial,
					AtascoFunctionFactory.getActionsFunction(),AtascoFunctionFactory.getResultFunction(),
					new AtascoGoalTest());//como no hay funcion de coste en el constructor se usa el coste por defecto
			//indicar el tipo de busqueda
			Search search = new DepthFirstSearch(new GraphSearch());//busqueda en anchura
			//crear un agente que realice la busqueda sobre el problema
			SearchAgent agent=new SearchAgent(problem, search);
			//escribir la solucion encontrada (operadores aplicados) e informacion sobre los recursos utilizados
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		}catch(Exception e){
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
