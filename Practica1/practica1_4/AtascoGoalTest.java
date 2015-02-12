package practica1.practica1_4;

import aima.core.search.framework.GoalTest;
import aima.core.util.datastructure.XYLocation;



public class AtascoGoalTest implements GoalTest{
	public boolean isGoalState(Object state){
		Coche[] cochesGoal = new Coche[1];
		cochesGoal[0]= new Coche(new XYLocation(2,4), new XYLocation(2,5), true, true);
		EstadoAtasco goal = new EstadoAtasco(cochesGoal, 1);
		EstadoAtasco estado = (EstadoAtasco) state;
		return estado.equals(goal);
	}
}
