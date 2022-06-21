package main.model.dao;

import java.util.List;

import main.model.entity.Centro;
import main.model.entity.CentroSettimana;
import main.model.entity.Settimana;

public interface CentroSettimanaManage {
	
	
	int getDisponibilita(int s, int c);
	
	List<Settimana> getSettimaneDisponibilibyCentro(int c);
	
	List<Centro> getCentriDisponibilibySettimana(int s);
	
	List<CentroSettimana> getCentriSettimana();
	

}
