package main.control.gestioneIscrizione;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.dao.BambinoManage;
import main.model.dao.BambinoManageDS;
import main.model.dao.CentroManage;
import main.model.dao.CentroManageDS;
import main.model.dao.IscrizioneManage;
import main.model.dao.IscrizioneManageDS;
import main.model.dao.SettimanaManage;
import main.model.dao.SettimanaManageDS;
import main.model.dao.UtenteManage;
import main.model.dao.UtenteManageDS;
import main.model.entity.Bambino;
import main.model.entity.Centro;
import main.model.entity.Genitore;
import main.model.entity.Iscrizione;
import main.model.entity.Responsabile;
import main.model.entity.Settimana;
import main.model.entity.Utente;

/**
 * Servlet implementation class VisualizzaIscrizioniControl
 */
@WebServlet("/list_iscrizioni")
public class VisualizzaIscrizioniControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaIscrizioniControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente u = (Utente) request.getSession(false).getAttribute("utente");
		if(u==null) {
			response.sendError(401, "Autenticazione non effettuata!");
			return;
		} 
		
		
		
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("centri")) {
			if(!u.isAdmin()) {
				response.sendError(403, "Non sei autorizzato!");
				return;
			}
			String centro= request.getParameter("centro");
		
			IscrizioneManage iscrizioneManage = new IscrizioneManageDS();
			List<Iscrizione> iscrizioni = (List<Iscrizione>) iscrizioneManage.getIscrizioneByCentro(Integer.parseInt(centro));
			
			CentroManage centroman= new CentroManageDS();
			Centro cen = (Centro) centroman.getCentro(Integer.parseInt(centro));
			
			request.setAttribute("iscrizioni", iscrizioni);
			request.setAttribute("centro", cen);
		
		}
		else {
			if(u.isAdmin()) {
				response.sendError(403, "Non sei autorizzato!");
				return;
			}
			IscrizioneManage iscrizioneManage = new IscrizioneManageDS();
			List<Iscrizione> iscrizioni = (List<Iscrizione>) iscrizioneManage.getIscrizioniByGenitore(u.getCodiceFiscale());
			
			request.setAttribute("iscrizioni", iscrizioni);
		}
		
		
		
		/**
		 * Dispatch verso la lista delle iscrizioni
		 */
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/list_iscrizioni.jsp");
		dispatcher.forward(request, response);
		
		
	}

}