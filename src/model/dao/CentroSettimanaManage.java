package model.dao;

import java.util.List;

import model.entity.Centro;
import model.entity.CentroSettimana;
import model.entity.Settimana;

public interface CentroSettimanaManage {
	
	
	int getDisponibilita(int s, int c);
	
	List<CentroSettimana> getSettimaneDisponibilibyCentro(int c);
	
	List<Centro> getCentriDisponibilibySettimana(int s);
	
	List<CentroSettimana> getCentriSettimana();
	

}
