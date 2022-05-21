package model.dao;

import java.util.List;

import model.entity.Centro;
import model.entity.CentroSettimana;
import model.entity.Settimana;

public interface CentroSettimanaManage {
	
	
	int getDisponibilita(Settimana s, Centro c);
	
	List<Settimana> getSettimaneDisponibilibyCentro(Centro c);
	
	List<Centro> getCentriDisponibilibySettimana(Settimana s);
	
	List<CentroSettimana> getCentriSettimana();
	

}
