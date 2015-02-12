package practica1.practica1_3;

import aima.core.search.framework.GoalTest;

public class MisionerosGoalTest implements GoalTest{
	EstadoMisioneros goal = new EstadoMisioneros(0,0,false);
	public boolean isGoalState(Object state){
		EstadoMisioneros estado = (EstadoMisioneros) state;
		return estado.equals(goal);
	}
}