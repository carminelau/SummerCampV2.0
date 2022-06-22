package main.control.gestioneCentri;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.dao.CentroManage;
import main.model.dao.CentroManageDS;
import main.model.entity.Centro;
import main.model.entity.Genitore;
import main.model.entity.Responsabile;
import main.model.entity.Utente;

/**
 * Servlet implementation class CentriControl
 */
@WebServlet("/centri")
@MultipartConfig
public class CentriControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CentriControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente u = (Utente) request.getSession(false).getAttribute("utente");
		String action= request.getParameter("action");
		
		if(action.equalsIgnoreCase("eliminacentro")) {
			
			int centro = Integer.parseInt(request.getParameter("centro"));
			CentroManage centroman= new CentroManageDS();
			centroman.setCencellato(centro);
			
			response.sendRedirect(request.getContextPath()+"/list_centri");
		
	}
		else {
			if(u==null) {
				response.sendError(401, "Autenticazione non effettuata!");
				return;
			} 
			
			if(!(u instanceof Responsabile)) {
				response.sendError(403, "Non sei autorizzato!");
				return;
			}
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/centri.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action= request.getParameter("action");
		String denominazione = (String) request.getParameter("nome");
		String comune = (String) request.getParameter("comune");
		String provincia = (String) request.getParameter("provincia");
		String indirizzo = (String) request.getParameter("indirizzo");
		String capienza2 =(String) request.getParameter("capienza");

		CentroManage centroman= new CentroManageDS();
		Centro c = new Centro();
		
		if ((denominazione != null && !denominazione.isBlank())
				|| (comune != null && !comune.isBlank())
				|| (provincia != null && !provincia.isBlank())
				|| (indirizzo != null && !indirizzo.isBlank())
				|| (!capienza2.isBlank() && Integer.parseInt(capienza2) >=1))
		{
			c.setCapienzaTot(Integer.parseInt(capienza2));
			c.setComune(comune);
			c.setDenominazione(denominazione);
			c.setProvincia(provincia);
			c.setIndirizzo(indirizzo);
			
			centroman.inserisciCentro(c);
			
			response.sendRedirect(request.getContextPath()+"/list_centri");
		} else {
			request.setAttribute("errorMessage", "Il formato dei dati e' errato o non sono presenti tutti i campi!");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/centri.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		/**
		if ((denominazione == null || denominazione.isEmpty())
				|| (comune == null || comune.isEmpty())
				|| (provincia == null || provincia.isEmpty())
				|| (indirizzo == null || indirizzo.isEmpty()))
		{
			request.setAttribute("errorMessage", "Il formato dei dati e' errato o non sono presenti tutti i campi!");
			this.doGet(request, response);
			return;
			
		} else {
			
			c.setCapienzaTot(capienza);
			c.setComune(comune);
			c.setDenominazione(denominazione);
			c.setProvincia(provincia);
			c.setIndirizzo(indirizzo);
			
			centroman.inserisciCentro(c);
			
			response.sendRedirect(request.getContextPath()+"/list_centri");
			
		}
		*/
		
	}

}
