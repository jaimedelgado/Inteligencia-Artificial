package practica1.practica1_2;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;


import aima.core.agent.Action;
/*import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.EightPuzzleFunctionFactory;
import aima.core.environment.eightpuzzle.EightPuzzleGoalTest;*/
import aima.core.environment.eightpuzzle.*;
import aima.core.search.framework.*;
/*import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Metrics;
import aima.core.search.framework.Node;
import aima.core.search.framework.Problem;
import aima.core.search.framework.QueueSearch;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;*/
import aima.core.search.uninformed.*;
import aima.core.search.informed.*;





public class apartado2 {
	static EightPuzzleBoard boardWithThreeMoveSolution = new EightPuzzleBoard(
			new int[] { 1, 2, 5, 3, 4, 0, 6, 7, 8 });;
			//Busqueda en anchura
			private static void eightPuzzleBreadhSearch() {
				System.out.println("\nEightPuzzle BreadhSearch -->");
				try {
					Problem problem = new Problem(boardWithThreeMoveSolution, EightPuzzleFunctionFactory
							.getActionsFunction(), EightPuzzleFunctionFactory
							.getResultFunction(), new EightPuzzleGoalTest());
					Search search = new BreadthFirstSearch() ;
					SearchAgent agent = new SearchAgent(problem, search);
					printActions(agent.getActions());
					printInstrumentation(agent.getInstrumentation());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			//Busqueda en profundidad
			private static void eightPuzzleDepthSearch() {
				System.out.println("\nEightPuzzle DepthSearch -->");
				try {
					Problem problem = new Problem(boardWithThreeMoveSolution, EightPuzzleFunctionFactory
							.getActionsFunction(), EightPuzzleFunctionFactory
							.getResultFunction(), new EightPuzzleGoalTest());
					//Search search = new DepthFirstSearch(new TreeSearch()); Sin control de ciclos hace una rama infinita
					Search search = new DepthLimitedSearch(10) ; //version limitada(10) de busqueda en profundidad
					SearchAgent agent = new SearchAgent(problem, search);
					printActions(agent.getActions());
					printInstrumentation(agent.getInstrumentation());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			//Busqueda A* en grafo con heuristica Manhattan
			private static void eightPuzzleStartGraphSearchManhattan() {
				System.out.println("\nEightPuzzle StartGraphSearchManhattan -->");
				try {
					Problem problem = new Problem(boardWithThreeMoveSolution, EightPuzzleFunctionFactory
							.getActionsFunction(), EightPuzzleFunctionFactory
							.getResultFunction(), new EightPuzzleGoalTest());
					
					Search search = new AStarSearch(new GraphSearch(),new ManhattanHeuristicFunction()) ;
					SearchAgent agent = new SearchAgent(problem, search);
					printActions(agent.getActions());
					printInstrumentation(agent.getInstrumentation());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			//Busqueda A* en grafo con heuristica Piezas Descolocadas
			private static void eightPuzzleStartGraphSearchDescolocadas() {
				System.out.println("\nEightPuzzle StartGraphSearchDescolocadas -->");
				try {
					Problem problem = new Problem(boardWithThreeMoveSolution, EightPuzzleFunctionFactory
							.getActionsFunction(), EightPuzzleFunctionFactory
							.getResultFunction(), new EightPuzzleGoalTest());
					
					Search search = new AStarSearch(new GraphSearch(),new MisplacedTilleHeuristicFunction()) ;
					SearchAgent agent = new SearchAgent(problem, search);
					printActions(agent.getActions());
					printInstrumentation(agent.getInstrumentation());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			//Busqueda A* en arbol con heuristica Piezas Descolocadas
			private static void eightPuzzleStartTreeSearchDescolocadas() {
				System.out.println("\nEightPuzzle StartTreeSearchDescolocadas -->");
				try {
					Problem problem = new Problem(boardWithThreeMoveSolution, EightPuzzleFunctionFactory
							.getActionsFunction(), EightPuzzleFunctionFactory
							.getResultFunction(), new EightPuzzleGoalTest());
					
					Search search = new AStarSearch(new TreeSearch(),new MisplacedTilleHeuristicFunction()) ;
					SearchAgent agent = new SearchAgent(problem, search);
					printActions(agent.getActions());
					printInstrumentation(agent.getInstrumentation());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			//Busqueda A* en arbol con heuristica Manhattan
			private static void eightPuzzleStartTreeSearchManhattan() {
				System.out.println("\nEightPuzzle StartTreeSearchManhattan -->");
				try {
					Problem problem = new Problem(boardWithThreeMoveSolution, EightPuzzleFunctionFactory
							.getActionsFunction(), EightPuzzleFunctionFactory
							.getResultFunction(), new EightPuzzleGoalTest());
					
					Search search = new AStarSearch(new TreeSearch(),new ManhattanHeuristicFunction()) ;
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
			public static void main(String[] args) {
				eightPuzzleBreadhSearch();
				eightPuzzleDepthSearch();
				eightPuzzleStartGraphSearchManhattan();
				eightPuzzleStartGraphSearchDescolocadas();
				eightPuzzleStartTreeSearchDescolocadas();
				eightPuzzleStartTreeSearchManhattan();
			}

}



