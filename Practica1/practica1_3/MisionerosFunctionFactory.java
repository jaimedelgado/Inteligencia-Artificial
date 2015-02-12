package practica1.practica1_3;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;


public class MisionerosFunctionFactory {
	private static ActionsFunction _actionsFunction=null;
	private static ResultFunction _resultFunction=null;
	
	public static ActionsFunction getActionsFunction(){
		if(null==_actionsFunction){
			_actionsFunction = new MisionerosActionsFunctions();
		}
		return _actionsFunction;
	}
	
	public static ResultFunction getResultsFunction(){
		if(null==_resultFunction){
			_resultFunction = new MisionerosResultsFunctions();
		}
		return _resultFunction;
	}
	
	private static class MisionerosActionsFunctions implements ActionsFunction {
		public Set<Action> actions(Object state) {
			EstadoMisioneros estado = (EstadoMisioneros) state;
			//Lista de acciones posibles
			Set<Action> actions = new LinkedHashSet<Action>();
			// si se cumplen las precondiciones y no se va a un estado de peligro entonces
			// se añade la accion a la lista de acciones posibles
			if (estado.movimientoValido(EstadoMisioneros.M))
				actions.add(EstadoMisioneros.M);
			if (estado.movimientoValido(EstadoMisioneros.MM))
				actions.add(EstadoMisioneros.MM);
			if (estado.movimientoValido(EstadoMisioneros.C))
				actions.add(EstadoMisioneros.C);
			if (estado.movimientoValido(EstadoMisioneros.CC))
				actions.add(EstadoMisioneros.CC);
			if (estado.movimientoValido(EstadoMisioneros.MC))
				actions.add(EstadoMisioneros.MC);
			return actions;
			
		}

	}
	private static class MisionerosResultsFunctions implements ResultFunction{
		public Object result (Object s, Action a){
			EstadoMisioneros estado = (EstadoMisioneros) s;
			if(EstadoMisioneros.M.equals(a)){
				EstadoMisioneros nuevoEstado = new EstadoMisioneros(estado);
				nuevoEstado.move(EstadoMisioneros.M);
				return nuevoEstado;
			}else if(EstadoMisioneros.MM.equals(a)){
				EstadoMisioneros nuevoEstado = new EstadoMisioneros(estado);
				nuevoEstado.move(EstadoMisioneros.MM);
				return nuevoEstado;
			}else if(EstadoMisioneros.C.equals(a)){
				EstadoMisioneros nuevoEstado = new EstadoMisioneros(estado);
				nuevoEstado.move(EstadoMisioneros.C);
				return nuevoEstado;
			}else if(EstadoMisioneros.CC.equals(a)){
				EstadoMisioneros nuevoEstado = new EstadoMisioneros(estado);
				nuevoEstado.move(EstadoMisioneros.CC);
				return nuevoEstado;
			}else if(EstadoMisioneros.MC.equals(a)){
				EstadoMisioneros nuevoEstado = new EstadoMisioneros(estado);
				nuevoEstado.move(EstadoMisioneros.MC);
				return nuevoEstado;
			}else{
				return s;
			}
					
			
		}
	}
}
