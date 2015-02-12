package practica1.practica1_4;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;



public class AtascoFunctionFactory {
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;

	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new EPActionsFunction();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new EPResultFunction();
		}
		return _resultFunction;
	}

	private static class EPActionsFunction implements ActionsFunction {
		public Set<Action> actions(Object state) {
			EstadoAtasco board = (EstadoAtasco) state;

			Set<Action> actions = new LinkedHashSet<Action>();
			
			
			if(board.puedeMover(EstadoAtasco.delanteA)){
				actions.add(EstadoAtasco.delanteA);
			}
			if(board.puedeMover(EstadoAtasco.detrasA)){
				actions.add(EstadoAtasco.detrasA);
			}
			if(board.puedeMover(EstadoAtasco.delanteR)){
				actions.add(EstadoAtasco.delanteR);
			}
			if(board.puedeMover(EstadoAtasco.detrasR)){
				actions.add(EstadoAtasco.detrasR);
			}
			if(board.puedeMover(EstadoAtasco.delanteZ)){
				actions.add(EstadoAtasco.delanteZ);
			}
			if(board.puedeMover(EstadoAtasco.detrasZ)){
				actions.add(EstadoAtasco.detrasZ);
			}
			if(board.puedeMover(EstadoAtasco.delanteV)){
				actions.add(EstadoAtasco.delanteV);
			}
			if(board.puedeMover(EstadoAtasco.detrasV)){
				actions.add(EstadoAtasco.detrasV);
			}
			if(board.puedeMover(EstadoAtasco.delanteS)){
				actions.add(EstadoAtasco.delanteS);
			}
			if(board.puedeMover(EstadoAtasco.detrasS)){
				actions.add(EstadoAtasco.detrasS);
			}
			if(board.puedeMover(EstadoAtasco.delanteG)){
				actions.add(EstadoAtasco.delanteG);
			}
			if(board.puedeMover(EstadoAtasco.detrasG)){
				actions.add(EstadoAtasco.detrasG);
			}
			if(board.puedeMover(EstadoAtasco.delanteC1)){
				actions.add(EstadoAtasco.delanteC1);
			}
			if(board.puedeMover(EstadoAtasco.detrasC1)){
				actions.add(EstadoAtasco.detrasC1);
			}
			if(board.puedeMover(EstadoAtasco.delanteC2)){
				actions.add(EstadoAtasco.delanteC2);
			}
			if(board.puedeMover(EstadoAtasco.detrasC2)){
				actions.add(EstadoAtasco.detrasC2);
			}
			return actions;
		}
	}

	private static class EPResultFunction implements ResultFunction {
		public Object result(Object s, Action a) {
			EstadoAtasco estado = (EstadoAtasco) s;
	
			if(EstadoAtasco.delanteA.equals(a)&&estado.puedeMover(EstadoAtasco.delanteA)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.delanteA);
				return nuevoEstado;
			}else if(EstadoAtasco.detrasA.equals(a)&&estado.puedeMover(EstadoAtasco.detrasA)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.detrasA);
				return nuevoEstado;
			}else if(EstadoAtasco.delanteR.equals(a)&&estado.puedeMover(EstadoAtasco.delanteR)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.delanteR);
				return nuevoEstado;
			}else if(EstadoAtasco.detrasR.equals(a)&&estado.puedeMover(EstadoAtasco.detrasR)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.detrasR);
				return nuevoEstado;
			}else if(EstadoAtasco.delanteZ.equals(a)&&estado.puedeMover(EstadoAtasco.delanteZ)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.delanteZ);
				return nuevoEstado;
			}else if(EstadoAtasco.detrasZ.equals(a)&&estado.puedeMover(EstadoAtasco.detrasZ)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.detrasZ);
				return nuevoEstado;
			}else if(EstadoAtasco.delanteV.equals(a)&&estado.puedeMover(EstadoAtasco.delanteV)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.delanteV);
				return nuevoEstado;
			}else if(EstadoAtasco.detrasV.equals(a)&&estado.puedeMover(EstadoAtasco.detrasV)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.detrasV);
				return nuevoEstado;
			}else if(EstadoAtasco.delanteS.equals(a)&&estado.puedeMover(EstadoAtasco.delanteS)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.delanteS);
				return nuevoEstado;
			}else if(EstadoAtasco.detrasS.equals(a)&&estado.puedeMover(EstadoAtasco.detrasS)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.detrasS);
				return nuevoEstado;
			}else if(EstadoAtasco.delanteG.equals(a)&&estado.puedeMover(EstadoAtasco.delanteG)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.delanteG);
				return nuevoEstado;
			}else if(EstadoAtasco.detrasG.equals(a)&&estado.puedeMover(EstadoAtasco.detrasG)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.detrasG);
				return nuevoEstado;
			}else if(EstadoAtasco.delanteC1.equals(a)&&estado.puedeMover(EstadoAtasco.delanteC1)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.delanteC1);
				return nuevoEstado;
			}else if(EstadoAtasco.detrasC1.equals(a)&&estado.puedeMover(EstadoAtasco.detrasC1)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.detrasC1);
				return nuevoEstado;
			}else if(EstadoAtasco.delanteC2.equals(a)&&estado.puedeMover(EstadoAtasco.delanteC2)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.delanteC2);
				return nuevoEstado;
			}else if(EstadoAtasco.detrasC2.equals(a)&&estado.puedeMover(EstadoAtasco.detrasC2)){
				EstadoAtasco nuevoEstado = new EstadoAtasco(estado);
				nuevoEstado.mueve(EstadoAtasco.detrasC2);
				return nuevoEstado;
			}
		
			
			// The Action is not understood or is a NoOp
			// the result will be the current state.
			return s;
		}
	}
}
